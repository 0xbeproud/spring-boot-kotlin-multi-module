package com.another.demoappapi

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoAppApiApplicationTests {

    @Test
    fun contextLoads() {
        assertThat(true)
    }

}
