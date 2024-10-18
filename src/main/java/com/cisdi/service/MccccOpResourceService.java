package com.cisdi.service;

import java.util.List;

/**
* @author Heyinqing
* @description 针对表【obs_op_resource】的数据库操作Service
* @createDate 2024-10-09 15:13:03
*/
public interface MccccOpResourceService {

    /**
     * @description: 数据处理
     * @param: val 数据
     * @return: void
     * @author Heyinqing
     * @date: 2024/10/10 15:13
     */
    void fileDataProcessing(List<String> values) throws IllegalAccessException;
}
