package com.yuzi.gpt.openai.model;

import lombok.Data;

import java.util.List;

/**
 * 创建补全请求
 * <a href="https://platform.openai.com/docs/api-reference/completions/create">参考文档</a>

 */
@Data
public class CreateCompletionRequest {

    /**
     * 模型
     */
    private String model;

    /**
     * 提示词
     */
    private List<Messages> messages;


    @Data
    public static class Messages {
        private String role = "user";

        private String content;
    }

}
