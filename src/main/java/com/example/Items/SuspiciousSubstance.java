package com.example.Items;

import com.example.ExampleMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class SuspiciousSubstance {

    public static final RegistryKey<Item> defaultItemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExampleMod.MOD_ID, "suspicious_substance"));
    public static final Item.Settings defaultItemSettings = new Item.Settings().registryKey(defaultItemKey);
    public static final Function<Item.Settings, Item> itemFactory = Item::new;

    public static Item register() {
        // Create the item instance.
        Item item = itemFactory.apply(defaultItemSettings);

        // Register the item.
        Registry.register(Registries.ITEM, defaultItemKey, item);

        return item;
    }

    public static void initialize(Item suspiciousSubstance) {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.add(suspiciousSubstance));
    }
}
