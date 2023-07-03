package com.rhseung.abstractlib

import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.api.annotation.ko_kr
import com.rhseung.abstractlib.data.example.ModBlockLootTableProvider
import com.rhseung.abstractlib.data.AbstractBlockTagProvider
import com.rhseung.abstractlib.data.example.ModBlockTagProvider
import com.rhseung.abstractlib.data.example.ModLanguageProvider
import com.rhseung.abstractlib.data.example.ModModelProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import java.io.File

object ModData : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		val pack = fabricDataGenerator.createPack()

		pack.addProvider { output: FabricDataOutput -> ModModelProvider(output) }
//		pack.addProvider { output: FabricDataOutput -> ModLanguageProvider(output, en_us::class) }
		pack.addProvider { output: FabricDataOutput -> ModLanguageProvider(output, "en_us") }
		// fixme: ko_kr::class, en_us::class 를 둘 다 generate하면 둘 다 KClass<*>이기 때문에 구분이 안돼서 Duplicate provider 오류가 남
//		pack.addProvider { output: FabricDataOutput -> ModLanguageProvider(output, ko_kr::class) }
		pack.addProvider { output: FabricDataOutput -> ModBlockLootTableProvider(output) }
		pack.addProvider { output: FabricDataOutput, registriesFuture -> ModBlockTagProvider(output, registriesFuture) }
	}
}