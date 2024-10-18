package com.cisdi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cisdi.Enums.constant.UploadFileConstant;
import com.cisdi.entity.MccccOpTechEconIndicatorsEntity;
import com.cisdi.service.MccccOpTechEconIndicatorsService;
import com.cisdi.mapper.MccccOpTechEconIndicatorsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
* @author Heyinqing
* @description 针对表【obs_op_tech_econ_indicators】的数据库操作Service实现
* @createDate 2024-10-12 15:33:16
*/
@Service
public class MccccOpTechEconIndicatorsServiceImpl extends ServiceImpl<MccccOpTechEconIndicatorsMapper, MccccOpTechEconIndicatorsEntity>
    implements MccccOpTechEconIndicatorsService {

    @Resource
    private MccccOpTechEconIndicatorsMapper techEconIndicatorsMapper;

    @Override
    public void fileDataProcessing(List<String> val) throws IllegalAccessException {
        String reportTime = val.get(1).split(",")[2].substring(0, 7);
        LambdaQueryWrapper<MccccOpTechEconIndicatorsEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MccccOpTechEconIndicatorsEntity::getReportingTime,reportTime);
        techEconIndicatorsMapper.delete(queryWrapper);
        Field[] fields = MccccOpTechEconIndicatorsEntity.class.getDeclaredFields();
        for (int i = 5; i <29; i++) {
            String[] split = val.get(i).split(",");
            MccccOpTechEconIndicatorsEntity techEconIndicatorsEntity = new MccccOpTechEconIndicatorsEntity();
            techEconIndicatorsEntity.setReportingTime(reportTime);
            techEconIndicatorsEntity.setInformant("上报人");
            techEconIndicatorsEntity.setFillingTime(new Date());
            techEconIndicatorsEntity.setProjCode("HYDD001");
            techEconIndicatorsEntity.setProjName("巴基斯坦杜达铅锌矿项目");
            techEconIndicatorsEntity.setLineNumber(Integer.parseInt(split[0]));
            techEconIndicatorsEntity.setClassify(split[2]);
            if (UploadFileConstant.TECH_ECON_INDICATORS_TITLE.contains(split[0])) {
                techEconIndicatorsMapper.insert(techEconIndicatorsEntity);
                continue;
            }
            for (int j = 3; j < split.length; j++) {
                String value = split[j];
                if (null == value || value.isEmpty()){
                    continue;
                }
                Field field = fields[j+5];
                field.setAccessible(true);
                field.set(techEconIndicatorsEntity, "java.lang.Double".equals(field.getType().getName())?new BigDecimal(value).doubleValue():value);
            }
            techEconIndicatorsMapper.insert(techEconIndicatorsEntity);
            // techEconIndicatorsEntity.setUnit(split[3]);
            // techEconIndicatorsEntity.setAnnualPlan(null == split[4]||split[4].isEmpty()? BigDecimal.ZERO:new BigDecimal(split[4]));
            // techEconIndicatorsEntity.setMonthPlan(null == split[5]||split[5].isEmpty()? BigDecimal.ZERO:new BigDecimal(split[5]));
            // techEconIndicatorsEntity.setActual(null == split[6]||split[6].isEmpty()? BigDecimal.ZERO:new BigDecimal(split[6]));
            // techEconIndicatorsEntity.setSubItemName(split[7]);
            // techEconIndicatorsEntity.setSubItemValue(null == split[8]||split[8].isEmpty()? BigDecimal.ZERO:new BigDecimal(split[8]));
            // techEconIndicatorsEntity.setSubItemName(split[9]);
            // techEconIndicatorsEntity.setSubItemValue(null == split[10]||split[10].isEmpty()? BigDecimal.ZERO:new BigDecimal(split[10]));

        }
    }
}




