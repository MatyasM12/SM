package com.services

import com.domain.User
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService {
    fun save(user: User): User
    fun get(id: Int)

}
