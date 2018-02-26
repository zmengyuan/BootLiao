package com.imooc.gril;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 将application.yml文件中girl为前缀的值映射过来
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String cupSize;

    private Integer age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
