package klepto.legendaryweapons.registry.sound;

import klepto.legendaryweapons.LegendaryWeapons;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    
    public static SoundEvent MYSTICAL_RESIDUE_SUCCESS = registerSoundEvent("mystical_residue_success");
    public static SoundEvent MYSTICAL_RESIDUE_FAIL = registerSoundEvent("mystical_residue_fail");



    public static SoundEvent SOAPY_SOAP_USE = registerSoundEvent("soapy_soap_use");
    public static SoundEvent SLIMEY_SOAP_USE = registerSoundEvent("slimey_soap_use");
    public static SoundEvent SOAP_USE = registerSoundEvent("soap_use");


    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(LegendaryWeapons.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static String registerModSounds(){
        return "Registering SOUNDS for " + LegendaryWeapons.MOD_ID;
    } 

}
