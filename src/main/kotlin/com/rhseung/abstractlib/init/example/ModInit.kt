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
import com.rhseung.abstractlib.registration.Register.of
import com.rhseung.abstractlib.registration.ToolLevel.Companion.using
import net.minecraft.item.ItemGroups
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.text.Text

object ModInit : IInit {
    @ko_kr("예제 아이템 그룹")
    val EXAMPLE_ITEM_GROUP = itemGroup("example_item_group" of Mod.modId) {
        icon = ItemStack(Items.NETHERITE_PICKAXE)
    }
    
    @ko_kr("황동 주괴")
    val BRASS_INGOT = item("brass_ingot" of Mod.modId) {
        itemGroup = EXAMPLE_ITEM_GROUP.registry
    }
    
    @ko_kr("블록 1")
    val BLOCK_1 = block("block_1" of Mod.modId) {
        itemGroup = EXAMPLE_ITEM_GROUP.registry
        toolLevel = MiningLevel.STONE using PICKAXE
        setting = setting
            .strength(5.0f, 6.0f)
    }
}