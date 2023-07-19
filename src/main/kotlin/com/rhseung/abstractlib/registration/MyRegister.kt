package com.rhseung.abstractlib.registration

import com.rhseung.abstractlib.Mod
import com.rhseung.abstractlib.api.file.path.Location
import com.rhseung.abstractlib.api.file.path.URI
import com.rhseung.abstractlib.registration.key.BasicBlock
import com.rhseung.abstractlib.registration.key.BasicItem
import com.rhseung.abstractlib.registration.key.BasicItemGroup
import com.rhseung.abstractlib.registration.key.IBasicRegistryKey
import net.minecraft.item.Item.Settings
import net.minecraft.registry.RegistryKey
import kotlin.reflect.KClass

class MyRegister<T: IBasicRegistryKey>(
    private val modId: String
) {
    private val entries = mutableListOf<T>()

    /**
     * @param name 아이템의 이름, `modid/itemname` 형식으로 작성
     * @param key
     */
//    fun create(name: String, key: () -> T): T {
//        return key().apply {
//            id = Location(modId, name)
//            entries.add(this)
//        }
//    }

    fun forEach(action: (T) -> Unit) {
        entries.forEach(action)
    }

//    /**
//     * @param name 아이템의 이름, `itemname of modid` 형식으로 작성
//     * @param key
//     */
//    fun create(name: Location, key: () -> T): T {
//        return key().apply {
//            id = name
//            entries.add(this)
//        }
//    }
}