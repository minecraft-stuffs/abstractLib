package com.rhseung.abstractlib.registration.key

import com.rhseung.abstractlib.api.MiningLevel
import com.rhseung.abstractlib.api.StringStyle.titlecase
import com.rhseung.abstractlib.api.ToolType
import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.api.annotation.ko_kr
import com.rhseung.abstractlib.api.file.path.Location
import com.rhseung.abstractlib.api.utility.ErrorSolver
import com.rhseung.abstractlib.registration.ToolLevel
import com.rhseung.abstractlib.registration.ToolLevel.Companion.using
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

open class BasicBlock(
    override val id: Location,
    var requiredToolLevel: ToolLevel,    // todo: auto generate mining level tag
    var setting: Settings,
) : Block(setting), IBasicRegistryKey {
    constructor(loc: Location) : this(loc, MiningLevel.WOOD using ToolType.ANY, Settings.create())

    init { langUpdate() }

    val item = BlockItem(this, Item.Settings())
    
    override val names = mutableMapOf<KClass<*>, String>(
        en_us::class to id.path.titlecase()
    )

    override fun toString(): String {
        return "BasicBlock(loc=$id, setting=$setting)"
    }

    // todo: 각 key마다 builder를 가지기
}