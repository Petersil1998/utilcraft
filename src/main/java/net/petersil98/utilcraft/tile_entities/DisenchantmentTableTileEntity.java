package net.petersil98.utilcraft.tile_entities;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.INameable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.petersil98.utilcraft.Utilcraft;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DisenchantmentTableTileEntity extends TileEntity implements INameable {

    private ITextComponent customName;

    public DisenchantmentTableTileEntity() {
        super(ModTileEntities.DISENCHANTMENT_BLOCK);
    }

    @Nonnull
    public CompoundNBT write(@Nonnull CompoundNBT compound) {
        super.write(compound);
        if (this.hasCustomName()) {
            compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
        }

        return compound;
    }

    public void read(@Nonnull BlockState state, @Nonnull CompoundNBT nbt) {
        super.read(state, nbt);
        if (nbt.contains("CustomName", 8)) {
            this.customName = ITextComponent.Serializer.getComponentFromJson(nbt.getString("CustomName"));
        }

    }

    @Nonnull
    public ITextComponent getName() {
        return this.customName != null ? this.customName : new TranslationTextComponent(String.format("screen.%s.disenchantment_table", Utilcraft.MOD_ID));
    }

    public void setCustomName(@Nullable ITextComponent name) {
        this.customName = name;
    }

    @Nullable
    public ITextComponent getCustomName() {
        return this.customName;
    }
}
