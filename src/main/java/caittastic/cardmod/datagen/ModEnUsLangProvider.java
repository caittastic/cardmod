package caittastic.cardmod.datagen;

import caittastic.cardmod.CardMod;
import caittastic.cardmod.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsLangProvider extends LanguageProvider{
  public ModEnUsLangProvider(DataGenerator gen, String locale){
    super(gen, CardMod.MOD_ID, locale);
  }

  @Override
  protected void addTranslations(){
    add(ModItems.OVERWORLD_PACK.get(), "Card Pack");
    add("card_set." + CardMod.MOD_ID + ".overworld_card", "§8§oOverworld Card");

    add("tooltip." + CardMod.MOD_ID + ".overworld_pack_tooltip", "§7§oOverworld Set Pack");
    add("tooltip." + CardMod.MOD_ID + ".cart_count_3_tooltip", "§8§oContains 3 Cards");
    add("card_shiny_indicator."+ CardMod.MOD_ID, "§5§o ♢");

    for(int i = 0; i < ModItems.overworldCards.length; i++){
      int cardNumber = i + 1;
      add(ModItems.OVERWORLD_MAP.get(cardNumber).get(), ModItems.overworldCards[i][0]);
      add("tooltip." + CardMod.MOD_ID + ".overworld_card_" + cardNumber, "§7§o" + ModItems.overworldCards[i][1]);
    }

  }
}
