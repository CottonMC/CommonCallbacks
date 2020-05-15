package io.github.cottonmc.ccb.api.event.advancement;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.server.network.ServerPlayerEntity;

//TODO: predicate system instead of just firing every listener on every event?
public interface InventoryChangedCallback {
	Event<InventoryChangedCallback> EVENT = EventFactory.createArrayBacked(InventoryChangedCallback.class, listeners -> (player, inventory) -> {
		for (InventoryChangedCallback listener : listeners) {
			listener.handleInventoryChange(player, inventory);
		}
	});

	void handleInventoryChange(ServerPlayerEntity player, PlayerInventory inventory);
}
