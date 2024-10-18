package com.cisdi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cisdi.PoiTrainingApplication;
import java.io.Serializable;
import java.util.Date;

/**
 * 主要财务指标月报
 * @TableName Mcccc_op_finance
 */
@TableName(value ="Mcccc_op_finance")
public class MccccOpFinanceEntity extends PoiTrainingApplication implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 序号
     */
    @TableField(value = "serial_number")
    private String serialNumber;

    /**
     * 分类
     */
    @TableField(value = "classify")
    private String classify;

    /**
     * 年度预算
     */
    @TableField(value = "annual_budget")
    private Double annualBudget;

    /**
     * 本月预算指标
     */
    @TableField(value = "monthly_budget")
    private Double monthlyBudget;

    /**
     * 本月实际完成
     */
    @TableField(value = "monthly_actual")
    private Double monthlyActual;

    /**
     * 本月完成比例(%)
     */
    @TableField(value = "monthly_ratio")
    private Double monthlyRatio;

    /**
     * 本年完成
     */
    @TableField(value = "yearly_completion")
    private Double yearlyCompletion;

    /**
     * 完成年度比例(%)
     */
    @TableField(value = "annual_ratio")
    private Double annualRatio;

    /**
     * 上年同期
     */
    @TableField(value = "last_year_same_period")
    private Double lastYearSamePeriod;

    /**
     * 较上年增减比例(%)
     */
    @TableField(value = "yoy_change")
    private Double yoyChange;

    /**
     * 下月预算
     */
    @TableField(value = "next_month_budget")
    private Double nextMonthBudget;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public Double getAnnualBudget() {
        return annualBudget;
    }

    public void setAnnualBudget(Double annualBudget) {
        this.annualBudget = annualBudget;
    }

    public Double getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(Double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public Double getMonthlyActual() {
        return monthlyActual;
    }

    public void setMonthlyActual(Double monthlyActual) {
        this.monthlyActual = monthlyActual;
    }

    public Double getMonthlyRatio() {
        return monthlyRatio;
    }

    public void setMonthlyRatio(Double monthlyRatio) {
        this.monthlyRatio = monthlyRatio;
    }

    public Double getYearlyCompletion() {
        return yearlyCompletion;
    }

    public void setYearlyCompletion(Double yearlyCompletion) {
        this.yearlyCompletion = yearlyCompletion;
    }

    public Double getAnnualRatio() {
        return annualRatio;
    }

    public void setAnnualRatio(Double annualRatio) {
        this.annualRatio = annualRatio;
    }

    public Double getLastYearSamePeriod() {
        return lastYearSamePeriod;
    }

    public void setLastYearSamePeriod(Double lastYearSamePeriod) {
        this.lastYearSamePeriod = lastYearSamePeriod;
    }

    public Double getYoyChange() {
        return yoyChange;
    }

    public void setYoyChange(Double yoyChange) {
        this.yoyChange = yoyChange;
    }

    public Double getNextMonthBudget() {
        return nextMonthBudget;
    }

    public void setNextMonthBudget(Double nextMonthBudget) {
        this.nextMonthBudget = nextMonthBudget;
    }
}