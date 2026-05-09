package io.github.sayuzaur.honeybees.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.minecraft.item.StackableFoodItem;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.EntrypointManager;
import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.template.item.TemplateStackableFoodItem;

import java.lang.invoke.MethodHandles;

import static io.github.sayuzaur.honeybees.HoneyBees.NAMESPACE;

public class ItemListener {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    public static Item HONEY;
    public static Item JAR;
    public static Item JAR_BEES;
    public static Item APPLE_GLAZED;
    public static Item PORK_GLAZED;
    public static Item COOKIE_HONEY;

    @EventListener
    public static void registerItems(ItemRegistryEvent event){
        HONEY = new TemplateItem(NAMESPACE.id("honey")).setTranslationKey(NAMESPACE.id("honey"));
        JAR = new TemplateItem(NAMESPACE.id("jar")).setTranslationKey(NAMESPACE.id("jar"));
        JAR_BEES = new TemplateItem(NAMESPACE.id("jar_bees")).setTranslationKey(NAMESPACE.id("jar_bees")).setMaxCount(1).setCraftingReturnItem(ItemListener.JAR);
        PORK_GLAZED = new TemplateFoodItem(NAMESPACE.id("pork_glazed"), 9, true).setTranslationKey(NAMESPACE.id("pork_glazed"));
        APPLE_GLAZED = new TemplateFoodItem(NAMESPACE.id("apple_glazed"), 5, false).setTranslationKey(NAMESPACE.id("apple_glazed"));
        COOKIE_HONEY = new TemplateStackableFoodItem(NAMESPACE.id("cookie_honey"), 1, false, 8).setTranslationKey(NAMESPACE.id("cookie_honey"));
    }
}
