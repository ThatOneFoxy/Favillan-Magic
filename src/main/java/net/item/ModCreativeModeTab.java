package net.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab FAVILLANMAGIC = new CreativeModeTab("data/favillanmagic") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FIRE_CRYSTAL.get()); //todo: update this icon to a different item.
        }
    };
}
