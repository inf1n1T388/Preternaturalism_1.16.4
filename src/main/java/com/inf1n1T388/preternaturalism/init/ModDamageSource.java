package com.inf1n1T388.preternaturalism.init;

import com.inf1n1T388.preternaturalism.Preternaturalism;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.GameRules;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Preternaturalism.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModDamageSource extends DamageSource{

    public static final ModDamageSource CONTAMINATED_BLOCK = (ModDamageSource) (new ModDamageSource("contamination")).setDamageBypassesArmor().setDifficultyScaled();

    public ModDamageSource(String damageTypeIn) {
        super(damageTypeIn);
    }

    public static DamageSource causeContaminationDamage(PlayerEntity player) {
        return new EntityDamageSource("contamination", player);
    }

    @Override
    public ITextComponent getDeathMessage(LivingEntity entityLivingBaseIn) {
        LivingEntity livingentity = entityLivingBaseIn.getAttackingEntity();
        String s = "death.attack." + this.damageType;
        if (livingentity != null) {
            s = s + ".player";
        }
        Preternaturalism.LOGGER.info("DEATH MESSAGE: " + s + ", " + new TranslationTextComponent(s).getString());
        return livingentity != null ? new TranslationTextComponent(s, entityLivingBaseIn.getDisplayName(), livingentity.getDisplayName()) : new TranslationTextComponent(s, entityLivingBaseIn.getDisplayName());
    }
}
