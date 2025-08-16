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

fun getShoppingCards() :List<CardsDataClass>{
    return listOf(
        CardsDataClass(
            title = "Clothes & shoes",
            images = R.drawable.clothes
        ),
        CardsDataClass(
            title = "Drug-store, chemist",
            images = R.drawable.drug
        ),
        CardsDataClass(
            title = "Electronics, accessories",
            images = R.drawable.electronics
        ),
        CardsDataClass(
            title = "Free time",
            images = R.drawable.freetime
        ),
        CardsDataClass(
            title = "Health and beauty",
            images = R.drawable.health
        ),
        CardsDataClass(
            title = "Home, garden",
            images = R.drawable.home
        ),
        CardsDataClass(
            title = "Jewels, accessories",
            images = R.drawable.jewels
        ),
        CardsDataClass(
            title = "Kids",
            images = R.drawable.kids
        ),
        CardsDataClass(
            title = "Pets, animals",
            images = R.drawable.pets
        ),
        CardsDataClass(
            title = "Stationery, tools",
            images = R.drawable.stationery
        ),

    )
}

fun getHousingCards() : List<CardsDataClass>{
    return listOf(
        CardsDataClass(
            title = "Energy, utilities",
            images = R.drawable.energy,
        ),
        CardsDataClass(
            title = "Maintenance, repairs",
            images = R.drawable.maintenance,
        ),
        CardsDataClass(
            title = "Mortgage",
            images = R.drawable.mortgage,
        ),
        CardsDataClass(
            title = "Property insurance",
            images = R.drawable.property,
        ),
        CardsDataClass(
            title = "Rent",
            images = R.drawable.rent,
        ),
        CardsDataClass(
            title = "Services",
            images = R.drawable.service,
        ),
    )
}