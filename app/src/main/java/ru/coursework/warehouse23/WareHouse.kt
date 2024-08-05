package ru.coursework.warehouse23

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext
import ru.coursework.warehouse23.WareHouseCommonMain.bedCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.bedLinenCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.blanketCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.breadCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.kitchenCabinetCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.laptopCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.mattressesCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.meatCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.milkCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.pillowsCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.potatoCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.removableDiskCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.shoeBoxCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.speakerSystemCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.timeForUnloadingTruck1Final
import ru.coursework.warehouse23.WareHouseCommonMain.timeForUnloadingTruck2Final
import ru.coursework.warehouse23.WareHouseCommonMain.timeForUnloadingTruck3Final
import ru.coursework.warehouse23.WareHouseCommonMain.videoProjectorCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.wardrobeClosetCommonCountInWarehouseFinal

class WareHouse {
    val scope = CoroutineScope(newSingleThreadContext("storage"))

    companion object Helper {
        private val differentProductsValueMap: MutableMap<String, Int> = mutableMapOf(
            "breadCommonCountInWarehouseFinal" to 0,
            "milkCommonCountInWarehouseFinal" to 0,
            "potatoCommonCountInWarehouseFinal" to 0,
            "meatCommonCountInWarehouseFinal" to 0,
            "laptopCommonCountInWarehouseFinal" to 0,
            "videoProjectorCommonCountInWarehouseFinal" to 0,
            "speakerSystemCommonCountInWarehouseFinal" to 0,
            "removableDiskCommonCountInWarehouseFinal" to 0,
            "pillowsCommonCountInWarehouseFinal" to 0,
            "bedLinenCommonCountInWarehouseFinal" to 0,
            "mattressesCommonCountInWarehouseFinal" to 0,
            "blanketCommonCountInWarehouseFinal" to 0,
            "kitchenCabinetCommonCountInWarehouseFinal" to 0,
            "shoeBoxCommonCountInWarehouseFinal" to 0,
            "wardrobeClosetCommonCountInWarehouseFinal" to 0,
            "bedCommonCountInWarehouseFinal" to 0
        )
         val timeTrucksUnloading: MutableMap<String, Long> = mutableMapOf(
            "timeForUnloadingTruck1Final" to 0L,
            "timeForUnloadingTruck2Final" to 0L,
            "timeForUnloadingTruck3Final" to 0L,
        )
        private val weightTrucks:MutableMap<Int,Int> = mutableMapOf(
            1 to 0,
            2 to 0,
            3 to 0
        )
    }

    suspend fun saveWeightAnyTruck(key: Int, value: Int) =
        withContext(scope.coroutineContext) {
            when (key) {
                1-> {weightTrucks[1]=value}
                2-> {weightTrucks[2]=value}
                3-> {weightTrucks[3]=value}
            }

}
   @Synchronized
    fun getWeightAnyTruck(truckNumber: Int): Int {
        var weightTruck:Int = 0
        when (truckNumber) {
            1 -> {
                weightTruck = weightTrucks[truckNumber]!!
            }

            2 -> {
                weightTruck = weightTrucks[truckNumber]!!
            }

            3 -> {
                weightTruck = weightTrucks[truckNumber]!!
            }
        }
            return weightTruck
        }

    suspend fun clearTime(key: String) =
        withContext(scope.coroutineContext) {
            timeTrucksUnloading[key]=0L
                }
        suspend fun saveTimeForAnyTruck(key: String, value: Long) =
            withContext(scope.coroutineContext) {
                when (key) {
                    "timeForUnloadingTruck1Final" -> {
                        val oldValue = timeTrucksUnloading["timeForUnloadingTruck1Final"]
                        timeTrucksUnloading["timeForUnloadingTruck1Final"] =
                            oldValue!! + value
                    }

                    "timeForUnloadingTruck2Final" -> {
                        val oldValue = timeTrucksUnloading["timeForUnloadingTruck2Final"]
                        timeTrucksUnloading["timeForUnloadingTruck2Final"] =
                            oldValue!! + value
                    }

                    "timeForUnloadingTruck3Final" -> {
                        val oldValue = timeTrucksUnloading["timeForUnloadingTruck3Final"]
                        timeTrucksUnloading["timeForUnloadingTruck3Final"] =
                            oldValue!! + value
                    }

                }
            }

