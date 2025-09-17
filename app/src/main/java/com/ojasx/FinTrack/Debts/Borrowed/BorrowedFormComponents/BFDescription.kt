package com.ojasx.FinTrack.Debts.Borrowed.BorrowedFormComponents

import BorrowedViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ojasx.FinTrack.Debts.LentForm.LentViewModel
import com.ojasx.FinTrack.ThinLine
import com.ojasx.FinTrack.ui.theme.walletblue

@Composable
fun BFDescription(borrowedViewModel: BorrowedViewModel) {
    // observe the current name from ViewModel
    val name by borrowedViewModel.description.observeAsState(initial = "")

    var isFocused by remember { mutableStateOf(false) }

    Spacer(Modifier.height(12.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Description",
            color = if (isFocused) walletblue else Color.Gray,
            fontWeight = FontWeight.Medium
        )

        BasicTextField(
            value = name,
            onValueChange = { newValue ->
                borrowedViewModel.updateDescription(newValue)
            },
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black,
                fontSize = 20.sp
            ),

            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
                .padding(top = 6.dp, bottom = 16.dp),
            decorationBox = { innerTextField ->
                Column {
                    //placeholder
                    if (name.isEmpty() && !isFocused) {
                        Text(
                            text = "What was it for?",
                            color = Color.LightGray,
                            fontSize = 20.sp
                        )
                    }

                    innerTextField()

                    Spacer(Modifier.height(4.dp))

                    //Thin Line
                    ThinLine(isFocused = isFocused)
                }
            }
        )
    }
}
