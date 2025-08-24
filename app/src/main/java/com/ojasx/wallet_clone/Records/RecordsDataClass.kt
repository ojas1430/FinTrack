package com.ojasx.wallet_clone.Records

enum class RecordIcon{ // This is to store all the icons

}

data class RecordsDataClass(
    val id: Int,
    val icon : RecordIcons,
    var title : String,
    val amount : String ,
    val date : String,
)

