package net.petersil98.utilcraft.datagen;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.petersil98.utilcraft.Utilcraft;
import net.petersil98.utilcraft.tags.UtilcraftTags;

import static net.petersil98.utilcraft.blocks.sideslabs.UtilcraftSideSlabs.*;
import static net.petersil98.utilcraft.blocks.UtilcraftBlocks.*;

public class UtilcraftBlockTags extends BlockTagsProvider {

    public UtilcraftBlockTags(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Utilcraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        this.getOrCreateBuilder(UtilcraftTags.BlockTags.SIDE_SLABS_BLOCKS).add(SIDE_ACACIA_SLAB, SIDE_BIRCH_SLAB, SIDE_COBBLESTONE_SLAB, SIDE_DARK_OAK_SLAB, SIDE_GOLD_SLAB, SIDE_JUNGLE_SLAB, SIDE_OAK_SLAB, SIDE_REDSTONE_SLAB, SIDE_SAKURA_SLAB, SIDE_SPRUCE_SLAB, SIDE_STONE_SLAB);
        this.getOrCreateBuilder(UtilcraftTags.BlockTags.SAKURA_LOGS).add(SAKURA_LOG);

        this.getOrCreateBuilder(BlockTags.FENCE_GATES).add(SAKURA_FENCE_GATE);
        this.getOrCreateBuilder(BlockTags.FLOWER_POTS).add(POTTED_SAKURA_SAPLING);
        this.getOrCreateBuilder(BlockTags.LEAVES).add(SAKURA_LEAVES);
        this.getOrCreateBuilder(BlockTags.LOGS_THAT_BURN).addTag(UtilcraftTags.BlockTags.SAKURA_LOGS);
        this.getOrCreateBuilder(BlockTags.PLANKS).add(SAKURA_PLANKS);
        this.getOrCreateBuilder(BlockTags.SAPLINGS).add(SAKURA_SAPLING);
        this.getOrCreateBuilder(BlockTags.SLABS).add(GOLD_SLAB, REDSTONE_SLAB);
        this.getOrCreateBuilder(BlockTags.STAIRS).add(SAKURA_STAIRS, GOLD_STAIRS, REDSTONE_STAIRS, GLASS_STAIRS);
        this.getOrCreateBuilder(BlockTags.STANDING_SIGNS).add(SAKURA_SIGN);
        this.getOrCreateBuilder(BlockTags.WALL_SIGNS).add(SAKURA_WALL_SIGN);
        this.getOrCreateBuilder(BlockTags.WALLS).add(GOLD_WALL);
        this.getOrCreateBuilder(BlockTags.WOODEN_BUTTONS).add(SAKURA_BUTTON);
        this.getOrCreateBuilder(BlockTags.WOODEN_DOORS).add(SAKURA_DOOR);
        this.getOrCreateBuilder(BlockTags.WOODEN_FENCES).add(SAKURA_FENCE);
        this.getOrCreateBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(SAKURA_PRESSURE_PLATE);
        this.getOrCreateBuilder(BlockTags.WOODEN_SLABS).add(SAKURA_SLAB);
        this.getOrCreateBuilder(BlockTags.WOODEN_TRAPDOORS).add(SAKURA_TRAPDOOR);
        this.getOrCreateBuilder(BlockTags.BEACON_BASE_BLOCKS).add(ROSE_QUARTZ_BLOCK);

        this.getOrCreateBuilder(Tags.Blocks.FENCE_GATES_WOODEN).add(SAKURA_FENCE_GATE);
        this.getOrCreateBuilder(Tags.Blocks.FENCES_WOODEN).add(SAKURA_FENCE);
        this.getOrCreateBuilder(Tags.Blocks.ORES).add(SILVER_ORE, ROSE_QUARTZ_ORE);
    }
}
