package com.rhseung.abstractlib

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.rhseung.abstractlib.init.example.ModInit
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

object Mod : ModInitializer {
	val modId: String = "abstractlib"
	
	/**
	 * JsonParser.parseString(
	 * 		File("/src/main/resources/fabric.mod.json").readText()
	 * 	).asJsonObject.get("id").asString
	 */
	
    val logger: Logger = LoggerFactory.getLogger(modId)

	override fun onInitialize() {
		ModInit.register()
	}
}