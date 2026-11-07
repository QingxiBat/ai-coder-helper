package com.qingxi.aicoderhelper.ai;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiCoderHelperServiceTest {

    @Resource
    private AiCoderHelperService ai_coder_helper_service;

    @Test
    void chat() {
        String result = ai_coder_helper_service.chat("你好");
        System.out.println(result);
    }
}