package com.rhseung.abstractlib.init.example

import com.rhseung.abstractlib.Mod
import com.rhseung.abstractlib.api.Location.Companion.div
import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.api.annotation.ko_kr
import com.rhseung.abstractlib.init.IBasicRegistryKey
import com.rhseung.abstractlib.init.IInit
import com.rhseung.abstractlib.init.Register.Companion.block
import com.rhseung.abstractlib.init.Register.Companion.item
import net.minecraft.item.ItemGroups

object ExampleInit {
    val EXAMPLE_INGOT = item(Mod.modId / "example_ingot") {
        group = ItemGroups.INGREDIENTS
    }

    @en_us("Block of Example")
    val EXAMPLE_BLOCK = block(Mod.modId / "example_block") {}

    fun register() {
        this::class.java.declaredFields.forEach {
            if (IBasicRegistryKey::class.java.isAssignableFrom(it.type)) {
                it.annotations.forEach { annotation ->
                    when (annotation) {
                        is en_us -> (it.get(this) as IBasicRegistryKey).translationName.en_us = annotation.value
                        is ko_kr -> (it.get(this) as IBasicRegistryKey).translationName.ko_kr = annotation.value
                    }
                }
            }
        }
    }
}