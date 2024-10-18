package com.cisdi.Enums;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Heyinqing
 * @date 2024/10/10
 */
public enum UploadFileEnum {
    RESOURCE("季度保有资源储量",1),
    MONTH_YIELD("月生产主要产量、作业量统计表",2),
    MONTH_TECH_ECON_INDICATORS("月生产主要技术经济指标统计表",3),
    MATERIAL_CONSUMPTION("月生产主要材料消耗指标统计表",4),
    COST_ANALYSIS("成本分析月报",5),
    FINANCE("主要财务指标月报表",6),
    HUMAN_RESOURCE("人力资源统计月报",8)
    ;

    private final String massage;

    private final Integer value;

    UploadFileEnum(String massage, Integer value) {
        this.massage = massage;
        this.value = value;
    }

    public String getMassage() {
        return massage;
    }

    public Integer getValue() {
        return value;
    }

    public static UploadFileEnum getValueByMassage(String massage){
        UploadFileEnum[] values = values();
        List<UploadFileEnum> collect = Arrays.stream(values)
                .filter(info -> massage.contains(info.getMassage()))
                .collect(Collectors.toList());
        if (collect.size() == 0){
            return null;
        }
        return collect.get(0);
    }
}
