package com.security

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler
import java.io.IOException
import java.util.*
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AfterLoginAuthenticationHandler: SavedRequestAwareAuthenticationSuccessHandler() {
    private val TRUE = "true"
    private val FALSE = "false"
    private val FIVE_DAYS_IN_SECONDS = 5 * 24 * 60 * 60
    private val THREE_HOURS_IN_SECONDS = 3 * 60 * 60
    private val LANGUAGE = "language"

    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse, authentication: Authentication
    ) {
        var sessionTimeSetter = request.getParameter("sessionTimeSetter")
        if (Objects.isNull(sessionTimeSetter)) {
            sessionTimeSetter = FALSE
        }
        when (sessionTimeSetter) {
            TRUE -> request.session.maxInactiveInterval = FIVE_DAYS_IN_SECONDS
            FALSE -> request.session.maxInactiveInterval = THREE_HOURS_IN_SECONDS
            else -> request.session.maxInactiveInterval = THREE_HOURS_IN_SECONDS
        }

        val objectMapper = ObjectMapper()
        response.writer.append(objectMapper.writeValueAsString(AuthenticationResult(true)))
        response.status = 200
    }
}
