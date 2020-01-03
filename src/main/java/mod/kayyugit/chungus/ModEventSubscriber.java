package mod.kayyugit.chungus;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import mod.kayyugit.init.ModBlocks;
import mod.kayyugit.init.ModItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@EventBusSubscriber(modid = Chungus.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber
{
	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(
				setup(new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)), "carrot_item")
		);
		
		ForgeRegistries.BLOCKS.getValues().parallelStream()
		.filter(block -> block.getRegistryName().getNamespace().equals(Chungus.MODID))
		.forEach(block -> 
		{
			final Item.Properties properties = new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP);
			final BlockItem blockItem = new BlockItem(block, properties);
			event.getRegistry().register(setup(blockItem, block.getRegistryName()));
		});
	}
	
	@SubscribeEvent
	public static void onRegisterBlocks(RegistryEvent.Register<Block> event) 
	{
		event.getRegistry().registerAll(
				setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)), 
						"carrot_block")
		);
	}
	
	@SubscribeEvent
	public static void onRegisterTileEntityTypes(final RegistryEvent.Register<TileEntityType<?>> event) 
	{
		event.getRegistry().registerAll(
				setup(TileEntityType.Builder.create(CarrotBlockTileEntity::new, 
						ModBlocks.CARROT_BLOCK).build(null), "carrot_block")
		);
	}
	
	@SubscribeEvent
	public static void onRegisterContainerTypes(final RegistryEvent.Register<ContainerType<?>> event) 
	{
		event.getRegistry().registerAll();
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) 
	{
		return setup(entry, new ResourceLocation(Chungus.MODID, name));
	}
	
	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, 
			final ResourceLocation registryName) 
	{
		entry.setRegistryName(registryName);
		return entry;
	}
	
}
