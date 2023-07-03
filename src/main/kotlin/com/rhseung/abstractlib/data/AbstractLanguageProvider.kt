package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.init.example.ModInit
import com.rhseung.abstractlib.registration.BasicBlock
import com.rhseung.abstractlib.registration.BasicItem
import com.rhseung.abstractlib.registration.Register
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import kotlin.reflect.KClass

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
        Register.getItems(BasicItem::class).forEach { item -> when (languageCode) {
                "en_us" -> handler.addItem(item to item.translationName[en_us::class]!!)
                "ko_kr" -> handler.addItem(item to item.translationName[en_us::class]!!)
                else -> error("Unsupported language code: $languageCode")
//            handler.addItem(item to (item.translationName[languageCode] ?: item.translationName[en_us::class]!!))
            }
        }

        // blocks auto generated
        Register.getBlocks(BasicBlock::class).forEach { block -> when (languageCode) {
                "en_us" -> handler.addBlock(block to block.translationName[en_us::class]!!)
                "ko_kr" -> handler.addBlock(block to block.translationName[en_us::class]!!)
                else -> error("Unsupported language code: $languageCode")
//            handler.addBlock(block to (block.translationName[languageCode] ?: block.translationName[en_us::class]!!))
            }
        }
        
        // itemGroups auto generated
        // todo: BasicItemGroup의 보완이 시급함
//        Register.getItemGroups().forEach { itemGroup ->
//            handler.addItemGroup(
//                RegistryKey.of(RegistryKeys.ITEM_GROUP, Registries.ITEM_GROUP.getId(itemGroup))
//                    to
//                    (itemGroup.translationName[languageCode] ?: itemGroup.translationName[en_us::class]!!)
//            )
//        }
        handler.addItemGroup(
        ModInit.EXAMPLE_ITEM_GROUP.registry
            to
//            (ModInit.EXAMPLE_ITEM_GROUP.translationName[languageCode] ?: ModInit.EXAMPLE_ITEM_GROUP.translationName[en_us::class]!!)
                (ModInit.EXAMPLE_ITEM_GROUP.translationName[en_us::class] ?: ModInit.EXAMPLE_ITEM_GROUP.translationName[en_us::class]!!)
        )
    }
}