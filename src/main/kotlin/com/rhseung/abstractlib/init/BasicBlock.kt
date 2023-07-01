package com.rhseung.abstractlib.init

import com.rhseung.abstractlib.api.Location
import com.rhseung.abstractlib.api.Translation
import net.minecraft.block.AbstractBlock.Settings
import net.minecraft.block.Block

class BasicBlock(
    val loc: Location,
    private val setting: Settings
) : Block(setting), IBasicRegistryKey {
    constructor(loc: Location) : this(loc, Settings.create())

    override var translationName = Translation(
        en_us = loc.path.lowercase().split("_").joinToString(" ") { it.replaceFirstChar { it.titlecase() } },
        ko_kr = ""
    )

    override fun toString(): String {
        return "BasicBlock(loc=$loc, setting=$setting)"
    }
}