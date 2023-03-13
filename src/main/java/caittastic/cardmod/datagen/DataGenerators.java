package caittastic.cardmod.datagen;

import caittastic.cardmod.CardMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CardMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators{
  @SubscribeEvent
  public static void gatherData(GatherDataEvent event){
    ExistingFileHelper helper = event.getExistingFileHelper();
    DataGenerator generator = event.getGenerator();

    /*     client     */
    boolean isIncludeClient = event.includeClient();
    generator.addProvider(isIncludeClient, new ModItemModels(generator, helper));
    generator.addProvider(isIncludeClient, new ModEnUsLangProvider(generator, "en_us"));
  }
}
