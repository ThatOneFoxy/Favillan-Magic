package net.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers{
    public static final ForgeTier Elysium = new ForgeTier(3, 3600, 6f, 2f, 27,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.ELYSIUM_GEM.get()));

    public static final ForgeTier FireStaff = new ForgeTier(3, 200, 1f, 1f, 0,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.FIRE_CRYSTAL.get()));

}
