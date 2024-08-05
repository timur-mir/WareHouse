package ru.coursework.warehouse23

import android.annotation.SuppressLint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("SuspiciousIndentation")
suspend fun main() = coroutineScope<Unit> {
    val supplyGenerator = SupplyGenerator()
    var truckR1: Truck.Truck1? = null
    var truckR2: Truck.Truck2? = null
    var truckR3: Truck.Truck3? = null
    var commonTime1 = 0L
    var commonTime2 = 0L
    var commonTime3 = 0L
    launch {
        var time1 = 0L
        var time2 = 0L
        var time3 = 0L
        var time4 = 0L
        supplyGenerator.sharedFlow_Truck1.collect { truck1 ->
            truckR1 = truck1
            truck1.product1?.forEach { it ->
                time1 += it.products.time*it.count
                commonTime1 += time1
            }
            truck1.product2?.forEach { it ->
                time2 += it.products.time*it.count
                commonTime1 += time2
            }
            truck1.product3?.forEach { it ->
                time3 += it.products.time*it.count
                commonTime1 += time3
            }
            truck1.products4?.forEach { it ->
                time4 += it.products.time
                commonTime1 += time4
            }
        }
    }
    launch {
        var time5 = 0L
        var time6 = 0L
        var time7 = 0L
        var time8 = 0L
        supplyGenerator.sharedFlow_Truck2.collect { truck2 ->
            truckR2 = truck2
            truck2.product1?.forEach { it ->
                time5 += it.products.time*it.count
                commonTime2 += time5
            }
            truck2.product2?.forEach { it ->
                time6 += it.products.time*it.count
                commonTime2 += time6
            }
            truck2.product3?.forEach { it ->
                time7 += it.products.time*it.count
                commonTime2 += time7
            }
            truck2.products4?.forEach { it ->
                time8 += it.products.time*it.count
                commonTime2 += time8
            }
        }
    }
    launch {
        var time9 = 0L
        var time10 = 0L
        var time11 = 0L
        var time12 = 0L
        supplyGenerator.sharedFlow_Truck3.collect { truck3 ->
            truckR3 = truck3
            truck3.product1?.forEach { it ->
                time9 += it.products.time
                commonTime3 += time9
            }
            truck3.product2?.forEach { it ->
                time10 += it.products.time*it.count
                commonTime3 += time10
            }
            truck3.product3?.forEach { it ->
                time11 += it.products.time*it.count
                commonTime3 += time11
            }
            truck3.products4?.forEach { it ->
                time12 += it.products.time*it.count
                commonTime3 += time12
            }
        }
    }
    launch {
        delay(2500)
        println("1:${commonTime1} 2:${commonTime2} 3:${commonTime3}")
        val trucks = listOf(truckR1, truckR2, truckR3)
        val trucksR = produceTrucks(trucks)
        var oldNumberPort = 0
        for (receiveTruck in trucksR) {
            val numberPort = (1..3).random()
            delay(250)
            if (oldNumberPort == 0) {
                oldNumberPort = numberPort
                if (numberPort == 1 && TruckAcceptancePortObject.unlockFlagPort1) {
                    TruckAcceptancePortObject.firstPort(receiveTruck, commonTime1)
                } else if (numberPort == 2 && TruckAcceptancePortObject.unlockFlagPort2) {
                    TruckAcceptancePortObject.secondPort(receiveTruck, commonTime2)
                } else if (numberPort == 3 && TruckAcceptancePortObject.unlockFlagPort3) {
                    TruckAcceptancePortObject.thirdPort(receiveTruck, commonTime3)
                }
            } else
                if (oldNumberPort != 0) {
                    if (oldNumberPort == 1) {
                        if (numberPort == 2 && TruckAcceptancePortObject.unlockFlagPort2) {
                            TruckAcceptancePortObject.secondPort(receiveTruck, commonTime2)
                        }
                    }
                    if (oldNumberPort == 2) {

                        if (numberPort == 3 && TruckAcceptancePortObject.unlockFlagPort3) {
                            TruckAcceptancePortObject.thirdPort(receiveTruck, commonTime3)
                        }
                    }
                    if (oldNumberPort == 3) {
                        if (numberPort == 1 && TruckAcceptancePortObject.unlockFlagPort1) {
                            TruckAcceptancePortObject.firstPort(receiveTruck, commonTime1)
                        }
                    }
                }
        }
    }
delay(3500)
    var i=1
    println("Общий вес продуктов на складе:${WareHouseCommonMain.getCommonWeightInWarehouse()}")
    while (true) {
       delay(1000)
        TruckAcceptancePortObject.wareHouse.clearTime("timeForUnloadingTruck1Final")
        TruckAcceptancePortObject.wareHouse.clearTime("timeForUnloadingTruck2Final")
        TruckAcceptancePortObject.wareHouse.clearTime("timeForUnloadingTruck3Final")
        supplyGenerator.generateTruck()
        println("NowGenerate:${i}")
        TruckAcceptancePortObject.firmaPort1=""
        TruckAcceptancePortObject.firmaPort2=""
        TruckAcceptancePortObject.firmaPort3=""
        val numberPort = (1..3).random()
                i++
    val job =launch {
            supplyGenerator.sharedFlow_AnyTruck.collect { truck ->
                var trucksR: Truck? = null
                trucksR = truck
            delay(100)
                if (numberPort == 1 && TruckAcceptancePortObject.unlockFlagPort1) {
                    if (trucksR != null) {
                        TruckAcceptancePortObject.firstPort(trucksR, commonTime1)
                    }
                } else if (numberPort == 2 && TruckAcceptancePortObject.unlockFlagPort2) {
                    if (trucksR != null) {
                        TruckAcceptancePortObject.secondPort(trucksR, commonTime2)
                    }
                } else if (numberPort == 3 && TruckAcceptancePortObject.unlockFlagPort3) {
                    if (trucksR != null) {
                        TruckAcceptancePortObject.thirdPort(trucksR, commonTime3)
                    }
                }
                TruckLoadingPort.loadingTruckPort()
            }
        }
        delay(1360)
        job.cancel()
        job.join()
        println("Общий вес продуктов на складе:${WareHouseCommonMain.getCommonWeightInWarehouse()}")
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.produceTrucks(trucks: List<Truck?>) = produce<Truck> {
    if (trucks != null) {
        println("NowGenerates")
        for (truck in trucks) {
            if (truck != null) {
                send(truck)
            }
        }
    } else {
        println("NowNoGenerates")
    }
}
@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.produceSimpleTruck(truck: Truck) = produce<Truck> {
    if (truck != null) {
        println("NowGenerate")
        send(truck)
    } else {
        println("Now2NoGenerate")
    }
}












