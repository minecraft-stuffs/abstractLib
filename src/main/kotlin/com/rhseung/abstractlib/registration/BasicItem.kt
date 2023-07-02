package com.rhseung.abstractlib.registration

import com.rhseung.abstractlib.api.file.Location
import com.rhseung.abstractlib.api.StringStyle.titlecase
import net.minecraft.item.Item

class BasicItem(
    val id: Location,
    private val setting: Settings
) : Item(setting), IBasicRegistryKey {
    constructor(loc: Location) : this(loc, Settings())

    override var translationName = mutableMapOf(
        "en_us" to id.path.titlecase()
    )

    override fun toString(): String {
        return "BasicItem(loc=$id, setting=$setting)"
    }
}