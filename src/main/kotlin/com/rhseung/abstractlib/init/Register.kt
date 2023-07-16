package com.rhseung.abstractlib.init

import com.rhseung.abstractlib.api.ToolType
import com.rhseung.abstractlib.api.file.path.Location
import com.rhseung.abstractlib.registration.*
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.item.Item.Settings
import net.minecraft.item.ItemStack
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text

object Register {
	class Item internal constructor(val modid: String) {
		companion object {
			internal val ITEM = mutableListOf<BasicItem>()
		}
		
		fun create(name: String, lambda: Builder.() -> Unit): BasicItem {
			return Builder(Location(modid, name)).apply(lambda).build()
		}
		
		fun create(name: String): BasicItem {
			return Builder(Location(modid, name)).build()
		}
		
		class Builder(private val loc: Location) {
			private val item = BasicItem(loc)
			
			var itemGroup: Group? = null
				set(value) {
					if (value != null) {
						ItemGroupEvents.modifyEntriesEvent(value)
							.register(ItemGroupEvents.ModifyEntries { entries -> entries.add(item) })
					}
				}
			
			var group: BasicItemGroup? = null
				set(value) {
					if (value != null) {
						ItemGroupEvents.modifyEntriesEvent(value.registry)
							.register(ItemGroupEvents.ModifyEntries { entries -> entries.add(item) })
					}
					field = value
				}
			
			// todo: setting 밖으로 꺼내기
			var setting: Settings
				get() = item.setting
				set(value) {
					item.setting = value
				}
			
			fun build(): BasicItem {
				val ret = BasicItem(loc, setting)
				
				ITEM.add(ret)
				return ret
			}
		}
	}
	
	class Block internal constructor(val modid: String) {
		companion object {
			internal val BLOCK = mutableListOf<BasicBlock>()
		}
		
		fun create(name: String, lambda: Builder.() -> Unit): BasicBlock {
			return Builder(Location(modid, name)).apply(lambda).build()
		}
		
		fun create(name: String): BasicBlock {
			return Builder(Location(modid, name)).build()
		}
		
		class Builder(private val loc: Location) {
			private val block = BasicBlock(loc)
			
			var group: Group? = null
				set(value) {
					if (value != null) {
						ItemGroupEvents.modifyEntriesEvent(value)
							.register(ItemGroupEvents.ModifyEntries { entries -> entries.add(block) })
					}
				}
			
			// todo: setting 밖으로 꺼내기
			var setting: AbstractBlock.Settings
				get() = block.setting
				set(value) {
					block.setting = value
				}
			
			var requireLevel: ToolLevel
				get() = block.requireLevel
				set(value) {
					block.requireLevel = value
				}
			
			fun build(): BasicBlock {
				/**
				 * tool level이 0이라는 건, 손 혹은 나무 등급을 의미한다
				 *  - tool type가 ANY라면, 손으로 채광 가능한 블록이다
				 *  - tool type가 ANY가 아니라면, 나무 도구로 채광 가능한 블록이다
				 */
				if (requireLevel.toolType != ToolType.ANY)
					setting = setting.requiresTool()
				
				val block = BasicBlock(loc, requireLevel, setting)
				
				BLOCK.add(block)
				return block
			}
		}
	}
	
	class ItemGroup internal constructor(val modid: String) {
		companion object {
			internal val ITEM_GROUP = mutableListOf<BasicItemGroup>()
		}
		
		fun create(name: String, lambda: Builder.() -> Unit): BasicItemGroup {
			return Builder(Location(modid, name)).apply(lambda).build()
		}
		
		fun create(name: String): BasicItemGroup {
			return Builder(Location(modid, name)).build()
		}
		
		class Builder(private val loc: Location) {
			var icon: ItemStack = ItemStack.EMPTY
			var texture = "items.png"
			var special: Boolean = false
			var showRenderName: Boolean = true
			var showScrollbar: Boolean = true
			
			fun build(): BasicItemGroup {
				val builder = FabricItemGroup.builder()
					.icon { icon }
					.displayName(Text.translatable("${loc.namespace}.${loc.path}"))
					.texture(texture)
				
				if (special)
					builder.special()
				if (!showRenderName)
					builder.noRenderedName()
				if (!showScrollbar)
					builder.noScrollbar()
				
				val ret = BasicItemGroup(loc, RegistryKey.of(RegistryKeys.ITEM_GROUP, loc), builder.build())
				
				ITEM_GROUP.add(ret)
				return ret
			}
		}
	}
}