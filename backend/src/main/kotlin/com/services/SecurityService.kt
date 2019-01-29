package com.services

import com.domain.CurrentUser
import com.domain.User

interface SecurityService {

    fun getCurrentUser(): CurrentUser?
    fun getCurrentUserEntity(): User
    fun getCurrentUserWithDetails(): User
}