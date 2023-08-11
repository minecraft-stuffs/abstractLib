package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.api.Languages
import com.rhseung.abstractlib.data.LanguageHandler.Companion.aka
import com.rhseung.abstractlib.registration.MyRegistry
import com.rhseung.abstractlib.registration.key.IRegistryKey
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.block.Block
import net.minecraft.enchantment.Enchantment
import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.EntityAttribute
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKey
import net.minecraft.stat.StatType
import net.minecraft.util.Identifier

abstract class AbstractLanguageProvider(
    open val output: FabricDataOutput,
    open val language: Languages
) : FabricLanguageProvider(output, language.code) {

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
        val getLangSafe = { it: IRegistryKey -> it.langs[language] ?: it.langs[Languages.EN_US]!! }

        MyRegistry.ITEMS.forEach { lang += it aka getLangSafe(it) }
        MyRegistry.BLOCKS.forEach { lang += it aka getLangSafe(it) }
        MyRegistry.ITEM_GROUPS.forEach { lang += it aka getLangSafe(it) }
    }
}