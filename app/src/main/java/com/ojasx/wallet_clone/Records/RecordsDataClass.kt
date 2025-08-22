package com.ojasx.wallet_clone.Records

enum class RecordIcon{ // This is to store all the icons

}

data class RecordsDataClass(
    val icon : RecordIcons,
    var title : String,
    val amount : Double ,
    val date : Long = System.currentTimeMillis(),
)

fun getFakeRecords() : List<RecordsDataClass>{

    return listOf(
        RecordsDataClass(RecordIcons.BAR,"Electronics",100.00,10),
        RecordsDataClass(RecordIcons.BAR,"dfa",100.00,10),
        //RecordsDataClass("Electronics",100.00,10)
    )
}
