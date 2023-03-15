package com.rhseung.abstractlib

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object ModInit : ModInitializer {
	const val modid = "abstractlib"
	private val logger = LoggerFactory.getLogger(modid)

	override fun onInitialize() {
	}
}