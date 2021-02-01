package io.github.mariazevedo88.messaginglib;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class MessagingLibApplicationTests {

	private static MessagerConfig messagingConfig;

    @BeforeAll
    public static void initalizeGreetingConfig() {
    	messagingConfig = new MessagerConfig();
    	messagingConfig.put(MessagerConfigParams.USER_NAME, "World");
    	messagingConfig.put(MessagerConfigParams.MORNING_MESSAGE, "Good Morning");
    	messagingConfig.put(MessagerConfigParams.AFTERNOON_MESSAGE, "Good Afternoon");
    	messagingConfig.put(MessagerConfigParams.EVENING_MESSAGE, "Good Evening");
    	messagingConfig.put(MessagerConfigParams.NIGHT_MESSAGE, "Good Night");
    }

    @Test
    public void givenMorningTime_ifMorningMessage_thenSuccess() {
        Messager messager = new Messager(messagingConfig);
        String expected = "Hello World, Good Morning";
        String actual = messager.sendMessage(LocalDateTime.of(2017, 3, 1, 6, 0));
        assertEquals(expected, actual);
    }

    @Test
    public void givenAfternoonTime_ifAfternoonMessage_thenSuccess() {
    	Messager messager = new Messager(messagingConfig);
        String expected = "Hello World, Good Afternoon";
        String actual = messager.sendMessage(LocalDateTime.of(2017, 3, 1, 13, 0));
        assertEquals(expected, actual);
    }

    @Test
    public void givenEveningTime_ifEveningMessage_thenSuccess() {
    	Messager messager = new Messager(messagingConfig);
        String expected = "Hello World, Good Evening";
        String actual = messager.sendMessage(LocalDateTime.of(2017, 3, 1, 19, 0));
        assertEquals(expected, actual);
    }

    @Test
    public void givenNightTime_ifNightMessage_thenSuccess() {
    	Messager messager = new Messager(messagingConfig);
        String expected = "Hello World, Good Night";
        String actual = messager.sendMessage(LocalDateTime.of(2017, 3, 1, 21, 0));
        assertEquals(expected, actual);
    }

}
