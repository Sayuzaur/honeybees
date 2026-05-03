package io.github.sayuzaur.honeybees;

import net.glasslauncher.mods.gcapi3.api.ConfigCategory;
import net.glasslauncher.mods.gcapi3.api.ConfigEntry;

public class HoneyBeesConfig {
    @ConfigCategory(name = "Features Generation Config")
    public FeaturesGenConfig gen = new FeaturesGenConfig();

    @ConfigCategory(name = "Beehive Config")
    public BeeHiveClientConfig beehiveclient = new BeeHiveClientConfig();

    public static class FeaturesGenConfig {
        @ConfigEntry(name = "Oak Tree with Bee Nest rarity", minValue = 1, maxValue = 16, description = "1 -> Common, 16 -> Very hard to find", requiresRestart = true)
        public Integer oakTreeBeeChance = 8;

        @ConfigEntry(name = "Birch Tree with Bee Nest rarity", minValue = 1, maxValue = 16, description = "1 -> Common, 16 -> Very hard to find", requiresRestart = true)
        public Integer birchTreeBeeChance = 6;
    }

    public static class BeeHiveClientConfig {
        @ConfigEntry(name = "Bee Particles num subtracting", minValue = 1,  maxValue = 64, description = "1 -> Max Bees Particles Rate, 64 - > Sparse")
        public Integer beeParticlesNum = 1;

        @ConfigEntry(name = "Show Bees on Flowers", description = "Might have small performance impact")
        public Boolean beesOnFlowers = true;

        @ConfigEntry(name = "Bees Sound Volume multiplier", minValue = 0, maxValue = 5, description = "0.0F -> Mute")
        public Float beesSoundVolume = 1.0F;
    }
}
