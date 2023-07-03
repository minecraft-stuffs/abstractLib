package com.rhseung.abstractlib.registration

import com.rhseung.abstractlib.api.file.Location
import com.rhseung.abstractlib.api.MiningLevel
import com.rhseung.abstractlib.api.StringStyle.titlecase
import com.rhseung.abstractlib.api.ToolType
import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.registration.ToolLevel.Companion.using
import net.minecraft.block.Block
import kotlin.reflect.KClass

open class BasicBlock(
    val id: Location,
    val requiresTool: ToolLevel,
    private val setting: Settings
) : Block(setting), IBasicRegistryKey {
    constructor(loc: Location) : this(loc, MiningLevel.WOOD using ToolType.ANY, Settings.create())
    
    override var translationName = mutableMapOf<KClass<*>, String>(
        en_us::class to id.path.titlecase()
    )

    override fun toString(): String {
        return "BasicBlock(loc=$id, setting=$setting)"
    }
}