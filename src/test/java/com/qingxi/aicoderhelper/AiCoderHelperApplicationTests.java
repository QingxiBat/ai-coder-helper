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
    private AiCoderHelper ai_coder_helper;

    @Test
    void chat() {
        ai_coder_helper.chat("你好");
    }

    @Test
    void chat_with_multi_message() throws IOException {
        Path img = Path.of("data/img/1.jpg");
        byte[] bytes = Files.readAllBytes(img);
        String img_base64 = Base64.getEncoder().encodeToString(bytes);

        UserMessage user_message = UserMessage.from(
                TextContent.from("描述图片"),
                ImageContent.from(img_base64, "image/jpeg")
        );

        ai_coder_helper.chat_with_multi_massage(user_message);
    }

}
