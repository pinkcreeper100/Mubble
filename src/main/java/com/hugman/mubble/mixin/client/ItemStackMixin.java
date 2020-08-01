package com.hugman.mubble.mixin.client;

import com.hugman.dawn.api.util.EnchantmentUtil;
import com.hugman.mubble.init.MubbleEnchantmentPack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.ListTag;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import javax.annotation.Nullable;
import java.util.List;

@Environment(EnvType.CLIENT)
@Mixin(ItemStack.class)
public class ItemStackMixin {
	private static final String List = "Ljava/util/List;";
	private static final String ListTag = "Lnet/minecraft/nbt/ListTag;";

	@Redirect(method = "getTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;appendEnchantments(" + List + ListTag + ")V"))
	public void mubble_appendEnchantments(List<Text> tooltip, ListTag enchantments, @Nullable PlayerEntity playerEntity, TooltipContext context) {
		ItemStack stack = (ItemStack) (Object) this;
		if(EnchantmentUtil.hasEnchantment(MubbleEnchantmentPack.IGNORANCE_CURSE, stack)) {
			if(playerEntity != null) {
				if(playerEntity.isCreative()) {
					ItemStack.appendEnchantments(tooltip, enchantments);
					return;
				}
			}
			tooltip.add(MubbleEnchantmentPack.IGNORANCE_CURSE.getName(EnchantmentHelper.getLevel(MubbleEnchantmentPack.IGNORANCE_CURSE, stack)));
		}
		else {
			ItemStack.appendEnchantments(tooltip, enchantments);
		}
	}

	@Redirect(method = "getTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isDamaged()Z"))
	public boolean mubble_isDamaged(ItemStack stack) {
		ClientPlayerEntity clientPlayerEntity = MinecraftClient.getInstance().player;
		if(EnchantmentUtil.hasEnchantment(MubbleEnchantmentPack.IGNORANCE_CURSE, stack) && !clientPlayerEntity.isCreative()) {
			return false;
		}
		return stack.isDamaged();
	}
}
