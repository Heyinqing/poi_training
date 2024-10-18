package com.cisdi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cisdi.PoiTrainingApplication;
import java.io.Serializable;
import java.util.Date;

/**
 * 杜达项目投资管理月报-累计
 * @TableName Mcccc_op_investment_cumulative
 */
@TableName(value ="Mcccc_op_investment_cumulative")
public class MccccOpInvestmentCumulativeEntity extends PoiTrainingApplication implements Serializable {
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
     * 项目建设总投资
     */
    @TableField(value = "total_investment")
    private Double totalInvestment;

    /**
     * 项目建设实际完成投资额
     */
    @TableField(value = "actual_investment")
    private Double actualInvestment;

    /**
     * 完成总计划百分比
     */
    @TableField(value = "total_completion_pct")
    private Double totalCompletionPct;

    /**
     * 年计划投资额
     */
    @TableField(value = "annual_plan_investment")
    private Double annualPlanInvestment;

    /**
     * 自年初累计完成投资额
     */
    @TableField(value = "yearly_cumulative_investment")
    private Double yearlyCumulativeInvestment;

    /**
     * 完成年计划百分比
     */
    @TableField(value = "annual_completion_percentage")
    private Double annualCompletionPercentage;

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

    public Double getTotalInvestment() {
        return totalInvestment;
    }

    public void setTotalInvestment(Double totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public Double getActualInvestment() {
        return actualInvestment;
    }

    public void setActualInvestment(Double actualInvestment) {
        this.actualInvestment = actualInvestment;
    }

    public Double getTotalCompletionPct() {
        return totalCompletionPct;
    }

    public void setTotalCompletionPct(Double totalCompletionPct) {
        this.totalCompletionPct = totalCompletionPct;
    }

    public Double getAnnualPlanInvestment() {
        return annualPlanInvestment;
    }

    public void setAnnualPlanInvestment(Double annualPlanInvestment) {
        this.annualPlanInvestment = annualPlanInvestment;
    }

    public Double getYearlyCumulativeInvestment() {
        return yearlyCumulativeInvestment;
    }

    public void setYearlyCumulativeInvestment(Double yearlyCumulativeInvestment) {
        this.yearlyCumulativeInvestment = yearlyCumulativeInvestment;
    }

    public Double getAnnualCompletionPercentage() {
        return annualCompletionPercentage;
    }

    public void setAnnualCompletionPercentage(Double annualCompletionPercentage) {
        this.annualCompletionPercentage = annualCompletionPercentage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}