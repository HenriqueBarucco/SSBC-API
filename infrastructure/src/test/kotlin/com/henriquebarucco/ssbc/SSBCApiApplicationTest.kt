package com.henriquebarucco.ssbc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest()
class SSBCApiApplicationTest {
    @Test
    fun contextLoads() {
        assertThat(true).isTrue()
    }
}
