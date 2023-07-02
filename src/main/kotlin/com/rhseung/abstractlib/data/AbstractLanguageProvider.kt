package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.registration.BasicBlock
import com.rhseung.abstractlib.registration.BasicItem
import com.rhseung.abstractlib.registration.Register
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider

abstract class AbstractLanguageProvider(
    open val output: FabricDataOutput,
    open val languageCode: String
) : FabricLanguageProvider(output, languageCode) {

    override fun generateTranslations(translationBuilder: TranslationBuilder) {
        val handler = LanguageHandler(output.modId, translationBuilder)
        register(handler)
    }

    open fun register(handler: LanguageHandler) {
        // items auto generated
        Register.getItems(BasicItem::class).forEach { item ->
            handler.addItem(item to (item.translationName[languageCode] ?: item.translationName["en_us"]!!))
        }

        // blocks auto generated
        Register.getBlocks(BasicBlock::class).forEach { block ->
            handler.addBlock(block to (block.translationName[languageCode] ?: block.translationName["en_us"]!!))
        }
    }
}