package com.ojasx.FinTrack.Records

import java.text.SimpleDateFormat
import java.util.*

fun FormatDate(dateString: String?): String {
    if (dateString.isNullOrBlank()) return ""

    return try {
        val sdf = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()) // <-- match save format
        sdf.isLenient = false
        val recordDate = sdf.parse(dateString) ?: return dateString

        val today = Calendar.getInstance()
        val yesterday = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, -1)
        }
        val recordCal = Calendar.getInstance().apply { time = recordDate }

        when {
            today.get(Calendar.YEAR) == recordCal.get(Calendar.YEAR) &&
                    today.get(Calendar.DAY_OF_YEAR) == recordCal.get(Calendar.DAY_OF_YEAR) -> "Today"

            yesterday.get(Calendar.YEAR) == recordCal.get(Calendar.YEAR) &&
                    yesterday.get(Calendar.DAY_OF_YEAR) == recordCal.get(Calendar.DAY_OF_YEAR) -> "Yesterday"

            else -> dateString // already in dd MMM yyyy format
        }
    } catch (e: Exception) {
        dateString
    }
}
