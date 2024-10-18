package com.cisdi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cisdi.entity.MccccOpCostAnalysisEntity;
import com.cisdi.service.MccccOpCostAnalysisService;
import com.cisdi.mapper.MccccOpCostAnalysisMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
* @author Heyinqing
* @description 针对表【obs_op_cost_analysis】的数据库操作Service实现
* @createDate 2024-10-14 15:02:39
*/
@Service
public class MccccOpCostAnalysisServiceImpl extends ServiceImpl<MccccOpCostAnalysisMapper, MccccOpCostAnalysisEntity>
    implements MccccOpCostAnalysisService {

    @Resource
    private MccccOpCostAnalysisMapper costAnalysisMapper;

    @Override
    public void fileDataProcessing(List<String> val) {
        String reportTime = val.get(1).split(",")[1].substring(0,7);
        LambdaQueryWrapper<MccccOpCostAnalysisEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MccccOpCostAnalysisEntity::getReportingTime,reportTime);
        costAnalysisMapper.delete(queryWrapper);
        // Boolean isContent = true;
        String[] original = val.get(3).split(",");
        String[] timeArray = Arrays.copyOfRange(original,4,original.length);
        Field[] fields = MccccOpCostAnalysisEntity.class.getDeclaredFields();
        for (int i = 4; i < 35; i++) {
            // if (isContent){
            //     isContent = !split[1].contains("序号");
            //     continue;
            // }
            String[] split = val.get(i).split(",");
            MccccOpCostAnalysisEntity costAnalysisEntity = new MccccOpCostAnalysisEntity();
            costAnalysisEntity.setReportingTime(reportTime);
            costAnalysisEntity.setInformant("上报人");
            costAnalysisEntity.setFillingTime(new Date());
            costAnalysisEntity.setProjCode("HYDD001");
            costAnalysisEntity.setProjName("巴基斯坦杜达铅锌矿项目");
            costAnalysisEntity.setLineNumber(Integer.parseInt(split[0]));
            costAnalysisEntity.setSerialNumber(split[1]);
            costAnalysisEntity.setCostItem(split[2]);
            if (split.length==4){
                costAnalysisEntity.setUnit(split[3]);
                costAnalysisMapper.insert(costAnalysisEntity);
                continue;
            }else if (split.length<4){
                costAnalysisMapper.insert(costAnalysisEntity);
                continue;
            }
            for (int j = 4; j < split.length; j++) {
                costAnalysisEntity.setId(null);
                costAnalysisEntity.setUnit(split[3]);
                String dataItemTime = timeArray[j - 4];
                costAnalysisEntity.setDataItemTime(dataItemTime);
                costAnalysisEntity.setTimeType(dataItemTime.contains("月")?"月度":"年度");
                costAnalysisEntity.setPlanActual(dataItemTime.contains("计划")?"计划":"实际");
                costAnalysisEntity.setDataValue(null==split[j]||"".equals(split[j])?0d:new BigDecimal(split[j]).doubleValue());
                costAnalysisMapper.insert(costAnalysisEntity);
            }
        }
    }
}




