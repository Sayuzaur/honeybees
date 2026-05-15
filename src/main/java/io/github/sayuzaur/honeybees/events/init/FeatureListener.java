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

package io.github.sayuzaur.honeybees.events.init;

import io.github.sayuzaur.honeybees.world.feature.BirchTreeBeeFeature;
import io.github.sayuzaur.honeybees.world.feature.OakTreeBeeFeature;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.worldgen.biome.BiomeModificationEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.EntrypointManager;

import java.lang.invoke.MethodHandles;

public class FeatureListener {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    public void registerFeatures(BiomeModificationEvent event){
        if (BirchTreeBeeFeature.targetBiomes.contains(event.biome.name)) {
            BirchTreeBeeFeature birchTreeBee = new BirchTreeBeeFeature();

            event.biome.addFeature(birchTreeBee);
        }
        if (OakTreeBeeFeature.targetBiomes.contains(event.biome.name)) {
            OakTreeBeeFeature oakTreeBee = new OakTreeBeeFeature();

            event.biome.addFeature(oakTreeBee);
        }
    }
}
