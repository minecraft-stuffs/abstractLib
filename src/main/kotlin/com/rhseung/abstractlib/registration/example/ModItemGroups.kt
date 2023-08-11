package com.rhseung.abstractlib.registration.example

import com.rhseung.abstractlib.registration.MyRegistry.ITEM_GROUPS
import net.minecraft.item.ItemStack

object ModItemGroups : IModInit {
    val TOOLS = ITEM_GROUPS.register("tools") {
        icon { ItemStack(ModItems.example_ingot) }
    }
}