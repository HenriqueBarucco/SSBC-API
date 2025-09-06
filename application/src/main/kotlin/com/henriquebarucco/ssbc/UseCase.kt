package com.henriquebarucco.ssbc

abstract class UseCase<IN, OUT> {
    abstract fun execute(input: IN): OUT
}
