package ru.coursework.warehouse23

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
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
import ru.coursework.warehouse23.WareHouseCommonMain.videoProjectorCommonCountInWarehouseFinal
import ru.coursework.warehouse23.WareHouseCommonMain.wardrobeClosetCommonCountInWarehouseFinal

class TruckLoadingGenerator {
    val sharedFlowForAnyTruckLoading = MutableSharedFlow<Truck>(replay = 0,0,BufferOverflow.SUSPEND)
    val sharedFlow_AnyTruckLoading = sharedFlowForAnyTruckLoading.asSharedFlow()
    var scope = CoroutineScope(Job() + Dispatchers.Default)
 /////////////////////////////////////////////////////////////
    val productOneType =
        List(20) { FoodProducts((13..15).random(), FoodProductsTypes.values().random()) }
    val productSecondType =
        List(10) { SmallSizedGoods((13..15).random(), SmallSizedGoodsTypes.values().random()) }
    val productThirdType =
        List(10) { MediumSizedGoods((13..15).random(), MediumSizedGoodsTypes.values().random()) }
    val productFourthType =
        List(2) { BulkyGoods((3..6).random(), BulkyGoodsTypes.values().random()) }
/////////////////////////////////////////////////////////////
val productOneTypeTruck2 =
    List(20) { FoodProducts((13..15).random(), FoodProductsTypes.values().random()) }
    val productSecondTypeTruck2 =
        List(10) { SmallSizedGoods((13..15).random(), SmallSizedGoodsTypes.values().random()) }
    val productThirdTypeTruck2 =
        List(10) { MediumSizedGoods((13..15).random(), MediumSizedGoodsTypes.values().random()) }
    val productFourthTypeTruck2 =
        List(2) { BulkyGoods((3..6).random(), BulkyGoodsTypes.values().random()) }

