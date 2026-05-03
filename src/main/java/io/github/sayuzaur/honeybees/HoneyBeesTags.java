package io.github.sayuzaur.honeybees;

import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;

import static io.github.sayuzaur.honeybees.HoneyBees.NAMESPACE;

public class HoneyBeesTags {
    public static final TagKey<Block> FLOWERS = TagKey.of(BlockRegistry.KEY, NAMESPACE.id("flowers"));
}
