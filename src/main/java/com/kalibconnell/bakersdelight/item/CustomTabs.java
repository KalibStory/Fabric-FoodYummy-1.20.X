package com.kalibconnell.bakersdelight.item;

import com.kalibconnell.bakersdelight.BakersDelight;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class CustomTabs {

    public static ItemGroup maintab;

    public static ItemGroup newItemGroup(ItemGroup group) {
        return Registry.register(Registries.ITEM_GROUP, new Identifier(BakersDelight.MOD_ID,group.getDisplayName().getString()), group);
    }



    public static void registerTabs() {
        BakersDelight.LOGGER.info("Registering new Item Groups in CustomTabs.java for: " + BakersDelight.MOD_ID);

        maintab = newItemGroup(
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(CustomFood.mod_icon))
                        .displayName(Text.translatable("itemgroup." + BakersDelight.MOD_ID + ".maintab"))

                        .entries((context, entries) -> {
                            entries.add(CustomFood.pumpkin_cake);
                            entries.add(CustomFood.slime_cube);
                        })
                    .build()
        );
    }
}
