package com.sdarthur.aatm.datagen;

import com.sdarthur.aatm.AnotherAppleTreeMod;
import com.sdarthur.aatm.worldgen.AATMBiomeModifiers;
import com.sdarthur.aatm.worldgen.AATMConfiguredFeatures;
import com.sdarthur.aatm.worldgen.AATMPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AATMDataPackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, AATMConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, AATMPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, AATMBiomeModifiers::bootstrap);

    public AATMDataPackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(AnotherAppleTreeMod.MODID));
    }
}
