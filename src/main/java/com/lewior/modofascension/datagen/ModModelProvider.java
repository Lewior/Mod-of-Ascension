package com.lewior.modofascension.datagen;

import com.lewior.modofascension.ModofAscension;
import com.lewior.modofascension.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, ModofAscension.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.ASCENSION_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ASCENDED_BAR.get(), ModelTemplates.FLAT_ITEM);


    }
}
