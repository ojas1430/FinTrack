package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.FloatingWindow
import androidx.tv.material3.Button
import androidx.tv.material3.Text
import com.ojasx.wallet_clone.ui.theme.calculatorcolor
import com.ojasx.wallet_clone.ui.theme.premium
import com.ojasx.wallet_clone.ui.theme.walletblue

fun buttonlist() = listOf(
    "C","(",")","/",
    "7","8","9","*",
    "4","5","6","-",
    "1","2","3","+",
    "AC","0",".","="
)

@Composable
fun CalculatorButtons(viewModel: CalculatorViewModel , selectedButton : String) {

    val equationText = viewModel.equationText.observeAsState()
    val resultText = viewModel.resultdata.observeAsState()

    val PrefixSign = when (selectedButton){
        "INCOME" -> "+"
        "EXPENSE" -> "-"
        else -> ""
    }

    Box(modifier = Modifier.background(calculatorcolor)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End
        ) {
            // Calcualating the numbers text
            Text(text = equationText.value?:"",
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.height(15.dp))


            //placing sign and result in a row
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)) {

                //showing sign
                Spacer(Modifier.width(10.dp))
                Text(
                    text = "$PrefixSign",
                    style = TextStyle(
                        fontSize = 60.sp,
                        textAlign = TextAlign.Start
                    ),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                //Showing Result
                Text(
                    resultText.value ?: ""
                    , modifier = Modifier.weight(1f),
                    style = TextStyle(
                        fontSize = 80.sp,
                        textAlign = TextAlign.End,
                    ),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

            }


            //Passing  Calculator Buttons
            Spacer(Modifier.weight(1f))

            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(buttonlist()){
                    CalculatorBtn(it, onClick = {
                        viewModel.onButtonClick(it)
                    } )
                }
            }
        }
    }
}


// Providing the size of buttons
@Composable
fun CalculatorBtn(btn : String,onClick : ()-> Unit) {
    Box(
        modifier = Modifier.padding(8.dp)
    ){
        FloatingActionButton(
            onClick = onClick,
            modifier = Modifier.size(64.dp),
            shape = RoundedCornerShape(10.dp),
            backgroundColor = getBtnColor(btn)
        ) {
            Text(btn,
                color = getNumberColor(btn),
                fontSize = if (btn in listOf("+", "-", "*", "/", "=",".")) 24.sp else 16.sp,
            )
        }
    }
}


fun getBtnColor(btn : String): Color {
    if(btn == "C" || btn == "AC"){
        return Color(0xFF4300FF)
    }
    if(btn == "+" || btn == "-" || btn == "*" || btn == "/" || btn == "(" || btn == ")"){
        return Color.LightGray
    }
    if(btn == "="){
        return premium
    }
    return Color(0xFFD1D5F9)
}

fun getNumberColor(btn: String): Color {
    if(btn == "C" || btn == "AC"){
        return Color.White
    }
    if(btn == "="){
        return Color.White
    }
    return Color.Black
}