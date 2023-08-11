package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.api.Languages
import com.rhseung.abstractlib.data.AbstractLanguageProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import kotlin.reflect.KClass

class ModLanguageProvider(
    override val output: FabricDataOutput,
    override val language: Languages
) : AbstractLanguageProvider(output, language) {

}