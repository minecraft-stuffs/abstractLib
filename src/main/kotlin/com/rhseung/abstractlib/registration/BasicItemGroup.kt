package com.rhseung.abstractlib.registration

import com.rhseung.abstractlib.api.file.Location
import com.rhseung.abstractlib.api.StringStyle.titlecase
import com.rhseung.abstractlib.api.annotation.en_us
import net.minecraft.item.ItemGroup
import net.minecraft.registry.RegistryKey
import kotlin.reflect.KClass

class BasicItemGroup(
    val id: Location,
    val group: ItemGroup,
    val registry: RegistryKey<ItemGroup>
) : IBasicRegistryKey
// , ItemGroup(null, -1, Type.CATEGORY, Text.translatable("${Mod.modId}.${id.path}"),
// { ItemStack.EMPTY }, EntryCollector { displayContext, entries ->  }),
{
    override var translationName = mutableMapOf<KClass<*>, String>(
        en_us::class to id.path.titlecase()
    )

    override fun toString(): String {
        return "BasicItemGroup(loc=$id, group=$group)"
    }
}