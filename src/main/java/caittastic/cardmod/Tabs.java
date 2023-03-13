package caittastic.cardmod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Tabs{
  //register the industry tab
  public static final CreativeModeTab CARD_MOD_TAB =
          new CreativeModeTab("card_mod_tab"){
            @Override
            public ItemStack makeIcon(){return new ItemStack(ModItems.OVERWORLD_PACK.get());}
          };
}
