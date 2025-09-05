package com.ojasx.FinTrack.Statistics.Outlook

data class ForecastEntry(
    val label: String,
    val value: Int,
    val type: EntryType
)

enum class EntryType {
    NEGATIVE,
    POSITIVE,
    FORECAST,
    STARTING_BALANCE
}
