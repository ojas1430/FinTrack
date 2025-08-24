package com.ojasx.wallet_clone.Records

import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.ojasx.wallet_clone.R


enum class RecordIcons{
    BAR , GROCERIES , RESTRAUANT , CLOTHES , DRUG ,
    ELECTRONICS , FREETIME , HEALTH , HOME , JEWELS , KIDS , PETS ,STATIONERY
}


fun mapTitleToRecordIcon(title: String): RecordIcons? {
    return when (title) {
        //FOOD AND DRINKS
        "Bar, Cafe" -> RecordIcons.BAR
        "Groceries" -> RecordIcons.GROCERIES
        "Food & Drinks" -> RecordIcons.RESTRAUANT

        //SHOPPING
        "Clothes & shoes" -> RecordIcons.CLOTHES
        "Drug-store, chemist" -> RecordIcons.DRUG
        "Electronics, accessories" -> RecordIcons.ELECTRONICS
        "Free time" -> RecordIcons.FREETIME
        "Health and beauty" -> RecordIcons.HEALTH
        "Home, garden" -> RecordIcons.HOME
        "Jewels, accessories" -> RecordIcons.JEWELS
        "Kids" -> RecordIcons.KIDS
        "Pets, animals" -> RecordIcons.PETS
        "Stationery, tools" -> RecordIcons.STATIONERY

        else -> null
    }
}

@Composable
fun getRecordIcons(icon : RecordIcons): Painter {

    return when (icon){
        // Food and drinks
        RecordIcons.BAR -> painterResource(R.drawable.bar)
        RecordIcons.GROCERIES -> painterResource(R.drawable.groceries)
        RecordIcons.RESTRAUANT -> painterResource(R.drawable.restrauant)

        //Shopping
        RecordIcons.CLOTHES -> painterResource(R.drawable.clothes)
        RecordIcons.DRUG -> painterResource(R.drawable.drug)
        RecordIcons.ELECTRONICS -> painterResource(R.drawable.electronics)
        RecordIcons.FREETIME -> painterResource(R.drawable.freetime)
        RecordIcons.HEALTH -> painterResource(R.drawable.health)
        RecordIcons.HOME -> painterResource(R.drawable.home)
        RecordIcons.JEWELS -> painterResource(R.drawable.jewels)
        RecordIcons.KIDS -> painterResource(R.drawable.kids)
        RecordIcons.PETS -> painterResource(R.drawable.pets)
        RecordIcons.STATIONERY -> painterResource(R.drawable.stationery)
    }

}