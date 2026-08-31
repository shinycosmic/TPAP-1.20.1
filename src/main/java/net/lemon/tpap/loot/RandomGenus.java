package net.lemon.tpap.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.lemon.tpap.item.BlueprintItem;
import net.lemon.tpap.item.MoldSize;
import net.lemon.tpap.registry.ModBlocks;
import net.lemon.tpap.registry.ModLootFunctions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RandomGenus extends LootItemConditionalFunction {

    protected RandomGenus(LootItemCondition[] conditions) {
        super(conditions);
    }

    @Override
    public LootItemFunctionType getType() {
        return ModLootFunctions.RANDOM_GENUS.get();
    }

    @Override
    protected ItemStack run(ItemStack stack, LootContext context) {
        String genus = rollGenus(context.getRandom());
        if (genus != null) {
            stack.getOrCreateTag().putString(BlueprintItem.GENUS_TAG, genus);
        }
        return stack;
    }

    /** Weighted pick across all genera; a genus weighs in at its biggest mold size. */
    @Nullable
    public static String rollGenus(RandomSource random) {
        List<String> genera = List.copyOf(ModBlocks.GENUS_MAP.keySet());
        int total = 0;
        for (String genus : genera) {
            total += weight(genus);
        }
        if (total <= 0) {
            return null;
        }
        int roll = random.nextInt(total);
        for (String genus : genera) {
            roll -= weight(genus);
            if (roll < 0) {
                return genus;
            }
        }
        return null;
    }

    private static int weight(String genus) {
        MoldSize biggest = MoldSize.SMALL;
        for (ModBlocks.StatueEntry entry : ModBlocks.GENUS_MAP.get(genus)) {
            if (entry.moldSize().ordinal() > biggest.ordinal()) {
                biggest = entry.moldSize();
            }
        }
        return switch (biggest) {
            case SMALL -> 8;
            case MEDIUM -> 4;
            case LARGE -> 2;
            case HUGE -> 1;
        };
    }

    public static class Serializer extends LootItemConditionalFunction.Serializer<RandomGenus> {
        @Override
        public RandomGenus deserialize(JsonObject json, JsonDeserializationContext ctx, LootItemCondition[] conditions) {
            return new RandomGenus(conditions);
        }
    }
}