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
 * @TableName Mcccc_op_month_yield
 */
@TableName(value ="Mcccc_op_month_yield")
public class MccccOpMonthYieldEntity extends PoiTrainingApplication implements Serializable {
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
     * 月计划完成率
     */
    @TableField(value = "finishing_rate")
    private Double finishingRate;

    /**
     * 去年同期实际完成
     */
    @TableField(value = "yoy_finishing_rate")
    private String yoyFinishingRate;

    /**
     * 历年月度最好值
     */
    @TableField(value = "yearly_best_value")
    private String yearlyBestValue;

    /**
     * 年计划
     */
    @TableField(value = "annual_plan")
    private Double annualPlan;

    /**
     * 本年累计完成
     */
    @TableField(value = "current_year_total")
    private String currentYearTotal;

    /**
     * 年计划完成率
     */
    @TableField(value = "plan_completion_rate")
    private Double planCompletionRate;

    /**
     * 去年同期累计完成
     */
    @TableField(value = "last_year_total")
    private String lastYearTotal;

    /**
     * 投产至今累计出矿量及累计产品量
     */
    @TableField(value = "cumulative_output")
    private Double cumulativeOutput;

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

    public Double getFinishingRate() {
        return finishingRate;
    }

    public void setFinishingRate(Double finishingRate) {
        this.finishingRate = finishingRate;
    }

    public String getYoyFinishingRate() {
        return yoyFinishingRate;
    }

    public void setYoyFinishingRate(String yoyFinishingRate) {
        this.yoyFinishingRate = yoyFinishingRate;
    }

    public String getYearlyBestValue() {
        return yearlyBestValue;
    }

    public void setYearlyBestValue(String yearlyBestValue) {
        this.yearlyBestValue = yearlyBestValue;
    }

    public Double getAnnualPlan() {
        return annualPlan;
    }

    public void setAnnualPlan(Double annualPlan) {
        this.annualPlan = annualPlan;
    }

    public String getCurrentYearTotal() {
        return currentYearTotal;
    }

    public void setCurrentYearTotal(String currentYearTotal) {
        this.currentYearTotal = currentYearTotal;
    }

    public Double getPlanCompletionRate() {
        return planCompletionRate;
    }

    public void setPlanCompletionRate(Double planCompletionRate) {
        this.planCompletionRate = planCompletionRate;
    }

    public String getLastYearTotal() {
        return lastYearTotal;
    }

    public void setLastYearTotal(String lastYearTotal) {
        this.lastYearTotal = lastYearTotal;
    }

    public Double getCumulativeOutput() {
        return cumulativeOutput;
    }

    public void setCumulativeOutput(Double cumulativeOutput) {
        this.cumulativeOutput = cumulativeOutput;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}