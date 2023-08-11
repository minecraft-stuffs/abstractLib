//package com.rhseung.abstractlib.registration.old
//
//import com.rhseung.abstractlib.registration.old.MyRegister.Companion.ITEM
//
//object ModItems : IModInit<BasicItem> {
//    @ko_kr("예제 아이템")
//    val example_item = ITEM.create("example_item") {
//        BasicItem {
//            setting = setting
//                .maxCount(16)
//        }
//    }
//
//    fun registerGem() {
//        // todo: setting에서도 lang을 등록할 수 있도록
//    }
//
//    override fun register() {
//        registerGem()
//
//        super.register()
//    }
//}