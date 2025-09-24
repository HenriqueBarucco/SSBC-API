package com.henriquebarucco.ssbc.service.templates

import com.henriquebarucco.ssbc.sensor.dto.FetchSensorDto
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class SensorQueryTemplatesBuilder(
    private val fetchSensorDto: FetchSensorDto,
) {
    private val criteria: Criteria = Criteria()

    fun whereName(): SensorQueryTemplatesBuilder {
        if (fetchSensorDto.name.isNullOrEmpty()) return this
        criteria
            .and("name")
            .regex(".*${Regex.escape(fetchSensorDto.name!!)}.*", "i")
        return this
    }

    fun wherePhoneNumber(): SensorQueryTemplatesBuilder {
        if (fetchSensorDto.phoneNumber.isNullOrEmpty()) return this
        criteria.and("phoneNumber").`is`(fetchSensorDto.phoneNumber)
        return this
    }

    fun compileQuery(pageable: Pageable? = null): Query {
        val query = Query(criteria)
        if (pageable == null) {
            return query
        }
        return query.with(pageable)
    }
}
