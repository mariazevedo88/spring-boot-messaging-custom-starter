package io.github.mariazevedo88.msgspringbootsampleapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.mariazevedo88.messaginglib.Messager;

@SpringBootTest(classes = MessagingSpringBootSampleAppApplication.class)
class MessagingSpringBootSampleAppApplicationTests {

	@Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {}
	
	@Autowired
    private Messager messager;
    
    @Test
    public void givenMorningTime_ifMorningMessage_thenSuccess() {
        String expected = "Hello Mariana, Good Morning";
        String actual = messager.sendMessage(LocalDateTime.of(2017, 3, 1, 6, 0));
        assertEquals(expected, actual);
    }

    @Test
    public void givenAfternoonTime_ifAfternoonMessage_thenSuccess() {
        String expected = "Hello Mariana, Woha Afternoon";
        String actual = messager.sendMessage(LocalDateTime.of(2017, 3, 1, 13, 0));
        assertEquals(expected, actual);
    }

    @Test
    public void givenEveningTime_ifEveningMessage_thenSuccess() {
        String expected = "Hello Mariana, Good Evening";
        String actual = messager.sendMessage(LocalDateTime.of(2017, 3, 1, 19, 0));
        assertEquals(expected, actual);
    }

    @Test
    public void givenNightTime_ifNightMessage_thenSuccess() {
        String expected = "Hello Mariana, Good Night";
        String actual = messager.sendMessage(LocalDateTime.of(2017, 3, 1, 21, 0));
        assertEquals(expected, actual);
    }

}