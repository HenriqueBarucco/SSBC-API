package com.henriquebarucco.ssbc.external

interface NotificationSender {
    fun send(
        to: String,
        message: String,
    )

    fun send(
        to: String,
        message: String?,
        photo: ByteArray,
    )
}
