package com.ojasx.FinTrack.Debts.LentForm.LentFormComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import com.ojasx.FinTrack.ThinLine
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun LFDate() {
    var colors = MaterialTheme.colorScheme
    var isFocused by remember { mutableStateOf(false) }

    // Remember selected date
    var pickedDate by remember { mutableStateOf(LocalDate.now()) }

    // Format date only (no time)
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("MMM dd yyyy").format(pickedDate)
        }
    }

    // Date picker dialog state
    val dateDialogState = rememberMaterialDialogState()

    // Date picker dialog
    MaterialDialog(
        dialogState = dateDialogState,
        buttons = {
            positiveButton(text = "OK")
            negativeButton(text = "CANCEL")
        }
    ) {
        datepicker(
            initialDate = pickedDate,
            title = "Pick a Date"
        ) {
            pickedDate = it
        }
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .weight(1f)
        ) {
            // Label
            Text(
                text = "Date",
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            )
            Spacer(Modifier.height(4.dp))

            // Selected Date
            Text(
                text = formattedDate,
                color = colors.onBackground,
                fontSize = 20.sp,
                modifier = Modifier.clickable { dateDialogState.show() }
            )

            Spacer(Modifier.height(4.dp))
            ThinLine(isFocused = isFocused)
            Spacer(Modifier.height(16.dp))
        }
    }
}
