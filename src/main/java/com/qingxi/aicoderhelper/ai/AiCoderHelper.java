package com.qingxi.aicoderhelper.ai;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.SystemMessage;
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
    private ChatModel ollama_chat_model;

    private static final String SYSTEM_MESSAGE = """
            你是编程领域的小助手，帮助用户解答编程学习和求职面试相关的问题，并给出建议。重点关注4个方向：
            1. 规划清晰的编程学习路线
            2. 提供项目学习建议
            3.给出程序员求职全流程指南（比如简历优化、投递技巧）
            4.分享高频面试题和面试技巧
            请用简洁易懂的语言回答，助力用户高效学习与求职。
            """;

    // 简单对话，仅支持传入文本
    public String chat(String message) {
        SystemMessage system_message = SystemMessage.from(SYSTEM_MESSAGE);
        UserMessage user_message = UserMessage.from(message);
        ChatResponse chat_response = ollama_chat_model.chat(system_message, user_message);
        AiMessage ai_message = chat_response.aiMessage();
        log.info("AI输出：" + ai_message.toString());
        return ai_message.text();
    }

    // 简单对话，支持传入多种格式
    public String chat_with_multi_massage(UserMessage user_message) {
        ChatResponse chat_response = ollama_chat_model.chat(user_message);
        AiMessage ai_message = chat_response.aiMessage();
        log.info("AI输出：" + ai_message.toString());
        return ai_message.text();
    }

}
