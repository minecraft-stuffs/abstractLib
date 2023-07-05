package com.rhseung.abstractlib

import com.rhseung.abstractlib.init.example.ModInit
import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.impl.util.FileSystemUtil
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.file.Path

object Mod : ModInitializer {
	val modId: String = "abstractlib"
	
	/** todo: automatically get modId from fabric.mod.json
	 * JsonParser.parseString(
	 * 		File("/src/main/resources/fabric.mod.json").readText()
	 * 	).asJsonObject.get("id").asString
	 */
	
    val logger: Logger = LoggerFactory.getLogger(modId)

	override fun onInitialize() {
		ModInit.register()
	}
}