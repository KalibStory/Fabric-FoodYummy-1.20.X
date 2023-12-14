package com.kalibconnell.bakersdelight.item;

import com.kalibconnell.bakersdelight.BakersDelight;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class CustomFood {

    public static Item pumpkin_cake;
    public static Item mod_icon;
    public static Item slime_cube;




    public static void registerFood() {
        pumpkin_cake = newItem(
                "pumpkin_cake",
                new FabricItemSettings().food(new FoodComponent.Builder()
                        .hunger(2)

                        .saturationModifier(2)
                        .build()
                ),
                ItemGroups.FOOD_AND_DRINK
        );
        mod_icon = newItem(
                "mod_icon",
                new FabricItemSettings(),
                ItemGroups.HOTBAR
        );
        slime_cube = newItem(
                "slime_cube",
                (new FabricItemSettings().food(new FoodComponent.Builder()
                        .hunger(0)
                        .saturationModifier(-6)
                        .build())),

                ItemGroups.COMBAT
        );


    }
    //public static final Item mod_icon = newItem("fy_icon");


    private static Item newItem(String name, FabricItemSettings settings, RegistryKey<ItemGroup> group) {

        Item newItem = Registry.register(
                Registries.ITEM,
                new Identifier(BakersDelight.MOD_ID, name),
                new Item(settings)
        );

        ItemGroupEvents.modifyEntriesEvent(group).register(content -> content.add(newItem));

        return newItem;
    }
}
