package com.henriquebarucco.ssbc

abstract class UnitUseCase<IN> {
    abstract fun execute(input: IN)
}
