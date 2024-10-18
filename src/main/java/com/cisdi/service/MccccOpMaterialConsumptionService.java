package com.cisdi.service;

import com.cisdi.entity.MccccOpMaterialConsumptionEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Heyinqing
* @description 针对表【obs_op_material_consumption】的数据库操作Service
* @createDate 2024-10-14 10:08:49
*/
public interface MccccOpMaterialConsumptionService extends IService<MccccOpMaterialConsumptionEntity> {

    void fileDataProcessing(List<String> val) throws IllegalAccessException;
}
