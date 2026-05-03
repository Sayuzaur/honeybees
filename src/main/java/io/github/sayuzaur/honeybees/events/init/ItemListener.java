package io.github.sayuzaur.honeybees.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.EntrypointManager;
import net.modificationstation.stationapi.api.template.item.TemplateItem;

import java.lang.invoke.MethodHandles;

import static io.github.sayuzaur.honeybees.HoneyBees.NAMESPACE;

public class ItemListener {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    public static Item HONEY;
    public static Item JAR;
    public static Item JAR_BEES;

    @EventListener
    public static void registerItems(ItemRegistryEvent event){
        HONEY = new TemplateItem(NAMESPACE.id("honey")).setTranslationKey(NAMESPACE.id("honey"));
        JAR = new TemplateItem(NAMESPACE.id("jar")).setTranslationKey(NAMESPACE.id("jar"));
        JAR_BEES = new TemplateItem(NAMESPACE.id("jar_bees")).setTranslationKey(NAMESPACE.id("jar_bees")).setMaxCount(1).setCraftingReturnItem(ItemListener.JAR);
    }
}
