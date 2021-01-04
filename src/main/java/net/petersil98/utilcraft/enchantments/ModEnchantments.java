package net.petersil98.utilcraft.enchantments;

import net.minecraftforge.registries.ObjectHolder;
import net.petersil98.utilcraft.Utilcraft;

@ObjectHolder(Utilcraft.MOD_ID)
public class ModEnchantments {

    @ObjectHolder("beheading_enchantment")
    public static BeheadingEnchantment BEHEADING;

    @ObjectHolder("beheading")
    public static BeheadingModifier.Serializer BEHEADING_SERIALIZER;
}
