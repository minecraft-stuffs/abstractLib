package com.rhseung.abstractlib.api.file

data class URI(
    val path: String
) {
    companion object {
        operator fun URI.div(other: URI) = URI("${this.path}/${other.path}")
        operator fun URI.div(other: String) = URI("${this.path}/$other")
        operator fun String.div(other: URI) = URI("$this/${other.path}")
        
        // fixme: this is not working
//        val modid = Path(JsonParser.parseString(
//            File("/src/main/resources/fabric.mod.json").readText()
//        ).asJsonObject.get("id").asString)
        val assets = URI("assets")
            val blockstates = URI("blockstates")
            val lang = URI("lang")
            val models = URI("models")
        val data = URI("data")
            val loot_tables = URI("loot_tables")
            val tags = URI("tags")
                val blocks = URI("blocks")
                    val mineable = URI("mineable")
                val items = URI("items")
            val recipes = URI("recipes")
        val textures = URI("textures")
            val gui = URI("gui")
                val icon = URI("icon")

        val block = URI("block")
        val item = URI("item")
    }
}