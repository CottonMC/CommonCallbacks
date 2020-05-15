package io.github.cottonmc.ccb.mixin;

import io.github.cottonmc.ccb.api.event.advancement.EntityKilledPlayerCallback;
import io.github.cottonmc.ccb.api.event.advancement.PlayerKilledEntityCallback;
import net.minecraft.advancement.criterion.Criterions;
import net.minecraft.advancement.criterion.OnKilledCriterion;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OnKilledCriterion.class)
public class MixinOnKilledCriterion {
	@Inject(method = "trigger", at = @At("HEAD"))
	private void injectEvent(ServerPlayerEntity player, Entity entity, DamageSource source, CallbackInfo info) {
		if ((Object)this == Criterions.ENTITY_KILLED_PLAYER) {
			EntityKilledPlayerCallback.EVENT.invoker().handleEntityKillPlayer(player, entity, source);
		} else if ((Object)this == Criterions.PLAYER_KILLED_ENTITY) {
			PlayerKilledEntityCallback.EVENT.invoker().handlePlayerKillEntity(player, entity, source);
		}
	}
}
