package com.rhseung.abstractlib.api

import com.rhseung.abstractlib.registration.Nbt
import com.rhseung.abstractlib.api.file.path.URI
import net.minecraft.item.ItemStack

class NbtStack(
	val stack: ItemStack,
	val nbt: Nbt.NbtCompound
) {
	init {
		// todo: stack.nbt에 nbt handler 적용
	}
	
	companion object {
		// examples
		val gear_data = URI("Gear_Data")
		val stats = URI("Stats")
		val mining_speed = URI("mining_speed")
		val attack_damage = URI("attack_damage")
		val attack_speed = URI("attack_speed")
		val durability = URI("durability")
		val parts = URI("Parts")
		val head = URI("head")
		val binding = URI("binding")
		val handle = URI("Handle")
		val damage = URI("damage")
		val modifiers = URI("modifiers")
		val tag = URI("tag")
	}
	
	// todo: implement
}