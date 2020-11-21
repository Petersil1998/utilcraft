package net.petersil98.utilcraft.items;

import net.minecraft.item.*;
import net.petersil98.utilcraft.Main;
import net.petersil98.utilcraft.items.custom.ModItemTier;

public class RoseQuartzSword extends SwordItem {
    public RoseQuartzSword() {
        super(ModItemTier.ROSE_QUARTZ, 5, -2.0F, (new Item.Properties()).group(Main.itemGroup));
    }
}
