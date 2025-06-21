package com.example.Blocks;

import com.example.ExampleMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
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

public class Giulio {

    public static final RegistryKey<Block> defaultBlockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ExampleMod.MOD_ID, "giulio"));
    public static final AbstractBlock.Settings defaultBlockSettings = AbstractBlock.Settings.create().requiresTool().registryKey(defaultBlockKey).sounds(BlockSoundGroup.GLASS).hardness(Blocks.STONE.getHardness());
    public static final RegistryKey<Item> defaultItemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExampleMod.MOD_ID, "giulio"));
    public static final Item.Settings defaultItemSettings = new Item.Settings().registryKey(defaultItemKey).food(new FoodComponent.Builder().nutrition(1).build(), ConsumableComponents.drink().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 10 * 20, 1), 1.0f)).build());
    public static final Function<AbstractBlock.Settings, Block> blockFactory = Block::new;

    public static Block register() {
        Block block = blockFactory.apply(defaultBlockSettings);

        BlockItem blockItem = new BlockItem(block, defaultItemSettings);
        Registry.register(Registries.ITEM, defaultItemKey, blockItem);

        return Registry.register(Registries.BLOCK, defaultBlockKey, block);
    }

    public static void initialize(Block giulio) {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register((itemGroup) -> { itemGroup.add(giulio.asItem());});
    }
}
