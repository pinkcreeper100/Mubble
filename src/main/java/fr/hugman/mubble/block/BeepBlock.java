package fr.hugman.mubble.block;

import fr.hugman.dawn.block.DawnBlockSettings;
import fr.hugman.mubble.world.MubbleGamerules;
import net.minecraft.SharedConstants;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/**
 * @author komerish
 * @author Napero
 * @author Hugman
 * @since v4.0.0
 */
public class BeepBlock extends Block {
	public static final int DEFAULT_COOLDOWN = SharedConstants.TICKS_PER_SECOND * 4;
	public static final BooleanProperty FRAME = BooleanProperty.of("frame");

	public final boolean offset;

	public BeepBlock(Settings settings, boolean offset) {
		super(settings);
		this.offset = offset;
		this.setDefaultState(getDefaultState().with(FRAME, false));
	}

	public BeepBlock(MapColor mapColor, boolean offset) {
		this(makeSettings(mapColor), offset);

	}

	public static Settings makeSettings(MapColor mapColor) {
		return DawnBlockSettings.of(Material.STONE, mapColor)
				.sounds(BlockSoundGroup.AMETHYST_BLOCK)
				.strength(1.5f).requiresTool().item()
				.allowsSpawning(BeepBlock::isNotFrame)
				.solidBlock(BeepBlock::isNotFrame)
				.suffocates(BeepBlock::isNotFrame)
				.blockVision(BeepBlock::isNotFrame);
	}

	private static boolean isFrame(BlockState state) {
		return state.get(FRAME);
	}

	private static boolean isNotFrame(BlockState state, BlockView world, BlockPos pos) {
		return !isFrame(state);
	}

	private static boolean isNotFrame(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
		return !isFrame(state);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FRAME);
	}

	@Override
	public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
		return isFrame(state);
	}
	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return isFrame(state) ? VoxelShapes.empty() : VoxelShapes.fullCube();
	}

	@Override
	public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
		return isFrame(state) ? VoxelShapes.empty() : VoxelShapes.fullCube();
	}

	@Override
	public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
		return isFrame(state) ? 1.0F : 0.2f;
	}

	@Nullable
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return getStateAtTime(ctx.getWorld());
	}

	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		this.refreshState(world, pos);
		this.scheduleTick(world, pos, state.getBlock());
	}

	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if(!world.isClient()) {
			this.refreshState(world, pos);
			this.scheduleTick(world, pos, state.getBlock());
		}
	}

	public void refreshState(World world, BlockPos pos) {
		world.setBlockState(pos, getStateAtTime(world));
	}

	public void scheduleTick(World world, BlockPos pos, Block block) {
		int cooldown = world.getGameRules().getInt(MubbleGamerules.BEEP_BLOCK_COOLDOWN);
		if(cooldown > 0) {
			long worldTime = world.getTime();
			int delta = (int) (cooldown - worldTime);
			world.scheduleBlockTick(pos, block, (delta == 0) ? cooldown : delta % cooldown);
		}
	}

	public BlockState getStateAtTime(World world) {
		int cooldown = world.getGameRules().getInt(MubbleGamerules.BEEP_BLOCK_COOLDOWN);
		if(cooldown <= 0) return getDefaultState().with(FRAME, this.offset);
		long worldTime = world.getTime();
		boolean frame = (int) ((worldTime + (this.offset ? cooldown : 0)) % (cooldown * 2)) < cooldown;
		return this.getDefaultState().with(FRAME, frame);
	}
}