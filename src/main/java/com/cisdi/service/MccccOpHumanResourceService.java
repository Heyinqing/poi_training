package com.cisdi.service;

import com.cisdi.entity.MccccOpHumanResourceEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Heyinqing
* @description 针对表【obs_op_human_resource(人力资源统计月报)】的数据库操作Service
* @createDate 2024-10-17 08:43:34
*/
public interface MccccOpHumanResourceService extends IService<MccccOpHumanResourceEntity> {

    void fileDataProcessing(List<String> val) throws IllegalAccessException;
}