    suspend fun loadingTrack() {
        var weightBread = 0
        var weightMilk = 0
        var weightPotato = 0
        var weightMeat = 0
        var weightLaptop = 0
        var weightVideoProjector = 0
        var weightSpeakerSystem = 0
        var weightRemovableDisk = 0
        var weightPillows = 0
        var weightBedLinen = 0
        var weightMattresses = 0
        var weightBlanket = 0
        var weightKitchenCabinet = 0
        var weightShoeBox = 0
        var weightWardrobeCloset = 0
        var weightBed = 0
        var weightBreadT2 = 0
        var weightMilkT2 = 0
        var weightPotatoT2 = 0
        var weightMeatT2 = 0
        var weightLaptopT2 = 0
        var weightVideoProjectorT2 = 0
        var weightSpeakerSystemT2 = 0
        var weightRemovableDiskT2 = 0
        var weightPillowsT2 = 0
        var weightBedLinenT2 = 0
        var weightMattressesT2 = 0
        var weightBlanketT2 = 0
        var weightKitchenCabinetT2 = 0
        var weightShoeBoxT2 = 0
        var weightWardrobeClosetT2 = 0
        var weightBedT2 = 0

        var p1Channel: ReceiveChannel<FoodProducts>
        var p2Channel: ReceiveChannel<SmallSizedGoods>
        var p3Channel: ReceiveChannel<MediumSizedGoods>
        var p4Channel: ReceiveChannel<BulkyGoods>
        var p1ChannelT2: ReceiveChannel<FoodProducts>
        var p2ChannelT2: ReceiveChannel<SmallSizedGoods>
        var p3ChannelT2: ReceiveChannel<MediumSizedGoods>
        var p4ChannelT2: ReceiveChannel<BulkyGoods>
        val numberTruckForLoading=(1..2).random()
        if(numberTruckForLoading==1){
      val job= scope.launch {
            productOneType.forEach { someProduct ->
                when (someProduct.products.name) {
                    "Bread" -> {
                        weightBread += someProduct.products.weight * someProduct.count

                    }

                    "Milk" -> {
                        weightMilk += someProduct.products.weight * someProduct.count

                    }

                    "Potato" -> {
                        weightPotato += someProduct.products.weight * someProduct.count

                    }

                    "Meat" -> {
                        weightMeat += someProduct.products.weight * someProduct.count
                    }
                }
            }
            delay(600)
            if (breadCommonCountInWarehouseFinal > weightBread) {
                breadCommonCountInWarehouseFinal -= weightBread
            } else {
                delay(1000)
                if (breadCommonCountInWarehouseFinal > weightBread) {
                    breadCommonCountInWarehouseFinal -= weightBread
                }

            }
            if (milkCommonCountInWarehouseFinal > weightMilk) {
                milkCommonCountInWarehouseFinal -= weightMilk
            } else {
                delay(1000)
                if (milkCommonCountInWarehouseFinal > weightMilk) {
                    milkCommonCountInWarehouseFinal -= weightMilk
                }

            }
            if (potatoCommonCountInWarehouseFinal > weightPotato) {
                potatoCommonCountInWarehouseFinal -= weightPotato
            } else {
                delay(1000)
                if (potatoCommonCountInWarehouseFinal > weightPotato) {
                    potatoCommonCountInWarehouseFinal -= weightPotato
                }

            }
            if (meatCommonCountInWarehouseFinal > weightMeat) {
                meatCommonCountInWarehouseFinal -= weightMeat
            } else {
                delay(1000)
                if (meatCommonCountInWarehouseFinal > weightMeat) {
                    meatCommonCountInWarehouseFinal -= weightMeat
                }

            }
            p1Channel = produce(capacity = Channel.BUFFERED) {
                productOneType.forEach { send(it) }
            }
            //////////////////////////////////
            productSecondType.forEach { someProduct ->
                when (someProduct.products.name) {
                    "Laptop" -> {
                        weightLaptop += someProduct.products.weight * someProduct.count

                    }

                    "VideoProjector" -> {
                        weightVideoProjector += someProduct.products.weight * someProduct.count

                    }

                    "SpeakerSystem" -> {
                        weightSpeakerSystem += someProduct.products.weight * someProduct.count

                    }

                    "RemovableDisk" -> {
                        weightRemovableDisk += someProduct.products.weight * someProduct.count
                    }
                }
            }
            delay(600)
            if (laptopCommonCountInWarehouseFinal > weightLaptop) {
                laptopCommonCountInWarehouseFinal -= weightLaptop
            } else {
                delay(1000)
                if (laptopCommonCountInWarehouseFinal > weightLaptop) {
                    laptopCommonCountInWarehouseFinal -= weightLaptop
                }
            }
            if (videoProjectorCommonCountInWarehouseFinal > weightVideoProjector) {
                videoProjectorCommonCountInWarehouseFinal -= weightVideoProjector
            } else {
                delay(1000)
                if (videoProjectorCommonCountInWarehouseFinal > weightVideoProjector) {
                    videoProjectorCommonCountInWarehouseFinal -= weightVideoProjector
                }

            }
            if (speakerSystemCommonCountInWarehouseFinal > weightSpeakerSystem) {
                speakerSystemCommonCountInWarehouseFinal -= weightSpeakerSystem
            } else {
                delay(1000)
                if (speakerSystemCommonCountInWarehouseFinal > weightSpeakerSystem) {
                    speakerSystemCommonCountInWarehouseFinal -= weightSpeakerSystem
                }
            }
            if (removableDiskCommonCountInWarehouseFinal > weightRemovableDisk) {
                removableDiskCommonCountInWarehouseFinal -= weightRemovableDisk
            } else {
                delay(1000)
                if (removableDiskCommonCountInWarehouseFinal > weightRemovableDisk) {
                    removableDiskCommonCountInWarehouseFinal -= weightRemovableDisk
                }
                //  return@withContext
            }
            p2Channel = produce(capacity = Channel.BUFFERED) {
                productSecondType.forEach { send(it) }
            }

            ////////////////////////////////
            productThirdType.forEach { someProduct ->
                when (someProduct.products.name) {
                    "Pillows" -> {
                        weightPillows += someProduct.products.weight * someProduct.count

                    }

                    "BedLinen" -> {
                        weightBedLinen += someProduct.products.weight * someProduct.count

                    }

                    "Mattresses" -> {
                        weightMattresses += someProduct.products.weight * someProduct.count

                    }

                    "Blanket" -> {
                        weightBlanket += someProduct.products.weight * someProduct.count
                    }
                }
            }
            delay(600)
            if (pillowsCommonCountInWarehouseFinal > weightPillows) {
                pillowsCommonCountInWarehouseFinal -= weightPillows
            } else {
                delay(1000)
                if (pillowsCommonCountInWarehouseFinal > weightPillows) {
                    pillowsCommonCountInWarehouseFinal -= weightPillows
                }
            }
            if (bedLinenCommonCountInWarehouseFinal > weightBedLinen) {
                bedLinenCommonCountInWarehouseFinal -= weightBedLinen
            } else {
                delay(1000)
                if (bedLinenCommonCountInWarehouseFinal > weightBedLinen) {
                    bedLinenCommonCountInWarehouseFinal -= weightBedLinen
                }
            }
            if (mattressesCommonCountInWarehouseFinal > weightMattresses) {
                mattressesCommonCountInWarehouseFinal -= weightMattresses
            } else {
                delay(1000)
                if (mattressesCommonCountInWarehouseFinal > weightMattresses) {
                    mattressesCommonCountInWarehouseFinal -= weightMattresses
                }
//            return@withContext
            }
            if (blanketCommonCountInWarehouseFinal > weightBlanket) {
                blanketCommonCountInWarehouseFinal -= weightBlanket
            } else {
                delay(1000)
                if (blanketCommonCountInWarehouseFinal > weightBlanket) {
                    blanketCommonCountInWarehouseFinal -= weightBlanket
                }
            }
            p3Channel = produce(capacity = Channel.BUFFERED) {
                productThirdType.forEach { send(it) }
            }
            //////////////////////////////////
            productFourthType.forEach { someProduct ->
                when (someProduct.products.name) {
                    " KitchenCabinet" -> {
                        weightKitchenCabinet += someProduct.products.weight * someProduct.count

                    }

                    "ShoeBox" -> {
                        weightShoeBox += someProduct.products.weight * someProduct.count

                    }

                    "WardrobeCloset" -> {
                        weightWardrobeCloset += someProduct.products.weight * someProduct.count

                    }

                    "Bed" -> {
                        weightBed += someProduct.products.weight * someProduct.count
                    }
                }
            }
            delay(600)
            if (kitchenCabinetCommonCountInWarehouseFinal > weightKitchenCabinet) {
                kitchenCabinetCommonCountInWarehouseFinal -= weightKitchenCabinet
            } else {
                delay(1000)
                if (kitchenCabinetCommonCountInWarehouseFinal > weightKitchenCabinet) {
                    kitchenCabinetCommonCountInWarehouseFinal -= weightKitchenCabinet
                }
            }
            if (shoeBoxCommonCountInWarehouseFinal > weightShoeBox) {
                shoeBoxCommonCountInWarehouseFinal -= weightShoeBox
            } else {
                delay(1000)
                if (shoeBoxCommonCountInWarehouseFinal > weightShoeBox) {
                    shoeBoxCommonCountInWarehouseFinal -= weightShoeBox
                }
            }
            if (wardrobeClosetCommonCountInWarehouseFinal > weightWardrobeCloset) {
                wardrobeClosetCommonCountInWarehouseFinal -= weightWardrobeCloset
            } else {
                delay(1000)
                if (wardrobeClosetCommonCountInWarehouseFinal > weightWardrobeCloset) {
                    wardrobeClosetCommonCountInWarehouseFinal -= weightWardrobeCloset
                }
            }
            if (bedCommonCountInWarehouseFinal > weightBed) {
                bedCommonCountInWarehouseFinal -= weightBed
            } else {
                delay(1000)
                if (bedCommonCountInWarehouseFinal > weightBed) {
                    bedCommonCountInWarehouseFinal -= weightBed
                }
            }
            p4Channel = produce(capacity = Channel.BUFFERED) {
                productFourthType.forEach { send(it) }
            }

            val truckWithOnlyFoodProduct = (1..2).random()
            if (truckWithOnlyFoodProduct == 1) {
                val truck =
                    loadingByTheSupplierWareHouse(p1Channel, null, null, null, "База>>> Мегаполис")
                delay(200)
                sharedFlowForAnyTruckLoading.emit(truck)
            } else {

                val truck = loadingByTheSupplierWareHouse(
                    null,
                    p2Channel,
                    p3Channel,
                    p4Channel,
                    "База>>> Мегаполис"
                )
                delay(200)
                sharedFlowForAnyTruckLoading.emit(truck)
            }
        }
            delay(655)
            job.cancel()
            job.join()
      }
        else if(numberTruckForLoading==2)
        {
            val job= scope.launch {
                productOneTypeTruck2.forEach { someProduct ->
                    when (someProduct.products.name) {
                        "Bread" -> {
                            weightBreadT2 += someProduct.products.weight * someProduct.count

                        }

                        "Milk" -> {
                            weightMilkT2 += someProduct.products.weight * someProduct.count

                        }

                        "Potato" -> {
                            weightPotatoT2 += someProduct.products.weight * someProduct.count

                        }

                        "Meat" -> {
                            weightMeatT2 += someProduct.products.weight * someProduct.count
                        }
                    }
                }
                delay(600)
                if (breadCommonCountInWarehouseFinal > weightBreadT2) {
                    breadCommonCountInWarehouseFinal -= weightBreadT2
                } else {
                    delay(1000)
                    if (breadCommonCountInWarehouseFinal > weightBreadT2) {
                        breadCommonCountInWarehouseFinal -= weightBreadT2
                    }

                }
                if (milkCommonCountInWarehouseFinal > weightMilkT2) {
                    milkCommonCountInWarehouseFinal -= weightMilkT2
                } else {
                    delay(1000)
                    if (milkCommonCountInWarehouseFinal > weightMilkT2) {
                        milkCommonCountInWarehouseFinal -= weightMilkT2
                    }

                }
                if (potatoCommonCountInWarehouseFinal > weightPotatoT2) {
                    potatoCommonCountInWarehouseFinal -= weightPotatoT2
                } else {
                    delay(1000)
                    if (potatoCommonCountInWarehouseFinal > weightPotatoT2) {
                        potatoCommonCountInWarehouseFinal -= weightPotatoT2
                    }

                }
                if (meatCommonCountInWarehouseFinal > weightMeatT2) {
                    meatCommonCountInWarehouseFinal -= weightMeatT2
                } else {
                    delay(1000)
                    if (meatCommonCountInWarehouseFinal > weightMeatT2) {
                        meatCommonCountInWarehouseFinal -= weightMeatT2
                    }

                }
                p1ChannelT2 = produce(capacity = Channel.BUFFERED) {
                    productOneTypeTruck2.forEach { send(it) }
                }
                //////////////////////////////////
                productSecondTypeTruck2.forEach { someProduct ->
                    when (someProduct.products.name) {
                        "Laptop" -> {
                            weightLaptopT2 += someProduct.products.weight * someProduct.count

                        }

                        "VideoProjector" -> {
                            weightVideoProjectorT2 += someProduct.products.weight * someProduct.count

                        }

                        "SpeakerSystem" -> {
                            weightSpeakerSystemT2 += someProduct.products.weight * someProduct.count

                        }

                        "RemovableDisk" -> {
                            weightRemovableDiskT2 += someProduct.products.weight * someProduct.count
                        }
                    }
                }
                delay(600)
                if (laptopCommonCountInWarehouseFinal > weightLaptopT2) {
                    laptopCommonCountInWarehouseFinal -= weightLaptopT2
                } else {
                    delay(1000)
                    if (laptopCommonCountInWarehouseFinal > weightLaptopT2) {
                        laptopCommonCountInWarehouseFinal -= weightLaptopT2
                    }
                }
                if (videoProjectorCommonCountInWarehouseFinal > weightVideoProjectorT2) {
                    videoProjectorCommonCountInWarehouseFinal -= weightVideoProjectorT2
                } else {
                    delay(1000)
                    if (videoProjectorCommonCountInWarehouseFinal > weightVideoProjectorT2) {
                        videoProjectorCommonCountInWarehouseFinal -= weightVideoProjectorT2
                    }

                }
                if (speakerSystemCommonCountInWarehouseFinal > weightSpeakerSystemT2) {
                    speakerSystemCommonCountInWarehouseFinal -= weightSpeakerSystemT2
                } else {
                    delay(1000)
                    if (speakerSystemCommonCountInWarehouseFinal > weightSpeakerSystemT2) {
                        speakerSystemCommonCountInWarehouseFinal -= weightSpeakerSystemT2
                    }
                }
                if (removableDiskCommonCountInWarehouseFinal > weightRemovableDiskT2) {
                    removableDiskCommonCountInWarehouseFinal -= weightRemovableDiskT2
                } else {
                    delay(1000)
                    if (removableDiskCommonCountInWarehouseFinal > weightRemovableDiskT2) {
                        removableDiskCommonCountInWarehouseFinal -= weightRemovableDiskT2
                    }
                    //  return@withContext
                }
                p2ChannelT2 = produce(capacity = Channel.BUFFERED) {
                    productSecondTypeTruck2.forEach { send(it) }
                }

                ////////////////////////////////
                productThirdTypeTruck2.forEach { someProduct ->
                    when (someProduct.products.name) {
                        "Pillows" -> {
                            weightPillowsT2 += someProduct.products.weight * someProduct.count

                        }

                        "BedLinen" -> {
                            weightBedLinenT2 += someProduct.products.weight * someProduct.count

                        }

                        "Mattresses" -> {
                            weightMattressesT2 += someProduct.products.weight * someProduct.count

                        }

                        "Blanket" -> {
                            weightBlanketT2 += someProduct.products.weight * someProduct.count
                        }
                    }
                }
                delay(600)
                if (pillowsCommonCountInWarehouseFinal > weightPillowsT2) {
                    pillowsCommonCountInWarehouseFinal -= weightPillowsT2
                } else {
                    delay(1000)
                    if (pillowsCommonCountInWarehouseFinal > weightPillowsT2) {
                        pillowsCommonCountInWarehouseFinal -= weightPillowsT2
                    }
                }
                if (bedLinenCommonCountInWarehouseFinal > weightBedLinenT2) {
                    bedLinenCommonCountInWarehouseFinal -= weightBedLinenT2
                } else {
                    delay(1000)
                    if (bedLinenCommonCountInWarehouseFinal > weightBedLinenT2) {
                        bedLinenCommonCountInWarehouseFinal -= weightBedLinenT2
                    }
                }
                if (mattressesCommonCountInWarehouseFinal > weightMattressesT2) {
                    mattressesCommonCountInWarehouseFinal -= weightMattressesT2
                } else {
                    delay(1000)
                    if (mattressesCommonCountInWarehouseFinal > weightMattressesT2) {
                        mattressesCommonCountInWarehouseFinal -= weightMattressesT2
                    }
//            return@withContext
                }
                if (blanketCommonCountInWarehouseFinal > weightBlanketT2) {
                    blanketCommonCountInWarehouseFinal -= weightBlanketT2
                } else {
                    delay(1000)
                    if (blanketCommonCountInWarehouseFinal > weightBlanketT2) {
                        blanketCommonCountInWarehouseFinal -= weightBlanketT2
                    }
                }
                p3ChannelT2 = produce(capacity = Channel.BUFFERED) {
                    productThirdTypeTruck2.forEach { send(it) }
                }
                //////////////////////////////////
                productFourthTypeTruck2.forEach { someProduct ->
                    when (someProduct.products.name) {
                        " KitchenCabinet" -> {
                            weightKitchenCabinetT2 += someProduct.products.weight * someProduct.count

                        }

                        "ShoeBox" -> {
                            weightShoeBoxT2 += someProduct.products.weight * someProduct.count

                        }

                        "WardrobeCloset" -> {
                            weightWardrobeClosetT2 += someProduct.products.weight * someProduct.count

                        }

                        "Bed" -> {
                            weightBedT2 += someProduct.products.weight * someProduct.count
                        }
                    }
                }
                delay(500)
                if (kitchenCabinetCommonCountInWarehouseFinal > weightKitchenCabinetT2) {
                    kitchenCabinetCommonCountInWarehouseFinal -= weightKitchenCabinetT2
                } else {
                    delay(1000)
                    if (kitchenCabinetCommonCountInWarehouseFinal > weightKitchenCabinetT2) {
                        kitchenCabinetCommonCountInWarehouseFinal -= weightKitchenCabinetT2
                    }
                }
                if (shoeBoxCommonCountInWarehouseFinal > weightShoeBoxT2) {
                    shoeBoxCommonCountInWarehouseFinal -= weightShoeBoxT2
                } else {
                    delay(1000)
                    if (shoeBoxCommonCountInWarehouseFinal > weightShoeBoxT2) {
                        shoeBoxCommonCountInWarehouseFinal -= weightShoeBoxT2
                    }
                }
                if (wardrobeClosetCommonCountInWarehouseFinal > weightWardrobeClosetT2) {
                    wardrobeClosetCommonCountInWarehouseFinal -= weightWardrobeClosetT2
                } else {
                    delay(1000)
                    if (wardrobeClosetCommonCountInWarehouseFinal > weightWardrobeClosetT2) {
                        wardrobeClosetCommonCountInWarehouseFinal -= weightWardrobeClosetT2
                    }
                }
                if (bedCommonCountInWarehouseFinal > weightBedT2) {
                    bedCommonCountInWarehouseFinal -= weightBedT2
                } else {
                    delay(1000)
                    if (bedCommonCountInWarehouseFinal > weightBedT2) {
                        bedCommonCountInWarehouseFinal -= weightBedT2
                    }
                }
                p4ChannelT2 = produce(capacity = Channel.BUFFERED) {
                    productFourthTypeTruck2.forEach { send(it) }
                }

                val truckWithOnlyFoodProduct = (1..2).random()
                if (truckWithOnlyFoodProduct == 1) {
                    val truck =
                        loadingByTheSupplierWareHouse2(p1ChannelT2, null, null, null, "База>>> Мегаполис")
                    delay(200)
                    sharedFlowForAnyTruckLoading.emit(truck)
                } else {

                    val truck = loadingByTheSupplierWareHouse2(
                        null,
                        p2ChannelT2,
                        p3ChannelT2,
                        p4ChannelT2,
                        "База>>> Мегаполис"
                    )
                    delay(200)
                    sharedFlowForAnyTruckLoading.emit(truck)

                }
            }
            delay(655)
            job.cancel()
            job.join()
        }
    }

