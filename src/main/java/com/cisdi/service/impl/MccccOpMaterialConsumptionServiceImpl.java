package com.cisdi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cisdi.entity.MccccOpMaterialConsumptionEntity;
import com.cisdi.service.MccccOpMaterialConsumptionService;
import com.cisdi.mapper.MccccOpMaterialConsumptionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
* @author Heyinqing
* @description 针对表【obs_op_material_consumption】的数据库操作Service实现
* @createDate 2024-10-14 10:08:49
*/
@Service
public class MccccOpMaterialConsumptionServiceImpl extends ServiceImpl<MccccOpMaterialConsumptionMapper, MccccOpMaterialConsumptionEntity>
    implements MccccOpMaterialConsumptionService {

    @Resource
    private MccccOpMaterialConsumptionMapper materialConsumptionMapper;

    @Override
    public void fileDataProcessing(List<String> val) throws IllegalAccessException {
        String reportTime = val.get(1).split(",")[1].substring(0, 7);
        LambdaQueryWrapper<MccccOpMaterialConsumptionEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MccccOpMaterialConsumptionEntity::getReportingTime,reportTime);
        materialConsumptionMapper.delete(queryWrapper);
        Field[] fields = MccccOpMaterialConsumptionEntity.class.getDeclaredFields();
        for (int i = 5; i < 38; i++) {
            String[] split = val.get(i).split(",");
            MccccOpMaterialConsumptionEntity materialConsumptionEntity = new MccccOpMaterialConsumptionEntity();
            materialConsumptionEntity.setReportingTime(reportTime);
            materialConsumptionEntity.setInformant("上报人");
            materialConsumptionEntity.setFillingTime(new Date());
            materialConsumptionEntity.setProjCode("HYDD001");
            materialConsumptionEntity.setProjName("巴基斯坦杜达铅锌矿项目");
            materialConsumptionEntity.setLineNumber(Integer.parseInt(split[0]));
            // materialConsumptionEntity.setClassify(split[2]);
            // if (UploadFileConstant.MATERIAL_CONSUMPTION_TITLE.contains(split[0])) {
            //     materialConsumptionMapper.insert(materialConsumptionEntity);
            //     continue;
            // }
            for (int j = 1; j < split.length; j++) {
                String value = split[j];
                if (value.isEmpty()){
                    continue;
                }
                Field field = fields[j+6];
                field.setAccessible(true);
                field.set(materialConsumptionEntity,"java.lang.Double".equals(field.getType().getName())?new BigDecimal(value).doubleValue():value);
            }
            materialConsumptionMapper.insert(materialConsumptionEntity);
        }
    }
}




