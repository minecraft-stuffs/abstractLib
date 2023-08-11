package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.api.ToolType
import com.rhseung.abstractlib.api.file.path.URI.Companion.div
import com.rhseung.abstractlib.data.BlockTagHandler.Companion.mineable
import com.rhseung.abstractlib.data.BlockTagHandler.Companion.needs_diamond_tool
import com.rhseung.abstractlib.data.BlockTagHandler.Companion.needs_iron_tool
import com.rhseung.abstractlib.data.BlockTagHandler.Companion.needs_stone_tool
import com.rhseung.abstractlib.registration.MyRegistry
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

abstract class AbstractBlockTagProvider(
    open val output: FabricDataOutput,
    open val registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricTagProvider<net.minecraft.block.Block>(output, RegistryKeys.BLOCK, registriesFuture) {

    override fun configure(arg: RegistryWrapper.WrapperLookup) {
        val handler = BlockTagHandler(output.modId, this)
        
        MyRegistry.BLOCKS.forEach { block ->
            when (block.properties.requiredToolLevel.level) {
                1 -> getOrCreateTagBuilder(handler.getVanilia(needs_stone_tool))
                    .add(block)
                2 -> getOrCreateTagBuilder(handler.getVanilia(needs_iron_tool))
                    .add(block)
                3 -> getOrCreateTagBuilder(handler.getVanilia(needs_diamond_tool))
                    .add(block)
                else -> if (block.properties.requiredToolLevel.level > 3)
                    getOrCreateTagBuilder(handler.getVanilia("needs_tool_level_${block.properties.requiredToolLevel.level}"))
                        .add(block)
            }

            if (block.properties.requiredToolLevel.toolType != ToolType.ANY)
                getOrCreateTagBuilder(handler.getVanilia(mineable/block.properties.requiredToolLevel.toolType.name))
                    .add(block)
        }
    }

    open fun register(handler: BlockTagHandler) {
        // todo: handler 구현
    }
}