package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.data.LanguageHandler.Companion.aka
import com.rhseung.abstractlib.registration.Register
import com.rhseung.abstractlib.registration.key.IBasicKey
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import kotlin.reflect.KClass

abstract class AbstractLanguageProvider(
    open val output: FabricDataOutput,
    open val languageCode: KClass<*>
) : FabricLanguageProvider(output, languageCode.simpleName!!) {

    override fun generateTranslations(translationBuilder: TranslationBuilder) {
        val lang = LanguageHandler(output.modId, translationBuilder)
        register(lang)
    }

    open fun register(lang: LanguageHandler) {
        val getLangSafe = { it: IBasicKey -> it.names[languageCode] ?: it.names[en_us::class]!! }
        
        lang.adds(Register.Item.ITEM, getLangSafe)
        lang.adds(Register.Block.BLOCK, getLangSafe)
        lang.adds(Register.ItemGroup.ITEM_GROUP, getLangSafe)
    }
}