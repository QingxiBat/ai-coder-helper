package com.qingxi.aicoderhelper.ai;

import dev.langchain4j.service.SystemMessage;

public interface AiCoderHelperService {

    @SystemMessage(fromResource = "system-prompt.txt")
    String chat(String userMessage);
}
