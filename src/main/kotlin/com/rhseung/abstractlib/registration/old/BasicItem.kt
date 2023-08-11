//package com.rhseung.abstractlib.registration.old
//
//import com.rhseung.abstractlib.api.file.path.Location
//import com.rhseung.abstractlib.registration.key.IRegistryKey
//import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
//import net.minecraft.item.Item
//import net.minecraft.registry.Registries
//import net.minecraft.registry.Registry
//import net.minecraft.registry.RegistryKey
//import kotlin.reflect.KClass
//
//open class BasicItem private constructor(
//    override val id: Location,
//    override val names: MutableMap<KClass<*>, String> = mutableMapOf<KClass<*>, String>(),
//    override val itemGroup: Group?,
//    var setting: Settings = Settings()
//) : Item(setting), IRegistryKey, IBasicThing {
//
//    init {
//        // test: 이걸로 해보고 안되면 IModInit의 langUpdate 함수 사용하기
////        langUpdate()
//    }
//
//    override fun toString(): String {
//        return "BasicItem(loc=$id, setting=$setting)"
//    }
//
//    override fun register() {
//        Registry.register(Registries.ITEM, id, this)
//
//        ItemGroupEvents.modifyEntriesEvent(itemGroup)
//            .register(ItemGroupEvents.ModifyEntries { entries -> entries.add(this) })
//    }
//
//    companion object {
//        /**
//         * @property itemGroup [RegistryKey]
//         * @property group [BasicItemGroup]
//         * @property setting [Item.Settings]
//         */
//        operator fun invoke(builder: Builder.() -> Unit): BasicItem {
//            return Builder().apply(builder).build()
//        }
//    }
//
//    class Builder {
//        var itemGroup: Group? = null
//        var group: BasicItemGroup? = null
//        val names = mutableMapOf<KClass<*>, String>()
//        // todo: setting 밖으로 꺼내기
//        var setting: Settings = Settings()
//
//        fun build(): BasicItem {
//
//
//            check(itemGroup == null || group == null) {
//                "itemGroup과 group 중 하나만 설정해야 합니다."
//            }
//
//            if (group != null)
//                itemGroup = group!!.registry
//
//            return BasicItem(id, )
//        }
//    }
//}