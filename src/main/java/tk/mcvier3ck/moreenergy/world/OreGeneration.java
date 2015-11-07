package tk.mcvier3ck.moreenergy.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import tk.mcvier3ck.moreenergy.block.BlockRegistry;

public class OreGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {

	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {

		generateOre(world, BlockRegistry.BlueOre, random, chunkX, chunkZ, 3, 10);
		generateOre(world, BlockRegistry.RedOre, random, chunkX, chunkZ, 3, 10);
		generateOre(world, BlockRegistry.GreenOre, random, chunkX, chunkZ, 3, 10);
		generateOre(world, BlockRegistry.YellowOre, random, chunkX, chunkZ, 3, 10);

	}

	private void generateNether(World world, Random random, int chunkX, int chunkZ) {

	}

	public void generateOre(World world, Block block, Random random, int chunkX, int chunkZ, int veinsize, int chance) {
		for (int i = 0; i < chance; i++) {
			int randPosX = chunkX + random.nextInt(16);
			int randPosY = random.nextInt(64);
			int randPosZ = chunkZ + random.nextInt(16);

			(new WorldGenMinable(block, veinsize)).generate(world, random, randPosX, randPosY, randPosZ);

		}
	}

}
