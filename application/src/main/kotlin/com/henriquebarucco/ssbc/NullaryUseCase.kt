package com.henriquebarucco.ssbc

abstract class NullaryUseCase<OUT> {
    abstract fun execute(): OUT
}
