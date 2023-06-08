package com.customoverhead;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class CustomOverheadPluginTest {
    public static void main(String[] args) throws Exception {
        ExternalPluginManager.loadBuiltin(CustomOverheadPlugin.class);
        RuneLite.main(args);
    }
}