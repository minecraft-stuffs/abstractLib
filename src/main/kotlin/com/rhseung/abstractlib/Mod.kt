package com.rhseung.abstractlib

import com.rhseung.abstractlib.api.file.path.URI
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Mod : ModInitializer {
	val modId = URI.getModId()
    val logger = LoggerFactory.getLogger(modId)

	override fun onInitialize() {
//		ModItems.register()
//		ModBlocks.register()
		// todo: ModItemGroups
//		ModItemGroups.register()

		// note: 나중에 ModTags, ModRecipes 같이 registry와 상관 없는 객체 ModInit들을 다룰텐데, 어떻게 할지 생각해보기
	}
}