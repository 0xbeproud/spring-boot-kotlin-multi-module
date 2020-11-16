package com.another.demoappapi.controller

import com.another.demoappapi.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/v1")
class UserController(
    private val userService: UserService
) {
    @GetMapping("/users")
    fun getUsers(request: HttpServletRequest): String {
        println("hello users")
        return "hello"
    }
}