package com.hugman.mubble.init.world;

import com.hugman.mubble.init.MubbleBlocks;
import com.hugman.mubble.init.data.MubbleBlockStateProperties;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class MubbleSurfaceBuilders {
	private static final BlockState SMW_GROUND_TOP = MubbleBlocks.SMW_GROUND_GROUND_BLOCK.getDefaultState().with(MubbleBlockStateProperties.OVER, true);
	private static final BlockState SMW_GROUND_DIRT = MubbleBlocks.SMW_GROUND_GROUND_BLOCK.getDefaultState().with(MubbleBlockStateProperties.OVER, false);
	private static final BlockState SMW_DESERT_TOP = MubbleBlocks.SMW_DESERT_GROUND_BLOCK.getDefaultState().with(MubbleBlockStateProperties.OVER, true);
	private static final BlockState SMW_DESERT_DIRT = MubbleBlocks.SMW_DESERT_GROUND_BLOCK.getDefaultState().with(MubbleBlockStateProperties.OVER, false);
	private static final BlockState AMARANTH_DYLIUM = MubbleBlocks.AMARANTH_DYLIUM.getDefaultState();
	private static final BlockState END_STONE = Blocks.END_STONE.getDefaultState();
	private static final BlockState DIRT = Blocks.DIRT.getDefaultState();

	public static final TernarySurfaceConfig SMW_GROUND_SURFACE = new TernarySurfaceConfig(SMW_GROUND_TOP, SMW_GROUND_DIRT, SMW_GROUND_DIRT);
	public static final TernarySurfaceConfig SMW_DESERT_SURFACE = new TernarySurfaceConfig(SMW_DESERT_TOP, SMW_DESERT_DIRT, DIRT);
	public static final TernarySurfaceConfig AMARANTH_DYLIUM_SURFACE = new TernarySurfaceConfig(AMARANTH_DYLIUM, END_STONE, END_STONE);
}