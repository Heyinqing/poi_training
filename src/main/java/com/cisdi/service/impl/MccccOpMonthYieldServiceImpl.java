package com.cisdi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cisdi.Enums.constant.UploadFileConstant;
import com.cisdi.entity.MccccOpMonthYieldEntity;
import com.cisdi.service.MccccOpMonthYieldService;
import com.cisdi.mapper.MccccOpMonthYieldMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
* @author Heyinqing
* @description 针对表【obs_op_month_yield】的数据库操作Service实现
* @createDate 2024-10-12 10:56:08
*/
@Service
public class MccccOpMonthYieldServiceImpl extends ServiceImpl<MccccOpMonthYieldMapper, MccccOpMonthYieldEntity>
    implements MccccOpMonthYieldService {

    @Resource
    private MccccOpMonthYieldMapper mccccOpMonthYieldMapper;

    @Override
    public void fileDataProcessing(List<String> val) {
        String reportTime = val.get(1).split(",")[1].substring(0, 7);
        LambdaQueryWrapper<MccccOpMonthYieldEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MccccOpMonthYieldEntity::getReportingTime,reportTime);
        mccccOpMonthYieldMapper.delete(queryWrapper);
        for (int i = 7; i <36; i++) {
            String[] split = val.get(i).split(",");
            MccccOpMonthYieldEntity monthYieldEntity = new MccccOpMonthYieldEntity();
            monthYieldEntity.setReportingTime(reportTime);
            monthYieldEntity.setInformant("上报人");
            monthYieldEntity.setFillingTime(new Date());
            monthYieldEntity.setProjCode("HYDD001");
            monthYieldEntity.setProjName("巴基斯坦杜达铅锌矿项目");
            monthYieldEntity.setLineNumber(Integer.parseInt(split[0]));
            monthYieldEntity.setClassify(split[1]);
            if (UploadFileConstant.MONTH_YIEID_TITLE.contains(split[0])){
                mccccOpMonthYieldMapper.insert(monthYieldEntity);
                continue;
            }
            monthYieldEntity.setUnit(split[3]);
            monthYieldEntity.setMonthPlan(null == split[5]||split[5].isEmpty()?split[4]:split[4]+"/"+split[5]);
            monthYieldEntity.setMonthActualCom(null == split[7]||split[7].isEmpty()?split[6]:split[6]+"/"+split[7]);
            monthYieldEntity.setFinishingRate(null == split[8] || split[8].isEmpty()? 0d:new BigDecimal(split[8]).doubleValue());
            monthYieldEntity.setYoyFinishingRate(null == split[10]||split[10].isEmpty()?split[9]:split[9]+"/"+split[10]);
            monthYieldEntity.setYearlyBestValue(split[11]);
            monthYieldEntity.setAnnualPlan(null == split[12] || split[12].isEmpty()? 0d:new BigDecimal(split[12]).doubleValue());
            monthYieldEntity.setCurrentYearTotal(null == split[14]||split[14].isEmpty()?split[13]:split[13]+"/"+split[14]);
            monthYieldEntity.setAnnualPlan(null == split[15] || split[15].isEmpty()? 0d:new BigDecimal(split[15]).doubleValue());
            if (split.length==17){
                monthYieldEntity.setLastYearTotal(split[16]);
                mccccOpMonthYieldMapper.insert(monthYieldEntity);
                continue;
            }
            monthYieldEntity.setCurrentYearTotal(null == split[17]||split[17].isEmpty()?split[16]:split[16]+"/"+split[17]);
            if (split.length==18){
                mccccOpMonthYieldMapper.insert(monthYieldEntity);
                continue;
            }
            monthYieldEntity.setCumulativeOutput(null == split[18] || split[18].isEmpty()? 0d :new BigDecimal(split[18]).doubleValue());
            if (split.length==20){
                monthYieldEntity.setRemark(split[19]);
            }
            mccccOpMonthYieldMapper.insert(monthYieldEntity);
        }


    }
}




