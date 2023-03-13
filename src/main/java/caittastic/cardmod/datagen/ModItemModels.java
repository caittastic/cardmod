package caittastic.cardmod.datagen;

import caittastic.cardmod.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static caittastic.cardmod.CardMod.MOD_ID;

public class ModItemModels extends ItemModelProvider{

  public ModItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper){
    super(generator, MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerModels(){

    registerFlatItemModel(ModItems.OVERWORLD_PACK);

    for(int i = 1; i <= ModItems.overworldCards.length; i++){
      RegistryObject<Item> item = ModItems.OVERWORLD_MAP.get(i);

      ResourceLocation back = new ResourceLocation(MOD_ID,
              "item/overworld_set/" + "overworld_card_back");

      ResourceLocation resourceLocation = new ResourceLocation(MOD_ID,
              "item/overworld_set/" + item.getId().getPath());

      singleTexture(
              item.getId().getPath(),
              new ResourceLocation(MOD_ID,"item/card"),
              "front", resourceLocation).texture("back", back);
    }


  }
  private void registerFlatItemModel(RegistryObject<Item> item){
    ResourceLocation resourceLocation = new ResourceLocation(
            MOD_ID,
            "item/" + item.getId().getPath());
    singleTexture(
            item.getId().getPath(),
            mcLoc("item/generated"),
            "layer0", resourceLocation);
  }
}
