package com.henriquebarucco.ssbc.sensor

import com.henriquebarucco.ssbc.shared.utils.DomainId

data class SensorId(
    val value: String,
) : DomainId() {
    companion object {
        fun unique(): SensorId = SensorId(generate())

        fun with(value: String): SensorId {
            validate<SensorId>(value)
            return SensorId(value)
        }
    }
}
