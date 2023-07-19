package com.rhseung.abstractlib.registration

import com.rhseung.abstractlib.api.ToolType
import com.rhseung.abstractlib.api.file.path.Location
import com.rhseung.abstractlib.api.file.path.URI
import com.rhseung.abstractlib.registration.key.*
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.item.Item.Settings
import net.minecraft.item.ItemStack
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text

object Register {
	private object database {
		val ITEM = mutableListOf<BasicItem>()
		val BLOCK = mutableListOf<BasicBlock>()
		val ITEM_GROUP = mutableListOf<BasicItemGroup>()
	}

	object item {
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
		
		class Builder(private val loc: Location) {
			private val item = BasicItem(loc)
			
			var itemGroup: Group? = null
			var group: BasicItemGroup? = null
			
			// todo: setting 밖으로 꺼내기
			var setting: Settings
				get() = item.setting
				set(value) {
					item.setting = value
				}
			
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
				
				database.ITEM.add(item)
				return item
			}
		}
	}
	
	object block {
		/**
		 * @param name 아이템의 이름, `modid/blockname` 형식으로 작성
		 * @param lambda 아이템의 설정을 DSL 빌더로 작성
		 *   - `itemGroup`: [RegistryKey]
		 *   - `group`: [BasicItemGroup]
		 *   - `requiredToolLevel`: [ToolLevel], `[miningLevel] using [toolType]`로 사용할 수 있다.
		 *   - `setting`: [AbstractBlock.Settings]
		 */
		fun create(name: URI, lambda: Builder.() -> Unit): BasicBlock {
			return Builder(Location(name.paths[0], name.paths[1])).apply(lambda).build()
		}

		/**
		 * @param name 아이템의 이름, `modid/blockname` 형식으로 작성
		 */
		fun create(name: URI): BasicBlock {
			return Builder(Location(name.paths[0], name.paths[1])).build()
		}

		/**
		 * @param name 아이템의 이름, `blockname of modid` 형식으로 작성
		 * @param lambda 아이템의 설정을 DSL 빌더로 작성
		 *   - `itemGroup`: [RegistryKey]
		 *   - `group`: [BasicItemGroup]
		 *   - `requiredToolLevel`: [ToolLevel], `[miningLevel] using [toolType]`로 사용할 수 있다.
		 *   - `setting`: [AbstractBlock.Settings]
		 */
		fun create(name: Location, lambda: Builder.() -> Unit): BasicBlock {
			return Builder(name).apply(lambda).build()
		}

		/**
		 * @param name 아이템의 이름, `blockname of modid` 형식으로 작성
		 */
		fun create(name: Location): BasicBlock {
			return Builder(name).build()
		}
		
		class Builder(private val loc: Location) {
			private val block = BasicBlock(loc)

			var itemGroup: Group? = null
			var group: BasicItemGroup? = null
			
			// todo: setting 밖으로 꺼내기
			var setting: AbstractBlock.Settings
				get() = block.setting
				set(value) {
					block.setting = value
				}
			
			var requiredToolLevel: ToolLevel
				get() = block.requiredToolLevel
				set(value) {
					block.requiredToolLevel = value
				}
			
			fun build(): BasicBlock {
				/**
				 * tool level이 0이라는 건, 손 혹은 나무 등급을 의미한다
				 *  - tool type가 ANY라면, 손으로 채광 가능한 블록이다
				 *  - tool type가 ANY가 아니라면, 나무 도구로 채광 가능한 블록이다
				 */
				if (requiredToolLevel.toolType != ToolType.ANY)
					setting = setting.requiresTool()
				
				val block = BasicBlock(loc, requiredToolLevel, setting)

				check(itemGroup != null && group != null) {
					"itemGroup과 group 중 하나만 설정해야 합니다."
				}

				if (group != null) {
					itemGroup = group!!.registry
				}

				if (itemGroup != null) {
					ItemGroupEvents.modifyEntriesEvent(itemGroup)
						.register(ItemGroupEvents.ModifyEntries { entries -> entries.add(block) })
				}
				
				database.BLOCK.add(block)
				return block
			}
		}
	}
	
	object itemGroup {
		/**
		 * @param name 아이템의 이름, `modid/groupname` 형식으로 작성
		 * @param lambda 아이템의 설정을 DSL 빌더로 작성
		 *   - `icon`: [ItemStack]
		 *   - `texture`: [String]
		 *   - `special`: [Boolean]
		 *   - `showRenderName`: [Boolean]
		 *   - `showScrollbar`: [Boolean]
		 */
		fun create(name: URI, lambda: Builder.() -> Unit): BasicItemGroup {
			return Builder(Location(name.paths[0], name.paths[1])).apply(lambda).build()
		}

		/**
		 * @param name 아이템의 이름, `modid/groupname` 형식으로 작성
		 */
		fun create(name: URI): BasicItemGroup {
			return Builder(Location(name.paths[0], name.paths[1])).build()
		}

		/**
		 * @param name 아이템의 이름, `groupname of modid` 형식으로 작성
		 * @param lambda 아이템의 설정을 DSL 빌더로 작성
		 *   - `icon`: [ItemStack]
		 *   - `texture`: [String]
		 *   - `special`: [Boolean]
		 *   - `showRenderName`: [Boolean]
		 *   - `showScrollbar`: [Boolean]
		 */
		fun create(name: Location, lambda: Builder.() -> Unit): BasicItemGroup {
			return Builder(name).apply(lambda).build()
		}

		/**
		 * @param name 아이템의 이름, `groupname of modid` 형식으로 작성
		 */
		fun create(name: Location): BasicItemGroup {
			return Builder(name).build()
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
				
				database.ITEM_GROUP.add(ret)
				return ret
			}
		}
	}
	
	fun loopItem(iteratee: (BasicItem) -> Unit) {
		database.ITEM.forEach(iteratee)
	}
	
	fun loopBlock(iteratee: (BasicBlock) -> Unit) {
		database.BLOCK.forEach(iteratee)
	}
	
	fun loopItemGroup(iteratee: (BasicItemGroup) -> Unit) {
		database.ITEM_GROUP.forEach(iteratee)
	}
}