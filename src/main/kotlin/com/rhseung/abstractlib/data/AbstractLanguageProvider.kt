package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.data.LanguageHandler.Companion.aka
import com.rhseung.abstractlib.registration.Register
import com.rhseung.abstractlib.registration.key.IBasicKey
import com.rhseung.abstractlib.registration.key.BasicItemGroup
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.item.Item
import net.minecraft.block.Block
import net.minecraft.util.Identifier
import net.minecraft.enchantment.Enchantment
import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.EntityAttribute
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.stat.StatType
import net.minecraft.item.ItemGroup
import net.minecraft.registry.RegistryKey
import kotlin.reflect.KClass

abstract class AbstractLanguageProvider(
    open val output: FabricDataOutput,
    open val languageCode: KClass<*>
) : FabricLanguageProvider(output, languageCode.simpleName!!) {

    override fun generateTranslations(translationBuilder: TranslationBuilder) {
        val lang = LanguageHandler(output.modId, translationBuilder)
        register(lang)
    }
    
    /** `languageCode`에 해당하는 언어로 번역을 등록합니다.
     * ```kotlin
     * lang += [번역할 대상] aka [번역할 대상의 번역 이름]
     * lang += [Collection<번역할 대상의 타입>] aka { [번역할 대상] -> [번역할 대상의 번역 이름] }
     * ```
     * 번역할 대상에는 [Item], [Block], [Identifier], [String], [Enchantment], [EntityType], [EntityAttribute], [BasicItemGroup], [RegistryKey], [StatusEffect], [StatType]가 가능합니다.
     *
     * @param lang: LanguageHandler
     * @see LanguageHandler
     */
    open fun register(lang: LanguageHandler) {
        val getLangSafe = { it: IBasicKey -> it.names[languageCode] ?: it.names[en_us::class]!! }
        
        lang += Register.Item.ITEM aka getLangSafe
        lang += Register.Block.BLOCK aka getLangSafe
        lang += Register.ItemGroup.ITEM_GROUP aka getLangSafe
    }
}