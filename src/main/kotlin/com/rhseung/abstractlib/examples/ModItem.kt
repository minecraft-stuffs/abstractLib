package com.rhseung.abstractlib.examples

import com.rhseung.abstractlib.ModInit
import com.rhseung.abstractlib.api.registration.AbstractModRegistrations
import com.rhseung.abstractlib.api.registration.registrykeys.BasicItem

object ModItems : AbstractModRegistrations<BasicItem>() {
    @Loc("test_item")
    val testItem = BasicItem.of(ModInit.modid);

    @Loc("diamond_block")
    @Name("Block of Diamond")
    val diamondBlock = BasicItem.of(ModInit.modid);

    @Loc("diamond")
    val diamond = BasicItem.of(ModInit.modid);
}