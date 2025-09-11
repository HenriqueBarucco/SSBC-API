package com.henriquebarucco.ssbc.event

import com.henriquebarucco.ssbc.event.DomainEvent

interface DomainEventPublisher {
    fun publish(event: DomainEvent)
}
