package com.rhseung.abstractlib.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.block.Block
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

abstract class AbstractBlockTagProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricTagProvider<Block>(output, RegistryKeys.BLOCK, registriesFuture) {

    override fun configure(arg: RegistryWrapper.WrapperLookup) {
//        val handler = BlockTagHandler(output.modId, this)
//        register(handler)
    }

    open fun register(handler: BlockTagHandler) {
//        val iron_tool = handler.get(needs_iron_tool)
//        iron_tool += Blocks.NETHERITE_BLOCK
//        iron_tool -= Blocks.DIAMOND_ORE
//        iron_tool += handler.get(needs_stone_tool)
//
//        val pickaxe = handler.getVanilia(minable/pickaxe)
    }
}