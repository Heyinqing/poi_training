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
 * @TableName Mcccc_op_tech_econ_indicators
 */
@TableName(value ="Mcccc_op_tech_econ_indicators")
public class MccccOpTechEconIndicatorsEntity extends PoiTrainingApplication implements Serializable {
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
     * 年计划
     */
    @TableField(value = "annual_plan")
    private Double annualPlan;

    /**
     * 月计划
     */
    @TableField(value = "month_plan")
    private Double monthPlan;

    /**
     * 实际
     */
    @TableField(value = "actual")
    private Double actual;

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
     * 去年同期
     */
    @TableField(value = "yoy_finishing_rate")
    private Double yoyFinishingRate;

    /**
     * 历年月度最好值
     */
    @TableField(value = "yearly_best_value")
    private Double yearlyBestValue;

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

    public Double getAnnualPlan() {
        return annualPlan;
    }

    public void setAnnualPlan(Double annualPlan) {
        this.annualPlan = annualPlan;
    }

    public Double getMonthPlan() {
        return monthPlan;
    }

    public void setMonthPlan(Double monthPlan) {
        this.monthPlan = monthPlan;
    }

    public Double getActual() {
        return actual;
    }

    public void setActual(Double actual) {
        this.actual = actual;
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

    public Double getYoyFinishingRate() {
        return yoyFinishingRate;
    }

    public void setYoyFinishingRate(Double yoyFinishingRate) {
        this.yoyFinishingRate = yoyFinishingRate;
    }

    public Double getYearlyBestValue() {
        return yearlyBestValue;
    }

    public void setYearlyBestValue(Double yearlyBestValue) {
        this.yearlyBestValue = yearlyBestValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}