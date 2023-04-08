package net.rhseung.rhseungslib.datagen.model

import com.rhseung.abstractlib.api.file.Location
import com.rhseung.abstractlib.api.model.ParentType
import net.minecraft.block.Block
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.util.Identifier

class BlockModelHandler (
	val modId: String,
	val modelGenerator: BlockStateModelGenerator
) {
	fun <T : Block> generateBlock(
		block: T,
		parent: ParentType = ParentType.CUBE,
	) {
		modelGenerator.registerCubeAllModelTexturePool(block)
//		val identifier = RegistryHelper.getId(item)
//		this.generate(
//			ItemModelHandler.ItemModelBuilder(identifier)
//				.setParent(parent)
//				.addTexture(identifier.path, prefix = "")
//		)
	}
	
}