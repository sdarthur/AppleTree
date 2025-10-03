package com.sdarthur.datagen;

import com.sdarthur.aatm.block.AATMBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class AATMBlockLootTableProvider extends BlockLootSubProvider {
    protected AATMBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.dropSelf(AATMBlocks.APPLE_TREE_SAPLING.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return AATMBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
