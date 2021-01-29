package com.inf1n1T388.preternaturalism.objects.items;

import com.inf1n1T388.preternaturalism.entities.ExplosiveAbniteOrbEntity;
import com.inf1n1T388.preternaturalism.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ExplosiveAbniteOrb extends Item {
    public ExplosiveAbniteOrb(Properties properties) {
        super(properties);
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote) {
            ExplosiveAbniteOrbEntity eaoe = new ExplosiveAbniteOrbEntity(worldIn, playerIn);
            eaoe.setItem(itemstack);
            eaoe.setHeadRotation(playerIn.rotationYaw, Math.round(playerIn.rotationPitch));
            eaoe.shoot(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), 1.5F, 0.0F);
            //eaoe.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 0.0F);
            worldIn.addEntity(eaoe);
        }

        playerIn.addStat(Stats.ITEM_USED.get(this));
        if (!playerIn.abilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        return ActionResult.resultSuccess(itemstack);
    }
}