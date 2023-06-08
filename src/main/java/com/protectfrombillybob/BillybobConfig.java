package com.protectfrombillybob;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("billybob")
public interface BillybobConfig extends Config {
    @ConfigItem(
            keyName = "selectedPrayer",
            name = "Prayer",
            description = "Select the prayer whose icon should be replaced",
            position = 1
    )
    default Prayer getSelectedPrayer() {
        return Prayer.RETRIBUTION;
    }

    @ConfigItem(
            keyName = "selectedPrayer",
            name = "Prayer",
            description = "Select the prayer whose icon should be replaced"
    )
    void setSelectedPrayer(Prayer prayer);
}
