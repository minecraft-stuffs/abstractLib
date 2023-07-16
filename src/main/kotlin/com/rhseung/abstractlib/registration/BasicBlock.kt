package com.rhseung.abstractlib.registration

import com.rhseung.abstractlib.api.file.path.Location
import com.rhseung.abstractlib.api.MiningLevel
import com.rhseung.abstractlib.api.StringStyle.titlecase
import com.rhseung.abstractlib.api.ToolType
import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.registration.ToolLevel.Companion.using
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import kotlin.reflect.KClass

open class BasicBlock(
	val id: Location,
	var requireLevel: ToolLevel,    // todo: auto tag mining level
	var setting: Settings,
) : Block(setting), IBasicKey {
    constructor(loc: Location) : this(loc, MiningLevel.WOOD using ToolType.ANY, Settings.create())
    
    val item = BlockItem(this, Item.Settings())
    
    override var names = mutableMapOf<KClass<*>, String>(
        en_us::class to id.path.titlecase()
    )

    override fun toString(): String {
        return "BasicBlock(loc=$id, setting=$setting)"
    }
}