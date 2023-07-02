package com.rhseung.abstractlib

import com.rhseung.abstractlib.init.example.ModInit
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object Mod : ModInitializer {
	const val modId = "abstractlib"
    val logger = LoggerFactory.getLogger(modId)

	override fun onInitialize() {
		ModInit.register()
	}
}