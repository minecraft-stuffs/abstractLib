//package com.rhseung.abstractlib.registration.old
//
//import com.rhseung.abstractlib.registration.old.MyRegister.Companion.ITEM_GROUP
//import net.minecraft.item.ItemStack
//import net.minecraft.item.Items
//
//object ModItemGroups : IModInit<BasicItemGroup> {
//    @ko_kr("예제 아이템 그룹")
//    val example_item_group = ITEM_GROUP.create {
//        BasicItemGroup("example_item_group") {
//            icon = ItemStack(Items.DIAMOND)
//            special = true
//        }
//    }
//}