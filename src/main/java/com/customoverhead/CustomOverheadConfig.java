package com.customoverhead;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("customOverhead")
public interface CustomOverheadConfig extends Config {
    @ConfigItem(
            keyName = "configuredPrayer",
            name = "Prayer",
            description = "Select the prayer whose icon should be replaced",
            position = 1
    )
    default ConfiguredPrayer getConfiguredPrayer() {
        return ConfiguredPrayer.PROTECT_FROM_MELEE;
    }

    void setConfiguredPrayer(ConfiguredPrayer prayer);
}
