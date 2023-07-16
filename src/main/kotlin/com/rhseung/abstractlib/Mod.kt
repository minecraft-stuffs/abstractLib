package com.rhseung.abstractlib

import com.rhseung.abstractlib.init.example.ModInits
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
	 *
	 * 	이 코드 작동 안하는 이유: 컴파일 타임에는 위치가 /run/...에 있기 때문에.
	 */
	
    val logger: Logger = LoggerFactory.getLogger(modId)

	override fun onInitialize() {
		ModInits(modId).update()
	}
}