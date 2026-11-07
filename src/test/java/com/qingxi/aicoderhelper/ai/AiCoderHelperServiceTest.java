package com.qingxi.aicoderhelper.ai;

import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiCoderHelperServiceTest {

    @Resource
    private AiCoderHelperService aiCoderHelperService;

    @Test
    void chat() {
        String result = aiCoderHelperService.chat("你好");
        System.out.println(result);
    }

    @Test
    void chatWithMemory() {
        String result = aiCoderHelperService.chat("你好，我是qingxi");
        System.out.println(result);
        result = aiCoderHelperService.chat("我是谁");
        System.out.println(result);
    }

    @Test
    void chatForReport() {
        String userMessage = "你好，我是qingxi，初学编程，请为我制定学习计划";
        AiCoderHelperService.Report report = aiCoderHelperService.chatForReport(userMessage);
        System.out.println(report);
    }
}