package com.mrtrollnugnug.experienceore;

import java.security.Security;
import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.API;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {

		private WorldGenerator genExperienceOre;
		public WorldGen() {

			// Vanilla default prob 10
			this.genExperienceOre = new WorldGenMinable(ExperienceOre.BLOCK_EXPERIENCE_ORE.getDefaultState(), 100);
		    
		}
	    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
		        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		    int heightDiff = maxHeight - minHeight + 1;
		    for (int i = 0; i < chancesToSpawn; i ++) {
		        int x = chunk_X * 16 + rand.nextInt(16);
		        int y = minHeight + rand.nextInt(heightDiff);
		        int z = chunk_Z * 16 + rand.nextInt(16);
		        generator.generate(world, rand, new BlockPos(x, y, z));
		    }
		}

		@Override
		public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
				IChunkProvider chunkProvider) {
			// TODO Auto-generated method stub
			  switch (world.provider.getDimension()) {
			    case 0: //Overworld
			        this.runGenerator(this.genExperienceOre, world, random, chunkX, chunkZ, 100, 0, 64);
			        break;
				case -1: // Nether

				break;
				case 1: // End
					break;
				}
		}
}