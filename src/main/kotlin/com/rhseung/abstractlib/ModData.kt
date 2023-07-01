package com.rhseung.abstractlib

import com.rhseung.abstractlib.data.example.ModLanguageProvider
import com.rhseung.abstractlib.data.example.ModModelProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

object ModData : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		val pack = fabricDataGenerator.createPack()

		pack.addProvider { output: FabricDataOutput -> ModModelProvider(output) }
		pack.addProvider { output: FabricDataOutput -> ModLanguageProvider(output) }
	}
}