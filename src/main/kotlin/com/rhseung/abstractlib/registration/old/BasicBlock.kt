//package com.rhseung.abstractlib.registration.old
//
//import com.rhseung.abstractlib.api.ToolType
//import com.rhseung.abstractlib.api.file.path.Location
//import com.rhseung.abstractlib.api.utility.InitOnce.Companion.initOnce
//import com.rhseung.abstractlib.registration.ToolLevel
//import com.rhseung.abstractlib.registration.ToolLevel.Companion.using
//import com.rhseung.abstractlib.registration.key.IRegistryKey
//import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
//import net.minecraft.block.AbstractBlock
//import net.minecraft.block.Block
//import net.minecraft.item.BlockItem
//import net.minecraft.item.Item
//import net.minecraft.registry.Registries
//import net.minecraft.registry.Registry
//import net.minecraft.registry.RegistryKey
//import kotlin.reflect.KClass
//
//open class BasicBlock(
//    var requiredToolLevel: ToolLevel = MiningLevel.WOOD using ToolType.ANY,    // todo: auto generate mining level tag
//    var setting: Settings = Settings.create()
//) : Block(setting), IRegistryKey, IBasicThing {
//
//    override var id: Location by initOnce()
//    override val names = mutableMapOf<KClass<*>, String>()
//    override var itemGroup: Group by initOnce()
//    private var item: BlockItem by initOnce()
//
//    init {
//        // test: 이걸로 해보고 안되면 IModInit의 langUpdate 함수 사용하기
////        langUpdate()
//    }
//
//    override fun toString(): String {
//        return "BasicBlock(loc=$id, setting=$setting)"
//    }
//
//    override fun register() {
//        Registry.register(Registries.BLOCK, id, this)
//        Registry.register(Registries.ITEM, id, item)
//
//        ItemGroupEvents.modifyEntriesEvent(itemGroup)
//            .register(ItemGroupEvents.ModifyEntries { entries -> entries.add(this) })
//    }
//
//    companion object {
//        /**
//         * @property itemGroup [RegistryKey]
//         * @property group [BasicItemGroup]
//         * @property setting [AbstractBlock.Settings]
//         * @property requiredToolLevel [ToolLevel] <=> [MiningLevel] using [ToolType]
//         */
//        operator fun invoke(builder: Builder.() -> Unit): BasicBlock {
//            return Builder().apply(builder).build()
//        }
//    }
//
//    class Builder {
//        var itemGroup: Group? = null
//        var group: BasicItemGroup? = null
//        // todo: setting 밖으로 꺼내기
//        var setting: Settings = Settings.create()
//        var requiredToolLevel: ToolLevel = MiningLevel.WOOD using ToolType.ANY
//
//        fun build(): BasicBlock {
//            val block = BasicBlock(requiredToolLevel, setting)
//
//            check(itemGroup == null || group == null) {
//                "itemGroup과 group 중 하나만 설정해야 합니다."
//            }
//
//            if (group != null)
//                itemGroup = group!!.registry
//
//            if (itemGroup != null)
//                block.itemGroup = itemGroup!!
//
//            block.item = BlockItem(block, Item.Settings())
//
//            return block
//        }
//    }
//}