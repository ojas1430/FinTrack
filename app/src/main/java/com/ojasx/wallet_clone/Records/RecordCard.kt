package com.ojasx.wallet_clone.Records

import android.R.attr.onClick
import com.ojasx.wallet_clone.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards.MainViewModel


//@Composable
//fun RecordCard(record: RecordsDataClass) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 6.dp),
//        elevation = CardDefaults.cardElevation(4.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            // Icon
//            Icon(
//                painter = getRecordIcons(record.icon), // from your icons file
//                contentDescription = record.title,
//                modifier = Modifier.size(32.dp)
//            )
//
//            Spacer(modifier = Modifier.width(12.dp))
//
//            // Title on left
//            Text(
//                text = record.title,
//                style = MaterialTheme.typography.titleMedium
//            )
//
//            Spacer(modifier = Modifier.weight(1f))
//
//            // Amount + Date on right
//            Column(horizontalAlignment = Alignment.End) {
//                Text(
//                    text = "₹${record.amount}",
//                    style = MaterialTheme.typography.bodyMedium
//                )
//                Text(
//                    text = "23 Aug 2025", // replace with formatted date
//                    style = MaterialTheme.typography.bodySmall
//                )
//            }
//        }
//    }
//}


@Composable
fun RecordCard(
    record: RecordsDataClass
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable {},
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon
            Image(
                painter = getRecordIcons(record.icon),
                contentDescription = "",
                modifier = Modifier.size(48.dp)
            )

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
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = record.date, // replace with formatted date
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
