package hugman.mod.objects.block;

import hugman.mod.Mubble;
import hugman.mod.init.MubbleBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemGroup;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;

public class BlockDirectional extends net.minecraft.block.BlockDirectional
{	
    public BlockDirectional(String name, Properties properties, ItemGroup group)
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.UP));
        setRegistryName(Mubble.MOD_ID, name);
        MubbleBlocks.register(this, group);
    }
    
    @Override
    public IBlockState rotate(IBlockState state, Rotation rot)
    {
    	return state.with(FACING, rot.rotate(state.get(FACING)));
	}
    
    @Override
	public IBlockState mirror(IBlockState state, Mirror mirrorIn)
    {
    	return state.mirror(mirrorIn);
	}
    
    @Override
    public IBlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite());
    }
    
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder)
    {
    	builder.add(FACING);
	}
}
