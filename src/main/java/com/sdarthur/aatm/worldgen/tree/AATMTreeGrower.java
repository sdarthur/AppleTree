package com.sdarthur.aatm.worldgen.tree;

import com.sdarthur.aatm.AnotherAppleTreeMod;
import com.sdarthur.aatm.worldgen.AATMConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class AATMTreeGrower {
    public static final TreeGrower APPLE_TREE = new TreeGrower(AnotherAppleTreeMod.MODID + ":apple_tree",
            Optional.empty(), Optional.of(AATMConfiguredFeatures.APPLE_TREE_KEY), Optional.empty());
}
