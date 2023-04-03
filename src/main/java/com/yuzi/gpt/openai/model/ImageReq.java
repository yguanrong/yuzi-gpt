package com.yuzi.gpt.openai.model;

import lombok.Data;

/**
 * Created by YangGuanRong
 * date: 2023/4/3
 */
@Data
public class ImageReq {

    /**
     * A text description of the desired image(s). The maximum length is 1000 characters.
     */
    String prompt;

    /**
     * The number of images to generate. Must be between 1 and 10.
     */
    int n;
    /**
     * size
     * string
     * Optional
     * Defaults to 1024x1024
     * The size of the generated images. Must be one of 256x256, 512x512, or 1024x1024
     */
    String size = "1024x1024";
}
