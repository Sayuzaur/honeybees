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

import net.glasslauncher.mods.gcapi3.api.ConfigRoot;
import net.modificationstation.stationapi.api.util.Namespace;

public class HoneyBees {
    @SuppressWarnings("UnstableApiUsage")
    public static final Namespace NAMESPACE = Namespace.resolve();

    @ConfigRoot(value = "genconfig", visibleName = "Features Generation", index = 1)
    public static final HoneyBeesConfig.FeaturesGenConfig GEN_CONFIG = new HoneyBeesConfig.FeaturesGenConfig();

    @ConfigRoot(value = "beehiveclientconfig", visibleName = "Beehive Client-Side ", index = 0)
    public static final HoneyBeesConfig.BeeHiveClientConfig BEEHIVE_CLIENT_CONFIG = new HoneyBeesConfig.BeeHiveClientConfig();
}
