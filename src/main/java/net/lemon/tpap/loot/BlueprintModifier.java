package net.lemon.tpap.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.lemon.tpap.item.BlueprintItem;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class BlueprintModifier extends LootModifier {
    public static final Codec<BlueprintModifier> CODEC = RecordCodecBuilder.create(inst ->
            codecStart(inst)
                    .and(Codec.floatRange(0.0F, 1.0F).fieldOf("chance").forGetter(m -> m.chance))
                    .apply(inst, BlueprintModifier::new));

    private final float chance;

    public BlueprintModifier(LootItemCondition[] conditions, float chance) {
        super(conditions);
        this.chance = chance;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (!context.getQueriedLootTableId().getPath().startsWith("chests/")) {
            return generatedLoot;
        }
        RandomSource random = context.getRandom();
        if (random.nextFloat() >= this.chance) {
            return generatedLoot;
        }
        String genus = RandomGenus.rollGenus(random);
        if (genus != null) {
            generatedLoot.add(BlueprintItem.forGenus(genus));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}