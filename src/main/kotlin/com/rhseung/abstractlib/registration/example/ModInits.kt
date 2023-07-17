package com.rhseung.abstractlib.registration.example

import com.rhseung.abstractlib.api.NbtStack
import com.rhseung.abstractlib.api.NbtStack.Companion.attack_damage
import com.rhseung.abstractlib.api.NbtStack.Companion.attack_speed
import com.rhseung.abstractlib.api.NbtStack.Companion.binding
import com.rhseung.abstractlib.api.NbtStack.Companion.damage
import com.rhseung.abstractlib.api.NbtStack.Companion.durability
import com.rhseung.abstractlib.api.NbtStack.Companion.gear_data
import com.rhseung.abstractlib.api.NbtStack.Companion.handle
import com.rhseung.abstractlib.api.NbtStack.Companion.head
import com.rhseung.abstractlib.api.NbtStack.Companion.mining_speed
import com.rhseung.abstractlib.api.NbtStack.Companion.modifiers
import com.rhseung.abstractlib.api.NbtStack.Companion.parts
import com.rhseung.abstractlib.api.NbtStack.Companion.stats
import com.rhseung.abstractlib.api.NbtStack.Companion.tag
import com.rhseung.abstractlib.api.annotation.ko_kr
import com.rhseung.abstractlib.api.file.path.URI.Companion.div
import com.rhseung.abstractlib.registration.AbstractModInit
import com.rhseung.abstractlib.registration.Nbt
import com.rhseung.abstractlib.registration.Register
import net.minecraft.item.ItemGroups
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

class ModInits(val modId: String) : AbstractModInit(modId) {
	override fun register(item: Register.Item, block: Register.Block, group: Register.ItemGroup) {
		val myGroup = group.create("my_group") {
			icon = ItemStack(Items.BARRIER)
		}
		
		val brass_ingot = item.create("brass_ingot") {
			itemGroup = ItemGroups.INGREDIENTS
		}
		
		@ko_kr("예제 아이템")
		val example_item = item.create("example_item")
		
		val stack = NbtStack(ItemStack(example_item),
			Nbt.builder {
				compound(gear_data) {
					compound(stats) {
						float(mining_speed)
						float(attack_damage)
						float(attack_speed)
						int(durability)
					}
					compound(parts) {
						string(head)
						string(binding)
						string(handle)
					}
					int(damage)
					list<Int>(modifiers)
				}
				string(tag)
			}
		)
		
		stack.nbt[gear_data/ stats/ mining_speed] = 1.0f
	}
}