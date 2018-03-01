package com.imooc.gril.controller;

import com.imooc.gril.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class HelloController {

    /**
     * value注解注入配置文件中cupSize的值，配置文件不需要关心数据类型
     */

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping({"/hello","/hello2"})
    public String say() {
//        return cupSize+age+"-------"+content;
        return girlProperties.getCupSize();
    }

    //单独使用@ Controller时候
    @RequestMapping("/hi")
    public String hi() {
//        return cupSize+age+"-------"+content;
        return "index";
    }

    @RequestMapping(value="/{id}/say",method = RequestMethod.GET)
    public String say1(@PathVariable("id") Integer id) {
        return "id:"+id;
    }

    //    @RequestMapping(value="/say",method = RequestMethod.GET)
    @GetMapping(value="/say")
    public String say2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id:"+myId;
    }



}
