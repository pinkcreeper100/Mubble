package hugman.mubble.objects.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class SimpleEffect extends StatusEffect {
	public SimpleEffect(StatusEffectType typeIn, int liquidColorIn) {
		super(typeIn, liquidColorIn);
	}
}