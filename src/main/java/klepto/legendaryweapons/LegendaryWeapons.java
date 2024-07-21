package klepto.legendaryweapons;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementManager;
import net.minecraft.advancement.AdvancementPositioner;
import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.data.server.advancement.AdvancementProvider;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import klepto.legendaryweapons.registry.data_generation.DataGeneration.AdvancementsProvider;
import klepto.legendaryweapons.registry.item.ModItems;
import klepto.legendaryweapons.registry.util.ModLootTableModifiers;

public class LegendaryWeapons implements ModInitializer {
	public static final String MOD_ID = "legendary-weapons";
    public static final Logger LOGGER = LoggerFactory.getLogger("legendary-weapons");

	@Override
	public void onInitialize() {
		LOGGER.info(ModItems.registerModItems());
		ModLootTableModifiers.modifyLootTables();
		ServerTickEvents.START_SERVER_TICK.register(server -> {
			AdvancementEntry rootAdvancement = server.getAdvancementLoader().get(Identifier.of(LegendaryWeapons.MOD_ID + "/root"));
			List<ServerPlayerEntity> currentPlayers = server.getPlayerManager().getPlayerList();
			AdvancementProgress advancementProgress;
			for (int i = 0; i<currentPlayers.size(); i++){
				advancementProgress = currentPlayers.get(i).getAdvancementTracker().getProgress(rootAdvancement);
				if (advancementProgress.isDone()){
					for (int f = 0; f<currentPlayers.size(); f++){
						currentPlayers.get(f).getAdvancementTracker().grantCriterion(rootAdvancement, "legendary");
					}
				}
			}
        });
	}
}