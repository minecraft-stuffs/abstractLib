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
		
		Register.Item.ITEM.forEach { item ->
			Registry.register(Registries.ITEM, item.id, item)
		}
		Register.Block.BLOCK.forEach { block ->
			Registry.register(Registries.BLOCK, block.id, block)
			Registry.register(Registries.ITEM, block.id, block.item)
		}
		Register.ItemGroup.ITEM_GROUP.forEach { itemGroup ->
			Registry.register(Registries.ITEM_GROUP, itemGroup.registry, itemGroup.group)
		}
		
		// todo: reflection to language annotation
	}
	
	open fun register(item: Register.Item, block: Register.Block, itemGroup: Register.ItemGroup) {}
}