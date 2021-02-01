package io.github.mariazevedo88.msgspringbootautoconfigure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = MessagingAutoConfiguration.class)
class MessagingSpringBootAutoconfigureApplicationTests {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {}
    
}
