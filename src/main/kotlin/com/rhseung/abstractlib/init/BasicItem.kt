package com.rhseung.abstractlib.init

import com.rhseung.abstractlib.api.Location
import com.rhseung.abstractlib.api.Translation
import net.minecraft.item.Item

class BasicItem(
    val loc: Location,
    private val setting: Settings
) : Item(setting), IBasicRegistryKey {
    constructor(loc: Location) : this(loc, Settings())

    override var translationName = Translation(
        en_us = loc.path.lowercase().split("_").joinToString(" ") { it.replaceFirstChar { it.titlecase() } },
        ko_kr = ""
    )

    override fun toString(): String {
        return "BasicItem(loc=$loc, setting=$setting)"
    }
}