    private suspend fun CoroutineScope.loadingByTheSupplierWareHouse(
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
                        if(product.products.name==" Laptop") {
                            products2Weight += product.count*3
                        }
                        if(product.products.name=="VideoProjector") {
                            products2Weight += product.count*4
                        }
                        if(product.products.name=="SpeakerSystem") {
                            products2Weight += product.count*2
                        }
                        if(product.products.name=="RemovableDisk") {
                            products2Weight += product.count*1
                        }
                    }
                }
            }
            launch {
                if (orders3 != null) {
                    for (product in orders3) {
                        products3List.add(product)
                        if(product.products.name=="Pillows") {
                            products3Weight += product.count*2
                        }
                        if(product.products.name=="BedLinen") {
                            products3Weight += product.count*2
                        }
                        if(product.products.name=="Mattresses") {
                            products3Weight += product.count*8
                        }
                        if(product.products.name=="Blanket") {
                            products3Weight += product.count*7
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

            delay(110)
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
                    if(product.products.name=="Bread") {
                        products2Weight += product.count*1
                    }
                    if(product.products.name=="Milk") {
                        products2Weight += product.count*1
                    }
                    if(product.products.name=="Potato") {
                        products2Weight += product.count*1
                    }
                    if(product.products.name=="Meat") {
                        products2Weight += product.count*1
                    }
                }
            }

            delay(110)
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
    private suspend fun CoroutineScope.loadingByTheSupplierWareHouse2(
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
            launch {
                if (orders2 != null) {
                    for (product in orders2) {
                        products2List.add(product)
                        if(product.products.name==" Laptop") {
                            products2Weight += product.count*3
                        }
                        if(product.products.name=="VideoProjector") {
                            products2Weight += product.count*4
                        }
                        if(product.products.name=="SpeakerSystem") {
                            products2Weight += product.count*2
                        }
                        if(product.products.name=="RemovableDisk") {
                            products2Weight += product.count*1
                        }
                    }
                }
            }
            launch {
                if (orders3 != null) {
                    for (product in orders3) {
                        products3List.add(product)
                        if(product.products.name=="Pillows") {
                            products3Weight += product.count*2
                        }
                        if(product.products.name=="BedLinen") {
                            products3Weight += product.count*2
                        }
                        if(product.products.name=="Mattresses") {
                            products3Weight += product.count*8
                        }
                        if(product.products.name=="Blanket") {
                            products3Weight += product.count*7
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

            delay(110)
            return Truck.Truck2(
                2,
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
                    if(product.products.name=="Bread") {
                        products2Weight += product.count*1
                    }
                    if(product.products.name=="Milk") {
                        products2Weight += product.count*1
                    }
                    if(product.products.name=="Potato") {
                        products2Weight += product.count*1
                    }
                    if(product.products.name=="Meat") {
                        products2Weight += product.count*1
                    }
                }
            }

            delay(110)
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
}




