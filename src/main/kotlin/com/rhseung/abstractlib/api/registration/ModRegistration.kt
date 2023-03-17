package com.rhseung.abstractlib.api.registration

import com.rhseung.abstractlib.ModInit
import com.rhseung.abstractlib.api.registration.registrykeys.BasicItem

class ModRegistration : AbstractModRegistrations<BasicItem>() {
    override val things = listOf(
        BasicItem.of(ModInit.modid) { path = "test_item" },

    )
}