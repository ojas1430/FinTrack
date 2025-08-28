package com.ojasx.FinTrack.Records

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun RecordCard(
    record: RecordsDataClass
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable {},
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon
            mapTitleToRecordIcon(record.title)?.let { recordIcon ->
                Icon(
                    painter = getRecordIcons(recordIcon),
                    contentDescription = record.title,
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Title on left
            Text(
                text = record.title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.weight(1f))

            // Amount + Date on right
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "₹${record.amount}",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium,
                    color = when{
                        record.amount.contains("+") -> Color(0xFF2E7D32)
                        record.amount.contains("-") -> Color(0xFFC62828)
                        else -> Color.Black
                    }
                )
                //Date
                Text(
                    text = FormatDate(record.date),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}