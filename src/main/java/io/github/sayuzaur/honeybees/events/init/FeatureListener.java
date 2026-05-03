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
