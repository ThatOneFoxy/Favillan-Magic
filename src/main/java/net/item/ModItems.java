package net.item;

import net.item.ModCreativeModeTab;
import net.item.custom.FireStaffItem;
import net.item.custom.VoidPickaxeItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thatdevfoxy.favillanmagic.FavillanMagic;

public class ModItems {
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, FavillanMagic.MOD_ID);
    //ore stuff

    //base crystals
    public static final RegistryObject<Item> AIR_CRYSTAL = Items.register("aer_crystal",
            ()-> new Item(new Item.Properties().tab(ModCreativeModeTab.FAVILLANMAGIC)));

    public static final RegistryObject<Item> WATER_CRYSTAL = Items.register("aqua_crystal",
            ()-> new Item(new Item.Properties().tab(ModCreativeModeTab.FAVILLANMAGIC)));

    public static final RegistryObject<Item> EARTH_CRYSTAL = Items.register("terra_crystal",
            ()-> new Item(new Item.Properties().tab(ModCreativeModeTab.FAVILLANMAGIC)));

    public static final RegistryObject<Item> FIRE_CRYSTAL = Items.register("ignis_crystal",
            ()-> new Item(new Item.Properties().tab(ModCreativeModeTab.FAVILLANMAGIC)));

    public static final RegistryObject<Item> VOID_CRYSTAL = Items.register("inanis_crystal",
            ()-> new Item(new Item.Properties().tab(ModCreativeModeTab.FAVILLANMAGIC)));

    //result of mix

    public static final RegistryObject<Item> MOTION_CRYSTAL = Items.register("motus_crystal",
            ()-> new Item(new Item.Properties().tab(ModCreativeModeTab.FAVILLANMAGIC)));

//items
public static final RegistryObject<Item> GUIDE_BOOK = Items.register("guide_book",
        ()-> new Item(new Item.Properties().tab(ModCreativeModeTab.FAVILLANMAGIC)));
  //custom
  public static final RegistryObject<Item> FIRE_STAFF = Items.register("fire_staff",
          ()-> new FireStaffItem(new Item.Properties().tab(ModCreativeModeTab.FAVILLANMAGIC).stacksTo(1)));

    public static final RegistryObject<Item> ELYSIUM_GEM = Items.register("elysium",
            ()-> new Item(new Item.Properties().tab(ModCreativeModeTab.FAVILLANMAGIC)));

    //machine items
    public static final RegistryObject<Item> NILL = Items.register("change_in_machine_items",
            ()-> new Item(new Item.Properties().tab(ModCreativeModeTab.FAVILLANMAGIC).stacksTo(1)));


    //buckets
    //public static final RegistryObject<Item> CUSTOM_WATER_BUCKET = Items.register("custom_water_bucket",
            //()-> new BucketItem(ModFluids.SOURCE_CUSTOM_WATER,
                    //new Item.Properties().tab(ModCreativeModeTab.FAVILLANMAGIC).craftRemainder(net.minecraft.world.item.Items.BUCKET).stacksTo(1)));

    //tools / weapons
    public static final RegistryObject<Item> PICKAXE_OF_VOID = Items.register("void_pickaxe",
            ()-> new VoidPickaxeItem(ModTiers.Elysium, 4,4,
                    new Item.Properties().tab(ModCreativeModeTab.FAVILLANMAGIC).stacksTo(1)));




    public static void register(IEventBus eventBus){
        Items.register(eventBus);
    }

}

