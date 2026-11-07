package com.qingxi.aicoderhelper.ai;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiCoderHelperServiceFactory {

    @Resource
    private ChatModel ollama_chat_model;

    @Bean
    public AiCoderHelperService ai_coder_helper_service() {
        return AiServices.create(AiCoderHelperService.class, ollama_chat_model);
    }
}
