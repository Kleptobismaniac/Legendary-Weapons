package klepto.legendaryweapons.registry.block;


import klepto.legendaryweapons.LegendaryWeapons;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {


    




    
    private static Block registerBlock(String name, Block block, boolean registerBlockItem){
        Identifier id = Identifier.of(LegendaryWeapons.MOD_ID, name);
        //ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SOAP).register(content -> {content.add(block);});
        if(registerBlockItem){
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
			Registry.register(Registries.ITEM, id, blockItem);
        }
		return Registry.register(Registries.BLOCK, id, block);
	}

    public static String registerModBlocks(){
        return "Registering BLOCKS for " + LegendaryWeapons.MOD_ID;
    }
}
