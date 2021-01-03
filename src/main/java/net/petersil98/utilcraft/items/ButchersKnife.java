package net.petersil98.utilcraft.items;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.petersil98.utilcraft.Main;
import net.petersil98.utilcraft.blocks.ModBlocks;

import javax.annotation.Nonnull;

public class ButchersKnife extends Item {

    public ButchersKnife() {
        super(new Item.Properties().group(Main.itemGroup));
    }

    @Nonnull
    @Override
    public ActionResultType onItemUse(@Nonnull ItemUseContext context) {
        BlockPos pos = context.getPos();
        World world = context.getWorld();
        Block block = world.getBlockState(pos).getBlock();
        if(block.matchesBlock(Blocks.FURNACE)) {
            Block toCheck = world.getBlockState(pos.north()).getBlock();
            if(toCheck.matchesBlock(Blocks.CRAFTING_TABLE)) {
                replaceBlocks(pos, pos.north(), world);
                return ActionResultType.SUCCESS;
            }
            toCheck = world.getBlockState(pos.south()).getBlock();
            if (toCheck.matchesBlock(Blocks.CRAFTING_TABLE)) {
                replaceBlocks(pos, pos.south(), world);
                return ActionResultType.SUCCESS;
            }
            toCheck = world.getBlockState(pos.east()).getBlock();
            if (toCheck.matchesBlock(Blocks.CRAFTING_TABLE)) {
                replaceBlocks(pos, pos.east(), world);
                return ActionResultType.SUCCESS;
            }
            toCheck = world.getBlockState(pos.west()).getBlock();
            if (toCheck.matchesBlock(Blocks.CRAFTING_TABLE)) {
                replaceBlocks(pos, pos.west(), world);
                return ActionResultType.SUCCESS;
            }
        } else if (block.getBlock().matchesBlock(Blocks.CRAFTING_TABLE)) {
            Block toCheck = world.getBlockState(pos.north()).getBlock();
            if(toCheck.matchesBlock(Blocks.FURNACE)) {
                replaceBlocks(pos, pos.north(), world);
                return ActionResultType.SUCCESS;
            }
            toCheck = world.getBlockState(pos.south()).getBlock();
            if (toCheck.matchesBlock(Blocks.FURNACE)) {
                replaceBlocks(pos, pos.south(), world);
                return ActionResultType.SUCCESS;
            }
            toCheck = world.getBlockState(pos.east()).getBlock();
            if (toCheck.matchesBlock(Blocks.FURNACE)) {
                replaceBlocks(pos, pos.east(), world);
                return ActionResultType.SUCCESS;
            }
            toCheck = world.getBlockState(pos.west()).getBlock();
            if (toCheck.matchesBlock(Blocks.FURNACE)) {
                replaceBlocks(pos, pos.west(), world);
                return ActionResultType.SUCCESS;
            }
        }
        return super.onItemUse(context);
    }

    private void replaceBlocks(BlockPos pos1, BlockPos pos2, World world) {
        world.setBlockState(pos1, ModBlocks.SUSHI_MAKER.getDefaultState());
        world.setBlockState(pos2, ModBlocks.SUSHI_MAKER.getDefaultState());
    }
}
