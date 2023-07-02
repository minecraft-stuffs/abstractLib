package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.data.AbstractLanguageProvider
import com.rhseung.abstractlib.data.LanguageHandler
import com.rhseung.abstractlib.init.example.ModInit
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

class ModLanguageProvider(
    override val output: FabricDataOutput,
    override val languageCode: String = "en_us"
) : AbstractLanguageProvider(output, languageCode) {

}