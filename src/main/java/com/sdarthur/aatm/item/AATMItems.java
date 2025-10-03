package com.sdarthur.aatm.item;

import com.sdarthur.aatm.AnotherAppleTreeMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AATMItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AnotherAppleTreeMod.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
