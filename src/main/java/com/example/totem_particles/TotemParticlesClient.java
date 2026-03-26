package com.example.totem_particles;

import net.fabricmc.api.ClientModInitializer;

public class TotemParticlesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TotemParticlesConfig.load();
    }
}
