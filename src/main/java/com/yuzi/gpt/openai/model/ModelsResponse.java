package com.yuzi.gpt.openai.model;


import java.util.List;

/**
 * Created by YangGuanRong
 * date: 2023/4/3
 */
@lombok.Data
public class ModelsResponse {

    private List<Data> data;
    private String object;


    @lombok.Data
    public static class Data {

        private String id;
        private String object;
        private String owned_by;
        private List<String> permission;

    }

}
