package com.qingxi.aicoderhelper;

import com.qingxi.aicoderhelper.ai.AiCoderHelper;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@SpringBootTest
class AiCoderHelperApplicationTests {

    @Resource
    private AiCoderHelper aiCoderHelper;

    @Test
    void chat() {
        aiCoderHelper.chat("你好");
    }

    @Test
    void chatWithMultiMessage() throws IOException {
        Path img = Path.of("data/img/1.jpg");
        byte[] bytes = Files.readAllBytes(img);
        String imgBase64 = Base64.getEncoder().encodeToString(bytes);

        UserMessage userMessage = UserMessage.from(
                TextContent.from("描述图片"),
                ImageContent.from(imgBase64, "image/jpeg")
        );

        aiCoderHelper.chatWithMultiMessage(userMessage);
    }

}
