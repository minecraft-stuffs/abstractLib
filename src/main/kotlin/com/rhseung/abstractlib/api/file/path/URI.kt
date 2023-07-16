package com.rhseung.abstractlib.api.file.path

// note: 언젠가 모든 [Location]을 교체할 놈
data class URI(
    val paths: List<String> = listOf()
) {
    constructor(vararg paths: String): this(paths.toList())
    
    companion object {
        operator fun URI.div(other: URI) = URI(paths + other.paths)
        operator fun URI.div(other: String) = URI(paths + other)
        operator fun String.div(other: URI) = URI(listOf(this) + other.paths)
        operator fun URI.rangeTo(other: URI) = Location(this.toString(), other.toString())
        
        val root = URI("")
        val minecraft = URI("minecraft")
        
        /** todo: automatically get modId from fabric.mod.json
         * val modid = URI(JsonParser.parseString(
         * 		File("/src/main/resources/fabric.mod.json").readText()
         * 	).asJsonObject.get("id").asString)
         *
         * 	이 코드 작동 안하는 이유: 컴파일 타임에는 위치가 /run/...에 있기 때문에
         */
        
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
    
    override fun toString() = paths.joinToString("/")
    
    fun into(execute: (String) -> Unit) {
        paths.forEach(execute)
    }
}