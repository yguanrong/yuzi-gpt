package com.yuzi.gpt.openai.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by YangGuanRong
 * date: 2023/4/3
 */
@lombok.Data
public class ImageResponse {

    private List<Data> data = new ArrayList();
    private Long created;


    @lombok.Data
    public static class Data {

        private String url;

    }

}
