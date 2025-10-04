package com.sdarthur.aatm.datagen;

import com.sdarthur.aatm.AnotherAppleTreeMod;
import com.sdarthur.aatm.block.AATMBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class AATMItemModelProvider extends ItemModelProvider {
    public AATMItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AnotherAppleTreeMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        saplingItem(AATMBlocks.APPLE_TREE_SAPLING);
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AnotherAppleTreeMod.MODID,"block/" + item.getId().getPath()));
    }
}
