package com.lochmessmonster.jackal;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {
    public static void main(String[] args) {
        String token = "";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // ping-pong
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
        });

        System.out.println("Invite both with url: " + api.createBotInvite());
    }


}
