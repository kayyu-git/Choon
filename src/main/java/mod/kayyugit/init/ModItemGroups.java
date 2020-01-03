package mod.kayyugit.init;

import org.apache.logging.log4j.util.Supplier;
import mod.kayyugit.chungus.Chungus;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups
{
	public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(Chungus.MODID, 
			() -> new ItemStack(ModItems.CARROT_ITEM));
	
	public static class ModItemGroup extends ItemGroup
	{
		private final Supplier<ItemStack> iconSupplier;
		
		public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier)
		{
			super(name);
			this.iconSupplier = iconSupplier;
		}
		
		@Override
		public ItemStack createIcon()
		{
			return iconSupplier.get();
		}
		
	}
	
}
