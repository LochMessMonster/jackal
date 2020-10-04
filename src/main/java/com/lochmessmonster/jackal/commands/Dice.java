package com.lochmessmonster.jackal.commands;

import java.util.Random;
import static java.lang.Integer.parseInt;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.entity.message.MessageDecoration;

public class Dice implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        String[] message = event.getMessageContent().split(" ");
        if (message[0].equals("/j") && message[1].equals("roll")) {
            // log
            System.out.println("Dice roll requested.");

            if (message.length >= 2) {
                String[] command = message[2].split("d");
                int numberOfDice = parseInt(command[0]);
                int numberOfDiceFaces = parseInt(command[1]);

                // response
                MessageBuilder response = new MessageBuilder()
//                        .append("@"+ event.getMessageAuthor().getDiscriminatedName())
                        .append(" " + message[2])
                        .append(" ---> ");

                // basic validation
                if (numberOfDice >= 1
                        && numberOfDice <= 1000
                        && numberOfDiceFaces >= 1
                        && numberOfDiceFaces <= 10000) {

                    Random rand = new Random();
                    int[] results = new int[numberOfDice];
                    int sum = 0;

                    // Roll dice n times
                    for (int i = 0; i < results.length; i++) {
                        results[i] = rand.nextInt(numberOfDiceFaces) + 1;
                        sum += results[i];
                        // append result appropriately
                        if (i != results.length - 1) {
                            response.append( results[i] + "+");
                        } else {
                            response.append(results[i] + " = ");
                        }
                    }

                    // append sum and send
                    response.append(Integer.toString(sum), MessageDecoration.BOLD);
                    response.send(event.getChannel());
                } else  {
                    System.err.println("Dice command error");
                }
            } else {
                System.err.println("Dice roll args not provided");
            }


        }
    }
}
