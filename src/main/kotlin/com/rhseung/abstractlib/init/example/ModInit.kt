package com.rhseung.abstractlib.init.example

import com.rhseung.abstractlib.Mod
import com.rhseung.abstractlib.api.MiningLevel
import com.rhseung.abstractlib.api.ToolType.Companion.AXE
import com.rhseung.abstractlib.api.ToolType.Companion.HOE
import com.rhseung.abstractlib.api.ToolType.Companion.PICKAXE
import com.rhseung.abstractlib.api.ToolType.Companion.SHOVEL
import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.api.annotation.ko_kr
import com.rhseung.abstractlib.init.IInit
import com.rhseung.abstractlib.registration.Register.block
import com.rhseung.abstractlib.registration.Register.item
import com.rhseung.abstractlib.registration.Register.itemGroup
import com.rhseung.abstractlib.registration.ToolLevel.Companion.using
import net.minecraft.item.ItemGroups
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.text.Text

object ModInit : IInit {
    @ko_kr("예제 아이템 그룹")
    val EXAMPLE_ITEM_GROUP = itemGroup("example_item_group") {
        icon = ItemStack(Items.NETHERITE_PICKAXE)
    }
    
    @ko_kr("황동 주괴")
    val BRASS_INGOT = item("brass_ingot") {
        itemGroup = EXAMPLE_ITEM_GROUP.registry
    }
    
    @ko_kr("블록 1")
    val BLOCK_1 = block("block_1") {
        itemGroup = EXAMPLE_ITEM_GROUP.registry
        toolLevel = MiningLevel.WOOD using PICKAXE
        setting = setting
            .strength(5.0f, 6.0f)
    }

    @ko_kr("블록 2")
    val BLOCK_2 = block("block_2") {
        itemGroup = EXAMPLE_ITEM_GROUP.registry
        toolLevel = MiningLevel.STONE using AXE
        setting = setting
            .strength(5.0f, 6.0f)
    }

    @ko_kr("블록 3")
    val BLOCK_3 = block("block_3") {
        itemGroup = EXAMPLE_ITEM_GROUP.registry
        toolLevel = MiningLevel.IRON using SHOVEL
        setting = setting
            .strength(5.0f, 6.0f)
    }

    @ko_kr("블록 4")
    val BLOCK_4 = block("block_4") {
        itemGroup = EXAMPLE_ITEM_GROUP.registry
        toolLevel = MiningLevel.DIAMOND using HOE
        setting = setting
            .strength(5.0f, 6.0f)
    }

    @ko_kr("블록 5")
    val BLOCK_5 = block("block_5") {
        itemGroup = EXAMPLE_ITEM_GROUP.registry
        toolLevel = MiningLevel.NETHERITE using PICKAXE
        setting = setting
            .strength(5.0f, 6.0f)
    }
}