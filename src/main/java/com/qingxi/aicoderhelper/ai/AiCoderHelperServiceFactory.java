package com.qingxi.aicoderhelper.ai;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiCoderHelperServiceFactory {

    @Resource
    private ChatModel ollamaChatModel;

    @Bean
    public AiCoderHelperService aiCoderHelperService() {

        ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        return AiServices.builder(AiCoderHelperService.class)
                .chatModel(ollamaChatModel)
                .chatMemory(chatMemory)
                .build();
    }
}
