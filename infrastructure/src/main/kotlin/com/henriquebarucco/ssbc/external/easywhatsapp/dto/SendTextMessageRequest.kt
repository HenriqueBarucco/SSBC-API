package com.henriquebarucco.ssbc.external.easywhatsapp.dto

data class SendTextMessageRequest(
    val token: String,
    val phone: String,
    val message: String,
)
