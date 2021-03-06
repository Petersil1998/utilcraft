package net.petersil98.utilcraft.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.petersil98.utilcraft.Utilcraft;
import net.petersil98.utilcraft.data.capabilities.home.CapabilityHome;
import net.petersil98.utilcraft.data.capabilities.home.HomeProvider;
import net.petersil98.utilcraft.data.capabilities.last_death.CapabilityLastDeath;
import net.petersil98.utilcraft.data.capabilities.last_death.LastDeathProvider;
import net.petersil98.utilcraft.data.capabilities.vein_miner.CapabilityVeinMiner;
import net.petersil98.utilcraft.data.capabilities.vein_miner.VeinMinerProvider;

import javax.annotation.Nonnull;
import java.util.concurrent.atomic.AtomicReference;

@Mod.EventBusSubscriber(modid = Utilcraft.MOD_ID)
public class AttachCapabilities {

    @SubscribeEvent
    public static void attachVeinMinerCapability(@Nonnull AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof ServerPlayerEntity) {
            VeinMinerProvider provider = new VeinMinerProvider();
            event.addCapability(new ResourceLocation(Utilcraft.MOD_ID, "active"), provider);
            event.addListener(provider::invalidate);
        }
    }

    @SubscribeEvent
    public static void attachHomeCapability(@Nonnull AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof ServerPlayerEntity) {
            HomeProvider provider = new HomeProvider();
            event.addCapability(new ResourceLocation(Utilcraft.MOD_ID, "home"), provider);
            event.addListener(provider::invalidate);
        }
    }

    @SubscribeEvent
    public static void attachLastDeathCapability(@Nonnull AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof ServerPlayerEntity) {
            LastDeathProvider provider = new LastDeathProvider();
            event.addCapability(new ResourceLocation(Utilcraft.MOD_ID, "last_death"), provider);
            event.addListener(provider::invalidate);
        }
    }

    public static void adjustCapabilities(@Nonnull PlayerEntity original, @Nonnull PlayerEntity clone) {
        AtomicReference<Boolean> veinMiner = new AtomicReference<>();

        original.getCapability(CapabilityVeinMiner.VEIN_MINER_CAPABILITY).ifPresent(iVeinMiner -> {
            veinMiner.set(iVeinMiner.getVeinMiner());
        });

        clone.getCapability(CapabilityVeinMiner.VEIN_MINER_CAPABILITY).ifPresent(iVeinMiner -> {
            iVeinMiner.setVeinMiner(veinMiner.get());
        });

        AtomicReference<BlockPos> blockPos = new AtomicReference<>();
        AtomicReference<ResourceLocation> resourceLocation = new AtomicReference<>();

        original.getCapability(CapabilityHome.HOME_CAPABILITY).ifPresent(iHome -> {
            blockPos.set(iHome.getHome());
        });

        clone.getCapability(CapabilityHome.HOME_CAPABILITY).ifPresent(iHome -> {
            iHome.setHome(blockPos.get());
        });

        original.getCapability(CapabilityLastDeath.LAST_DEATH_CAPABILITY).ifPresent(iLastDeath -> {
            blockPos.set(iLastDeath.getDeathPoint());
            resourceLocation.set(iLastDeath.getDeathDimension());
        });

        clone.getCapability(CapabilityLastDeath.LAST_DEATH_CAPABILITY).ifPresent(iLastDeath -> {
            iLastDeath.setDeathPoint(blockPos.get());
            iLastDeath.setDeathDimension(resourceLocation.get());
        });
    }
}
