package com.yuzi.gpt.openai.model;

import lombok.Data;

import java.util.List;
@Data
public class CreateCompletionResponse
{
    private String id;

    private String object;

    private int created;

    private List<Choices> choices;

    private Usage usage;


    @Data
    public static class Message
    {
        private String role;
        private String content;

    }

    @Data
    public static class Choices
    {
        private int index;
        private Message message;
        private String finish_reason;
    }

    @Data
    public static class Usage
    {
        private int prompt_tokens;
        private int completion_tokens;
        private int total_tokens;
    }

}
