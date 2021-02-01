package io.github.mariazevedo88.messaginglib;

import java.time.LocalDateTime;

public class Messager {

	private MessagerConfig messagingConfig;

    public Messager(MessagerConfig messagingConfig) {
        this.messagingConfig = messagingConfig;
    }

    public String sendMessage(LocalDateTime localDateTime) {

        String name = messagingConfig.getProperty(MessagerConfigParams.USER_NAME);
        int hourOfDay = localDateTime.getHour();

        if (hourOfDay >= 5 && hourOfDay < 12) {
            return String.format("Hello %s, %s", name, 
            		messagingConfig.get(MessagerConfigParams.MORNING_MESSAGE));
        } else if (hourOfDay >= 12 && hourOfDay < 17) {
            return String.format("Hello %s, %s", name, 
            		messagingConfig.get(MessagerConfigParams.AFTERNOON_MESSAGE));
        } else if (hourOfDay >= 17 && hourOfDay < 20) {
            return String.format("Hello %s, %s", name, 
            		messagingConfig.get(MessagerConfigParams.EVENING_MESSAGE));
        } else {
            return String.format("Hello %s, %s", name, 
            		messagingConfig.get(MessagerConfigParams.NIGHT_MESSAGE));
        }
        
    }

    public String sendMessage() {
        return sendMessage(LocalDateTime.now());
    }

}
