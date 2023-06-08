package com.protectfrombillybob;

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
        name = "Protect from Billybob"
)
public class BillybobPlugin extends Plugin {
    private SelectedPrayer selectedPrayer;
    @Inject
    private Client client;

    @Inject
    private BillybobConfig config;

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
    BillybobConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(BillybobConfig.class);
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) {
        selectedPrayer = config.getSelectedPrayer();

        if (gameStateChanged.getGameState() == GameState.LOGGED_IN && selectedPrayer != null) {
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "Billybob", "Selected Prayer: " + selectedPrayer.getName(), null);
        }
    }

    @Subscribe
    public void onGameTick(GameTick event) {

        boolean prayerActive = client.isPrayerActive(
                selectedPrayer.getPrayer()
        );


    /*  @TODO: IMPLEMENT THIS :)

        if (
                config.getSelectedPrayer() != null && prayerActive
        ) {
            spriteManager.addSpriteOverrides(

            );
        } else {
            spriteManager.removeSpriteOverrides(

            );
        } */


        System.out.println(prayerActive);
    }
}
