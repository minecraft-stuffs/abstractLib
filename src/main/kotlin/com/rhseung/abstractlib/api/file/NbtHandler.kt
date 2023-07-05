package com.rhseung.abstractlib.api.file

object NbtHandler {
	val x = builder {
		compound("Gear_Data") {
			compound("Stats") {
				float("mining_speed")
				float("attack_damage")
				float("attack_speed")
				int("durability")
			}
			compound("Parts") {
				string("Head")
				string("Binding")
				string("Handle")
			}
			int("damage")
		}
		string("tag")
	}
	
	// note: 이렇게 사용?할 예정
	//  - x.get("Gear_Data/Stats/attack_damage").set(3.0)
	//  - URI로 사용하고 싶어요
	
	interface NbtKeyElement
	data class NbtKeyCompound(val key: String, val elements: MutableList<NbtKeyElement>) : NbtKeyElement
	data class NbtKeyList(val key: String) : NbtKeyElement
	data class NbtKeyString(val key: String) : NbtKeyElement
	
	data class NbtKeyLong(val key: String) : NbtKeyElement  // 64bit
	data class NbtKeyInt(val key: String) : NbtKeyElement   // 32bit
	data class NbtKeyShort(val key: String) : NbtKeyElement // 16bit
	data class NbtKeyByte(val key: String) : NbtKeyElement  // 8bit
	
	data class NbtKeyDouble(val key: String) : NbtKeyElement    // 64bit
	data class NbtKeyFloat(val key: String) : NbtKeyElement     // 32bit
	
	fun builder(block: NbtKeyCompoundBuilder.() -> Unit): NbtKeyCompound {
		return NbtKeyCompoundBuilder("").apply(block).build()   // head
	}
	
	class NbtKeyCompoundBuilder(val key: String) {
		private var elements: MutableList<NbtKeyElement> = mutableListOf()
		
		fun compound(key: String, block: NbtKeyCompoundBuilder.() -> Unit) {
			elements.add(NbtKeyCompoundBuilder(key).apply(block).build())
		}
		
		fun string(key: String) {
			elements.add(NbtKeyString(key))
		}
		
		fun int(key: String) {
			elements.add(NbtKeyInt(key))
		}
		
		fun float(key: String) {
			elements.add(NbtKeyFloat(key))
		}
		
		fun list(key: String) {
			elements.add(NbtKeyList(key))
		}
		
		fun long(key: String) {
			elements.add(NbtKeyLong(key))
		}
		
		fun short(key: String) {
			elements.add(NbtKeyShort(key))
		}
		
		fun byte(key: String) {
			elements.add(NbtKeyByte(key))
		}
		
		fun double(key: String) {
			elements.add(NbtKeyDouble(key))
		}
		
		fun build() = NbtKeyCompound(key, elements)
	}
}