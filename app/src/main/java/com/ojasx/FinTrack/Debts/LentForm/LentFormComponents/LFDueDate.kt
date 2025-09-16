package com.ojasx.FinTrack.Debts.LentForm.LentFormComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ojasx.FinTrack.ThinLine
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun LFDueDate() {
    var isFocused by remember { mutableStateOf(false) }

    // it remembers date and time
    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }

    // it is used to show date and time in string format
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MMM dd yyyy")
                .format(pickedDate)
        }
    }


    // used to show the dialog which appears after clicking
    val dateDialogState = rememberMaterialDialogState()

    // Designing date dialog
    MaterialDialog(
        dialogState = dateDialogState,
        buttons = {
            positiveButton(text = "OK") {}
            negativeButton(text = "CANCEL") {}
        }
    ) {
        datepicker(
            initialDate = LocalDate.now(),
            title = "PICK A DATE",

            ) {
            pickedDate = it
        }
    }

    Row(modifier = Modifier.fillMaxWidth()) {

        //Date
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .weight(1f)
        ) {
            // Top label
            Text(
                text = "Due Date",
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = formattedDate,
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier
                    .clickable { dateDialogState.show() }
            )
            Spacer(Modifier.height(4.dp))

            //underline
            ThinLine(isFocused = isFocused)
            Spacer(Modifier.height(16.dp))
        }
    }
}