package com.viol4tsf.exchangerate.model.cash

data class Cash(
    val Date: String,
    val PreviousDate: String,
    val PreviousURL: String,
    val Timestamp: String,
    val Valute: Valute
)