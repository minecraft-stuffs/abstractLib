package com.rhseung.abstractlib

import com.rhseung.abstractlib.init.example.ExampleInit
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object Mod : ModInitializer {
	const val modId = "abstractlib"
    private val logger = LoggerFactory.getLogger(modId)

	override fun onInitialize() {
		ExampleInit.register()
	}
}