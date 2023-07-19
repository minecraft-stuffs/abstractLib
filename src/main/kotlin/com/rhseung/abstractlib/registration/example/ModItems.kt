//package com.rhseung.abstractlib.registration.example
//
//import com.rhseung.abstractlib.Mod
//import com.rhseung.abstractlib.api.annotation.en_us
//import com.rhseung.abstractlib.api.annotation.ko_kr
//import com.rhseung.abstractlib.api.file.path.Location.Companion.of
//import com.rhseung.abstractlib.registration.IModInit
//import com.rhseung.abstractlib.registration.MyRegister
//import com.rhseung.abstractlib.registration.MyRegister.Companion.ITEM
//import com.rhseung.abstractlib.registration.Register
//import com.rhseung.abstractlib.registration.Register.item
//import com.rhseung.abstractlib.registration.Register.itemGroup
//import com.rhseung.abstractlib.registration.key.BasicItem
//
//object ModItems : IModInit<BasicItem> {
//    val ITEMS = MyRegister<BasicItem>(Mod.modId)
//
//    val brass_ingot = ITEMS.create("brass_ingot" of Mod.modId) {
//        setting = setting.fireproof()
//    }
//
//    fun registerGem() {
//        // todo: setting에서도 lang을 등록할 수 있도록
//    }
//
//    override fun register() {
//        registerGem()
//        super.register()
//    }
//}