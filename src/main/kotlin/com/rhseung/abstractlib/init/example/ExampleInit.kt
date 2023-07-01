package com.rhseung.abstractlib.init.example

import com.rhseung.abstractlib.Mod
import com.rhseung.abstractlib.api.Location.Companion.div
import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.init.IInit
import com.rhseung.abstractlib.init.Register.Companion.block
import com.rhseung.abstractlib.init.Register.Companion.item
import net.minecraft.item.ItemGroups

object ExampleInit : IInit {
    val EXAMPLE_INGOT = item(Mod.modId / "example_ingot") {
        group = ItemGroups.BUILDING_BLOCKS
    }

    @en_us("Block of Example")
    val EXAMPLE_BLOCK = block(Mod.modId / "example_block") {}
}