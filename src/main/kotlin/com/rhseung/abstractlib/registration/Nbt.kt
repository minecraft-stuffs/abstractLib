package com.rhseung.abstractlib.registration

import com.rhseung.abstractlib.api.file.*
import com.rhseung.abstractlib.api.file.path.URI
import com.rhseung.abstractlib.api.utility.ErrorSolver
import java.lang.IllegalArgumentException

typealias NbtString = Nbt.NbtValue<String>
typealias NbtInt = Nbt.NbtValue<Int>
typealias NbtFloat = Nbt.NbtValue<Float>
typealias NbtList<T> = Nbt.NbtValue<List<T>>
typealias NbtLong = Nbt.NbtValue<Long>
typealias NbtShort = Nbt.NbtValue<Short>
typealias NbtByte = Nbt.NbtValue<Byte>
typealias NbtDouble = Nbt.NbtValue<Double>

object Nbt {
	interface NbtElement {
		val key: URI
		
		operator fun get(key: URI): NbtElement
		operator fun set(key: URI, value: Any?)
	}
	
	data class NbtCompound(override val key: URI, val elements: List<NbtElement> = listOf()): NbtElement {
		override fun get(key: URI): NbtElement {
			var current: NbtElement = this
			
			key.into { path ->
				check(current is NbtCompound)
				current = (current as NbtCompound).elements.find { it.key.toString() == path }
					?: ErrorSolver.nsee("NbtElement $path not found")
			}
			
			return current
		}
		
		override fun set(key: URI, value: Any?) {
			val current = get(key)
			
			check(current !is NbtCompound)
			current[key] = value
		}
	}
	
	data class NbtValue<T: Any>(override val key: URI, var value: T? = null): NbtElement {
		override fun get(key: URI) = throw NotImplementedError()
		
		override fun set(key: URI, value: Any?) {
			this.value = (value as? T) ?: throw IllegalArgumentException("NbtValue $key is not T")
		}
	}
	
	fun builder(block: NbtCompoundBuilder.() -> Unit): NbtCompound {
		return NbtCompoundBuilder(URI.root).apply(block).build()
	}
	
	class NbtCompoundBuilder(val key: URI) {
		private var elements: MutableList<NbtElement> = mutableListOf()
		
		fun compound(key: URI, block: NbtCompoundBuilder.() -> Unit) {
			elements.add(NbtCompoundBuilder(key).apply(block).build())
		}
		
		fun string(key: URI) {
			elements.add(NbtString(key))
		}
		
		fun int(key: URI) {
			elements.add(NbtInt(key))
		}
		
		fun float(key: URI) {
			elements.add(NbtFloat(key))
		}
		
		fun <T> list(key: URI) {
			elements.add(NbtList<T>(key))
		}
		
		fun long(key: URI) {
			elements.add(NbtLong(key))
		}
		
		fun short(key: URI) {
			elements.add(NbtShort(key))
		}
		
		fun byte(key: URI) {
			elements.add(NbtByte(key))
		}
		
		fun double(key: URI) {
			elements.add(NbtDouble(key))
		}
		
		fun build() = NbtCompound(key, elements)
	}
}