package com.rhseung.abstractlib.registration.key

import com.rhseung.abstractlib.api.StringStyle.titlecase
import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.api.file.path.Location
import net.minecraft.item.ItemGroup
import net.minecraft.registry.RegistryKey
import kotlin.reflect.KClass

typealias Group = RegistryKey<ItemGroup>

open class BasicItemGroup(
	val id: Location,
	var registry: RegistryKey<ItemGroup>,
	var group: ItemGroup
) : IBasicKey {
    override var names = mutableMapOf<KClass<*>, String>(
        en_us::class to id.path.titlecase()
    )

    override fun toString(): String {
        return "BasicItemGroup(loc=$id, registry=$registry)"
    }
}