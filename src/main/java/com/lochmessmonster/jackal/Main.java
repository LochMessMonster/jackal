package com.lochmessmonster.jackal;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import com.lochmessmonster.jackal.commands.*;

public class Main {
    public static void main(String[] args) {
        // Check bot token was provided
        if (args.length <1 ) {
            System.err.println("Please provide the bot token as first arg.");
            System.err.println("Example: java jackal <token>");
            return;
        }

        // Setup
        String token = args[0];
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // Add listeners
        api.addMessageCreateListener(new Info());
        api.addMessageCreateListener(new Dice());

        // ping-pong
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
        });
    }


}
