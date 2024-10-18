package com.cisdi.service;

import com.cisdi.entity.MccccOpCostAnalysisEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Heyinqing
* @description 针对表【obs_op_cost_analysis】的数据库操作Service
* @createDate 2024-10-14 15:02:39
*/
public interface MccccOpCostAnalysisService extends IService<MccccOpCostAnalysisEntity> {

    void fileDataProcessing(List<String> val);
}
