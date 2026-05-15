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

import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;

import static io.github.sayuzaur.honeybees.HoneyBees.NAMESPACE;

public class HoneyBeesTags {
    public static final TagKey<Block> FLOWERS = TagKey.of(BlockRegistry.KEY, NAMESPACE.id("flowers"));
}
