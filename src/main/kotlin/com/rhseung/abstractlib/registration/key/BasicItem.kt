package com.rhseung.abstractlib.registration.key

import com.rhseung.abstractlib.api.StringStyle.titlecase
import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.api.file.path.Location
import com.rhseung.abstractlib.api.file.path.URI
import com.rhseung.abstractlib.api.utility.ErrorSolver
import com.rhseung.abstractlib.registration.MyRegister
import com.rhseung.abstractlib.registration.Register
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.Item.Settings
import net.minecraft.registry.RegistryKey
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

open class BasicItem(
    override val id: Location,
    var setting: Settings = Settings()
) : Item(setting), IBasicRegistryKey {
    constructor(loc: Location) : this(loc, Settings())

    init { langUpdate() }

    override fun langUpdate() {
        super.langUpdate()
    }

    override val names = mutableMapOf<KClass<*>, String>(
        en_us::class to id.path.titlecase()
    )

    override fun toString(): String {
        return "BasicItem(loc=$id, setting=$setting)"
    }

    companion object {
        /**
         * @param name 아이템의 이름, `modid/itemname` 형식으로 작성
         * @param lambda 아이템의 설정을 DSL 빌더로 작성
         *   - `itemGroup`: [RegistryKey]
         *   - `group`: [BasicItemGroup]
         *   - `setting`: [Settings]
         */
        fun create(name: URI, lambda: Builder.() -> Unit): BasicItem {
            return Builder(Location(name.paths[0], name.paths[1])).apply(lambda).build()
        }

        /**
         * @param name 아이템의 이름, `modid/itemname` 형식으로 작성
         */
        fun create(name: URI): BasicItem {
            return Builder(Location(name.paths[0], name.paths[1])).build()
        }

        /**
         * @param name 아이템의 이름, `itemname of modid` 형식으로 작성
         * @param lambda 아이템의 설정을 DSL 빌더로 작성
         *   - `itemGroup`: [RegistryKey]
         *   - `group`: [BasicItemGroup]
         *   - `setting`: [Settings]
         */
        fun create(name: Location, lambda: Builder.() -> Unit): BasicItem {
            return Builder(name).apply(lambda).build()
        }

        /**
         * @param name 아이템의 이름, `itemname of modid` 형식으로 작성
         */
        fun create(name: Location): BasicItem {
            return Builder(name).build()
        }
    }

    class Builder(private val loc: Location) {
        var itemGroup: Group? = null
        var group: BasicItemGroup? = null
        // todo: setting 밖으로 꺼내기
        var setting: Settings = Settings()

        fun build(): BasicItem {
            val item = BasicItem(loc, setting)

            check(itemGroup != null && group != null) {
                "itemGroup과 group 중 하나만 설정해야 합니다."
            }

            if (group != null) {
                itemGroup = group!!.registry
            }

            if (itemGroup != null) {
                ItemGroupEvents.modifyEntriesEvent(itemGroup)
                    .register(ItemGroupEvents.ModifyEntries { entries -> entries.add(item) })
            }

            return item
        }
    }
}