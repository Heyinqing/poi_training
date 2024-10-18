package com.cisdi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cisdi.entity.MccccOpResourceEntity;
import com.cisdi.mapper.MccccOpResourceMapper;
import com.cisdi.service.MccccOpResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.cisdi.Enums.constant.UploadFileConstant.RESOURCE_TITLE;

/**
* @author Heyinqing
* @description 针对表【obs_op_resource】的数据库操作Service实现
* @createDate 2024-10-09 15:13:03
*/
@Service
public class MccccOpResourceServiceImpl implements MccccOpResourceService {

    @Resource
    private MccccOpResourceMapper resourceMapper;

    @Override
    public void fileDataProcessing(List<String> values) throws IllegalAccessException {
        String reportTime = values.get(0).split(",")[1].substring(0,8);
        LambdaQueryWrapper<MccccOpResourceEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MccccOpResourceEntity::getReportingTime,reportTime);
        resourceMapper.delete(queryWrapper);
        Field[] fields = MccccOpResourceEntity.class.getDeclaredFields();
        for (int i = 4;i<35;i++){
            String[] split = values.get(i).split(",");
            if (RESOURCE_TITLE.contains(split[0])){
                continue;
            }
            MccccOpResourceEntity resourceEntity = new MccccOpResourceEntity();
            resourceEntity.setReportingTime(reportTime);
            resourceEntity.setInformant("上报人");
            resourceEntity.setFillingTime(new Date());
            resourceEntity.setProjCode("HYDD001");
            resourceEntity.setProjName("巴基斯坦杜达铅锌矿项目");
            resourceEntity.setLineNumber(Integer.parseInt(split[0]));
            for (int j = 1; j <split.length; j++) {
                String value = split[j];
                if (value.isEmpty()){
                    continue;
                }
                Field field = fields[j + 6];
                field.setAccessible(true);
                field.set(resourceEntity,"java.lang.Double".equals(field.getType().getName())?new BigDecimal(value).doubleValue():value);
            }
            // resourceEntity.setMineralReserveType(split[1]);
            // resourceEntity.setReserveQuantityType(split[2]);
            // resourceEntity.setMidsection(split[3]);
            // resourceEntity.setOreVolume(split[4]==null||"".equals(split[4])?BigDecimal.ZERO:new BigDecimal(split[4]));
            // resourceEntity.setLeadGrade(split[5]==null||"".equals(split[5])?BigDecimal.ZERO:new BigDecimal(split[5]));
            // resourceEntity.setZincGrade(split[6]==null||"".equals(split[6])?BigDecimal.ZERO:new BigDecimal(split[6]));
            // resourceEntity.setLeadContent(split[7]==null||"".equals(split[7])?BigDecimal.ZERO:new BigDecimal(split[7]));
            // resourceEntity.setZincContent(split[8]==null||"".equals(split[8])?BigDecimal.ZERO:new BigDecimal(split[8]));
            // resourceEntity.setRemark(split[9]);
            resourceMapper.insert(resourceEntity);
        }
    }
}




