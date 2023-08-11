//package com.rhseung.abstractlib.registration.old
//
//import com.rhseung.abstractlib.api.StringStyle.titlecase
//import com.rhseung.abstractlib.api.file.path.Location
//import com.rhseung.abstractlib.api.file.path.URI
//import com.rhseung.abstractlib.registration.key.IRegistryKey
//
//class MyRegister<T: IRegistryKey> private constructor() {
//    private val modId = URI.getModId()
//    private val entries = mutableListOf<T>()
//
//    fun create(name: String = "", key: () -> T): T {
//        return key().apply {
//            id = Location(modId, name)
//            names[en_us::class] = id.path.titlecase()
//
//            entries.add(this)
//        }
//    }
//
//    fun forEach(action: (T) -> Unit) {
//        entries.forEach(action)
//    }
//
//    fun getEntries(): List<T> {
//        return entries
//    }
//
//    companion object {
//        val ITEM = MyRegister<BasicItem>()
//        val BLOCK = MyRegister<BasicBlock>()
//        val ITEM_GROUP = MyRegister<BasicItemGroup>()
//    }
//}