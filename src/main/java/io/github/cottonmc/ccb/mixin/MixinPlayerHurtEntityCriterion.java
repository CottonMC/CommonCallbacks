package io.github.cottonmc.ccb.mixin;

import io.github.cottonmc.ccb.api.event.advancement.PlayerHurtEntityCallback;
import net.minecraft.advancement.criterion.PlayerHurtEntityCriterion;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerHurtEntityCriterion.class)
public class MixinPlayerHurtEntityCriterion {
	@Inject(method = "trigger", at = @At("HEAD"))
	private void injectEvent(ServerPlayerEntity player, Entity entity, DamageSource source, float dealt, float taken, boolean blocked, CallbackInfo info) {
		PlayerHurtEntityCallback.EVENT.invoker().handlePlayerHurtEntity(player, entity, source, dealt, taken, blocked);
	}
}
