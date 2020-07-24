package hugman.mubble.object.block;

import hugman.mubble.init.MubbleBlocks;
import hugman.mubble.init.world.MubbleConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NyliumBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import net.minecraft.world.gen.feature.NetherForestVegetationFeature;

import java.util.Random;

public class DyliumBlock extends NyliumBlock {
	public DyliumBlock(Settings settings) {
		super(settings);
	}

	private static boolean stayAlive(BlockState state, WorldView world, BlockPos pos) {
		BlockPos blockPos = pos.up();
		BlockState blockState = world.getBlockState(blockPos);
		int i = ChunkLightProvider.getRealisticOpacity(world, state, pos, blockState, blockPos, Direction.UP, blockState.getOpacity(world, blockPos));
		return i < world.getMaxLightLevel();
	}

	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if(!stayAlive(state, world, pos)) {
			world.setBlockState(pos, Blocks.END_STONE.getDefaultState());
		}
	}

	public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
		BlockState blockState = world.getBlockState(pos);
		BlockPos blockPos = pos.up();
		if(blockState.isOf(MubbleBlocks.AMARANTH_DYLIUM.getBlock())) {
			NetherForestVegetationFeature.method_26264(world, random, blockPos, MubbleConfiguredFeatures.Configs.AMARANTH_ROOTS, 3, 1);
		}
	}
}
