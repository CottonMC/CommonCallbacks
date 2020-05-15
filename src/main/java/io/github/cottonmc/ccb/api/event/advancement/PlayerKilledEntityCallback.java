package io.github.cottonmc.ccb.api.event.advancement;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;

//TODO: predicate system instead of just firing every listener on every event?
public interface PlayerKilledEntityCallback {
	Event<PlayerKilledEntityCallback> EVENT = EventFactory.createArrayBacked(PlayerKilledEntityCallback.class, listeners -> (killer, victim, source) -> {
		for (PlayerKilledEntityCallback listener : listeners) {
			listener.handlePlayerKillEntity(killer, victim, source);
		}
	});
	void handlePlayerKillEntity(ServerPlayerEntity killer, Entity victim, DamageSource source);
}
