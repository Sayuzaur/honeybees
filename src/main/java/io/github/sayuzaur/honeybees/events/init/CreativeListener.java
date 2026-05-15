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
import net.minecraft.item.ItemStack;
import paulevs.bhcreative.api.CreativeTab;
import paulevs.bhcreative.api.SimpleTab;
import paulevs.bhcreative.registry.TabRegistryEvent;

import static io.github.sayuzaur.honeybees.HoneyBees.NAMESPACE;

public class CreativeListener {
    public static CreativeTab tabHoneyBees;

    @EventListener
    public void onTabInit(TabRegistryEvent event) {
        tabHoneyBees = new SimpleTab(NAMESPACE.id("honeybees_creative_tab"), ItemListener.HONEY);
        event.register(tabHoneyBees);

        tabHoneyBees.addItem(new ItemStack(ItemListener.JAR));
        tabHoneyBees.addItem(new ItemStack(ItemListener.JAR_BEES));
        tabHoneyBees.addItem(new ItemStack(ItemListener.HONEY));
        tabHoneyBees.addItem(new ItemStack(ItemListener.PORK_GLAZED));
        tabHoneyBees.addItem(new ItemStack(ItemListener.COD_GLAZED));
        tabHoneyBees.addItem(new ItemStack(ItemListener.APPLE_GLAZED));
        tabHoneyBees.addItem(new ItemStack(ItemListener.COOKIE_HONEY));
        tabHoneyBees.addItem(new ItemStack(ItemListener.CANDY_HONEY));

        tabHoneyBees.addItem(new ItemStack(BlockListener.BEEHIVE_OAK));
        tabHoneyBees.addItem(new ItemStack(BlockListener.BEENEST_OAK));
        tabHoneyBees.addItem(new ItemStack(BlockListener.BEENEST_BIRCH));
        tabHoneyBees.addItem(new ItemStack(BlockListener.HONEYCOMB));
    }
}
