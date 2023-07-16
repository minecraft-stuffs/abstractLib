package com.rhseung.abstractlib.api.file

import com.rhseung.abstractlib.registration.Nbt.NbtValue

typealias NbtString = NbtValue<String>
typealias NbtInt = NbtValue<Int>
typealias NbtFloat = NbtValue<Float>
typealias NbtList<T> = NbtValue<List<T>>
typealias NbtLong = NbtValue<Long>
typealias NbtShort = NbtValue<Short>
typealias NbtByte = NbtValue<Byte>
typealias NbtDouble = NbtValue<Double>