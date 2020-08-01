package com.hugman.mubble.object.item.costume;

import com.hugman.mubble.init.MubbleBlockPack;
import com.hugman.mubble.object.block.KoretatoBlock;
import com.hugman.mubble.object.block.block_state_property.Princess;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrownCostume extends HeadCostume {
	protected final Princess princess;

	public CrownCostume(Item.Settings builder, Princess princess) {
		super(builder, SoundEvents.ITEM_ARMOR_EQUIP_IRON);
		this.princess = princess;
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		World world = context.getWorld();
		BlockPos blockPos = context.getBlockPos();
		BlockState iblockstate = world.getBlockState(blockPos);
		if(iblockstate.getBlock() == MubbleBlockPack.KORETATO_BLOCK && iblockstate.get(KoretatoBlock.PRINCESS) == Princess.NONE) {
			world.addParticle(ParticleTypes.HEART, (float) blockPos.getX() + 0.5F, (float) blockPos.getY() + 1.1F, (float) blockPos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
			if(!world.isClient) {
				BlockState blockState1 = iblockstate.with(KoretatoBlock.PRINCESS, princess);
				world.setBlockState(blockPos, blockState1, 2);
				context.getStack().decrement(1);
				world.playSound(null, blockPos, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, SoundCategory.BLOCKS, 1.0F, 1.0F);
				world.playSound(null, blockPos, this.getEquipSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
			return ActionResult.SUCCESS;
		}
		else {
			return super.useOnBlock(context);
		}
	}
}