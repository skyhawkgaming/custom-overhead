package com.protectfrombillybob;

import net.runelite.api.SpriteID;

public enum Prayer {
    PROTECT_FROM_MAGIC("Protect from Magic", 0),
    PROTECT_FROM_MISSILES("Protect from Missiles", 0),
    PROTECT_FROM_MELEE("Protect from Melee", 440),
    RETRIBUTION("Retribution", 0),
    REDEMPTION("Redemption", 0),
    SMITE("Smite", 0);

    private final String name;
    private final int spriteID;

    Prayer(String name, int spriteID) {
        this.name = name;
        this.spriteID = spriteID;
    }

    public String getName() {
        return name;
    }

    public int getSpriteID() {
        return spriteID;
    }
}
