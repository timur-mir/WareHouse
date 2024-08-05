package ru.coursework.warehouse23

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext

object WareHouseCommonMain {
    var breadCommonCountInWarehouseFinal = 0
    var milkCommonCountInWarehouseFinal = 0
    var potatoCommonCountInWarehouseFinal = 0
    var meatCommonCountInWarehouseFinal = 0
    var laptopCommonCountInWarehouseFinal = 0
    var videoProjectorCommonCountInWarehouseFinal = 0
    var speakerSystemCommonCountInWarehouseFinal = 0
    var removableDiskCommonCountInWarehouseFinal = 0
    var pillowsCommonCountInWarehouseFinal = 0
    var bedLinenCommonCountInWarehouseFinal = 0
    var mattressesCommonCountInWarehouseFinal = 0
    var blanketCommonCountInWarehouseFinal = 0
    var kitchenCabinetCommonCountInWarehouseFinal = 0
    var shoeBoxCommonCountInWarehouseFinal = 0
    var wardrobeClosetCommonCountInWarehouseFinal = 0
    var bedCommonCountInWarehouseFinal = 0
    var timeForUnloadingTruck1Final: Long = 0
    var timeForUnloadingTruck2Final: Long = 0
    var timeForUnloadingTruck3Final: Long = 0
    fun eraseSomeDataBase() {
        timeForUnloadingTruck1Final = 0
        timeForUnloadingTruck2Final = 0
        timeForUnloadingTruck3Final = 0
    }
    fun getCommonWeightInWarehouse():Int{
        return   breadCommonCountInWarehouseFinal+
         milkCommonCountInWarehouseFinal+
         potatoCommonCountInWarehouseFinal+
         meatCommonCountInWarehouseFinal+
         laptopCommonCountInWarehouseFinal+
         videoProjectorCommonCountInWarehouseFinal+
         speakerSystemCommonCountInWarehouseFinal+
         removableDiskCommonCountInWarehouseFinal+
         pillowsCommonCountInWarehouseFinal+
         bedLinenCommonCountInWarehouseFinal+
         mattressesCommonCountInWarehouseFinal+
         blanketCommonCountInWarehouseFinal+
         kitchenCabinetCommonCountInWarehouseFinal+
         shoeBoxCommonCountInWarehouseFinal+
         wardrobeClosetCommonCountInWarehouseFinal+
         bedCommonCountInWarehouseFinal
    }
}