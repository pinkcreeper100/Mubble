package hugman.mubble.mixin.client;

import hugman.mubble.Mubble;
import hugman.mubble.init.MubbleEnchantments;
import hugman.mubble.util.EnchantmentUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
	private static final String ItemStack = "Lnet/minecraft/item/ItemStack;";
	private static final String TextRenderer = "Lnet/minecraft/client/font/TextRenderer;";
	private static final String String = "Ljava/lang/String;";

	@Redirect(method = "renderGuiItemOverlay(" + TextRenderer + ItemStack + "II" + String + ")V", at = @At(value = "INVOKE",target = "Lnet/minecraft/item/ItemStack;isDamaged()Z"))
	public boolean mubble_appearsDamaged(ItemStack stack) {
		ClientPlayerEntity clientPlayerEntity = MinecraftClient.getInstance().player;
		if(EnchantmentUtil.hasEnchantment(MubbleEnchantments.IGNORANCE_CURSE, stack) && !clientPlayerEntity.isCreative()) {
			return false;
		}
		return stack.isDamaged();
	}
}
