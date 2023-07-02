package com.rhseung.abstractlib.init

import com.rhseung.abstractlib.api.Location
import com.rhseung.abstractlib.api.Translation
import net.minecraft.block.Block

class BasicBlock(
    val id: Location,
    private val setting: Settings
) : Block(setting), IBasicRegistryKey {
    constructor(loc: Location) : this(loc, Settings.create())

    override var translationName = Translation(
        en_us = id.path.lowercase().split("_").joinToString(" ") { it.replaceFirstChar { it.titlecase() } },
        ko_kr = ""
    )

    override fun toString(): String {
        return "BasicBlock(loc=$id, setting=$setting)"
    }
}