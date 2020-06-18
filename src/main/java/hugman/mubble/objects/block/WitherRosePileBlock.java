package hugman.mubble.objects.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import java.util.Random;

public class WitherRosePileBlock extends PileBlock {
	public WitherRosePileBlock(Settings builder) {
		super(builder);
	}

	@Override
	public boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return super.canPlantOnTop(state, worldIn, pos) || block == Blocks.SOUL_SAND;
	}

	@Environment(EnvType.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		for(int i = 0; i < 5; ++i) {
			if(rand.nextBoolean()) {
				worldIn.addParticle(ParticleTypes.SMOKE, (double) pos.getX() + (double) (rand.nextInt(17) / 16), (double) pos.getY() + (0.5D - (double) rand.nextFloat()), (double) pos.getZ() + (double) (rand.nextInt(17) / 16), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if(!worldIn.isClient && worldIn.getDifficulty() != Difficulty.PEACEFUL) {
			if(entityIn instanceof LivingEntity) {
				LivingEntity livingentity = (LivingEntity) entityIn;
				if(!livingentity.isInvulnerableTo(DamageSource.WITHER)) {
					livingentity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 40));
				}
			}
		}
	}
}
