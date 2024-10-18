package com.cisdi.service;

import com.cisdi.entity.MccccOpFinanceEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Heyinqing
* @description 针对表【obs_op_finance(主要财务指标月报)】的数据库操作Service
* @createDate 2024-10-17 08:38:55
*/
public interface MccccOpFinanceService extends IService<MccccOpFinanceEntity> {

    void fileDataProcessing(List<String> val) throws IllegalAccessException;
}
