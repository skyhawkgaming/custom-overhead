package com.protectfrombillybob;

import net.runelite.api.Prayer;
import net.runelite.api.SpriteID;
import net.runelite.client.game.SpriteOverride;

public enum SelectedPrayer implements SpriteOverride {
    PROTECT_FROM_MAGIC("Protect from Magic", 0, Prayer.PROTECT_FROM_MAGIC),
    PROTECT_FROM_MISSILES("Protect from Missiles", 0, Prayer.PROTECT_FROM_MISSILES),
    // SpriteID.OVERHEAD_PROTECT_FROM_MELEE is 440
    PROTECT_FROM_MELEE("Protect from Melee", SpriteID.OVERHEAD_PROTECT_FROM_MELEE, Prayer.PROTECT_FROM_MELEE),
    RETRIBUTION("Retribution", 0, Prayer.RETRIBUTION),
    REDEMPTION("Redemption", 0, Prayer.REDEMPTION),
    SMITE("Smite", 0, Prayer.SMITE);

    private final String prayerName;
    private final int spriteID;

    private final Prayer prayer;

    SelectedPrayer(String prayerName, int spriteID, Prayer prayer) {
        this.prayerName = prayerName;
        this.spriteID = spriteID;
        this.prayer = prayer;
    }

    public Prayer getPrayer() {
        return prayer;
    }

    public String getName() {
        return prayerName;
    }

    @Override
    public int getSpriteId() {
        return spriteID;
    }

    @Override
    public String getFileName() {
        return "billybob.png";
    }
}
