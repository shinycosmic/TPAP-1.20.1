package net.lemon.tpap.registry;

import net.lemon.tpap.TPAP;
import net.lemon.tpap.loot.RandomGenus;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModLootFunctions {
    public static final DeferredRegister<LootItemFunctionType> LOOT_FUNCTIONS =
            DeferredRegister.create(Registries.LOOT_FUNCTION_TYPE, TPAP.MODID);

    public static final RegistryObject<LootItemFunctionType> RANDOM_GENUS =
            LOOT_FUNCTIONS.register("random_genus", () -> new LootItemFunctionType(new RandomGenus.Serializer()));

    public static void register(IEventBus eventBus) {
        LOOT_FUNCTIONS.register(eventBus);
    }
}