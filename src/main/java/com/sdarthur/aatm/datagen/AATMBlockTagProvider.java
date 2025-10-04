package com.sdarthur.aatm.datagen;

import com.sdarthur.aatm.AnotherAppleTreeMod;
import com.sdarthur.aatm.block.AATMBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class AATMBlockTagProvider extends BlockTagsProvider {
    public AATMBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AnotherAppleTreeMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.LEAVES).add(
                AATMBlocks.APPLE_LEAVES.get(),
                AATMBlocks.APPLE_FLOWER_LEAVES.get(),
                AATMBlocks.UNRIPE_APPLE_LEAVES.get(),
                AATMBlocks.RIPE_APPLE_LEAVES.get()
        );
    }
}
