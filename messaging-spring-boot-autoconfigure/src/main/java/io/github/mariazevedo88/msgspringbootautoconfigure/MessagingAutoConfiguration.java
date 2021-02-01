package io.github.mariazevedo88.msgspringbootautoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.mariazevedo88.messaginglib.Messager;
import io.github.mariazevedo88.messaginglib.MessagerConfig;
import io.github.mariazevedo88.messaginglib.MessagerConfigParams;

@Configuration
@ConditionalOnClass(Messager.class)
@EnableConfigurationProperties(MessagingProperties.class)
public class MessagingAutoConfiguration {

	@Autowired
    private MessagingProperties messagingProperties;

    @Bean
    @ConditionalOnMissingBean
    public MessagerConfig greeterConfig() {

        String userName = messagingProperties.getUserName() == null ? 
        		System.getProperty("user.name") : messagingProperties.getUserName();
        String morningMessage = messagingProperties.getMorningMessage() == null ? 
        		"Good Morning" : messagingProperties.getMorningMessage();
        String afternoonMessage = messagingProperties.getAfternoonMessage() == null ? 
        		"Good Afternoon" : messagingProperties.getAfternoonMessage();
        String eveningMessage = messagingProperties.getEveningMessage() == null ? 
        		"Good Evening" : messagingProperties.getEveningMessage();
        String nightMessage = messagingProperties.getNightMessage() == null ? 
        		"Good Night" : messagingProperties.getNightMessage();

        MessagerConfig messagerConfig = new MessagerConfig();
        messagerConfig.put(MessagerConfigParams.USER_NAME, userName);
        messagerConfig.put(MessagerConfigParams.MORNING_MESSAGE, morningMessage);
        messagerConfig.put(MessagerConfigParams.AFTERNOON_MESSAGE, afternoonMessage);
        messagerConfig.put(MessagerConfigParams.EVENING_MESSAGE, eveningMessage);
        messagerConfig.put(MessagerConfigParams.NIGHT_MESSAGE, nightMessage);
        
        return messagerConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public Messager sendMessage(MessagerConfig messagerConfig) {
        return new Messager(messagerConfig);
    }


}
