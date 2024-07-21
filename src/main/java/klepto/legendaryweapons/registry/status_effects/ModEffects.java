package klepto.legendaryweapons.registry.status_effects;

import klepto.legendaryweapons.LegendaryWeapons;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {

    //public static final StatusEffect SLIPPERY = registerEffect("slippery", new SlipperyEffect(null, 0));
    


    private static StatusEffect registerEffect(String name, StatusEffect effect){
        return Registry.register(Registries.STATUS_EFFECT, Identifier.of(LegendaryWeapons.MOD_ID, name), effect);
	}

    public static String registerModEffects(){
        return "Registering EFFECTS for " + LegendaryWeapons.MOD_ID;
    }
}
