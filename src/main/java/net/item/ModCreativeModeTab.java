package net.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab FAVILLANMAGIC = new CreativeModeTab( "favillanmagic") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FIRE_CRYSTAL.get());
        }
    };
}
