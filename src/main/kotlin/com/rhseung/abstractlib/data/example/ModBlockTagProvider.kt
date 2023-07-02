package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.api.URI.Companion.div
import com.rhseung.abstractlib.data.AbstractBlockTagProvider
import com.rhseung.abstractlib.data.BlockTagHandler
import com.rhseung.abstractlib.data.BlockTagHandler.Companion.mineable
import com.rhseung.abstractlib.data.BlockTagHandler.Companion.needs_iron_tool
import com.rhseung.abstractlib.data.BlockTagHandler.Companion.pickaxe
import com.rhseung.abstractlib.init.example.ModInit
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class ModBlockTagProvider(
    val output: FabricDataOutput,
    val registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : AbstractBlockTagProvider(output, registriesFuture) {

    override fun configure(arg: RegistryWrapper.WrapperLookup) {
        val handler = BlockTagHandler(output.modId, this)

        getOrCreateTagBuilder(handler.getVanilia(needs_iron_tool)).add(ModInit.BRASS_BLOCK)
        getOrCreateTagBuilder(handler.getVanilia(mineable/pickaxe)).add(ModInit.BRASS_BLOCK)
    }
}