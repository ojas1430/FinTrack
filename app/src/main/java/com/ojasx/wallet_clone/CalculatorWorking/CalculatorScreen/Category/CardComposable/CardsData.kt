package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.CardsDataClass
import com.ojasx.wallet_clone.R

@Preview
@Composable
fun CardsData(): List<CardsDataClass> {
    return listOf(
        CardsDataClass(
            title = "Food & Drinks",
            images = R.drawable.restrauant,
        ),
        CardsDataClass(
            title = "Shopping",
            images = R.drawable.shopping,
        ),
        CardsDataClass(
            title = "Housing",
            images = R.drawable.housing,
        ),
        CardsDataClass(
            title = "Transportation",
            images = R.drawable.transportation,
        ),
        CardsDataClass(
            title = "Vehicle",
            images = R.drawable.vehiclechattels,
        ),
        CardsDataClass(
            title = "Life & Entertainment",
            images = R.drawable.lifeentertainment,
        ),
        CardsDataClass(
            title = "Communication, PC",
            images = R.drawable.communication,
        ),
        CardsDataClass(
            title = "Financial expenses",
            images = R.drawable.financial,
        ),
        CardsDataClass(
            title = "Investments",
            images = R.drawable.investment,
        ),
        CardsDataClass(
            title = "Income",
            images = R.drawable.income,
        ),
        CardsDataClass(
            title = "Others",
            images = R.drawable.others
        )
    )
}

fun getFoodsCards() : List<CardsDataClass> {
    return listOf(
        CardsDataClass(
            title = "Bar, Cafe",
            images = R.drawable.bar
        ),
        CardsDataClass(
            title = "Groceries",
            images = R.drawable.groceries
        ),
        CardsDataClass(
            title = "Restrauant, fast-food",
            images = R.drawable.restrauant
        )
    )
}