/*package klepto.legendaryweapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectorGroupInfo.Map;

import klepto.legendaryweapons.registry.data_generation.DataGeneration;
import klepto.legendaryweapons.registry.data_generation.DataGeneration.AdvancementsProvider;
import klepto.legendaryweapons.registry.server.ServerEventCallback;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.advancement.PlacedAdvancement;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.network.packet.s2c.play.AdvancementUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
 
@Mixin(PlayerAdvancementTracker.class)
public class PlayerAdvancementTrackerMixin{
    @Inject(at = @At("HEAD"), method = "sendUpdate")
    public void sendUpdate(ServerPlayerEntity player, CallbackInfo info) {
		ServerEventCallback.grantAdvancement(player, AdvancementsProvider.rootAdvancement);
	}
}
*/