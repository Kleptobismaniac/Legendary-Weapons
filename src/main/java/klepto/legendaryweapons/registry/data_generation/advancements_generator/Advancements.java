package klepto.legendaryweapons.registry.data_generation.advancements_generator;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.EffectsChangedCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.predicate.entity.EntityEffectPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.util.function.Consumer;


 /* 
public class Advancements implements Consumer<Consumer<Advancement>> {

 
    @Override
    @SuppressWarnings("unused")
    public void accept(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
        .display(
            ModItems.SOAP,
            Text.literal("Soap Making 101"),
            Text.literal("Craft a bar of Soap for the first time"),
            new Identifier("textures/gui/advancements/backgrounds/soapistry_background.png"),
            AdvancementFrame.GOAL,
            true,
            true,
            false
        )
        .criterion("got_soap", InventoryChangedCriterion.Conditions.items(ModItems.SOAP))
        .build(consumer, "soapistry" + "/root");

        
}
*/