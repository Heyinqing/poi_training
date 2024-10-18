package com.cisdi.controller;

import com.cisdi.service.MccccOpResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Heyinqing
 * @date 2024/10/9
 */
@RestController
@RequestMapping("/resource")
public class ObsOpResourceController {

    @Autowired
    private MccccOpResourceService resourceService;

}
