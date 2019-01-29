package com.security

import com.services.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.core.annotation.Order
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
open class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder
    @Autowired
    lateinit var userService: UserService
    override fun configure(http: HttpSecurity): Unit {
        http
            .exceptionHandling()

        http
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/api/auth/login")
            .defaultSuccessUrl("/secure")
            .permitAll()
            .successHandler(afterLoginAuthenticationHandler())
            .and()
            .csrf().disable()

        http
            .headers()
            .frameOptions()
            .sameOrigin()
    }

    fun afterLoginAuthenticationHandler(): AfterLoginAuthenticationHandler {
        return AfterLoginAuthenticationHandler()
    }

//    @Bean
//    open fun corsConfigurationSource(): CorsConfigurationSource {
//        val configuration = CorsConfiguration()
//        configuration.allowedOrigins = ImmutableList.of("*")
//        configuration.allowedMethods = ImmutableList.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH")
//        configuration.allowCredentials = true
//        configuration.allowedHeaders = ImmutableList.of("Authorization", "Cache-Control", "Content-Type")
//        val source = UrlBasedCorsConfigurationSource()
//        source.registerCorsConfiguration("/**", configuration)
//        return source
//    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.authenticationProvider(authProvider())
    }

    @Bean
    open fun authProvider(): DaoAuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userService)
        authProvider.setPasswordEncoder(passwordEncoder)
        return authProvider
    }
}

//@Component
//internal class MyApplicationListener : ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
//
//    override fun onApplicationEvent(event: AuthenticationFailureBadCredentialsEvent) {
//        val userName = event.authentication.principal
//        val credentials = event.authentication.credentials
//        LOG.info("Failed login using USERNAME [$userName]")
//        LOG.info("Failed login using PASSWORD [$credentials]")
//    }
//
//    companion object {
//        private val LOG = Logger.getLogger(MyApplicationListener::class.java)
//    }
//}