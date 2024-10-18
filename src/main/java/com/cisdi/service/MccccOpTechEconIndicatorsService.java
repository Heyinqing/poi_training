package com.cisdi.service;

import com.cisdi.entity.MccccOpTechEconIndicatorsEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Heyinqing
* @description 针对表【obs_op_tech_econ_indicators】的数据库操作Service
* @createDate 2024-10-12 15:33:16
*/
public interface MccccOpTechEconIndicatorsService extends IService<MccccOpTechEconIndicatorsEntity> {

    void fileDataProcessing(List<String> val) throws IllegalAccessException;
}
