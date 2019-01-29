package com.domain

import lombok.Getter
import lombok.Setter
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

@Getter
@Setter
class CurrentUser(
    id: Long,
    username: String?,
    password: String?,
    authorities: MutableCollection<out GrantedAuthority>?
) :
    User(username, password, authorities) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false
        return true
    }

}