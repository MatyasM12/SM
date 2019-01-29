package com.services

import com.domain.CurrentUser
import com.domain.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Service
import java.util.HashSet

@Service
class UserServiceImpl: UserService {
    override fun loadUserByUsername(username: String?): CurrentUser {
        val user = User("asd", "asd", "bb@yahoo.com", "\$2a\$10\$ntLEtWAYc63tU1zM3STgU.dE9Hdgafr.CkOjm/5YokYmB3je2JZdW")
        val grantedAuthorities = HashSet<GrantedAuthority>()
        grantedAuthorities.add(SimpleGrantedAuthority("ADMIN"))


        return CurrentUser(1, user.email, user.password, grantedAuthorities)
    }

    override fun get(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(user: User): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}