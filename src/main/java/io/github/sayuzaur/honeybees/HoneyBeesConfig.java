/*
 * Copyright (C) 2026 Sayuzaur
 *
 * This file is part of HoneyBees.
 * HoneyBees is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Foodies is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with HoneyBees.
 * If not, see <https://www.gnu.org/licenses/>.
 */

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
