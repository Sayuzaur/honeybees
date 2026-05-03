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
