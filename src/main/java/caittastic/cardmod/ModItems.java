package caittastic.cardmod;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

import static caittastic.cardmod.Tabs.CARD_MOD_TAB;

public class ModItems{
  // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CardMod.MOD_ID);
  public static final Map<Integer, RegistryObject<Item>> OVERWORLD_MAP = new HashMap<>();

  public static final String[][] overworldCards = {
          //common
          {"Rocky", "a big bass fan"},
          {"Tree", "used to know applette"},
          {"Applette", "a mobile developer"},
          {"Rose", "an old lass"},
          {"Grassy", "foundational"},
          {"Hutt", "well known everywhere"},
          {"Wheata", "best with friends"},
          {"Porky", "piggy piggy hole"},
          {"Zombo", "not a fan of plants"},
          //uncommon
          {"Ramona", "physically affectionate"},
          {"Woofie", "is a fan of Zombo"},
          {"Slimbo", "wants to be a rancher"},
          {"Barrel", "a bit of a hoarder"},
          {"Mushy", "high aspirations"},
          {"Fops The Sleepy", "zzz..."},
          //rare
          {"Gapplette", "very self confident"},
          {"The Enderman", "Watching..."},
          {"Mojang", "thingymabob"}};


  public static final RegistryObject<Item> OVERWORLD_PACK = ITEMS.register("overworld_pack", () -> new PackItem(new Item.Properties().tab(CARD_MOD_TAB)));


  static{
    for(int i = 0; i < overworldCards.length; i++){
      int cardNumber = i + 1;
      String tooltip = "tooltip."+CardMod.MOD_ID+".overworld_card_"+cardNumber;
      OVERWORLD_MAP.put(
              cardNumber,
              ITEMS.register("overworld_card_" + cardNumber,
                      () -> new CardItem(
                              new Item.Properties().tab(CARD_MOD_TAB),
                              Component.translatable( tooltip),
                              cardNumber)));
    }
  }
}
