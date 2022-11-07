package net.item.custom;

import net.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier ELYSIUM = new ForgeTier(3, 3600, 8f, 2f, 22, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.ELYSIUM_GEM.get()));

}
