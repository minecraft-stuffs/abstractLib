package com.rhseung.abstractlib

import com.rhseung.abstractlib.registration.ModInits
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Mod : ModInitializer {
	val modId: String = "abstractlib"   // note: 나중에 URI에서 modid 가져오기
	
    val logger: Logger = LoggerFactory.getLogger(modId)

	override fun onInitialize() {
		ModInits(modId).update()
	}
}