package com.cisdi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cisdi.PoiTrainingApplication;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName Mcccc_op_material_consumption
 */
@TableName(value ="Mcccc_op_material_consumption")
public class MccccOpMaterialConsumptionEntity extends PoiTrainingApplication implements Serializable {
    /**
     * 
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 上报时间
     */
    @TableField(value = "reporting_time")
    private String reportingTime;

    /**
     * 填报人
     */
    @TableField(value = "informant")
    private String informant;

    /**
     * 填报时间
     */
    @TableField(value = "filling_time")
    private Date fillingTime;

    /**
     * 项目编号
     */
    @TableField(value = "proj_code")
    private String projCode;

    /**
     * 项目名称
     */
    @TableField(value = "proj_name")
    private String projName;

    /**
     * 行号
     */
    @TableField(value = "line_number")
    private Integer lineNumber;

    /**
     * 分类
     */
    @TableField(value = "classify")
    private String classify;

    /**
     * 单位
     */
    @TableField(value = "unit")
    private String unit;

    /**
     * 月计划
     */
    @TableField(value = "month_plan")
    private String monthPlan;

    /**
     * 月计划实际完成
     */
    @TableField(value = "month_actual_com")
    private String monthActualCom;

    /**
     * 子项-名称
     */
    @TableField(value = "sub_item_name")
    private String subItemName;

    /**
     * 子项-值
     */
    @TableField(value = "sub_item_value")
    private Double subItemValue;

    /**
     * 母项-名称
     */
    @TableField(value = "parent_item_name")
    private String parentItemName;

    /**
     * 母项-值
     */
    @TableField(value = "parent_item_value")
    private Double parentItemValue;


    /**
     * 年计划
     */
    @TableField(value = "yoy_finishing_rate")
    private Double yoyFinishingRate;

    /**
     * 年计划
     */
    @TableField(value = "annual_plan")
    private Double annualPlan;

    /**
     * 本年累计单耗
     */
    @TableField(value = "current_year_cumulative")
    private Double currentYearCumulative;

    /**
     * 去年年计划
     */
    @TableField(value = "last_year_plan")
    private Double lastYearPlan;

    /**
     * 去年实际单耗
     */
    @TableField(value = "last_year_actual")
    private Double lastYearActual;

    /**
     * 历史完成最好单耗
     */
    @TableField(value = "best_historical")
    private Double bestHistorical;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportingTime() {
        return reportingTime;
    }

    public void setReportingTime(String reportingTime) {
        this.reportingTime = reportingTime;
    }

    public String getInformant() {
        return informant;
    }

    public void setInformant(String informant) {
        this.informant = informant;
    }

    public Date getFillingTime() {
        return fillingTime;
    }

    public void setFillingTime(Date fillingTime) {
        this.fillingTime = fillingTime;
    }

    public String getProjCode() {
        return projCode;
    }

    public void setProjCode(String projCode) {
        this.projCode = projCode;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getYoyFinishingRate() {
        return yoyFinishingRate;
    }

    public void setYoyFinishingRate(Double yoyFinishingRate) {
        this.yoyFinishingRate = yoyFinishingRate;
    }

    public String getMonthPlan() {
        return monthPlan;
    }

    public void setMonthPlan(String monthPlan) {
        this.monthPlan = monthPlan;
    }

    public String getMonthActualCom() {
        return monthActualCom;
    }

    public void setMonthActualCom(String monthActualCom) {
        this.monthActualCom = monthActualCom;
    }

    public String getSubItemName() {
        return subItemName;
    }

    public void setSubItemName(String subItemName) {
        this.subItemName = subItemName;
    }

    public Double getSubItemValue() {
        return subItemValue;
    }

    public void setSubItemValue(Double subItemValue) {
        this.subItemValue = subItemValue;
    }

    public String getParentItemName() {
        return parentItemName;
    }

    public void setParentItemName(String parentItemName) {
        this.parentItemName = parentItemName;
    }

    public Double getParentItemValue() {
        return parentItemValue;
    }

    public void setParentItemValue(Double parentItemValue) {
        this.parentItemValue = parentItemValue;
    }

    public Double getAnnualPlan() {
        return annualPlan;
    }

    public void setAnnualPlan(Double annualPlan) {
        this.annualPlan = annualPlan;
    }

    public Double getCurrentYearCumulative() {
        return currentYearCumulative;
    }

    public void setCurrentYearCumulative(Double currentYearCumulative) {
        this.currentYearCumulative = currentYearCumulative;
    }

    public Double getLastYearPlan() {
        return lastYearPlan;
    }

    public void setLastYearPlan(Double lastYearPlan) {
        this.lastYearPlan = lastYearPlan;
    }

    public Double getLastYearActual() {
        return lastYearActual;
    }

    public void setLastYearActual(Double lastYearActual) {
        this.lastYearActual = lastYearActual;
    }

    public Double getBestHistorical() {
        return bestHistorical;
    }

    public void setBestHistorical(Double bestHistorical) {
        this.bestHistorical = bestHistorical;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}