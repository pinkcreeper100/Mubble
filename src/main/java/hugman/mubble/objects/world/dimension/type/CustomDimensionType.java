package hugman.mubble.objects.world.dimension.type;

import java.util.function.BiFunction;

import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

public class CustomDimensionType extends ModDimension
{
	private final BiFunction<World, DimensionType, ? extends Dimension> dimClass;
	
	public CustomDimensionType(BiFunction<World, DimensionType, ? extends Dimension> dimClass)
	{
		this.dimClass = dimClass;
	}
	
	@Override
	public BiFunction<World, DimensionType, ? extends Dimension> getFactory()
	{
		return this.dimClass;
	}
}