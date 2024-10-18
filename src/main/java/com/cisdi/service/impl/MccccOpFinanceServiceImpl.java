package com.cisdi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cisdi.entity.MccccOpFinanceEntity;
import com.cisdi.service.MccccOpFinanceService;
import com.cisdi.mapper.MccccOpFinanceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
* @author Heyinqing
* @description 针对表【obs_op_finance(主要财务指标月报)】的数据库操作Service实现
* @createDate 2024-10-17 08:38:55
*/
@Service
public class MccccOpFinanceServiceImpl extends ServiceImpl<MccccOpFinanceMapper, MccccOpFinanceEntity>
    implements MccccOpFinanceService {

    @Resource
    private MccccOpFinanceMapper financeMapper;

    @Override
    public void fileDataProcessing(List<String> val) throws IllegalAccessException {
        String reportTime = val.get(1).split(",")[1].substring(0, 7);
        LambdaQueryWrapper<MccccOpFinanceEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MccccOpFinanceEntity::getReportingTime,reportTime);
        financeMapper.delete(queryWrapper);
        Field[] fields = MccccOpFinanceEntity.class.getDeclaredFields();
        for (int i = 5; i < 35; i++) {
            String[] split = val.get(i).split(",");
            MccccOpFinanceEntity financeEntity = new MccccOpFinanceEntity();
            financeEntity.setReportingTime(reportTime);
            financeEntity.setInformant("上报人");
            financeEntity.setFillingTime(new Date());
            financeEntity.setProjCode("HYDD001");
            financeEntity.setProjName("巴基斯坦杜达铅锌矿项目");
            financeEntity.setLineNumber(Integer.parseInt(split[0]));
            for (int j = 1; j < split.length && j < (fields.length-7); j++) {
                String value = split[j];
                if (value.isEmpty()){
                    continue;
                }
                Field field = fields[j + 6];
                field.setAccessible(true);
                field.set(financeEntity, "java.lang.Double".equals(field.getType().getName())
                        ?new BigDecimal(value).doubleValue():value);
            }
            financeMapper.insert(financeEntity);
        }
    }
}




