//package com.rhseung.abstractlib.registration.example
//
//import com.rhseung.abstractlib.Mod
//import com.rhseung.abstractlib.api.annotation.en_us
//import com.rhseung.abstractlib.api.annotation.ko_kr
//import com.rhseung.abstractlib.api.file.path.Location.Companion.of
//import com.rhseung.abstractlib.registration.IModInit
//import com.rhseung.abstractlib.registration.Register
//import com.rhseung.abstractlib.registration.Register.block
//import com.rhseung.abstractlib.registration.Register.item
//import com.rhseung.abstractlib.registration.Register.itemGroup
//import com.rhseung.abstractlib.registration.key.BasicItem
//
//object ModBlocks : IModInit<BasicItem> {
//    @ko_kr("예제 아이템")
//    @en_us("Block of Example")
//    val example_block = block.create("example_block" of Mod.modId) {
//
//    }
//}