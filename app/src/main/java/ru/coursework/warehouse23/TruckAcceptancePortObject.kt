package ru.coursework.warehouse23

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

object TruckAcceptancePortObject {
    var scope = CoroutineScope(Job() + Dispatchers.IO)
    val wareHouse = WareHouse()
    var unlockFlagPort1 = true
    var unlockFlagPort2 = true
    var unlockFlagPort3 = true
    var truckNumberPort1 = 0
    var truckNumberPort2 = 0
    var truckNumberPort3 = 0

    var el: Truck? = null
    var firmaPort1 = ""
    var firmaPort2 = ""
    var firmaPort3 = ""
    var weight=0
    var weight2=0
    var weight3=0
    suspend fun firstPort(anyTruck: Truck, unloadingTime: Long) {
        val job1 = scope.launch {
            if (anyTruck is Truck.Truck1 || anyTruck is Truck.Truck2 || anyTruck is Truck.Truck3) {
                el = anyTruck
                val result = withTimeout(unloadingTime) {
                    unlockFlagPort1 = false
                    launch {
                        if (el is Truck.Truck1) {
                            (el as Truck.Truck1).product1?.let {
                                weight = wareHouse.getWeightAnyTruck(1)
                                firmaPort1 = (el as Truck.Truck1).supplierName
                                truckNumberPort1 = (el as Truck.Truck1).truckNumber
                                el
                                wareHouse.calculateFoodProduct(
                                    it,
                                    (el as Truck.Truck1).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck1) {
                            (el as Truck.Truck1).product2?.let {
                                firmaPort1 = (el as Truck.Truck1).supplierName
                                truckNumberPort1 = (el as Truck.Truck1).truckNumber

                                wareHouse.calculateSmallSizeGoods(
                                    it,
                                    (el as Truck.Truck1).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck1) {
                            (el as Truck.Truck1).product3?.let {

                                wareHouse.calculateMediumSizeGoods(
                                    it,
                                    (el as Truck.Truck1).truckNumber
                                )
                            }

                        }
                    }
                    launch {
                        if (el is Truck.Truck1) {
                            (el as Truck.Truck1).products4?.let {

                                wareHouse.calculateBulkyGoods(
                                    it,
                                    (el as Truck.Truck1).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck2) {
                            (el as Truck.Truck2).product1?.let {
                                weight = wareHouse.getWeightAnyTruck(2)
                                firmaPort1 = (el as Truck.Truck2).supplierName
                                truckNumberPort1 = (el as Truck.Truck2).truckNumber
                                wareHouse.calculateFoodProduct(
                                    it,
                                    (el as Truck.Truck2).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck2) {
                            firmaPort1 = (el as Truck.Truck2).supplierName
                            truckNumberPort1 = (el as Truck.Truck2).truckNumber
                            (el as Truck.Truck2).product2?.let {

                                wareHouse.calculateSmallSizeGoods(
                                    it,
                                    (el as Truck.Truck2).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck2) {
                            (el as Truck.Truck2).product3?.let {
                                wareHouse.calculateMediumSizeGoods(
                                    it,
                                    (el as Truck.Truck2).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck2) {
                            (el as Truck.Truck2).products4?.let {
                                wareHouse.calculateBulkyGoods(
                                    it,
                                    (el as Truck.Truck2).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck3) {
                            (el as Truck.Truck3).product1?.let {
                                 weight = wareHouse.getWeightAnyTruck(3)
                                firmaPort1 = (el as Truck.Truck3).supplierName
                                truckNumberPort1 = (el as Truck.Truck3).truckNumber
                                wareHouse.calculateFoodProduct(
                                    it,
                                    (el as Truck.Truck3).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck3) {
                            (el as Truck.Truck3).product2?.let {
                                firmaPort1 = (el as Truck.Truck3).supplierName
                                truckNumberPort1 = (el as Truck.Truck3).truckNumber
                                wareHouse.calculateSmallSizeGoods(
                                    it,
                                    (el as Truck.Truck3).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck3) {
                            (el as Truck.Truck3).product3?.let {
                                wareHouse.calculateMediumSizeGoods(
                                    it,
                                    (el as Truck.Truck3).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck3) {
                            (el as Truck.Truck3).products4?.let {
                                wareHouse.calculateBulkyGoods(
                                    it,
                                    (el as Truck.Truck3).truckNumber
                                )
                            }
                        }
                    }
                    delay(600)
                    println(
                        "Общее время разгрузки  прибывшего грузовика под номером $truckNumberPort1 к первому порту: ${
                            wareHouse.getTimeForAnyTruck(
                                truckNumberPort1
                            )
                        }"
                    )
                    println("Фирма поставщик:${firmaPort1}")

                        println("Вес груза:${weight}")


                    println(
                        "" +
                                "" +
                                "" +
                                ""
                    )

                }
                if (result != null) {
                    unlockFlagPort1 = true
                }
            }
        }
    }


    suspend fun secondPort(anyTruck: Truck, unloadingTime: Long) {
        val job2 = scope.launch {
            if (anyTruck is Truck.Truck1 || anyTruck is Truck.Truck2 || anyTruck is Truck.Truck3) {
                el = anyTruck
                val result = withTimeout(unloadingTime) {
                    unlockFlagPort1 = false
                    launch {
                        if (el is Truck.Truck1) {
                            (el as Truck.Truck1).product1?.let {
                                weight2 = wareHouse.getWeightAnyTruck(1)
                                firmaPort2 = (el as Truck.Truck1).supplierName
                                truckNumberPort2 = (el as Truck.Truck1).truckNumber
                                wareHouse.calculateFoodProduct(
                                    it,
                                    (el as Truck.Truck1).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck1) {
                            (el as Truck.Truck1).product2?.let {
                                firmaPort2 = (el as Truck.Truck1).supplierName
                                truckNumberPort2 = (el as Truck.Truck1).truckNumber
                                wareHouse.calculateSmallSizeGoods(
                                    it,
                                    (el as Truck.Truck1).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck1) {
                            (el as Truck.Truck1).product3?.let {
                                wareHouse.calculateMediumSizeGoods(
                                    it,
                                    (el as Truck.Truck1).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck1) {
                            (el as Truck.Truck1).products4?.let {
                                wareHouse.calculateBulkyGoods(
                                    it,
                                    (el as Truck.Truck1).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck2) {
                            (el as Truck.Truck2).product1?.let {
                                weight2 = wareHouse.getWeightAnyTruck(2)
                                firmaPort2 = (el as Truck.Truck2).supplierName
                                truckNumberPort2 = (el as Truck.Truck2).truckNumber
                                wareHouse.calculateFoodProduct(
                                    it,
                                    (el as Truck.Truck2).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck2) {
                            (el as Truck.Truck2).product2?.let {
                                firmaPort2 = (el as Truck.Truck2).supplierName
                                truckNumberPort2 = (el as Truck.Truck2).truckNumber
                                wareHouse.calculateSmallSizeGoods(
                                    it,
                                    (el as Truck.Truck2).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck2) {
                            (el as Truck.Truck2).product3?.let {
                                wareHouse.calculateMediumSizeGoods(
                                    it,
                                    (el as Truck.Truck2).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck2) {
                            (el as Truck.Truck2).products4?.let {
                                wareHouse.calculateBulkyGoods(
                                    it,
                                    (el as Truck.Truck2).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck3) {
                            (el as Truck.Truck3).product1?.let {
                                weight2 = wareHouse.getWeightAnyTruck(3)
                                firmaPort2 = (el as Truck.Truck3).supplierName
                                truckNumberPort2 = (el as Truck.Truck3).truckNumber
                                wareHouse.calculateFoodProduct(
                                    it,
                                    (el as Truck.Truck3).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck3) {
                            (el as Truck.Truck3).product2?.let {
                                firmaPort2 = (el as Truck.Truck3).supplierName
                                truckNumberPort2 = (el as Truck.Truck3).truckNumber
                                wareHouse.calculateSmallSizeGoods(
                                    it,
                                    (el as Truck.Truck3).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck3) {
                            (el as Truck.Truck3).product3?.let {
                                wareHouse.calculateMediumSizeGoods(
                                    it,
                                    (el as Truck.Truck3).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck3) {
                            (el as Truck.Truck3).products4?.let {
                                wareHouse.calculateBulkyGoods(
                                    it,
                                    (el as Truck.Truck3).truckNumber
                                )
                            }
                        }
                    }
                    delay(600)
                    println(
                        "Общее время разгрузки  прибывшего грузовика под номером $truckNumberPort2 ко второму порту: ${
                            wareHouse.getTimeForAnyTruck(
                                truckNumberPort2
                            )
                        }"
                    )
                    println("Фирма поставщик:${firmaPort2}")
                    println("Вес груза:${weight2}")

                    println(
                        "" +
                                "" +
                                "" +
                                ""
                    )
                }
                if (result != null) {
                    unlockFlagPort2 = true
                }
            }
        }
    }

    suspend fun thirdPort(anyTruck: Truck, unloadingTime: Long) {
        val job3 = scope.launch {
            if (anyTruck is Truck.Truck1 || anyTruck is Truck.Truck2 || anyTruck is Truck.Truck3) {
                el = anyTruck
                val result = withTimeout(unloadingTime) {
                    unlockFlagPort1 = false
                    launch {
                        if (el is Truck.Truck1) {
                            (el as Truck.Truck1).product1?.let {
                                weight3 = wareHouse.getWeightAnyTruck(1)
                                firmaPort3 = (el as Truck.Truck1).supplierName
                                truckNumberPort3 = (el as Truck.Truck1).truckNumber
                                wareHouse.calculateFoodProduct(
                                    it,
                                    (el as Truck.Truck1).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck1) {
                            (el as Truck.Truck1).product2?.let {
                                firmaPort3 = (el as Truck.Truck1).supplierName
                                truckNumberPort3 = (el as Truck.Truck1).truckNumber
                                wareHouse.calculateSmallSizeGoods(
                                    it,
                                    (el as Truck.Truck1).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck1) {
                            (el as Truck.Truck1).product3?.let {
                                wareHouse.calculateMediumSizeGoods(
                                    it,
                                    (el as Truck.Truck1).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck1) {
                            (el as Truck.Truck1).products4?.let {
                                wareHouse.calculateBulkyGoods(
                                    it,
                                    (el as Truck.Truck1).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck2) {
                            (el as Truck.Truck2).product1?.let {
                                weight3 = wareHouse.getWeightAnyTruck(2)
                                firmaPort3 = (el as Truck.Truck2).supplierName
                                truckNumberPort3 = (el as Truck.Truck2).truckNumber
                                wareHouse.calculateFoodProduct(
                                    it,
                                    (el as Truck.Truck2).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck2) {
                            (el as Truck.Truck2).product2?.let {
                                firmaPort3 = (el as Truck.Truck2).supplierName
                                truckNumberPort3 = (el as Truck.Truck2).truckNumber
                                wareHouse.calculateSmallSizeGoods(
                                    it,
                                    (el as Truck.Truck2).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck2) {
                            (el as Truck.Truck2).product3?.let {
                                wareHouse.calculateMediumSizeGoods(
                                    it,
                                    (el as Truck.Truck2).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck2) {
                            (el as Truck.Truck2).products4?.let {
                                wareHouse.calculateBulkyGoods(
                                    it,
                                    (el as Truck.Truck2).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck3) {
                            (el as Truck.Truck3).product1?.let {
                                weight2 = wareHouse.getWeightAnyTruck(3)
                                firmaPort3 = (el as Truck.Truck3).supplierName
                                truckNumberPort3 = (el as Truck.Truck3).truckNumber
                                wareHouse.calculateFoodProduct(
                                    it,
                                    (el as Truck.Truck3).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck3) {
                            (el as Truck.Truck3).product2?.let {
                                firmaPort3 = (el as Truck.Truck3).supplierName
                                truckNumberPort3 = (el as Truck.Truck3).truckNumber
                                wareHouse.calculateSmallSizeGoods(
                                    it,
                                    (el as Truck.Truck3).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck3) {
                            (el as Truck.Truck3).product3?.let {
                                wareHouse.calculateMediumSizeGoods(
                                    it,
                                    (el as Truck.Truck3).truckNumber
                                )
                            }
                        }
                    }
                    launch {
                        if (el is Truck.Truck3) {
                            (el as Truck.Truck3).products4?.let {
                                wareHouse.calculateBulkyGoods(
                                    it,
                                    (el as Truck.Truck3).truckNumber
                                )
                            }
                        }
                    }
                    delay(600)
                    println(
                        "Общее время разгрузки  прибывшего грузовика под номером $truckNumberPort3 к третьему порту: ${
                            wareHouse.getTimeForAnyTruck(
                                truckNumberPort3
                            )
                        }"
                    )
                    println("Фирма поставщик:${firmaPort3}")
                    println("Вес груза:${weight3}")

                    println(
                        "" +
                                "" +
                                "" +
                                ""
                    )
                }
                if (result != null) {
                    unlockFlagPort3 = true
                }
            }
        }
    }
}

