package net.petersil98.utilcraft.dimensions;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.Blockreader;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.structure.StructureManager;

import javax.annotation.Nonnull;

public class AfterlifeChunkGenerator extends ChunkGenerator {

    public AfterlifeChunkGenerator(BiomeProvider biomeProvider){
        super(biomeProvider, DimensionSettings.func_242746_i().getStructures());
    }

    public static final Codec<AfterlifeChunkGenerator> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(
                    BiomeProvider.CODEC.fieldOf("biome_source")
                            .forGetter((generator) -> generator.biomeProvider)
            ).apply(instance, instance.stable(AfterlifeChunkGenerator::new))
    );

    @Nonnull
    @Override
    protected Codec<? extends ChunkGenerator> func_230347_a_() {
        return CODEC;
    }

    @Nonnull
    @Override
    public ChunkGenerator func_230349_a_(long p_230349_1_) {
        return this;
    }

    @Override
    public void generateSurface(@Nonnull WorldGenRegion p_225551_1_, @Nonnull IChunk p_225551_2_) {

    }

    @Override
    public void func_230352_b_(@Nonnull IWorld p_230352_1_, @Nonnull StructureManager p_230352_2_, @Nonnull IChunk p_230352_3_) {

    }

    @Override
    public int getHeight(int x, int z, @Nonnull Heightmap.Type heightmapType) {
        return 0;
    }

    @Nonnull
    @Override
    public IBlockReader func_230348_a_(int p_230348_1_, int p_230348_2_) {
        return new Blockreader(new BlockState[0]);
    }
}
