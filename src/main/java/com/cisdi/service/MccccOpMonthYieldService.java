package com.cisdi.service;

import com.cisdi.entity.MccccOpMonthYieldEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Heyinqing
* @description 针对表【obs_op_month_yield】的数据库操作Service
* @createDate 2024-10-12 10:56:08
*/
public interface MccccOpMonthYieldService extends IService<MccccOpMonthYieldEntity> {

    void fileDataProcessing(List<String> val);
}
