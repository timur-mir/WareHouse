package ru.coursework.warehouse23

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object TruckLoadingPort {
    var scope = CoroutineScope(Job() + Dispatchers.IO)
    val truckLoadingGenerator = TruckLoadingGenerator()
    var truckNumberPort1 = 0
    var truckNumberPort1Track2 = 0
    var firma = ""
 suspend fun loadingTruckPort() {
       val job=scope.launch {
            truckLoadingGenerator.loadingTrack()
           delay(600)
            truckLoadingGenerator.sharedFlow_AnyTruckLoading.collect { anyTruck ->
                if (anyTruck is Truck.Truck1) {
                    firma = (anyTruck as Truck.Truck1).supplierName
                    truckNumberPort1Track2 = (anyTruck as Truck.Truck1).truckNumber
                    println("Порт загрузки осуществил погрузку грузовика типа $truckNumberPort1Track2 ")
                    println("Фирма поставщик:${firma}")
                    println("Вес грузовика:${(anyTruck as Truck.Truck1).loadCapacity}")
                }
                else if(anyTruck is Truck.Truck2)
                {
                    firma = (anyTruck as Truck.Truck2).supplierName
                    truckNumberPort1 = (anyTruck as Truck.Truck2).truckNumber
                    println("Порт загрузки осуществил погрузку грузовика типа $truckNumberPort1 ")
                    println("Фирма поставщик:${firma}")
                    println("Вес грузовика:${(anyTruck as Truck.Truck2).loadCapacity}")
                }
            }
        }
     delay(620)//Очень чувствительный коэффициент
     job.cancel()
     job.join()

    }
}

