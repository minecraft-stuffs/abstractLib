package com.rhseung.abstractlib.api.model

class TextureKey(
    val name: String,
    val base: TextureKey? = null
) {
    override fun toString(): String {
        return "#$name"
    }

    companion object {
        val ALL = TextureKey("all");
        val TEXTURE = TextureKey("texture", ALL);
        val PARTICLE = TextureKey("particle", TEXTURE);
        val END = TextureKey("end", TEXTURE);
        val BOTTOM = TextureKey("bottom", END);
        val TOP = TextureKey("top", END);
        val FRONT = TextureKey("front", ALL);
        val BACK = TextureKey("back", ALL);
        val SIDE = TextureKey("side", ALL);
        val NORTH = TextureKey("north", SIDE);
        val SOUTH = TextureKey("south", SIDE);
        val EAST = TextureKey("east", SIDE);
        val WEST = TextureKey("west", SIDE);
        val UP = TextureKey("up");
        val DOWN = TextureKey("down");
        val CROSS = TextureKey("cross");
        val PLANT = TextureKey("plant");
        val WALL = TextureKey("wall", ALL);
        val RAIL = TextureKey("rail");
        val WOOL = TextureKey("wool");
        val PATTERN = TextureKey("pattern");
        val PANE = TextureKey("pane");
        val EDGE = TextureKey("edge");
        val FAN = TextureKey("fan");
        val STEM = TextureKey("stem");
        val UPPERSTEM = TextureKey("upperstem");
        val CROP = TextureKey("crop");
        val DIRT = TextureKey("dirt");
        val FIRE = TextureKey("fire");
        val LANTERN = TextureKey("lantern");
        val PLATFORM = TextureKey("platform");
        val UNSTICKY = TextureKey("unsticky");
        val TORCH = TextureKey("torch");
        fun LAYER(n: Int) = TextureKey("layer$n");
        val LIT_LOG = TextureKey("lit_log");
        val CANDLE = TextureKey("candle");
        val INSIDE = TextureKey("inside");
        val CONTENT = TextureKey("content");
        val INNER_TOP = TextureKey("inner_top");
        val FLOWERBED = TextureKey("flowerbed");
    }
}