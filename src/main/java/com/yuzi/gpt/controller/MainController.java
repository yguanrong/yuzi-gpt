package com.yuzi.gpt.controller;

import com.yuzi.gpt.common.BaseResponse;
import com.yuzi.gpt.config.OpenAiConfig;
import com.yuzi.gpt.openai.OpenAiApi;
import com.yuzi.gpt.openai.model.*;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 开放接口
 *
 */
@RestController
@Slf4j
public class MainController {

    @Resource
    private OpenAiApi openAiApi;

    @Autowired
    private OpenAiConfig openAiConfig;

    @PostMapping("/chatWithGpt")
    @ApiOperation(value = "发起chatGpt请求",httpMethod = "POST")
    public BaseResponse<String> chatWithGpt(String prompt){
        CreateCompletionRequest request = new CreateCompletionRequest();
        request.setPrompt(prompt);
        request.setModel(openAiConfig.getModel());
        request.setTemperature(0);
        request.setMax_tokens(1024);
        CreateCompletionResponse response = openAiApi.createCompletion(request, openAiConfig.getApiKey());
        List<CreateCompletionResponse.ChoicesItem> choicesItemList = response.getChoices();
        String answer = choicesItemList.stream()
                .map(CreateCompletionResponse.ChoicesItem::getText)
                .collect(Collectors.joining());
        log.info("OpenAiAnswerer 回答成功 \n 答案：{}", answer);
        return new BaseResponse<>(200,answer);
    }


    @GetMapping("/getModels")
    @ApiOperation(value = "获取模型",httpMethod = "GET")
    public BaseResponse<ModelsResponse> getModels(){

        ModelsResponse response = openAiApi.listModels(openAiConfig.getApiKey());

        return new BaseResponse<>(200,response);
    }


    @PostMapping("/createImage")
    @ApiOperation(value = "生成图片",httpMethod = "POST")
    public BaseResponse<ImageResponse> createImage(String prompt){
        ImageReq request = new ImageReq();
        request.setPrompt(prompt);
        request.setN(4);
        request.setSize("1024x1024");
        ImageResponse response = openAiApi.generationImages(request, openAiConfig.getApiKey());

        return new BaseResponse<>(200,response);
    }
}
