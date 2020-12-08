package net.petersil98.utilcraft.data.capabilities.inventory;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class InventoryProvider implements ICapabilitySerializable<CompoundNBT> {

    private DefaultInventory inventory = new DefaultInventory();
    private final LazyOptional<IInventory> inventoryOptional = LazyOptional.of(() -> inventory);

    public InventoryProvider(){
        inventory = new DefaultInventory();
    }

    public InventoryProvider(int size) {
        inventory = new DefaultInventory(size);
    }

    public void invalidate() {
        inventoryOptional.invalidate();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityInventory.INVENTORY_CAPABILITY) {
            return inventoryOptional.cast();
        } else {
            return LazyOptional.empty();
        }
    }

    @Override
    public CompoundNBT serializeNBT() {
        if (CapabilityInventory.INVENTORY_CAPABILITY == null) {
            return new CompoundNBT();
        } else {
            return (CompoundNBT) CapabilityInventory.INVENTORY_CAPABILITY.writeNBT(inventory, null);
        }
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if (CapabilityInventory.INVENTORY_CAPABILITY != null) {
            CapabilityInventory.INVENTORY_CAPABILITY.readNBT(inventory, null, nbt);
        }
    }
}