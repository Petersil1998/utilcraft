package net.petersil98.utilcraft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.StairsBlock;

public class GoldStairs extends StairsBlock {

    public GoldStairs() {
        super(() -> new GoldBrick().getDefaultState(), AbstractBlock.Properties.from(new GoldBrick()));
    }
}
