package net.rhseung.rhseungslib.datagen.lang

import com.rhseung.abstractlib.api.registration.RegistryManager
import com.rhseung.abstractlib.api.registration.registrykeys.BasicBlock
import com.rhseung.abstractlib.api.registration.registrykeys.BasicItem
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider

abstract class AbstractLanguageProvider (
	val output: FabricDataOutput,
	val languageCode: String = "en_us"
): FabricLanguageProvider(output, languageCode) {
	
	override fun generateTranslations(translationBuilder: TranslationBuilder) {
		val handler = LanguageHandler(output.modId, translationBuilder)
		register(handler)
	}
	
	open fun register(handler: LanguageHandler) {
		RegistryManager.getItems(BasicItem::class).forEach { handler.generate(it) }
		RegistryManager.getBlocks(BasicBlock::class).forEach { handler.generate(it) }
	}
}