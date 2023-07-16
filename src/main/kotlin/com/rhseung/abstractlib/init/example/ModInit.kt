package com.rhseung.abstractlib.init.example

import com.rhseung.abstractlib.Mod
import com.rhseung.abstractlib.api.annotation.ko_kr
import com.rhseung.abstractlib.init.IInit
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

object ModInit : IInit {
    // debug
    @ko_kr("예제 아이템 그룹")
    val EXAMPLE_ITEM_GROUP = itemGroup("example_item_group" of Mod.modId) {
        icon = ItemStack(Items.NETHERITE_PICKAXE)
    }
//
//    @ko_kr("황동 주괴")
//    val BRASS_INGOT = item("brass_ingot" of Mod.modId) {
//        itemGroup = EXAMPLE_ITEM_GROUP.registry
//    }
//
//    @ko_kr("블록 1")
//    val BLOCK_1 = block("block_1" of Mod.modId) {
//        itemGroup = EXAMPLE_ITEM_GROUP.registry
//        toolLevel = MiningLevel.STONE using PICKAXE
//        setting = setting
//            .strength(5.0f, 6.0f)
//    }
}