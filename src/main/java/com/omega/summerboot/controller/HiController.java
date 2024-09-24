package com.omega.summerboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class HiController
 *
 * @author KennySo
 * @date 2024/9/24
 */
@RestController
public class HiController {

    @RequestMapping("/hi")
    public String hi() {
        return "hi~, SummerBoot";
    }
}
