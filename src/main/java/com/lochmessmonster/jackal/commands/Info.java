package com.lochmessmonster.jackal.commands;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import java.awt.Color;

public class Info implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        String[] message = event.getMessageContent().split(" ");
        if (message[0].equals("/j")) {
            if (message[1].equals("info")) {
                // log
                System.out.println("Bot info requested.");

                // Build and send embed
                EmbedBuilder embed = new EmbedBuilder()
                        .setTitle("Info")
                        .setDescription("Hi! I'm Jackal, a Discord bot written in Java.")
                        .addInlineField("GitHub", "[jackal](https://github.com/LochMessMonster/jackal)")
                        .addInlineField("API", "[Javacord](https://javacord.org/)")
                        .setColor(Color.CYAN);
                event.getChannel().sendMessage(embed);
            }
        }
    }
}
