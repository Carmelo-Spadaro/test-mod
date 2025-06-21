package com.example;

import com.example.Blocks.Giulio;
import com.example.Items.SuspiciousSubstance;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ModFeatures {

    public static Block GIULIO = Giulio.register();

    public static final Item SUSPICIOUS_SUBSTANCE = SuspiciousSubstance.register();


    public static void initializeAll() {
        Giulio.initialize(GIULIO);
        SuspiciousSubstance.initialize(SUSPICIOUS_SUBSTANCE);
    }
}
