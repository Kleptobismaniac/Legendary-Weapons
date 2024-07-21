package klepto.legendaryweapons.registry.util;

import klepto.legendaryweapons.LegendaryWeapons;
import klepto.legendaryweapons.registry.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.advancement.criterion.PlayerGeneratesContainerLootCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.command.argument.RegistryEntryPredicateArgumentType;
import net.minecraft.command.argument.RegistryEntryArgumentType.LootConditionArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.EntityScoresLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.loot.condition.LootConditionTypes;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.ValueCheckLootCondition;
import net.minecraft.loot.context.LootContext.EntityTarget;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProviderType;
import net.minecraft.loot.provider.number.LootNumberProviderTypes;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NbtPredicate;
import net.minecraft.predicate.NumberRange.IntRange;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.EntitySubPredicate;
import net.minecraft.predicate.entity.EntitySubPredicateTypes;
import net.minecraft.predicate.entity.EntityTypePredicate;
import net.minecraft.predicate.entity.PlayerPredicate;
import net.minecraft.predicate.entity.PlayerPredicate.Builder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryOwner;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stat;
import net.minecraft.stat.StatType;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public class ModLootTableModifiers {
    private static final RegistryKey<LootTable> COAL_ORE_LOOT_TABLE_ID = Blocks.COAL_ORE.getLootTableKey();

    //TODO Add Loot Tables

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((id, tableBuilder, source) -> {
            if(source.isBuiltin()){
                if(COAL_ORE_LOOT_TABLE_ID.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.TEST_ITEM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                        //.conditionally(PlayerGeneratesContainerLootCriterion.Conditions.create(RegistryKey.of(null, null)));
                        .conditionally(EntityPropertiesLootCondition.builder(EntityTarget.THIS, EntityPredicate.Builder.create()
                            .typeSpecific(PlayerPredicate.Builder.create().advancement(Identifier.of(LegendaryWeapons.MOD_ID+"/root"), false)
                            //.stat(Stats.MINED, Blocks.ACACIA_BUTTON.getRegistryEntry(), IntRange.exactly(1))
                            .build())  
                        ));
                    tableBuilder.pool(poolBuilder.build());
                }
            }            
        });
    }
}
