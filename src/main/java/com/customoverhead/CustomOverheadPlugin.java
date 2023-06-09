package com.customoverhead;

import com.google.inject.Provides;

import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
        name = "Custom Overhead Prayer"
)
public class CustomOverheadPlugin extends Plugin {
    private ConfiguredPrayer configuredPrayer;
    @Inject
    private Client client;

    @Inject
    private CustomOverheadConfig config;

    @Inject
    private SpriteManager spriteManager;

    @Override
    protected void startUp() throws Exception {
        log.info("Example started!");
    }

    @Override
    protected void shutDown() throws Exception {
        log.info("Example stopped!");
    }

    @Provides
    CustomOverheadConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(CustomOverheadConfig.class);
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) {
        configuredPrayer = config.getConfiguredPrayer();

        if (gameStateChanged.getGameState() == GameState.LOGGED_IN && configuredPrayer != null) {
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "Billybob", "Selected Prayer: " + configuredPrayer.getName(), null);
        }
    }

    @Subscribe
    public void onGameTick(GameTick event) {
        configuredPrayer = config.getConfiguredPrayer();

        boolean prayerActive = client.isPrayerActive(
                configuredPrayer.getPrayer()
        );


        //@TODO: IMPLEMENT THIS :)

//        if (
//                config.getConfiguredPrayer() != null && prayerActive
//        ) {
//            spriteManager.addSpriteOverrides(
//
//            );
//        } else {
//            spriteManager.removeSpriteOverrides(
//
//            );
//        }


        System.out.println(prayerActive);
    }
}
