package klepto.legendaryweapons.registry.data_generation;
 
import java.util.function.Consumer;

import klepto.legendaryweapons.LegendaryWeapons;
import klepto.legendaryweapons.registry.item.ModItems;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DataGeneration implements DataGeneratorEntrypoint {

 
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
      FabricDataGenerator.Pack pack = dataGenerator.createPack();
      pack.addProvider(AdvancementsProvider::new);

    }


    public static class AdvancementsProvider extends FabricAdvancementProvider {

        protected AdvancementsProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataGenerator, registryLookup);
        }
 

        public void generateAdvancement(WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
          @SuppressWarnings("unused")
          //TODO Change Advancement parameters
          //TODO Add Advancements
              AdvancementEntry rootAdvancement = Advancement.Builder.create()
              .display(
                  ModItems.TEST_ITEM,
                  Text.literal("Soap Making 101"),
                  Text.literal("Craft a bar of Soap for the first time"),
                  Identifier.of("textures/gui/advancements/backgrounds/soapistry_background.png"),
                  AdvancementFrame.GOAL,
                  true,
                  true,
                  false
              )
              .criterion("legendary", InventoryChangedCriterion.Conditions.items(ModItems.TEST_ITEM))
              .build(consumer, LegendaryWeapons.MOD_ID + "/root");

      }  
    } 
  }