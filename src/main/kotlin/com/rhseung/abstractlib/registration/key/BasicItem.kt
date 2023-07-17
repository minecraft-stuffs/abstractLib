package com.rhseung.abstractlib.registration.key

import com.rhseung.abstractlib.api.StringStyle.titlecase
import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.api.file.path.Location
import net.minecraft.item.Item
import kotlin.reflect.KClass

open class BasicItem(
	val id: Location,
	var setting: Settings
) : Item(setting), IBasicKey {
    constructor(loc: Location) : this(loc, Settings())
    
    override val names = mutableMapOf<KClass<*>, String>(
        en_us::class to id.path.titlecase()
    )

    override fun toString(): String {
        return "BasicItem(loc=$id, setting=$setting)"
    }
}