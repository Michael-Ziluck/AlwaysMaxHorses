package com.ziluck.amh;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod("AlwaysMaxHorses")
@EventBusSubscriber(modid = "AlwaysMaxHorses")
public class AlwaysMaxHorses {
    @SubscribeEvent
    public static void onInteract(EntityMountEvent event) {
        if (!(event.getEntityBeingMounted() instanceof AbstractHorseEntity)) {
            return;
        }

        AbstractHorseEntity e = (AbstractHorseEntity) event.getEntityBeingMounted();
        e.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30);
        e.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3375);
        IAttributeInstance attr = e.getAttributes().getAttributeInstanceByName("horse.jumpStrength");
        if (attr != null) {
            attr.setBaseValue(1.0);
        }
    }
}
