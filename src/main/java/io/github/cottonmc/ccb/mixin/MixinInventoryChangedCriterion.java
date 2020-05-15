package io.github.cottonmc.ccb.mixin;

import io.github.cottonmc.ccb.api.event.advancement.InventoryChangedCallback;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryChangedCriterion.class)
public class MixinInventoryChangedCriterion {
	@Inject(method = "trigger", at = @At("HEAD"))
	private void injectEvent(ServerPlayerEntity player, PlayerInventory inventory, CallbackInfo info) {
		InventoryChangedCallback.EVENT.invoker().handleInventoryChange(player, inventory);
	}
}
