package com.henriquebarucco.ssbc.shared.utils

import com.henriquebarucco.ssbc.event.DomainEvent

abstract class Domain {
    private val _events: MutableList<DomainEvent> = mutableListOf()
    val events: List<DomainEvent> get() = _events

    protected fun registerEvent(event: DomainEvent) {
        _events.add(event)
    }

    fun clearEvents() {
        _events.clear()
    }
}
