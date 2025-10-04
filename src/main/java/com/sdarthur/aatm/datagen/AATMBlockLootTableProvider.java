package com.sdarthur.aatm.datagen;

import com.sdarthur.aatm.block.AATMBlocks;
import com.sdarthur.aatm.block.custom.AppleLeafBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class AATMBlockLootTableProvider extends BlockLootSubProvider {

    private LootItemCondition.Builder hasShearsOrSilkTouch() {
        return HAS_SHEARS.or(this.hasSilkTouch());
    }

    protected AATMBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.dropSelf(AATMBlocks.APPLE_TREE_SAPLING.get());

        this.add(AATMBlocks.APPLE_FLOWER_LEAVES.get(),
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(AATMBlocks.APPLE_FLOWER_LEAVES.get())
                                .when(hasShearsOrSilkTouch())
                        )
                )
        );

        this.add(AATMBlocks.UNRIPE_APPLE_LEAVES.get(),
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(AATMBlocks.UNRIPE_APPLE_LEAVES.get())
                                .when(hasShearsOrSilkTouch())
                        )
                )
        );

        this.add(AATMBlocks.RIPE_APPLE_LEAVES.get(),
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(AATMBlocks.RIPE_APPLE_LEAVES.get())
                                .when(hasShearsOrSilkTouch())
                        )
                )
        );

        this.add(AATMBlocks.APPLE_LEAVES.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(AATMBlocks.APPLE_FLOWER_LEAVES.get())
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AATMBlocks.APPLE_LEAVES.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(AppleLeafBlock.AGE, 0)))
                                .when(hasShearsOrSilkTouch())
                        )
                        .add(LootItem.lootTableItem(AATMBlocks.UNRIPE_APPLE_LEAVES.get())
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AATMBlocks.APPLE_LEAVES.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(AppleLeafBlock.AGE, 1)))
                                .when(hasShearsOrSilkTouch())
                        )
                        .add(LootItem.lootTableItem(AATMBlocks.RIPE_APPLE_LEAVES.get())
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AATMBlocks.APPLE_LEAVES.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(AppleLeafBlock.AGE, 2)))
                                .when(hasShearsOrSilkTouch())
                        )
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.APPLE)
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AATMBlocks.APPLE_LEAVES.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(AppleLeafBlock.AGE, 2)))
                                .when(ExplosionCondition.survivesExplosion())
                        )
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(AATMBlocks.APPLE_TREE_SAPLING.get()))
                        .when(LootItemRandomChanceCondition.randomChance(0.05f))
                        .when(InvertedLootItemCondition.invert(hasShearsOrSilkTouch()))
                )
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.STICK))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                        .when(LootItemRandomChanceCondition.randomChance(0.02f))
                        .when(InvertedLootItemCondition.invert(hasShearsOrSilkTouch()))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return AATMBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
