package com.controllers

import com.domain.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/users")
class UserController {

    @GetMapping
    fun getUsers(): MutableList<User> {
        val logger: Logger = LoggerFactory.getLogger("ABC")
        logger.info("User Controller")
        return Arrays.asList(User("mihai", "matyas", "mihai@yahoo.com", "123"))
    }
}