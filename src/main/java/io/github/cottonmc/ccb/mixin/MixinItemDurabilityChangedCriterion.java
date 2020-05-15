package io.github.cottonmc.ccb.mixin;

import io.github.cottonmc.ccb.api.event.advancement.ItemDurabilityChangedCallback;
import net.minecraft.advancement.criterion.ItemDurabilityChangedCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemDurabilityChangedCriterion.class)
public class MixinItemDurabilityChangedCriterion {
	@Inject(method = "trigger", at = @At("HEAD"))
	private void injectEvent(ServerPlayerEntity player, ItemStack stack, int damage, CallbackInfo info) {
		ItemDurabilityChangedCallback.EVENT.invoker().handleItemDurabilityChange(player, stack, damage);
	}
}
