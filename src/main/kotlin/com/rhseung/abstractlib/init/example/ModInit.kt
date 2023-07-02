package com.rhseung.abstractlib.init.example

import com.rhseung.abstractlib.Mod
import com.rhseung.abstractlib.api.Location.Companion.of
import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.init.IInit
import com.rhseung.abstractlib.init.Register.block
import com.rhseung.abstractlib.init.Register.item
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Blocks
import net.minecraft.block.MapColor
import net.minecraft.block.enums.Instrument
import net.minecraft.item.ItemGroups
import net.minecraft.sound.BlockSoundGroup

object ModInit : IInit {
    val BRASS_INGOT = item("brass_ingot" of Mod.modId) {
        group = ItemGroups.INGREDIENTS
    }

    @en_us("Block of Brass")
    val BRASS_BLOCK = block("brass_block" of Mod.modId) {
        group = ItemGroups.BUILDING_BLOCKS
        setting = setting
            .requiresTool()
            .strength(5.0f, 6.0f)
            .mapColor(MapColor.BLUE)
            .instrument(Instrument.BASEDRUM)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
    }
}