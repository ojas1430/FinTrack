package com.ojasx.FinTrack.Statistics.Balance

import java.math.BigDecimal
import java.time.LocalDate

data class BalancePoint(
    val date: LocalDate,
    val balance: Int
)
