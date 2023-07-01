package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.data.AbstractLanguageProvider
import com.rhseung.abstractlib.data.LanguageHandler
import com.rhseung.abstractlib.init.example.ExampleInit
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

class ModLanguageProvider(
    override val output: FabricDataOutput,
    override val languageCode: String = "en_us"
) : AbstractLanguageProvider(output, languageCode) {

    override fun register(handler: LanguageHandler) {
        handler.addItem(ExampleInit.EXAMPLE_INGOT to ExampleInit.EXAMPLE_INGOT.translationName.en_us)
        handler.addBlock(ExampleInit.EXAMPLE_BLOCK to ExampleInit.EXAMPLE_BLOCK.translationName.en_us)
    }
}