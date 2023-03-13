package caittastic.cardmod;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PackItem extends Item{
  public PackItem(Properties properties){
    super(properties);
  }

  @Override
  public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced){
    pTooltipComponents.add(Component.translatable("tooltip.examplemod.overworld_pack_tooltip"));
    pTooltipComponents.add(Component.translatable("tooltip.examplemod.cart_count_3_tooltip"));
    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
  }

  @Override
  public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand){
    int cardsPerPack = 3;

    if(pPlayer instanceof ServerPlayer){
      for(int i = 1; i <= cardsPerPack; i++){
        int card = ThreadLocalRandom.current().nextInt(1, ModItems.overworldCards.length + 1);
        ItemStack cardStack = new ItemStack(ModItems.OVERWORLD_MAP.get(card).get(), 1);
        if(i == cardsPerPack)
          CardItem.setFoil(cardStack);
        pPlayer.drop(cardStack, true);
      }
      pPlayer.getItemInHand(pUsedHand).shrink(1);
      pLevel.playSound(null, pPlayer.blockPosition(), SoundEvents.BUNDLE_DROP_CONTENTS, SoundSource.PLAYERS, 0.8F, 0.8F + pPlayer.getLevel().getRandom().nextFloat() * 0.4F);
      return InteractionResultHolder.sidedSuccess(pPlayer.getItemInHand(pUsedHand), pLevel.isClientSide());
    }
    return super.use(pLevel, pPlayer, pUsedHand);
  }
}