        @Synchronized
         fun getTimeForAnyTruck(truckNumber: Int): Long {
            var timeTruck: Long = 0L
            when (
                truckNumber
            ) {
                1 -> timeTruck = timeTrucksUnloading["timeForUnloadingTruck1Final"]!!
                2 -> timeTruck = timeTrucksUnloading["timeForUnloadingTruck2Final"]!!
                3 -> timeTruck = timeTrucksUnloading["timeForUnloadingTruck3Final"]!!
            }
            return timeTruck
        }

        suspend fun saveProductValue(key: String, value: Int) =
            withContext(scope.coroutineContext) {
                when (key) {
                    "breadCommonCountInWarehouseFinal" -> {
                        val oldValue = differentProductsValueMap["breadCommonCountInWarehouseFinal"]
                        differentProductsValueMap["breadCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "milkCommonCountInWarehouseFinal" -> {
                        val oldValue = differentProductsValueMap["milkCommonCountInWarehouseFinal"]
                        differentProductsValueMap["milkCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "potatoCommonCountInWarehouseFinal" -> {
                        val oldValue =
                            differentProductsValueMap["potatoCommonCountInWarehouseFinal"]
                        differentProductsValueMap["potatoCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "meatCommonCountInWarehouseFinal" -> {
                        val oldValue = differentProductsValueMap["meatCommonCountInWarehouseFinal"]
                        differentProductsValueMap["meatCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "laptopCommonCountInWarehouseFinal" -> {
                        val oldValue =
                            differentProductsValueMap["laptopCommonCountInWarehouseFinal"]
                        differentProductsValueMap["laptopCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "videoProjectorCommonCountInWarehouseFinal" -> {
                        val oldValue =
                            differentProductsValueMap["videoProjectorCommonCountInWarehouseFinal"]
                        differentProductsValueMap["videoProjectorCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "speakerSystemCommonCountInWarehouseFinal" -> {
                        val oldValue =
                            differentProductsValueMap["speakerSystemCommonCountInWarehouseFinal"]
                        differentProductsValueMap["speakerSystemCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "removableDiskCommonCountInWarehouseFinal" -> {
                        val oldValue =
                            differentProductsValueMap["removableDiskCommonCountInWarehouseFinal"]
                        differentProductsValueMap["removableDiskCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "pillowsCommonCountInWarehouseFinal" -> {
                        val oldValue =
                            differentProductsValueMap["pillowsCommonCountInWarehouseFinal"]
                        differentProductsValueMap["pillowsCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "bedLinenCommonCountInWarehouseFinal" -> {
                        val oldValue =
                            differentProductsValueMap["bedLinenCommonCountInWarehouseFinal"]
                        differentProductsValueMap["bedLinenCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "mattressesCommonCountInWarehouseFinal" -> {
                        val oldValue =
                            differentProductsValueMap["mattressesCommonCountInWarehouseFinal"]
                        differentProductsValueMap["mattressesCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "blanketCommonCountInWarehouseFinal" -> {
                        val oldValue =
                            differentProductsValueMap["blanketCommonCountInWarehouseFinal"]
                        differentProductsValueMap["blanketCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "kitchenCabinetCommonCountInWarehouseFinal" -> {
                        val oldValue =
                            differentProductsValueMap["kitchenCabinetCommonCountInWarehouseFinal"]
                        differentProductsValueMap["kitchenCabinetCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "shoeBoxCommonCountInWarehouseFinal" -> {
                        val oldValue =
                            differentProductsValueMap["shoeBoxCommonCountInWarehouseFinal"]
                        differentProductsValueMap["shoeBoxCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "wardrobeClosetCommonCountInWarehouseFinal" -> {
                        val oldValue =
                            differentProductsValueMap["wardrobeClosetCommonCountInWarehouseFinal"]
                        differentProductsValueMap["wardrobeClosetCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }

                    "bedCommonCountInWarehouseFinal" -> {
                        val oldValue = differentProductsValueMap["bedCommonCountInWarehouseFinal"]
                        differentProductsValueMap["bedCommonCountInWarehouseFinal"] =
                            oldValue!! + value
                    }
                }
            }


        suspend fun calculateFoodProduct(foodList: List<FoodProducts>, truckNumber: Int) =
            withContext(
                scope.coroutineContext
            ) {
                delay(80)
                when (truckNumber) {
                    1 -> {
                        foodList.forEach { productsFood ->
                            when (productsFood.products.name) {
                                "Bread" -> {
                                    WareHouseCommonMain.breadCommonCountInWarehouseFinal =
                                        breadCommonCountInWarehouseFinal +
                                                productsFood.count * 1
                                    saveProductValue(
                                        "breadCommonCountInWarehouseFinal",
                                        breadCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck1Final += productsFood.count * 5
                                    saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)

                                }

                                "Milk" -> {
                                    milkCommonCountInWarehouseFinal += productsFood.count * 1
                                    saveProductValue(
                                        "milkCommonCountInWarehouseFinal",
                                        milkCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck1Final += productsFood.count * 5
                                    saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)
                                }

                                "Potato" -> {
                                    potatoCommonCountInWarehouseFinal += productsFood.count * 1
                                    saveProductValue(
                                        "potatoCommonCountInWarehouseFinal",
                                        potatoCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck1Final += productsFood.count * 10
                                    saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)
                                }

                                "Meat" -> {
                                    meatCommonCountInWarehouseFinal += productsFood.count * 1
                                    saveProductValue(
                                        "meatCommonCountInWarehouseFinal",
                                        meatCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck1Final += productsFood.count * 10
                                    saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)
                                }


                            }
                        }

                    }

                    2 -> {
                        foodList.forEach { productsFood ->
                            when (productsFood.products.name) {
                                "Bread" -> {
                                    breadCommonCountInWarehouseFinal += productsFood.count * 1
                                    saveProductValue(
                                        "breadCommonCountInWarehouseFinal",
                                        breadCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck2Final += productsFood.count * 5
                                    saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)

                                }

                                "Milk" -> {
                                    milkCommonCountInWarehouseFinal += productsFood.count * 1
                                    saveProductValue(
                                        "milkCommonCountInWarehouseFinal",
                                        milkCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck2Final += productsFood.count * 5
                                    saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)
                                }

                                "Potato" -> {
                                    potatoCommonCountInWarehouseFinal += productsFood.count * 1
                                    saveProductValue(
                                        "meatCommonCountInWarehouseFinal",
                                        meatCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck2Final += productsFood.count * 10
                                    saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)
                                }

                                "Meat" -> {
                                    meatCommonCountInWarehouseFinal += productsFood.count * 1
                                    saveProductValue(
                                        "meatCommonCountInWarehouseFinal",
                                        meatCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck2Final += productsFood.count * 10
                                    saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)
                                }
                            }
                        }
                    }

                    3 -> {
                        foodList.forEach { productsFood ->
                            when (productsFood.products.name) {

                                "Bread" -> {
                                    breadCommonCountInWarehouseFinal += productsFood.count * 1
                                    saveProductValue(
                                        "breadCommonCountInWarehouseFinal",
                                        breadCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck3Final += productsFood.count * 5
                                    saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)

                                }

                                "Milk" -> {
                                    milkCommonCountInWarehouseFinal += productsFood.count * 1
                                    saveProductValue(
                                        "milkCommonCountInWarehouseFinal",
                                        milkCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck3Final += productsFood.count * 5
                                    saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)
                                }

                                "Potato" -> {
                                    potatoCommonCountInWarehouseFinal += productsFood.count * 1
                                    saveProductValue(
                                        "meatCommonCountInWarehouseFinal",
                                        meatCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck3Final += productsFood.count * 10
                                    saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)
                                }

                                "Meat" -> {
                                    meatCommonCountInWarehouseFinal += productsFood.count * 1
                                    saveProductValue(
                                        "meatCommonCountInWarehouseFinal",
                                        meatCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck3Final += productsFood.count * 10
                                    saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)
                                }

                            }
                        }
                    }

                }
            }


        suspend fun calculateSmallSizeGoods(productList: List<SmallSizedGoods>, truckNumber: Int) =
            withContext(
                scope.coroutineContext
            ) {
                delay(240)
                when (truckNumber) {
                    1 -> {
                        productList.forEach { smallSizeGoods ->
                            when (smallSizeGoods.products.name) {
                                "Laptop" -> {
                                    WareHouseCommonMain.laptopCommonCountInWarehouseFinal += smallSizeGoods.count * 3
                                    saveProductValue(
                                        "laptopCommonCountInWarehouseFinal",
                                        laptopCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck1Final += smallSizeGoods.count * 7
                                    saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)

                                }

                                "VideoProjector" -> {
                                    WareHouseCommonMain.videoProjectorCommonCountInWarehouseFinal += smallSizeGoods.count * 4
                                    saveProductValue(
                                        "videoProjectorCommonCountInWarehouseFinal",
                                        videoProjectorCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck1Final += smallSizeGoods.count * 7
                                    saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)

                                }

                                "SpeakerSystem" -> {
                                    WareHouseCommonMain.speakerSystemCommonCountInWarehouseFinal += smallSizeGoods.count * 2
                                    saveProductValue(
                                        "speakerSystemCommonCountInWarehouseFinal",
                                        speakerSystemCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck1Final += smallSizeGoods.count * 7
                                    saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)
                                }

                                "RemovableDisk" -> {
                                    WareHouseCommonMain.removableDiskCommonCountInWarehouseFinal += smallSizeGoods.count * 1
                                    saveProductValue(
                                        "removableDiskCommonCountInWarehouseFinal",
                                        removableDiskCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck1Final += smallSizeGoods.count * 5
                                    saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)
                                }

                            }
                        }
                    }

                    2 -> {
                        productList.forEach { smallSizeGoods ->
                            when (smallSizeGoods.products.name) {
                                "Laptop" -> {
                                    WareHouseCommonMain.laptopCommonCountInWarehouseFinal += smallSizeGoods.count * 3
                                    saveProductValue(
                                        "laptopCommonCountInWarehouseFinal",
                                        laptopCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck2Final += smallSizeGoods.count * 7
                                    saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)

                                }

                                "VideoProjector" -> {
                                    WareHouseCommonMain.videoProjectorCommonCountInWarehouseFinal += smallSizeGoods.count * 4
                                    saveProductValue(
                                        "videoProjectorCommonCountInWarehouseFinal",
                                        videoProjectorCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck2Final += smallSizeGoods.count * 7
                                    saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)

                                }

                                "SpeakerSystem" -> {
                                    WareHouseCommonMain.speakerSystemCommonCountInWarehouseFinal += smallSizeGoods.count * 2
                                    saveProductValue(
                                        "speakerSystemCommonCountInWarehouseFinal",
                                        speakerSystemCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck2Final += smallSizeGoods.count * 7
                                    saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)
                                }

                                "RemovableDisk" -> {
                                    WareHouseCommonMain.removableDiskCommonCountInWarehouseFinal += smallSizeGoods.count * 1
                                    saveProductValue(
                                        "removableDiskCommonCountInWarehouseFinal",
                                        removableDiskCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck2Final += smallSizeGoods.count * 5
                                    saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)
                                }
                            }
                        }
                    }

                    3 -> {
                        productList.forEach { smallSizeGoods ->
                            when (smallSizeGoods.products.name) {
                                "Laptop" -> {
                                    WareHouseCommonMain.laptopCommonCountInWarehouseFinal += smallSizeGoods.count * 3
                                    saveProductValue(
                                        "laptopCommonCountInWarehouseFinal",
                                        laptopCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck3Final += smallSizeGoods.count * 7
                                    saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)

                                }

                                "VideoProjector" -> {
                                    WareHouseCommonMain.videoProjectorCommonCountInWarehouseFinal += smallSizeGoods.count * 4
                                    saveProductValue(
                                        "videoProjectorCommonCountInWarehouseFinal",
                                        videoProjectorCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck3Final += smallSizeGoods.count * 7
                                    saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)
                                }

                                "SpeakerSystem" -> {
                                    WareHouseCommonMain.speakerSystemCommonCountInWarehouseFinal += smallSizeGoods.count * 2
                                    saveProductValue(
                                        "speakerSystemCommonCountInWarehouseFinal",
                                        speakerSystemCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck3Final += smallSizeGoods.count * 7
                                    saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)
                                }

                                "RemovableDisk" -> {
                                    WareHouseCommonMain.removableDiskCommonCountInWarehouseFinal += smallSizeGoods.count * 1
                                    saveProductValue(
                                        "removableDiskCommonCountInWarehouseFinal",
                                        removableDiskCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck3Final += smallSizeGoods.count * 5
                                    saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)
                                }
                            }
                        }
                    }
                }
            }

        suspend fun calculateMediumSizeGoods(
            mediumProductList: List<MediumSizedGoods>,
            truckNumber: Int
        ) = withContext(
            scope.coroutineContext
        ) {
            delay(300)
            when (truckNumber) {
                1 -> {
                    mediumProductList.forEach { mediumSizeGoods ->
                        when (mediumSizeGoods.products.name) {
                            "Pillows" -> {
                                WareHouseCommonMain.pillowsCommonCountInWarehouseFinal += mediumSizeGoods.count * 2
                                saveProductValue(
                                    "pillowsCommonCountInWarehouseFinal",
                                    pillowsCommonCountInWarehouseFinal
                                )
                                timeForUnloadingTruck1Final += mediumSizeGoods.count * 6
                                saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)

                            }

                            "BedLinen" -> {
                                WareHouseCommonMain.bedLinenCommonCountInWarehouseFinal += mediumSizeGoods.count * 2
                                saveProductValue(
                                    "bedLinenCommonCountInWarehouseFinal",
                                    bedLinenCommonCountInWarehouseFinal
                                )
                                timeForUnloadingTruck1Final += mediumSizeGoods.count * 6
                                saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)

                            }

                            "Mattresses" -> {
                                WareHouseCommonMain.mattressesCommonCountInWarehouseFinal += mediumSizeGoods.count * 8
                                saveProductValue(
                                    "mattressesCommonCountInWarehouseFinal",
                                    mattressesCommonCountInWarehouseFinal
                                )
                                timeForUnloadingTruck1Final += mediumSizeGoods.count * 10
                                saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)
                            }

                            "Blanket" -> {
                                WareHouseCommonMain.blanketCommonCountInWarehouseFinal += mediumSizeGoods.count * 3
                                saveProductValue(
                                    "blanketCommonCountInWarehouseFinal",
                                    blanketCommonCountInWarehouseFinal
                                )
                                timeForUnloadingTruck1Final += mediumSizeGoods.count * 7
                                saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)

                            }

                        }
                    }
                }

                2 -> {
                    mediumProductList.forEach { mediumSizeGoods ->
                        when (mediumSizeGoods.products.name) {
                            "Pillows" -> {
                                WareHouseCommonMain.pillowsCommonCountInWarehouseFinal += mediumSizeGoods.count * 2
                                saveProductValue(
                                    "pillowsCommonCountInWarehouseFinal",
                                    pillowsCommonCountInWarehouseFinal
                                )
                                timeForUnloadingTruck2Final += mediumSizeGoods.count * 6
                                saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)

                            }

                            "BedLinen" -> {
                                WareHouseCommonMain.bedLinenCommonCountInWarehouseFinal += mediumSizeGoods.count * 2
                                saveProductValue(
                                    "bedLinenCommonCountInWarehouseFinal",
                                    bedLinenCommonCountInWarehouseFinal
                                )
                                timeForUnloadingTruck2Final += mediumSizeGoods.count * 6
                                saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)

                            }

                            "Mattresses" -> {
                                WareHouseCommonMain.mattressesCommonCountInWarehouseFinal += mediumSizeGoods.count * 8
                                saveProductValue(
                                    "mattressesCommonCountInWarehouseFinal",
                                    mattressesCommonCountInWarehouseFinal
                                )
                                timeForUnloadingTruck2Final += mediumSizeGoods.count * 10
                                saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)
                            }

                            "Blanket" -> {
                                WareHouseCommonMain.blanketCommonCountInWarehouseFinal += mediumSizeGoods.count * 3
                                saveProductValue(
                                    "blanketCommonCountInWarehouseFinal",
                                    blanketCommonCountInWarehouseFinal
                                )
                                timeForUnloadingTruck2Final += mediumSizeGoods.count * 7
                                saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)

                            }
                        }
                    }
                }

                3 -> {
                    mediumProductList.forEach { mediumSizeGoods ->
                        when (mediumSizeGoods.products.name) {
                            "Pillows" -> {
                                WareHouseCommonMain.pillowsCommonCountInWarehouseFinal += mediumSizeGoods.count * 2
                                saveProductValue(
                                    "pillowsCommonCountInWarehouseFinal",
                                    pillowsCommonCountInWarehouseFinal
                                )
                                timeForUnloadingTruck3Final += mediumSizeGoods.count * 6
                                saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)

                            }

                            "BedLinen" -> {
                                WareHouseCommonMain.bedLinenCommonCountInWarehouseFinal += mediumSizeGoods.count * 2
                                saveProductValue(
                                    "bedLinenCommonCountInWarehouseFinal",
                                    bedLinenCommonCountInWarehouseFinal
                                )
                                timeForUnloadingTruck3Final += mediumSizeGoods.count * 6
                                saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)

                            }

                            "Mattresses" -> {
                                WareHouseCommonMain.mattressesCommonCountInWarehouseFinal += mediumSizeGoods.count * 8
                                saveProductValue(
                                    "mattressesCommonCountInWarehouseFinal",
                                    mattressesCommonCountInWarehouseFinal
                                )
                                timeForUnloadingTruck3Final += mediumSizeGoods.count * 10
                                saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)
                            }

                            "Blanket" -> {
                                WareHouseCommonMain.blanketCommonCountInWarehouseFinal += mediumSizeGoods.count * 3
                                saveProductValue(
                                    "blanketCommonCountInWarehouseFinal",
                                    blanketCommonCountInWarehouseFinal
                                )
                                timeForUnloadingTruck3Final += mediumSizeGoods.count * 7
                                saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)

                            }
                        }
                    }
                }
            }
        }

        suspend fun calculateBulkyGoods(bulkyList: List<BulkyGoods>, truckNumber: Int) =
            withContext(
                scope.coroutineContext
            )
            {
                delay(600)
                when (truckNumber) {
                    1 -> {
                        bulkyList.forEach { bulkyGoods ->
                            when (bulkyGoods.products.name) {
                                "KitchenCabinet" -> {
                                    kitchenCabinetCommonCountInWarehouseFinal += bulkyGoods.count * 100
                                    saveProductValue(
                                        "kitchenCabinetCommonCountInWarehouseFinal",
                                        kitchenCabinetCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck1Final += bulkyGoods.count * 25
                                    saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)

                                }

                                "ShoeBox" -> {
                                    shoeBoxCommonCountInWarehouseFinal += bulkyGoods.count * 35
                                    saveProductValue(
                                        "shoeBoxCommonCountInWarehouseFinal",
                                        shoeBoxCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck1Final += bulkyGoods.count * 20
                                    saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)
                                }

                                "WardrobeCloset" -> {
                                    wardrobeClosetCommonCountInWarehouseFinal += bulkyGoods.count * 100
                                    saveProductValue(
                                        "wardrobeClosetCommonCountInWarehouseFinal",
                                        wardrobeClosetCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck1Final += bulkyGoods.count * 30
                                    saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)
                                }

                                "Bed" -> {
                                    bedCommonCountInWarehouseFinal += bulkyGoods.count * 50
                                    saveProductValue(
                                        "bedCommonCountInWarehouseFinal",
                                        bedCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck1Final += bulkyGoods.count * 25
                                    saveTimeForAnyTruck("timeForUnloadingTruck1Final",timeForUnloadingTruck1Final)
                                }


                            }
                        }

                    }

                    2 -> {
                        bulkyList.forEach { bulkyGoods ->
                            when (bulkyGoods.products.name) {
                                "KitchenCabinet" -> {
                                    kitchenCabinetCommonCountInWarehouseFinal += bulkyGoods.count * 100
                                    saveProductValue(
                                        "kitchenCabinetCommonCountInWarehouseFinal",
                                        kitchenCabinetCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck2Final += bulkyGoods.count * 25
                                    saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)
                                }

                                "ShoeBox" -> {
                                    shoeBoxCommonCountInWarehouseFinal += bulkyGoods.count * 35
                                    saveProductValue(
                                        "shoeBoxCommonCountInWarehouseFinal",
                                        shoeBoxCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck2Final += bulkyGoods.count * 20
                                    saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)

                                }


                                "WardrobeCloset" -> {
                                    wardrobeClosetCommonCountInWarehouseFinal += bulkyGoods.count * 100
                                    saveProductValue(
                                        "wardrobeClosetCommonCountInWarehouseFinal",
                                        wardrobeClosetCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck2Final += bulkyGoods.count * 30
                                    saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)

                                }

                                "Bed" -> {
                                    bedCommonCountInWarehouseFinal += bulkyGoods.count * 50
                                    saveProductValue(
                                        "bedCommonCountInWarehouseFinal",
                                        bedCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck2Final += bulkyGoods.count * 25
                                    saveTimeForAnyTruck("timeForUnloadingTruck2Final",timeForUnloadingTruck2Final)
                                }

                            }
                        }
                    }

                    3 -> {
                        bulkyList.forEach { bulkyGoods ->
                            when (bulkyGoods.products.name) {
                                "KitchenCabinet" -> {
                                    kitchenCabinetCommonCountInWarehouseFinal += bulkyGoods.count * 100
                                    saveProductValue(
                                        "kitchenCabinetCommonCountInWarehouseFinal",
                                        kitchenCabinetCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck3Final += bulkyGoods.count * 25
                                    saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)
                                }

                                "ShoeBox" -> {
                                    shoeBoxCommonCountInWarehouseFinal += bulkyGoods.count * 35
                                    saveProductValue(
                                        "shoeBoxCommonCountInWarehouseFinal",
                                        shoeBoxCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck3Final += bulkyGoods.count * 20
                                    saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)

                                }


                                "WardrobeCloset" -> {
                                    wardrobeClosetCommonCountInWarehouseFinal += bulkyGoods.count * 100
                                    saveProductValue(
                                        "wardrobeClosetCommonCountInWarehouseFinal",
                                        wardrobeClosetCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck3Final += bulkyGoods.count * 30
                                    saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)

                                }

                                "Bed" -> {
                                    bedCommonCountInWarehouseFinal += bulkyGoods.count * 50
                                    saveProductValue(
                                        "bedCommonCountInWarehouseFinal",
                                        bedCommonCountInWarehouseFinal
                                    )
                                    timeForUnloadingTruck3Final += bulkyGoods.count * 25
                                    saveTimeForAnyTruck("timeForUnloadingTruck3Final",timeForUnloadingTruck3Final)
                                }

                            }
                        }
                    }

                }
            }
    }
