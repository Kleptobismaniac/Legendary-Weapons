/* package klepto.legendaryweapons.registry.server;

import java.util.List;

import klepto.legendaryweapons.registry.data_generation.DataGeneration.AdvancementsProvider;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.ServerStarted;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.SyncDataPackContents;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class ServerEventCallback implements ServerStarted, SyncDataPackContents{
    ServerPlayerEntity player;
    AdvancementEntry rootAdvancement = AdvancementsProvider.rootAdvancement;

    @Override
    public void onServerStarted(MinecraftServer server) {
        if (server.isRunning()){
            
        }
    }

    public void onSyncDataPackContents(ServerPlayerEntity player, boolean joined){
        List<ServerPlayerEntity> currentPlayers = player.getServer().getPlayerManager().getPlayerList();
        for (int i = 0; i<currentPlayers.size()-1; i++){
            if (currentPlayers.get(i).getAdvancementTracker().getProgress(rootAdvancement).isDone()){
                player.getAdvancementTracker().grantCriterion(rootAdvancement, "got_soap");
            }
        }
    }

    public static void grantAdvancement(ServerPlayerEntity player, AdvancementEntry advancement)
	{
		for (String criterion : advancement.value().criteria().keySet())
		{
			//player.getAdvancements().grantCriterion(advancement, criterion);
            player.getAdvancementTracker().grantCriterion(advancement, criterion);
		}
	}
    
}
*/