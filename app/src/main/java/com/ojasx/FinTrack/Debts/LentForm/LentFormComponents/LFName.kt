package com.ojasx.FinTrack.Debts.LentForm.LentFormComponents

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
fun LFName(lentViewModel: LentViewModel) {
    val name by lentViewModel.name.observeAsState(initial = "")
    val nameError by lentViewModel.nameError.observeAsState(initial = false)
    var isFocused by remember { mutableStateOf(false) }

    Spacer(Modifier.height(12.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Name",
            color = when {
                nameError -> Color.Red
                isFocused -> walletblue
                else -> Color.Gray
            },
            fontWeight = FontWeight.Medium
        )

        BasicTextField(
            value = name,
            onValueChange = { newValue ->
                lentViewModel.updateName(newValue)
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
                .padding(top = 6.dp, bottom = 4.dp),
            decorationBox = { innerTextField ->
                Column {
                    if (name.isEmpty() && !isFocused) {
                        Text(
                            text = "To whom you have lent?",
                            color = Color.LightGray,
                            fontSize = 20.sp
                        )
                    }

                    innerTextField()
                    Spacer(Modifier.height(4.dp))

                    ThinLine(
                        isFocused = isFocused
                    )
                }
            }
        )

        if (nameError) {
            Text(
                text = "Name cannot be empty",
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}