package io.github.cottonmc.ccb.api.event.advancement;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

//TODO: predicate system instead of just firing every listener on every event?
public interface ItemDurabilityChangedCallback {
	Event<ItemDurabilityChangedCallback> EVENT = EventFactory.createArrayBacked(ItemDurabilityChangedCallback.class, listeners -> (player, stack, damage) -> {
		for (ItemDurabilityChangedCallback listener : listeners) {
			listener.handleItemDurabilityChange(player, stack, damage);
		}
	});

	void handleItemDurabilityChange(ServerPlayerEntity player, ItemStack stack, int damage);
}
