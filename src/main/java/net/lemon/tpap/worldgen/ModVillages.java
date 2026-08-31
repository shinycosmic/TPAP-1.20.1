package net.lemon.tpap.worldgen;

import com.mojang.datafixers.util.Pair;
import net.lemon.tpap.TPAP;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

/**
 * Injects the sculptor house into the vanilla village house pools at
 * server start. Requires the accesstransformer entries for
 * StructureTemplatePool#templates and #rawTemplates.
 */
@Mod.EventBusSubscriber(modid = TPAP.MODID)
public class ModVillages {
    private static final String SCULPTOR_HOUSE = TPAP.MODID + ":village/sculptor_house";
    private static final List<String> VILLAGE_TYPES = List.of("plains", "desert", "savanna", "snowy", "taiga");

    @SubscribeEvent
    public static void onServerAboutToStart(ServerAboutToStartEvent event) {
        Registry<StructureTemplatePool> pools = event.getServer().registryAccess().registryOrThrow(Registries.TEMPLATE_POOL);
        Registry<StructureProcessorList> processors = event.getServer().registryAccess().registryOrThrow(Registries.PROCESSOR_LIST);
        for (String type : VILLAGE_TYPES) {
            addToPool(pools, processors, new ResourceLocation("minecraft", "village/" + type + "/houses"), SCULPTOR_HOUSE, 4);
        }
    }

    private static void addToPool(Registry<StructureTemplatePool> pools, Registry<StructureProcessorList> processors,
                                  ResourceLocation poolId, String pieceId, int weight) {
        StructureTemplatePool pool = pools.get(poolId);
        if (pool == null) {
            return;
        }
        Holder<StructureProcessorList> empty = processors.getHolderOrThrow(
                ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation("minecraft", "empty")));
        SinglePoolElement piece = StructurePoolElement.legacy(pieceId, empty).apply(StructureTemplatePool.Projection.RIGID);
        for (int i = 0; i < weight; i++) {
            pool.templates.add(piece);
        }
        List<Pair<StructurePoolElement, Integer>> rawTemplates = new ArrayList<>(pool.rawTemplates);
        rawTemplates.add(new Pair<>(piece, weight));
        pool.rawTemplates = rawTemplates;
    }
}