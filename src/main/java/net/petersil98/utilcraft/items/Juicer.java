package net.petersil98.utilcraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.petersil98.utilcraft.Main;

public class Juicer extends Item {

    public Juicer() {
        super(new Properties()
                .group(Main.itemGroup)
                .maxStackSize(1)
                .containerItem(ModItems.JUICER)
        );
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(ModItems.JUICER);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}
