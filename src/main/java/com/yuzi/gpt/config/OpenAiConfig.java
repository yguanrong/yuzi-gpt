package com.yuzi.gpt.config;

import com.yuzi.gpt.openai.model.ModelConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAi 配置
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Configuration
@ConfigurationProperties(prefix = "openai")
@Data
public class OpenAiConfig {

    /**
     * 模型
     */
    private String model = ModelConstant.GPT_3_5_TURBO;

    /**
     * apiKey
     */
    private String apiKey;
}
