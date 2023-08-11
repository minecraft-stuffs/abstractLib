package com.rhseung.abstractlib.registration.example

import com.rhseung.abstractlib.api.Languages
import com.rhseung.abstractlib.api.annotation.Lang
import com.rhseung.abstractlib.registration.MyRegistry
import com.rhseung.abstractlib.registration.MyRegistry.ITEMS
import net.minecraft.item.ItemGroups

object ModItems : IModInit {
    val example_ingot = ITEMS.register("example_ingot") {
        maxStackCount { 16 }
        vanillaGroup { ItemGroups.INGREDIENTS }
    }
}