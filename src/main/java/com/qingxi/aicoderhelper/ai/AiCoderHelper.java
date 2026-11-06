package com.qingxi.aicoderhelper.ai;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AiCoderHelper {

    @Resource
    private ChatModel OllamaChatModel;

    // 简单对话，仅支持传入文本
    public String chat(String message) {
        UserMessage user_message = UserMessage.from(message);
        ChatResponse chat_response = OllamaChatModel.chat(user_message);
        AiMessage ai_message = chat_response.aiMessage();
        log.info("AI输出：" + ai_message.toString());
        return ai_message.text();
    }

    // 简单对话，支持传入多种格式
    public String chat_with_multi_massage(UserMessage user_message) {
        ChatResponse chat_response = OllamaChatModel.chat(user_message);
        AiMessage ai_message = chat_response.aiMessage();
        log.info("AI输出：" + ai_message.toString());
        return ai_message.text();
    }

}
