package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.api.MiningLevel
import com.rhseung.abstractlib.api.ToolType
import com.rhseung.abstractlib.api.file.URI.Companion.div
import com.rhseung.abstractlib.data.BlockTagHandler.Companion.mineable
import com.rhseung.abstractlib.data.BlockTagHandler.Companion.needs_diamond_tool
import com.rhseung.abstractlib.data.BlockTagHandler.Companion.needs_iron_tool
import com.rhseung.abstractlib.data.BlockTagHandler.Companion.needs_stone_tool
import com.rhseung.abstractlib.registration.BasicBlock
import com.rhseung.abstractlib.registration.Register
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.block.Block
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

abstract class AbstractBlockTagProvider(
    open val output: FabricDataOutput,
    open val registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricTagProvider<Block>(output, RegistryKeys.BLOCK, registriesFuture) {

    override fun configure(arg: RegistryWrapper.WrapperLookup) {
        val handler = BlockTagHandler(output.modId, this)

        Register.getBlocks(BasicBlock::class).forEach { block ->
            when (block.requiresTool.miningLevel) {
                MiningLevel.STONE -> getOrCreateTagBuilder(handler.getVanilia(needs_stone_tool)).add(block)
                MiningLevel.IRON -> getOrCreateTagBuilder(handler.getVanilia(needs_iron_tool)).add(block)
                MiningLevel.DIAMOND -> getOrCreateTagBuilder(handler.getVanilia(needs_diamond_tool)).add(block)
                else -> if (block.requiresTool.miningLevel > MiningLevel.DIAMOND)
                    getOrCreateTagBuilder(handler.getVanilia("needs_tool_level_${block.requiresTool.miningLevel.toInt()}")).add(block)
            }

            if (block.requiresTool.toolType != ToolType.ANY)
                getOrCreateTagBuilder(handler.getVanilia(mineable/block.requiresTool.toolType.name)).add(block)
        }
    }

    open fun register(handler: BlockTagHandler) {
        // todo: handler 구현
    }
}