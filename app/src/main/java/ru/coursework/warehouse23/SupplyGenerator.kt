package ru.coursework.warehouse23

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class SupplyGenerator {

    val sharedFlowTruck1 = MutableSharedFlow<Truck.Truck1>()
    val sharedFlow_Truck1 = sharedFlowTruck1.asSharedFlow()

    val sharedFlowTruck2 = MutableSharedFlow<Truck.Truck2>()
    val sharedFlow_Truck2 = sharedFlowTruck2.asSharedFlow()

    val sharedFlowTruck3 = MutableSharedFlow<Truck.Truck3>()
    val sharedFlow_Truck3 = sharedFlowTruck3.asSharedFlow()

    val sharedFlowForAnyTruck = MutableSharedFlow<Truck>()
    val sharedFlow_AnyTruck = sharedFlowForAnyTruck.asSharedFlow()

    var scope = CoroutineScope(Job() + Dispatchers.Default)

    ///////////////////////////////////////////////
    val productOneType =
        List(20) { FoodProducts((13..15).random(), FoodProductsTypes.values().random()) }
    val productSecondType =
        List(10) { SmallSizedGoods((13..15).random(), SmallSizedGoodsTypes.values().random()) }
    val productThirdType =
        List(10) { MediumSizedGoods((13..15).random(), MediumSizedGoodsTypes.values().random()) }
    val productFourthType =
        List(2) { BulkyGoods((3..6).random(), BulkyGoodsTypes.values().random()) }

    //Около 1,5 тонн
    ////////////////////////////////////////////////
    val productOneTypeForSecondTruck =
        List(20) { FoodProducts((13..15).random(), FoodProductsTypes.values().random()) }
    val productSecondTypeForSecondTruck =
        List(10) { SmallSizedGoods((13..15).random(), SmallSizedGoodsTypes.values().random()) }
    val productThirdTypeSecondTruck =
        List(10) { MediumSizedGoods((13..15).random(), MediumSizedGoodsTypes.values().random()) }
    val productFourthTypeSecondTruck =
        List(2) { BulkyGoods((3..6).random(), BulkyGoodsTypes.values().random()) }

    ////////////////////////////////////////////////////
    val productOneTypeForThirdTruck =
        List(21) { FoodProducts((13..15).random(), FoodProductsTypes.values().random()) }
    val productSecondTypeForThirdTruck =
        List(15) { SmallSizedGoods((13..15).random(), SmallSizedGoodsTypes.values().random()) }
    val productThirdTypeThirdTruck =
        List(15) { MediumSizedGoods((13..15).random(), MediumSizedGoodsTypes.values().random()) }
    val productFourthTypeThirdTruck =
        List(2) { BulkyGoods((6..10).random(), BulkyGoodsTypes.values().random()) }

    //Около 2 тонн
    ////////////////////////////////////////////////////
    val truckNumberWithOnlyFoodProduct = (1..3).random()

    init {
        scope.launch {
            val p1Channel = produce(capacity = Channel.UNLIMITED) {
                productOneType.forEach { send(it) }
            }
            val p2Channel = produce(capacity = Channel.UNLIMITED) {
                productSecondType.forEach { send(it) }
            }
            val p3Channel = produce(capacity = Channel.UNLIMITED) {
                productThirdType.forEach { send(it) }
            }
            val p4Channel = produce(capacity = Channel.UNLIMITED) {
                productFourthType.forEach { send(it) }
            }

            val p1ChannelTruck2 = produce(capacity = Channel.UNLIMITED) {
                productOneTypeForSecondTruck.forEach { send(it) }
            }
            val p2ChannelTruck2 = produce(capacity = Channel.UNLIMITED) {
                productSecondTypeForSecondTruck.forEach { send(it) }
            }
            val p3ChannelTruck2 = produce(capacity = Channel.UNLIMITED) {
                productThirdTypeSecondTruck.forEach { send(it) }
            }
            val p4ChannelTruck2 = produce(capacity = Channel.UNLIMITED) {
                productFourthTypeSecondTruck.forEach { send(it) }
            }

            val p1ChannelTruck3 = produce(capacity = Channel.UNLIMITED) {
                productOneTypeForThirdTruck.forEach { send(it) }
            }
            val p2ChannelTruck3 = produce(capacity = Channel.UNLIMITED) {
                productSecondTypeForThirdTruck.forEach { send(it) }
            }
            val p3ChannelTruck3 = produce(capacity = Channel.UNLIMITED) {
                productThirdTypeThirdTruck.forEach { send(it) }
            }
            val p4ChannelTruck3 = produce(capacity = Channel.UNLIMITED) {
                productFourthTypeThirdTruck.forEach { send(it) }
            }

            if (truckNumberWithOnlyFoodProduct == 1) {
                val truck1 = uploadingByTheSupplier(p1Channel, null, null, null, "Фирма Север")
                delay(110)
                sharedFlowTruck1.emit(truck1)

                val truck2 = uploadingByTheSupplier2(
                    null,
                    p2ChannelTruck2,
                    p3ChannelTruck2,
                    p4ChannelTruck2,
                    "Фирма Горизонт"
                )
                delay(110)
                sharedFlowTruck2.emit(truck2)

                val truck3 = uploadingByTheSupplier3(
                    null,
                    p2ChannelTruck3,
                    p3ChannelTruck3,
                    p4ChannelTruck3,
                    "Фирма Алые паруса"
                )
                delay(110)
                sharedFlowTruck3.emit(truck3)
            }

            if (truckNumberWithOnlyFoodProduct == 2) {
                val truck2 =
                    uploadingByTheSupplier2(p1ChannelTruck2, null, null, null, "Фирма Горизонт")
                delay(110)
                sharedFlowTruck2.emit(truck2)

                val truck1 =
                    uploadingByTheSupplier(null, p2Channel, p3Channel, p4Channel, "Фирма Север")
                delay(110)
                sharedFlowTruck1.emit(truck1)

                val truck3 = uploadingByTheSupplier3(
                    null,
                    p2ChannelTruck3,
                    p3ChannelTruck3,
                    p4ChannelTruck3,
                    "Фирма Алые паруса"
                )
                delay(110)
                sharedFlowTruck3.emit(truck3)


            }
            if (truckNumberWithOnlyFoodProduct == 3) {
                val truck3 =
                    uploadingByTheSupplier3(p1ChannelTruck3, null, null, null, "Фирма Алые паруса")
                delay(110)
                sharedFlowTruck3.emit(truck3)

                val truck2 = uploadingByTheSupplier2(
                    null,
                    p2ChannelTruck2,
                    p3ChannelTruck2,
                    p4ChannelTruck2,
                    "Фирма Горизонт"
                )
                delay(110)
                sharedFlowTruck2.emit(truck2)

                val truck1 = uploadingByTheSupplier(
                    null,
                    p2Channel,
                    p3Channel,
                    p4Channel,
                    "Фирма Север"
                )
                delay(110)
                sharedFlowTruck1.emit(truck1)
            }

        }

    }

    fun generateTruck() {
        ///////////////////////////////////////////////
        val productOneType =
            List(20) { FoodProducts((13..15).random(), FoodProductsTypes.values().random()) }
        val productSecondType =
            List(20) { SmallSizedGoods((13..15).random(), SmallSizedGoodsTypes.values().random()) }
        val productThirdType =
            List(20) {
                MediumSizedGoods(
                    (13..15).random(),
                    MediumSizedGoodsTypes.values().random()
                )
            }
        val productFourthType =
            List(2) { BulkyGoods((1..2).random(), BulkyGoodsTypes.values().random()) }

        ////////////////////////////////////////////////
        val productOneTypeForSecondTruck =
            List(21) { FoodProducts((15..18).random(), FoodProductsTypes.values().random()) }
        val productSecondTypeForSecondTruck =
            List(19) { SmallSizedGoods((15..18).random(), SmallSizedGoodsTypes.values().random()) }
        val productThirdTypeSecondTruck =
            List(18) {
                MediumSizedGoods(
                    (13..15).random(),
                    MediumSizedGoodsTypes.values().random()
                )
            }
        val productFourthTypeSecondTruck =
            List(2) { BulkyGoods((2..3).random(), BulkyGoodsTypes.values().random()) }

        ////////////////////////////////////////////////////
        val productOneTypeForThirdTruck =
            List(21) { FoodProducts((15..18).random(), FoodProductsTypes.values().random()) }
        val productSecondTypeForThirdTruck =
            List(19) { SmallSizedGoods((15..18).random(), SmallSizedGoodsTypes.values().random()) }
        val productThirdTypeThirdTruck =
            List(18) {
                MediumSizedGoods(
                    (13..15).random(),
                    MediumSizedGoodsTypes.values().random()
                )
            }
        val productFourthTypeThirdTruck =
            List(2) { BulkyGoods((3..4).random(), BulkyGoodsTypes.values().random()) }

        ////////////////////////////////////////////////////

        val truckNumber = (1..3).random()
        val truckNumberWithOnlyFoodProductBoolean = (0..1).random()
        scope.launch {
            val p1Channel = produce(capacity = Channel.UNLIMITED) {
                productOneType.forEach { send(it) }
            }
            val p2Channel = produce(capacity = Channel.UNLIMITED) {
                productSecondType.forEach { send(it) }
            }
            val p3Channel = produce(capacity = Channel.UNLIMITED) {
                productThirdType.forEach { send(it) }
            }
            val p4Channel = produce(capacity = Channel.UNLIMITED) {
                productFourthType.forEach { send(it) }
            }

            val p1ChannelTruck2 = produce(capacity = Channel.UNLIMITED) {
                productOneTypeForSecondTruck.forEach { send(it) }
            }
            val p2ChannelTruck2 = produce(capacity = Channel.UNLIMITED) {
                productSecondTypeForSecondTruck.forEach { send(it) }
            }
            val p3ChannelTruck2 = produce(capacity = Channel.UNLIMITED) {
                productThirdTypeSecondTruck.forEach { send(it) }
            }
            val p4ChannelTruck2 = produce(capacity = Channel.UNLIMITED) {
                productFourthTypeSecondTruck.forEach { send(it) }
            }

            val p1ChannelTruck3 = produce(capacity = Channel.UNLIMITED) {
                productOneTypeForThirdTruck.forEach { send(it) }
            }
            val p2ChannelTruck3 = produce(capacity = Channel.UNLIMITED) {
                productSecondTypeForThirdTruck.forEach { send(it) }
            }
            val p3ChannelTruck3 = produce(capacity = Channel.UNLIMITED) {
                productThirdTypeThirdTruck.forEach { send(it) }
            }
            val p4ChannelTruck3 = produce(capacity = Channel.UNLIMITED) {
                productFourthTypeThirdTruck.forEach { send(it) }
            }
            when (truckNumber) {
                1 -> {
                    if (truckNumberWithOnlyFoodProductBoolean == 1) {
                        val truck1 =
                            uploadingByTheSupplier(p1Channel, null, null, null, "Фирма Север")
                        delay(150)
                        sharedFlowForAnyTruck.emit(truck1)
                    } else {
                        val truck1 =
                            uploadingByTheSupplier(
                                null,
                                p2Channel,
                                p3Channel,
                                p4Channel,
                                "Фирма Север"
                            )
                        delay(150)
                        sharedFlowForAnyTruck.emit(truck1)
                    }

                }

                2 -> {
                    if (truckNumberWithOnlyFoodProductBoolean == 1) {
                        val truck2 =
                            uploadingByTheSupplier2(
                                p1ChannelTruck2,
                                null,
                                null,
                                null,
                                "Фирма Горизонт"
                            )
                        delay(150)
                        sharedFlowForAnyTruck.emit(truck2)
                    } else {
                        val truck2 =
                            uploadingByTheSupplier2(
                                null,
                                p2ChannelTruck2,
                                p3ChannelTruck2,
                                p4ChannelTruck2,
                                "Фирма Горизонт"
                            )
                        delay(150)
                        sharedFlowForAnyTruck.emit(truck2)
                    }
                }

                3 -> {
                    if (truckNumberWithOnlyFoodProductBoolean == 1) {
                        val truck3 =
                            uploadingByTheSupplier3(
                                p1ChannelTruck3,
                                null,
                                null,
                                null,
                                "Фирма Алые паруса"
                            )
                        delay(150)
                        sharedFlowForAnyTruck.emit(truck3)
                    } else {
                        val truck3 =
                            uploadingByTheSupplier3(
                                null,
                                p2ChannelTruck3,
                                p3ChannelTruck3,
                                p4ChannelTruck3,
                                "Фирма Алые паруса"
                            )
                        delay(150)
                        sharedFlowForAnyTruck.emit(truck3)
                    }
                }

            }
        }
    }

    suspend fun
            CoroutineScope.uploadingByTheSupplier(
        orders: ReceiveChannel<FoodProducts>?,
        orders2: ReceiveChannel<SmallSizedGoods>?,
        orders3: ReceiveChannel<MediumSizedGoods>?,
        orders4: ReceiveChannel<BulkyGoods>?,
        supplierName: String
    ): Truck.Truck1 {

        val products1List = mutableListOf<FoodProducts>()
        val products2List = mutableListOf<SmallSizedGoods>()
        val products3List = mutableListOf<MediumSizedGoods>()
        val products4List = mutableListOf<BulkyGoods>()
        var products1Weight = 0
        var products2Weight = 0
        var products3Weight = 0
        var products4Weight = 0
        if (orders == null) {
            launch {
                if (orders2 != null) {
                    for (product in orders2) {
                        products2List.add(product)
                        if (product.products.name == " Laptop") {
                            products2Weight += product.count * 3
                        }
                        if (product.products.name == "VideoProjector") {
                            products2Weight += product.count * 4
                        }
                        if (product.products.name == "SpeakerSystem") {
                            products2Weight += product.count * 2
                        }
                        if (product.products.name == "RemovableDisk") {
                            products2Weight += product.count * 1
                        }
                    }
                }
            }
            launch {
                if (orders3 != null) {
                    for (product in orders3) {
                        products3List.add(product)
                        if (product.products.name == "Pillows") {
                            products3Weight += product.count * 2
                        }
                        if (product.products.name == "BedLinen") {
                            products3Weight += product.count * 2
                        }
                        if (product.products.name == "Mattresses") {
                            products3Weight += product.count * 8
                        }
                        if (product.products.name == "Blanket") {
                            products3Weight += product.count * 7
                        }
                    }
                }
            }
            launch {
                if (orders4 != null) {
                    for (product in orders4) {
                        products4List.add(product)
                        if (product.products.name == "KitchenCabinet") {
                            products4Weight += product.count * 100
                        }
                        if (product.products.name == "ShoeBox") {
                            products4Weight += product.count * 35
                        }
                        if (product.products.name == "WardrobeCloset") {
                            products4Weight += product.count * 100
                        }
                        if (product.products.name == "Bed") {
                            products4Weight += product.count * 50
                        }
                    }
                }
            }
            delay(300)
            TruckAcceptancePortObject.wareHouse.saveWeightAnyTruck(
                1,
                products2Weight + products3Weight + products4Weight
            )
            delay(120)
            return Truck.Truck1(
                1,
                products2Weight + products3Weight + products4Weight,
                products1List as List<FoodProducts>,
                products2List as List<SmallSizedGoods>,
                products3List as List<MediumSizedGoods>,
                products4List as List<BulkyGoods>,
                supplierName
            )


        } else {
            launch {
                for (product in orders) {
                    products1List.add(product)
                    if (product.products.name == "Bread") {
                        products1Weight += product.count * 1
                    }
                    if (product.products.name == "Milk") {
                        products1Weight += product.count * 1
                    }
                    if (product.products.name == "Potato") {
                        products1Weight += product.count * 1
                    }
                    if (product.products.name == "Meat") {
                        products1Weight += product.count * 1
                    }
                }
            }
            delay(300)
            TruckAcceptancePortObject.wareHouse.saveWeightAnyTruck(1, products1Weight)
            delay(120)
            return Truck.Truck1(
                1,
                products1Weight,
                products1List as List<FoodProducts>,
                null,
                null,
                null,
                supplierName
            )


        }

    }

    suspend fun CoroutineScope.uploadingByTheSupplier2(
        orders: ReceiveChannel<FoodProducts>?,
        orders2: ReceiveChannel<SmallSizedGoods>?,
        orders3: ReceiveChannel<MediumSizedGoods>?,
        orders4: ReceiveChannel<BulkyGoods>?,
        supplierName: String
    ): Truck.Truck2 {

        val products1List = mutableListOf<FoodProducts>()
        val products2List = mutableListOf<SmallSizedGoods>()
        val products3List = mutableListOf<MediumSizedGoods>()
        val products4List = mutableListOf<BulkyGoods>()
        var products1Weight = 0
        var products2Weight = 0
        var products3Weight = 0
        var products4Weight = 0
        if (orders == null) {
            if (orders2 != null) {
                launch {
                    for (product in orders2) {
                        products2List.add(product)
                        if (product.products.name == " Laptop") {
                            products2Weight += product.count * 3
                        }
                        if (product.products.name == "VideoProjector") {
                            products2Weight += product.count * 4
                        }
                        if (product.products.name == "SpeakerSystem") {
                            products2Weight += product.count * 2
                        }
                        if (product.products.name == "RemovableDisk") {
                            products2Weight += product.count * 1
                        }
                    }
                }
            }
            if (orders3 != null) {
                launch {
                    for (product in orders3) {
                        products3List.add(product)
                        if (product.products.name == "Pillows") {
                            products3Weight += product.count * 2
                        }
                        if (product.products.name == "BedLinen") {
                            products3Weight += product.count * 2
                        }
                        if (product.products.name == "Mattresses") {
                            products3Weight += product.count * 8
                        }
                        if (product.products.name == "Blanket") {
                            products3Weight += product.count * 7
                        }
                    }
                }
            }
            if (orders4 != null) {
                launch {
                    for (product in orders4) {
                        products4List.add(product)
                        if (product.products.name == "KitchenCabinet") {
                            products4Weight += product.count * 100
                        }
                        if (product.products.name == "ShoeBox") {
                            products4Weight += product.count * 35
                        }
                        if (product.products.name == "WardrobeCloset") {
                            products4Weight += product.count * 100
                        }
                        if (product.products.name == "Bed") {
                            products4Weight += product.count * 50
                        }
                    }
                }
            }
            delay(300)
            TruckAcceptancePortObject.wareHouse.saveWeightAnyTruck(
                2,
                products2Weight + products2Weight + products3Weight
            )
            delay(120)
            return Truck.Truck2(
                2,
                products2Weight + products3Weight + products4Weight,
                null,
                products2List as List<SmallSizedGoods>,
                products3List as List<MediumSizedGoods>,
                products4List as List<BulkyGoods>,
                supplierName

            )

        } else {
            launch {
                for (product in orders) {
                    products1List.add(product)
                    if (product.products.name == "Bread") {
                        products2Weight += product.count * 1
                    }
                    if (product.products.name == "Milk") {
                        products2Weight += product.count * 1
                    }
                    if (product.products.name == "Potato") {
                        products2Weight += product.count * 1
                    }
                    if (product.products.name == "Meat") {
                        products2Weight += product.count * 1
                    }
                }
            }
            delay(300)
            TruckAcceptancePortObject.wareHouse.saveWeightAnyTruck(2, products2Weight)
            delay(120)
            return Truck.Truck2(
                2,
                products1Weight,
                products1List as List<FoodProducts>,
                null,
                null,
                null,
                supplierName
            )
        }

    }

    suspend fun CoroutineScope.uploadingByTheSupplier3(
        orders: ReceiveChannel<FoodProducts>?,
        orders2: ReceiveChannel<SmallSizedGoods>?,
        orders3: ReceiveChannel<MediumSizedGoods>?,
        orders4: ReceiveChannel<BulkyGoods>?,
        supplierName: String
    ): Truck.Truck3 {

        val products1List = mutableListOf<FoodProducts>()
        val products2List = mutableListOf<SmallSizedGoods>()
        val products3List = mutableListOf<MediumSizedGoods>()
        val products4List = mutableListOf<BulkyGoods>()
        var products1Weight = 0
        var products2Weight = 0
        var products3Weight = 0
        var products4Weight = 0
        if (orders == null) {
            if (orders2 != null) {
                launch {
                    for (product in orders2) {
                        products2List.add(product)
                        if (product.products.name == " Laptop") {
                            products2Weight += product.count * 3
                        }
                        if (product.products.name == "VideoProjector") {
                            products2Weight += product.count * 4
                        }
                        if (product.products.name == "SpeakerSystem") {
                            products2Weight += product.count * 2
                        }
                        if (product.products.name == "RemovableDisk") {
                            products2Weight += product.count * 1
                        }
                    }
                }
            }
            if (orders3 != null) {
                launch {
                    for (product in orders3) {
                        products3List.add(product)
                        if (product.products.name == "Pillows") {
                            products3Weight += product.count * 2
                        }
                        if (product.products.name == "BedLinen") {
                            products3Weight += product.count * 2
                        }
                        if (product.products.name == "Mattresses") {
                            products3Weight += product.count * 8
                        }
                        if (product.products.name == "Blanket") {
                            products3Weight += product.count * 7
                        }
                    }
                }
            }
            if (orders4 != null) {
                launch {
                    for (product in orders4) {
                        products4List.add(product)
                        if (product.products.name == "KitchenCabinet") {
                            products4Weight += product.count * 100
                        }
                        if (product.products.name == "ShoeBox") {
                            products4Weight += product.count * 35
                        }
                        if (product.products.name == "WardrobeCloset") {
                            products4Weight += product.count * 100
                        }
                        if (product.products.name == "Bed") {
                            products4Weight += product.count * 50
                        }
                    }
                }
            }
            delay(300)
            TruckAcceptancePortObject.wareHouse.saveWeightAnyTruck(
                3,
                products2Weight + products2Weight + products3Weight
            )
            delay(120)
            return Truck.Truck3(
                3,
                products2Weight + products3Weight + products4Weight,
                null,
                products2List as List<SmallSizedGoods>,
                products3List as List<MediumSizedGoods>,
                products4List as List<BulkyGoods>,
                supplierName
            )


        } else {
            launch {
                for (product in orders) {
                    products1List.add(product)
                    if (product.products.name == "Bread") {
                        products2Weight += product.count * 1
                    }
                    if (product.products.name == "Milk") {
                        products2Weight += product.count * 1
                    }
                    if (product.products.name == "Potato") {
                        products2Weight += product.count * 1
                    }
                    if (product.products.name == "Meat") {
                        products2Weight += product.count * 1
                    }
                }
            }
            delay(300)
            TruckAcceptancePortObject.wareHouse.saveWeightAnyTruck(2, products1Weight)
            delay(120)
            return Truck.Truck3(
                3,
                products1Weight,
                products1List as List<FoodProducts>,
                null,
                null,
                null,
                supplierName
            )


        }

    }
}