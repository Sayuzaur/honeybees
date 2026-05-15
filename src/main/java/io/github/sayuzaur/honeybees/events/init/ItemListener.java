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

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
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

    public static Item JAR;
    public static Item JAR_BEES;
    public static Item HONEY;
    public static Item PORK_GLAZED;
    public static Item COD_GLAZED;
    public static Item APPLE_GLAZED;
    public static Item COOKIE_HONEY;
    public static Item CANDY_HONEY;

    @EventListener
    public static void registerItems(ItemRegistryEvent event){
        JAR = new TemplateItem(NAMESPACE.id("jar")).setTranslationKey(NAMESPACE.id("jar"));
        JAR_BEES = new TemplateItem(NAMESPACE.id("jar_bees")).setTranslationKey(NAMESPACE.id("jar_bees")).setMaxCount(1).setCraftingReturnItem(ItemListener.JAR);
        HONEY = new TemplateItem(NAMESPACE.id("honey")).setTranslationKey(NAMESPACE.id("honey"));
        PORK_GLAZED = new TemplateFoodItem(NAMESPACE.id("pork_glazed"), 9, true).setTranslationKey(NAMESPACE.id("pork_glazed"));
        COD_GLAZED = new TemplateFoodItem(NAMESPACE.id("cod_glazed"), 6, true).setTranslationKey(NAMESPACE.id("cod_glazed"));
        APPLE_GLAZED = new TemplateFoodItem(NAMESPACE.id("apple_glazed"), 5, false).setTranslationKey(NAMESPACE.id("apple_glazed"));
        COOKIE_HONEY = new TemplateStackableFoodItem(NAMESPACE.id("cookie_honey"), 1, false, 8).setTranslationKey(NAMESPACE.id("cookie_honey"));
        CANDY_HONEY = new TemplateStackableFoodItem(NAMESPACE.id("candy_honey"), 1, false, 8).setTranslationKey(NAMESPACE.id("candy_honey"));
    }
}
