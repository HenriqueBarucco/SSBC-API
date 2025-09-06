package com.henriquebarucco.ssbc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SSBCApiApplication

fun main(args: Array<String>) {
    runApplication<SSBCApiApplication>(*args)
}
