package com.rhseung.abstractlib.registration

import net.minecraft.registry.Registries
import net.minecraft.registry.Registry

abstract class AbstractModInit(
	val modid: String
) {
	open fun update() {
		val itemRegistry = Register.Item(modid)
		val blockRegistry = Register.Block(modid)
		val itemGroupRegistry = Register.ItemGroup(modid)
		
		register(itemRegistry, blockRegistry, itemGroupRegistry)
		
		Register.loopItem { item ->
			Registry.register(Registries.ITEM, item.id, item)
		}
		Register.loopBlock { block ->
			Registry.register(Registries.BLOCK, block.id, block)
			Registry.register(Registries.ITEM, block.id, block.item)    // blockitem
		}
		Register.loopItemGroup { itemGroup ->
			Registry.register(Registries.ITEM_GROUP, itemGroup.registry, itemGroup.group)
		}
		
		// todo: reflection to language annotation
		//  - 구조 상 로컬 변수는 런타임 시간에 만들어지므로, 리플렉션으로 얻어낼 수 없음
		//  - 어케하지;
	}
	
	open fun register(item: Register.Item, block: Register.Block, itemGroup: Register.ItemGroup) {}
}