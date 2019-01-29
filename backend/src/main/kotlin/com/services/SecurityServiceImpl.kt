package com.services

import com.domain.CurrentUser
import com.domain.User
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class SecurityServiceImpl : SecurityService {
    override fun getCurrentUser(): CurrentUser? {
        val securityContext: SecurityContext = SecurityContextHolder.getContext()
        val auth: Authentication = securityContext.authentication
        if (auth != null) {
            val principal = auth.principal
            if (principal is CurrentUser) {
                return principal
            }
        }
        return null
    }

    override fun getCurrentUserEntity(): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserWithDetails(): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}