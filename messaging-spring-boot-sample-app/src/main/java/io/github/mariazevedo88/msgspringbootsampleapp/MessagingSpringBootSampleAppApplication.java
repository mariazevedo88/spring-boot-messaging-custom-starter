package io.github.mariazevedo88.msgspringbootsampleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.mariazevedo88.messaginglib.Messager;

@SpringBootApplication
public class MessagingSpringBootSampleAppApplication implements CommandLineRunner {

	@Autowired
    private Messager messager;

    public static void main(String[] args) {
        SpringApplication.run(MessagingSpringBootSampleAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String message = messager.sendMessage();
        System.out.println(message);
    }

}