package com.rhseung.abstractlib

import com.rhseung.abstractlib.api.Languages
import com.rhseung.abstractlib.data.example.ModBlockLootTableProvider
import com.rhseung.abstractlib.data.example.ModBlockTagProvider
import com.rhseung.abstractlib.data.example.ModLanguageProvider
import com.rhseung.abstractlib.data.example.ModModelProvider
import com.rhseung.abstractlib.registration.MyRegistry
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.data.DataProvider

object ModData : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		val pack = fabricDataGenerator.createPack()

		pack.addProvider(::ModModelProvider)
		pack.addProvider(::ModBlockLootTableProvider)
		pack.addProvider(::ModBlockTagProvider)

		Languages.forEach {
			pack.addProvider { output: FabricDataOutput -> ModLanguageProvider(output, it) }
		}
	}
}