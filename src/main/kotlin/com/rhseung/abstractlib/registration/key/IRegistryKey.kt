package com.rhseung.abstractlib.registration.key

import com.rhseung.abstractlib.api.Languages.LanguageTable
import com.rhseung.abstractlib.api.file.path.Location
import net.minecraft.registry.Registry

interface IRegistryKey {
    /**
     * The ID of the item. This is used to register the key.
     */
    val id: Location

    /**
     * The language table of the item. The key is the language code, and the value is the translated string.
     */
    val langs: LanguageTable

    /**
     * Registers the key to the [Registry].
     */
    fun register()

    /**
     * Returns the string representation of the key.
     */
    override fun toString(): String
}