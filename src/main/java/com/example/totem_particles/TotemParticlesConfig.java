package com.example.totem_particles;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Config(name = "totem_particles")
public class TotemParticlesConfig implements ConfigData {

    public static TotemParticlesConfig INSTANCE;

    @ConfigEntry.ColorPicker
    public int primaryColor = 0xFFFFFF;

    @ConfigEntry.ColorPicker
    public int secondaryColor = 0x000000;

    public boolean dualColorMode = true;

    public boolean rainbowMode = false;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 200)
    public int intensityPercent = 100;

    public static void load() {
        AutoConfig.register(TotemParticlesConfig.class, GsonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(TotemParticlesConfig.class).getConfig();
    }
}
