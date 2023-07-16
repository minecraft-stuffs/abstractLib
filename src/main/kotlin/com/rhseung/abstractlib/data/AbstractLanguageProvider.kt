package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.registration.BasicBlock
import com.rhseung.abstractlib.registration.BasicItem
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import kotlin.reflect.KClass

abstract class AbstractLanguageProvider(
    open val output: FabricDataOutput,
    open val languageCode: KClass<*>
) : FabricLanguageProvider(output, languageCode.simpleName!!) {

    override fun generateTranslations(translationBuilder: TranslationBuilder) {
        val handler = LanguageHandler(output.modId, translationBuilder)
        register(handler)
    }

    open fun register(handler: LanguageHandler) {
        // items auto generated
        Register.getItems(BasicItem::class).forEach {
            handler.addItem(
                it to (it.translationName[languageCode]
                ?: it.translationName[en_us::class]!!)
            )
        }

        // blocks auto generated
        Register.getBlocks(BasicBlock::class).forEach {
            handler.addBlock(
                it to (it.translationName[languageCode]
                    ?: it.translationName[en_us::class]!!)
            )
        }
        
        // itemGroups auto generated
//        Register.getItemGroups().forEach { itemGroup ->
//            handler.addItemGroup(
//                RegistryKey.of(RegistryKeys.ITEM_GROUP, Registries.ITEM_GROUP.getId(itemGroup))
//                    to
//                    (itemGroup.translationName[languageCode] ?: itemGroup.translationName[en_us::class]!!)
//            )
//        }
        
        // todo: BasicItemGroup의 보완이 시급함
        // todo: handler.add[Type] 이런 형식의 builder 원하지 않습니다..
        Register.getGroups().forEach {
            handler.addItemGroup(
                it to (it.translationName[languageCode]
                    ?: it.translationName[en_us::class]!!)
            )
        }
    }
}