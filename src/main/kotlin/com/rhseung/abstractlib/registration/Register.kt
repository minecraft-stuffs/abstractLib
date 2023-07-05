package com.rhseung.abstractlib.registration

import com.rhseung.abstractlib.Mod
import com.rhseung.abstractlib.api.file.Location
import com.rhseung.abstractlib.api.MiningLevel
import com.rhseung.abstractlib.api.ToolType
import com.rhseung.abstractlib.registration.ToolLevel.Companion.using
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text
import kotlin.reflect.KClass

object Register {
    infix fun String.of(modId: String) = Location(modId, this)
    
    fun item(loc: Location, lambda: ItemBuilder.() -> Unit): BasicItem {
        return ItemBuilder(loc).apply(lambda).build()
    }

    fun block(loc: Location, lambda: BlockBuilder.() -> Unit): BasicBlock {
        return BlockBuilder(loc).apply(lambda).build()
    }
    
    // note: item group은 item, block과 달리 생성자가 private이라서 상속이 힘들어 BasicItemGroup가 굉장히 모호한 클래스임
    fun itemGroup(loc: Location, lambda: ItemGroupBuilder.() -> Unit): BasicItemGroup {
        return ItemGroupBuilder(loc).apply(lambda).build()
    }

    class ItemBuilder(val loc: Location) {
        var itemGroup: RegistryKey<ItemGroup>? = null
        var setting = Item.Settings()

        fun build(): BasicItem {
            val ret = BasicItem(loc, setting)

            if (itemGroup != null) {
                ItemGroupEvents.modifyEntriesEvent(itemGroup)
                    .register(ItemGroupEvents.ModifyEntries { entries -> entries.add(ret) })
            }

            return Registry.register(Registries.ITEM, loc, ret)
        }
    }

    class BlockBuilder(val loc: Location) {
        var itemGroup: RegistryKey<ItemGroup>? = null
        var toolLevel: ToolLevel = MiningLevel.WOOD using ToolType.ANY
        var setting = AbstractBlock.Settings.create()

        fun build(): BasicBlock {
            if (toolLevel.toolType != ToolType.ANY)
                setting = setting.requiresTool()

            val ret = BasicBlock(loc, toolLevel, setting)
            val blockItem = BlockItem(ret, Item.Settings())

            if (itemGroup != null) {
                ItemGroupEvents.modifyEntriesEvent(itemGroup)
                    .register(ItemGroupEvents.ModifyEntries { entries -> entries.add(blockItem) })
            }

            Registry.register(Registries.ITEM, loc, blockItem)
            return Registry.register(Registries.BLOCK, loc, ret)
        }
    }
    
    class ItemGroupBuilder(val loc: Location) {
        var icon: ItemStack = ItemStack.EMPTY
        var texture = "items.png"
        var special: Boolean = false
        var showRenderName: Boolean = true
        var showScrollbar: Boolean = true

        fun build(): BasicItemGroup {
            val builder = FabricItemGroup.builder()
                .icon { icon }
                .displayName(Text.translatable("${Mod.modId}.${loc.path}"))
                .texture(texture)
            
            if (special)
                builder.special()
            if (!showRenderName)
                builder.noRenderedName()
            if (!showScrollbar)
                builder.noScrollbar()
            
            val registry = RegistryKey.of(RegistryKeys.ITEM_GROUP, loc)
            val itemGroup = Registry.register(Registries.ITEM_GROUP, registry, builder.build())
            return BasicItemGroup(loc, itemGroup, registry)
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T: BasicItem> getItems(kclass: KClass<out T>): List<T> {
        return Registries.ITEM.streamEntries()
            .map { it.value() }
            .filter { kclass.isInstance(it) }
            .map { it as T }
            .toList()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T: BasicItem> getItem(loc: Location): T {
        return Registries.ITEM.get(loc) as T
    }

    @Suppress("UNCHECKED_CAST")
    fun <T: BasicBlock> getBlocks(kclass: KClass<out T>): List<T> {
        return Registries.BLOCK.streamEntries()
            .map { it.value() }
            .filter { kclass.isInstance(it) }
            .map { it as T }
            .toList()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T: BasicBlock> getBlock(loc: Location): T {
        return Registries.BLOCK.get(loc) as T
    }
    
    fun getItemGroups(): List<ItemGroup> {
        return Registries.ITEM_GROUP.streamEntries()
            .map { it.value() }
            .toList()
    }
    
    fun getItemGroup(loc: Location): ItemGroup {
        return Registries.ITEM_GROUP.get(loc) as ItemGroup
    }
}