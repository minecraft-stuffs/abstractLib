package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.api.file.Path
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
        val mineable = Path("mineable")
        val needs_stone_tool = Path("needs_stone_tool")
        val needs_iron_tool = Path("needs_iron_tool")
        val needs_diamond_tool = Path("needs_diamond_tool")
        val sword = Path("sword")
        val hoe = Path("hoe")
        val pickaxe = Path("pickaxe")
        val axe = Path("axe")
        val shovel = Path("shovel")
    }

    fun get(path: Path): TagKey<Block> {
        return TagKey.of(RegistryKeys.BLOCK, Identifier(modId, path.path))
    }

    fun get(path: String): TagKey<Block> {
        return TagKey.of(RegistryKeys.BLOCK, Identifier(modId, path))
    }

    fun getVanilia(path: Path): TagKey<Block> {
        return TagKey.of(RegistryKeys.BLOCK, Identifier("minecraft", path.path))
    }

    fun getVanilia(path: String): TagKey<Block> {
        return TagKey.of(RegistryKeys.BLOCK, Identifier("minecraft", path))
    }
}