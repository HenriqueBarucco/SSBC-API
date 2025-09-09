package com.henriquebarucco.ssbc.sensor

import com.henriquebarucco.ssbc.sensor.vo.Phone

class Sensor(
    val id: SensorId,
    val name: String,
    val phone: Phone,
) {
    companion object {
        fun new(
            name: String,
            phone: String,
        ) = Sensor(
            id = SensorId.unique(),
            name = name,
            phone = Phone(phone),
        )

        fun with(
            id: String,
            name: String,
            phoneNumber: String,
        ): Sensor =
            Sensor(
                id = SensorId.with(id),
                name = name,
                phone = Phone(phoneNumber),
            )
    }
}
