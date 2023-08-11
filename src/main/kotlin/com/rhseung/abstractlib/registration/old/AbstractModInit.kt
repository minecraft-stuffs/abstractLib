package com.rhseung.abstractlib.registration.old//package com.rhseung.abstractlib.registration
//
//import net.minecraft.registry.Registries
//import net.minecraft.registry.Registry
//
//@Deprecated("사장됨, 이유: 리플렉션으로도 로컬 변수를 얻어낼 수 없어 어노테이션 사용 불가능")
//abstract class AbstractModInit(
//	val modid: String
//) {
//	open fun update() {
//		val itemRegistry = Register.Item(modid)
//		val blockRegistry = Register.Block(modid)
//		val itemGroupRegistry = Register.ItemGroup(modid)
//
//		register(itemRegistry, blockRegistry, itemGroupRegistry)
//
//		Register.loopItem { item ->
//			Registry.register(Registries.ITEM, item.id, item)
//		}
//		Register.loopBlock { block ->
//			Registry.register(Registries.BLOCK, block.id, block)
//			Registry.register(Registries.ITEM, block.id, block.item)    // blockitem
//		}
//		Register.loopItemGroup { itemGroup ->
//			Registry.register(Registries.ITEM_GROUP, itemGroup.registry, itemGroup.group)
//		}
//	}
//
//	open fun register(item: Register.item, block: Register.Block, itemGroup: Register.ItemGroup) {}
//}