package com.rhseung.abstractlib.registration.key

import com.rhseung.abstractlib.api.Languages
import com.rhseung.abstractlib.api.Languages.LanguageTable
import com.rhseung.abstractlib.api.StringStyle.titlecase
import com.rhseung.abstractlib.api.annotation.Lang
import com.rhseung.abstractlib.api.file.path.Location
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.resource.featuretoggle.FeatureFlag
import net.minecraft.resource.featuretoggle.FeatureFlags
import net.minecraft.util.Rarity

class Item(
    /**
     * The ID of the item. This is used to register the item.
     */
    override val id: Location,

    /**
     * The settings of the item.
     */
    val properties: Properties
) : Item(properties.build()), IRegistryKey {

    /**
     * The language table of the item. The key is the language code, and the value is the translated string.
     */
    override val langs = LanguageTable(Languages.EN_US to id.path.titlecase())

    init {
        properties.langs.forEach { lang, name ->
            if (name != null)
                langs[lang] = name
        }
    }

    /**
     * Registers the item to the [Registry].
     */
    override fun register() {
        Registry.register(Registries.ITEM, id, this)

        if (properties.itemGroup != null) {
            ItemGroupEvents.modifyEntriesEvent(properties.itemGroup)
                .register(ItemGroupEvents.ModifyEntries { entries -> entries.add(this) })
        }
    }

    /**
     * Returns the string representation of the item.
     */
    override fun toString(): String {
        return "Item($id)"
    }

    /**
     * The settings of the item.
     * @property itemGroup
     * @property maxStackCount
     * @property rarity
     * @property fireproof
     * @property requiredFeatures
     * @property recipeRemainder
     */
    class Properties {
        /**
         * The item group that the item will be in. If null, the item will not be in any item group.
         */
        internal var itemGroup: Group? = null

        fun vanillaGroup(value: () -> Group) {
            this.itemGroup = value()
        }

        fun itemGroup(value: () -> ItemGroup) {
            this.itemGroup = value().registrykey
        }

        /**
         * The maximum stack count of the item. default is 64.
         */
        internal var maxStackCount: Int = 64

        fun maxStackCount(value: () -> Int) {
            this.maxStackCount = value()
        }

        /**
         * The rarity of the item. default is [Rarity.COMMON].
         */
        internal var rarity: Rarity = Rarity.COMMON

        fun rarity(value: () -> Rarity) {
            this.rarity = value()
        }

        /**
         * Whether the item is fireproof. default is false.
         */
        internal var fireproof: Boolean = false

        fun fireproof(value: () -> Boolean) {
            this.fireproof = value()
        }

        /**
         * The required features for the item. default is [FeatureFlags.VANILLA_FEATURES].
         */
        internal var requiredFeatures: Array<FeatureFlag> = arrayOf()

        @JvmName("requiredFeaturesArray")
        fun requiredFeatures(value: () -> Array<FeatureFlag>) {
            this.requiredFeatures = value()
        }

        @JvmName("requiredFeaturesCollection")
        fun requiredFeatures(value: () -> Collection<FeatureFlag>) {
            this.requiredFeatures = value().toTypedArray()
        }

        /**
         * The item that will be left over after crafting. default is null.
         *
         * e.g. if you craft a cake using milk bucket, the empty bucket will be left over.
         */
        internal var recipeRemainder: Item? = null

        fun recipeRemainder(value: () -> Item) {
            this.recipeRemainder = value()
        }

        /**
         * The language table of the item. The key is the language code, and the value is the translated string.
         */
        internal val langs = LanguageTable()

        fun lang(value: () -> Lang) {
            langs[value().language] = value().translation
        }

        /**
         * Builds the settings into an [Item.Settings] object.
         */
        fun build(): Item.Settings {
            return Item.Settings()
                .maxCount(maxStackCount)
                .rarity(rarity)
                .recipeRemainder(recipeRemainder)
                .requires(*requiredFeatures)
                .apply {
                    if (fireproof)
                        fireproof()
                }
        }
    }
}