package com.yuzi.gpt.openai;

import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.yuzi.gpt.openai.model.*;
import com.yuzi.gpt.common.ErrorCode;
import com.yuzi.gpt.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * OpenAi 接口
 * <a href="https://platform.openai.com/docs/api-reference">参考文档</a>
 **/
@Service
@Slf4j
public class OpenAiApi {

    /**
     * 补全
     *
     * @param request
     * @param openAiApiKey
     * @return
     */
    public CreateCompletionResponse createCompletion(CreateCompletionRequest request, String openAiApiKey) {
        if (StringUtils.isBlank(openAiApiKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "未传 openAiApiKey");
        }
        String url = "https://api.openai.com/v1/chat/completions";
        String json = JSONUtil.toJsonStr(request);
        String result = HttpRequest.post(url)
                .contentType(ContentType.JSON.getValue())
                .header("Authorization", "Bearer " + openAiApiKey)
                .body(json)
                .execute()
                .body();
        log.info("/v1/chat/completions,入参：{}。\n返回：{}", json, result);
        return JSONUtil.toBean(result, CreateCompletionResponse.class);
    }

    /**
     * 补全
     *
     * @param openAiApiKey
     * @return
     */
    public ModelsResponse listModels(String openAiApiKey) {
        if (StringUtils.isBlank(openAiApiKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "未传 openAiApiKey");
        }
        String url = "https://api.openai.com/v1/models";
        String result = HttpRequest.get(url)
                .header("Authorization", "Bearer " + openAiApiKey)
                .execute()
                .body();
        return JSONUtil.toBean(result, ModelsResponse.class);
    }

    /**
     * 生成图片
     *
     * @param openAiApiKey
     * @return
     */
    public ImageResponse generationImages(ImageReq request, String openAiApiKey) {
        if (StringUtils.isBlank(openAiApiKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "未传 openAiApiKey");
        }

        String url = "https://api.openai.com/v1/images/generations";
        String json = JSONUtil.toJsonStr(request);
        String result = HttpRequest.post(url)
                .header("Authorization", "Bearer " + openAiApiKey)
                .contentType(ContentType.JSON.getValue())
                .body(json)
                .execute()
                .body();
        log.info("/v1/images/generations,入参：{}。\n返回：{}", json, result);
        return JSONUtil.toBean(result, ImageResponse.class);
    }

}
