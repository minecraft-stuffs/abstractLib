package com.rhseung.abstractlib.registration.key

import com.rhseung.abstractlib.api.StringStyle.titlecase
import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.api.file.path.Location
import com.rhseung.abstractlib.api.utility.ErrorSolver
import net.minecraft.item.ItemGroup
import net.minecraft.registry.RegistryKey
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

typealias Group = RegistryKey<ItemGroup>

open class BasicItemGroup(
    override val id: Location,
    var registry: RegistryKey<ItemGroup>,
    var group: ItemGroup
) : IBasicRegistryKey {

    init { langUpdate() }

    override val names = mutableMapOf<KClass<*>, String>(
        en_us::class to id.path.titlecase()
    )

    override fun toString(): String {
        return "BasicItemGroup(loc=$id, registry=$registry)"
    }

    // todo: 각 key마다 builder를 가지기
}