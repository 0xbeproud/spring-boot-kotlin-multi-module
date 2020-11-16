package com.another.demoappapi.service

import com.another.demodomain.rds.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
}