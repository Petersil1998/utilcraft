package net.petersil98.utilcraft.items;

import net.minecraft.item.Item;
import net.petersil98.utilcraft.Utilcraft;

public class SilverIngot extends Item {
    public SilverIngot() {
        super(new Item.Properties()
                .group(Utilcraft.ITEM_GROUP)
                .maxStackSize(1)
        );
    }
}
