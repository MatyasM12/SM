package com.security

import com.domain.CurrentUser
import com.services.SecurityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/authorize")
class AuthorizationRestController @Autowired constructor(
    private val securityService: SecurityService
) {

    @GetMapping("/getCurrentUser")
    fun getCurrentUser(): CurrentUser? = securityService.getCurrentUser()
}