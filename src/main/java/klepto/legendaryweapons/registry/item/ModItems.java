package klepto.legendaryweapons.registry.item;

import klepto.legendaryweapons.LegendaryWeapons;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item TEST_ITEM = registerItem("test", new Item(new Item.Settings()));

    @SuppressWarnings("unused")
    private static Item registerItem(String name, Item item){
        Identifier id = Identifier.of(LegendaryWeapons.MOD_ID, name);

        //ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SOAP).register(content -> {content.add(item);});
        return Registry.register(Registries.ITEM, id, item);
	}

    public static String registerModItems(){
        return "Registering ITEMS for " + LegendaryWeapons.MOD_ID;
    }   

}
