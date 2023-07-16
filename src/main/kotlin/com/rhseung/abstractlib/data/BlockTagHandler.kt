package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.api.file.path.URI
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.block.Block
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

class BlockTagHandler(
    val modId: String,
    val provider: FabricTagProvider<Block>
) {
    companion object {
        val mineable = URI("mineable")
        val needs_stone_tool = URI("needs_stone_tool")
        val needs_iron_tool = URI("needs_iron_tool")
        val needs_diamond_tool = URI("needs_diamond_tool")
        val sword = URI("sword")
        val hoe = URI("hoe")
        val pickaxe = URI("pickaxe")
        val axe = URI("axe")
        val shovel = URI("shovel")
    }

    fun get(uri: URI): TagKey<Block> {
        return TagKey.of(RegistryKeys.BLOCK, Identifier(modId, uri.toString()))
    }

    fun get(path: String): TagKey<Block> {
        return TagKey.of(RegistryKeys.BLOCK, Identifier(modId, path))
    }

    fun getVanilia(uri: URI): TagKey<Block> {
        return TagKey.of(RegistryKeys.BLOCK, Identifier("minecraft", uri.toString()))
    }

    fun getVanilia(path: String): TagKey<Block> {
        return TagKey.of(RegistryKeys.BLOCK, Identifier("minecraft", path))
    }
}