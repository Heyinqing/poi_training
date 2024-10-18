package com.cisdi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cisdi.PoiTrainingApplication;
import java.io.Serializable;
import java.util.Date;

/**
 * 杜达项目投资管理月报-明细
 * @TableName Mcccc_op_investment_details
 */
@TableName(value ="Mcccc_op_investment_details")
public class MccccOpInvestmentDetailsEntity extends PoiTrainingApplication implements Serializable {
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
     * 项目分类名称
     */
    @TableField(value = "project_category")
    private String projectCategory;

    /**
     * 本年度计划
     */
    @TableField(value = "annual_plan")
    private Double annualPlan;

    /**
     * 本月计划
     */
    @TableField(value = "monthly_plan")
    private Double monthlyPlan;

    /**
     * 本月完成
     */
    @TableField(value = "monthly_completion")
    private Double monthlyCompletion;

    /**
     * 自年初累计完成
     */
    @TableField(value = "yearly_cumulative")
    private Double yearlyCumulative;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 未完成或超额情况说明
     */
    @TableField(value = "status_explanation")
    private String statusExplanation;

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

    public String getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(String projectCategory) {
        this.projectCategory = projectCategory;
    }

    public Double getAnnualPlan() {
        return annualPlan;
    }

    public void setAnnualPlan(Double annualPlan) {
        this.annualPlan = annualPlan;
    }

    public Double getMonthlyPlan() {
        return monthlyPlan;
    }

    public void setMonthlyPlan(Double monthlyPlan) {
        this.monthlyPlan = monthlyPlan;
    }

    public Double getMonthlyCompletion() {
        return monthlyCompletion;
    }

    public void setMonthlyCompletion(Double monthlyCompletion) {
        this.monthlyCompletion = monthlyCompletion;
    }

    public Double getYearlyCumulative() {
        return yearlyCumulative;
    }

    public void setYearlyCumulative(Double yearlyCumulative) {
        this.yearlyCumulative = yearlyCumulative;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatusExplanation() {
        return statusExplanation;
    }

    public void setStatusExplanation(String statusExplanation) {
        this.statusExplanation = statusExplanation;
    }
}