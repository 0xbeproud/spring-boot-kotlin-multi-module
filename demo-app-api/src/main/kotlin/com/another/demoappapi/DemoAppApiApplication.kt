package com.another.demoappapi

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan("com.another")
@SpringBootApplication
class DemoAppApiApplication

fun main(args: Array<String>) {
    runApplication<DemoAppApiApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
