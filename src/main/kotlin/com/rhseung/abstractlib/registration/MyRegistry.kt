package com.rhseung.abstractlib.registration

import com.rhseung.abstractlib.api.file.path.Location
import com.rhseung.abstractlib.registration.key.Block
import com.rhseung.abstractlib.registration.key.Item
import com.rhseung.abstractlib.registration.key.ItemGroup

object MyRegistry {
    object ITEMS {
        private val entries = mutableListOf<Item>()

        fun register(name: String, properties: Item.Properties.() -> Unit): Item {
            return Item(Location.of(name), Item.Properties().apply(properties)).also { entries.add(it) }
        }

        fun register(name: String): Item {
            return Item(Location.of(name), Item.Properties()).also { entries.add(it) }
        }

        fun forEach(action: (Item) -> Unit) {
            entries.forEach(action)
        }
    }

    object BLOCKS {
        private val entries = mutableListOf<Block>()

        fun register(name: String, properties: Block.Properties.() -> Unit): Block {
            return Block(Location.of(name), Block.Properties().apply(properties)).also { entries.add(it) }
        }

        fun register(name: String): Block {
            return Block(Location.of(name), Block.Properties()).also { entries.add(it) }
        }

        fun forEach(action: (Block) -> Unit) {
            entries.forEach(action)
        }
    }

    object ITEM_GROUPS {
        private val entries = mutableListOf<ItemGroup>()

        fun register(name: String, properties: ItemGroup.Properties.() -> Unit): ItemGroup {
            return ItemGroup(Location.of(name), ItemGroup.Properties().apply(properties)).also { entries.add(it) }
        }

        fun register(name: String): ItemGroup {
            return ItemGroup(Location.of(name), ItemGroup.Properties()).also { entries.add(it) }
        }

        fun forEach(action: (ItemGroup) -> Unit) {
            entries.forEach(action)
        }
    }
}