package io.github.cottonmc.ccb.api.event.advancement;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;

//TODO: predicate system instead of just firing every listener on every event?
public interface PlayerHurtEntityCallback {
	Event<PlayerHurtEntityCallback> EVENT = EventFactory.createArrayBacked(PlayerHurtEntityCallback.class, listeners -> (player, entity, source, dealt, taken, blocked) -> {
		for (PlayerHurtEntityCallback listener : listeners) {
			listener.handlePlayerHurtEntity(player, entity, source, dealt, taken, blocked);
		}
	});

	void handlePlayerHurtEntity(ServerPlayerEntity player, Entity entity, DamageSource source, float dealt, float taken, boolean blocked);
}
