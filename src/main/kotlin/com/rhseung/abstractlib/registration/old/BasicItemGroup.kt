//package com.rhseung.abstractlib.registration.old
//
//import com.rhseung.abstractlib.api.file.path.Location
//import com.rhseung.abstractlib.api.file.path.URI
//import com.rhseung.abstractlib.api.utility.InitOnce.Companion.initOnce
//import com.rhseung.abstractlib.api.utility.InitOnce.Companion.lazy
//import com.rhseung.abstractlib.registration.key.IRegistryKey
//import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
//import net.minecraft.item.ItemGroup
//import net.minecraft.item.ItemStack
//import net.minecraft.registry.Registries
//import net.minecraft.registry.Registry
//import net.minecraft.registry.RegistryKey
//import net.minecraft.registry.RegistryKeys
//import net.minecraft.text.Text
//import kotlin.reflect.KClass
//
//typealias Group = RegistryKey<ItemGroup>
//
//open class BasicItemGroup(
//    val group: ItemGroup
//) : IRegistryKey {
//
//    override var id: Location by initOnce()
//    val registry: Group by lazy { RegistryKey.of(RegistryKeys.ITEM_GROUP, id) }
//    override val names = mutableMapOf<KClass<*>, String>()
//
//    init {
//        // test: 이걸로 해보고 안되면 IModInit의 langUpdate 함수 사용하기
////        langUpdate()
//    }
//
//    override fun toString(): String {
//        return "BasicItemGroup(loc=$id, registry=$registry)"
//    }
//
//    override fun register() {
//        Registry.register(Registries.ITEM_GROUP, registry, this.group)
//    }
//
//    companion object {
//        /**
//         * @param name [String]
//         * @property icon [ItemStack]
//         * @property texture [String] = "items.png"
//         * @property special [Boolean] = false
//         * @property showRenderName [Boolean] = true
//         * @property showScrollbar [Boolean] = true
//         */
//        operator fun invoke(name: String, builder: Builder.() -> Unit): BasicItemGroup {
//            return Builder(name).apply(builder).build()
//        }
//    }
//
//    class Builder(name: String) {
//        val id = Location(URI.getModId(), name)
//        var icon: ItemStack = ItemStack.EMPTY
//        var texture = "items.png"
//        var special: Boolean = false
//        var showRenderName: Boolean = true
//        var showScrollbar: Boolean = true
//
//        fun build(): BasicItemGroup {
//            val builder = FabricItemGroup.builder()
//                .icon { icon }
//                .displayName(Text.translatable("${id.namespace}.${id.path}"))
//                .texture(texture)
//
//            if (special)
//                builder.special()
//            if (!showRenderName)
//                builder.noRenderedName()
//            if (!showScrollbar)
//                builder.noScrollbar()
//
//            val group = BasicItemGroup(builder.build())
//
//            return group
//        }
//    }
//}