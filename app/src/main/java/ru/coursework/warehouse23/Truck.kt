package ru.coursework.warehouse23

sealed class Truck  {
    data class Truck1(
        val truckNumber: Int,
        val loadCapacity: Int,
        val product1: List<FoodProducts>?,
        val product2: List<SmallSizedGoods>?,
        val product3: List<MediumSizedGoods>?,
        val products4: List<BulkyGoods>?,
        val supplierName: String
    ) : Truck()

    data class Truck2(
        val truckNumber: Int,
        val loadCapacity: Int,
        val product1: List<FoodProducts>?,
        val product2: List<SmallSizedGoods>?,
        val product3: List<MediumSizedGoods>?,
        val products4: List<BulkyGoods>?,
        val supplierName: String
    ) : Truck()

    data class Truck3(
        val truckNumber: Int,
        val loadCapacity: Int,
        val product1: List<FoodProducts>?,
        val product2: List<SmallSizedGoods>?,
        val product3: List<MediumSizedGoods>?,
        val products4: List<BulkyGoods>?,
        val supplierName: String
    ) : Truck()
}
