package com.cisdi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cisdi.entity.MccccOpHumanResourceEntity;
import com.cisdi.service.MccccOpHumanResourceService;
import com.cisdi.mapper.MccccOpHumanResourceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
* @author Heyinqing
* @description 针对表【obs_op_human_resource(人力资源统计月报)】的数据库操作Service实现
* @createDate 2024-10-17 08:43:34
*/
@Service
public class MccccOpHumanResourceServiceImpl extends ServiceImpl<MccccOpHumanResourceMapper, MccccOpHumanResourceEntity>
    implements MccccOpHumanResourceService {

    @Resource
    private MccccOpHumanResourceMapper humanResourceMapper;

    @Override
    public void fileDataProcessing(List<String> val) throws IllegalAccessException {
        String reportTime = val.get(1).split(",")[1].substring(0,7);
        LambdaQueryWrapper<MccccOpHumanResourceEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MccccOpHumanResourceEntity::getReportingTime,reportTime);
        humanResourceMapper.delete(queryWrapper);
        Field[] fields = MccccOpHumanResourceEntity.class.getDeclaredFields();
        for (int i = 7; i <9; i++) {
            String[] split = val.get(i).split(",");
            MccccOpHumanResourceEntity humanResourceEntity = new MccccOpHumanResourceEntity();
            humanResourceEntity.setReportingTime(reportTime);
            humanResourceEntity.setInformant("上报人");
            humanResourceEntity.setFillingTime(new Date());
            humanResourceEntity.setProjCode("HYDD001");
            humanResourceEntity.setProjName("巴基斯坦杜达铅锌矿项目");
            humanResourceEntity.setLineNumber(Integer.parseInt(split[0]));
            for (int j = 1; j < split.length; j++) {
                String value = split[j];
                if (value.isEmpty()){
                    continue;
                }
                Field field = fields[j + 6];
                field.setAccessible(true);
                field.set(humanResourceEntity,"java.lang.Integer".equals(field.getType().getName())?new BigDecimal(value).intValue():value);
            }
            humanResourceMapper.insert(humanResourceEntity);

        }

    }
}




