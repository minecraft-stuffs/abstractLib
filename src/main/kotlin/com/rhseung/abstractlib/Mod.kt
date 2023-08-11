package com.rhseung.abstractlib

import com.rhseung.abstractlib.api.file.path.URI
import com.rhseung.abstractlib.registration.example.ModBlocks
import com.rhseung.abstractlib.registration.example.ModItemGroups
import com.rhseung.abstractlib.registration.example.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object Mod : ModInitializer {
	val modId = URI.getModId()
    val logger = LoggerFactory.getLogger(modId)

	override fun onInitialize() {
		ModItemGroups.register()
		ModItems.register()
		ModBlocks.register()
	}
}