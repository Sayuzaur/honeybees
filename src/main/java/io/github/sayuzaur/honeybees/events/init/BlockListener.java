package io.github.sayuzaur.honeybees.events.init;

import io.github.sayuzaur.honeybees.block.BeeHive;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.EntrypointManager;

import java.lang.invoke.MethodHandles;

import static io.github.sayuzaur.honeybees.HoneyBees.NAMESPACE;

public class BlockListener {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    public static Block BEEHIVE_OAK;
    public static Block BEENEST_OAK;
    public static Block BEENEST_BIRCH;

    @EventListener
    private static void registerBlocks(BlockRegistryEvent event){
        BEEHIVE_OAK = new BeeHive(NAMESPACE.id("beehive_oak")).setTranslationKey(NAMESPACE.id("beehive_oak"));
        BEENEST_OAK = new BeeHive(NAMESPACE.id("beenest_oak")).setTranslationKey(NAMESPACE.id("beenest_oak"));
        BEENEST_BIRCH = new BeeHive(NAMESPACE.id("beenest_birch")).setTranslationKey(NAMESPACE.id("beenest_birch"));
    }
}
