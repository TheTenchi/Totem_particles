package com.example.totem_particles.mixin;

import com.example.totem_particles.TotemParticlesConfig;
import net.minecraft.client.particle.BillboardParticle;
import net.minecraft.client.particle.TotemParticle;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(TotemParticle.class)
public abstract class TotemParticleMixin extends BillboardParticle {

    private static final Random RANDOM = new Random();

    protected TotemParticleMixin(ClientWorld world, double x, double y, double z, Sprite sprite) {
        super(world, x, y, z, sprite);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void applyConfig(CallbackInfo ci) {
        TotemParticlesConfig cfg = TotemParticlesConfig.INSTANCE;
        if (cfg == null) return;

        int color;
        if (cfg.rainbowMode) {
            color = RANDOM.nextInt(0xFFFFFF);
        } else if (cfg.dualColorMode) {
            color = RANDOM.nextBoolean() ? cfg.primaryColor : cfg.secondaryColor;
        } else {
            color = cfg.primaryColor;
        }

        this.setColor(
            ((color >> 16) & 0xFF) / 255f,
            ((color >> 8)  & 0xFF) / 255f,
            ( color        & 0xFF) / 255f
        );
    }
}
