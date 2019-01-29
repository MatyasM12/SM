//package com.security
//
//import org.apache.log4j.Logger
//import org.springframework.stereotype.Component
//import org.springframework.web.filter.GenericFilterBean
//import java.io.IOException
//import javax.servlet.*
//import javax.servlet.http.HttpServletResponse
//
//@Component
//class CorsFilter : GenericFilterBean() {
//    companion object {
//        private val logger: Logger = Logger.getLogger(this::class.java)
//    }
//
//    @Throws(IOException::class, ServletException::class)
//    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
//        logger.info("Cors Filter")
//        val response = servletResponse as HttpServletResponse
//
//        response.setHeader("Access-Control-Allow-Origin", "*")
//        response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS")
//        response.setHeader("Access-Control-Allow-Headers", "*")
//        response.setHeader("Access-Control-Allow-Credentials", true.toString())
//        response.setHeader("Access-Control-Max-Age", 180.toString())
//        filterChain.doFilter(servletRequest, servletResponse)
//    }
//}