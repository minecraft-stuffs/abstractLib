package com.rhseung.abstractlib.api.file

import com.google.gson.JsonParser
import java.io.File

data class Path(
    val path: String
) {
    companion object {
        operator fun Path.div(other: Path) = Path("${this.path}/${other.path}")
        operator fun Path.div(other: String) = Path("${this.path}/$other")
        operator fun String.div(other: Path) = Path("$this/${other.path}")
        
        // fixme: this is not working
//        val modid = Path(JsonParser.parseString(
//            File("/src/main/resources/fabric.mod.json").readText()
//        ).asJsonObject.get("id").asString)
        val assets = Path("assets")
            val blockstates = Path("blockstates")
            val lang = Path("lang")
            val models = Path("models")
        val data = Path("data")
            val loot_tables = Path("loot_tables")
            val tags = Path("tags")
                val blocks = Path("blocks")
                    val mineable = Path("mineable")
                val items = Path("items")
            val recipes = Path("recipes")
        val textures = Path("textures")
            val gui = Path("gui")
                val icon = Path("icon")

        val block = Path("block")
        val item = Path("item")
    }
}