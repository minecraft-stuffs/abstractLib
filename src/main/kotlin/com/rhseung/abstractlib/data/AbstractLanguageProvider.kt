package com.rhseung.abstractlib.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.item.Items

abstract class AbstractLanguageProvider(
    open val output: FabricDataOutput,
    open val languageCode: String = "en_us"
) : FabricLanguageProvider(output, languageCode) {

    override fun generateTranslations(translationBuilder: TranslationBuilder) {
        val handler = LanguageHandler(output.modId, translationBuilder)
        register(handler)
    }

    open fun register(handler: LanguageHandler) {}
}