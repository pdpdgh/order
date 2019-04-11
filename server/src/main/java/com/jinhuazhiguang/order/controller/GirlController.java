package com.jinhuazhiguang.order.controller;

import com.jinhuazhiguang.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc : GirlController
 * @auth : pdp
 * @date : 2019/04/11 13:28
 */
@RestController
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print() {
        return "name:" + girlConfig.getName() + "age:" + girlConfig.getAge();
    }
}
