package com.rhseung.abstractlib.init.example

import com.rhseung.abstractlib.Mod
import com.rhseung.abstractlib.api.file.Location.Companion.of
import com.rhseung.abstractlib.api.MiningLevel
import com.rhseung.abstractlib.api.ToolType.Companion.AXE
import com.rhseung.abstractlib.api.ToolType.Companion.HOE
import com.rhseung.abstractlib.api.ToolType.Companion.PICKAXE
import com.rhseung.abstractlib.api.ToolType.Companion.SHOVEL
import com.rhseung.abstractlib.api.annotation.ko_kr
import com.rhseung.abstractlib.init.IInit
import com.rhseung.abstractlib.registration.Register.block
import com.rhseung.abstractlib.registration.Register.item
import com.rhseung.abstractlib.registration.Register.using
import net.minecraft.item.ItemGroups

object ModInit : IInit {
    @ko_kr("황동 주괴")
    val BRASS_INGOT = item("brass_ingot" of Mod.modId) {
        itemGroup = ItemGroups.INGREDIENTS
    }

    @ko_kr("블록 1")
    val BLOCK_1 = block("block_1" of Mod.modId) {
        itemGroup = ItemGroups.BUILDING_BLOCKS
        requiresTool = MiningLevel.WOOD using PICKAXE
        setting = setting
            .strength(5.0f, 6.0f)
    }

    @ko_kr("블록 2")
    val BLOCK_2 = block("block_2" of Mod.modId) {
        itemGroup = ItemGroups.BUILDING_BLOCKS
        requiresTool = MiningLevel.STONE using AXE
        setting = setting
            .strength(5.0f, 6.0f)
    }

    @ko_kr("블록 3")
    val BLOCK_3 = block("block_3" of Mod.modId) {
        itemGroup = ItemGroups.BUILDING_BLOCKS
        requiresTool = MiningLevel.IRON using SHOVEL
        setting = setting
            .strength(5.0f, 6.0f)
    }

    @ko_kr("블록 4")
    val BLOCK_4 = block("block_4" of Mod.modId) {
        itemGroup = ItemGroups.BUILDING_BLOCKS
        requiresTool = MiningLevel.DIAMOND using HOE
        setting = setting
            .strength(5.0f, 6.0f)
    }

    @ko_kr("블록 5")
    val BLOCK_5 = block("block_5" of Mod.modId) {
        itemGroup = ItemGroups.BUILDING_BLOCKS
        requiresTool = MiningLevel.NETHERITE using PICKAXE
        setting = setting
            .strength(5.0f, 6.0f)
    }
}