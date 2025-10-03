package com.henriquebarucco.ssbc.service.templates

import com.henriquebarucco.ssbc.sensor.dto.FetchSensorsDto
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class SensorQueryTemplatesBuilder(
    private val fetchSensorsDto: FetchSensorsDto,
) {
    private val criteria: Criteria = Criteria()

    fun whereName(): SensorQueryTemplatesBuilder {
        if (fetchSensorsDto.name.isNullOrEmpty()) return this
        criteria
            .and("name")
            .regex(".*${Regex.escape(fetchSensorsDto.name!!)}.*", "i")
        return this
    }

    fun wherePhoneNumber(): SensorQueryTemplatesBuilder {
        if (fetchSensorsDto.phoneNumber.isNullOrEmpty()) return this
        criteria.and("phoneNumber").`is`(fetchSensorsDto.phoneNumber)
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
