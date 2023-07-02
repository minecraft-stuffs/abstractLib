package com.rhseung.abstractlib.registration

import com.rhseung.abstractlib.api.file.Location
import com.rhseung.abstractlib.api.MiningLevel
import com.rhseung.abstractlib.api.StringStyle.titlecase
import com.rhseung.abstractlib.api.ToolType
import com.rhseung.abstractlib.registration.Register.using
import net.minecraft.block.Block

class BasicBlock(
    val id: Location,
    val requiresTool: Pair<MiningLevel, ToolType>,
    private val setting: Settings
) : Block(setting), IBasicRegistryKey {
    constructor(loc: Location) : this(loc, MiningLevel.WOOD using ToolType.ANY, Settings.create())

    override var translationName = mutableMapOf(
        "en_us" to id.path.titlecase()
    )

    override fun toString(): String {
        return "BasicBlock(loc=$id, setting=$setting)"
    }
}