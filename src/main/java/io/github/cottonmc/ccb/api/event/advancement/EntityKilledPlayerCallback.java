package io.github.cottonmc.ccb.api.event.advancement;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

//TODO: predicate system instead of just firing every listener on every event?
public interface EntityKilledPlayerCallback {
	Event<EntityKilledPlayerCallback> EVENT = EventFactory.createArrayBacked(EntityKilledPlayerCallback.class, listeners -> (victim, killer, source) -> {
		for (EntityKilledPlayerCallback listener : listeners) {
			listener.handleEntityKillPlayer(victim, killer, source);
		}
	});
	void handleEntityKillPlayer(PlayerEntity victim, Entity killer, DamageSource source);
}
