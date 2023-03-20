package com.rhseung.abstractlib.examples

import com.rhseung.abstractlib.ModInit
import com.rhseung.abstractlib.api.registration.AbstractModRegistrations
import com.rhseung.abstractlib.api.registration.registrykeys.BasicItem

class ModItems : AbstractModRegistrations<BasicItem>() {
    override val things = listOf(
        BasicItem.of(ModInit.modid) { path = "test_item" },
    )
}