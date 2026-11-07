package com.qingxi.aicoderhelper.ai;

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
}