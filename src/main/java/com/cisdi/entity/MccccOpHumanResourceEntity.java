package com.cisdi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cisdi.PoiTrainingApplication;
import java.io.Serializable;
import java.util.Date;

/**
 * 人力资源统计月报
 * @TableName Mcccc_op_human_resource
 */
@TableName(value ="Mcccc_op_human_resource")
public class MccccOpHumanResourceEntity extends PoiTrainingApplication implements Serializable {
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
     * 部门
     */
    @TableField(value = "dept")
    private String dept;

    /**
     * 年初数
     */
    @TableField(value = "initial_count")
    private Integer initialCount;

    /**
     * 本月末在册
     */
    @TableField(value = "end_month_count")
    private Integer endMonthCount;

    /**
     * 中方年度定员
     */
    @TableField(value = "cn_annual_quota")
    private Integer cnAnnualQuota;

    /**
     * 中方本月末在册
     */
    @TableField(value = "cn_end_month_count")
    private Integer cnEndMonthCount;

    /**
     * 中方现场人员
     */
    @TableField(value = "cn_on_site")
    private Integer cnOnSite;

    /**
     * 中方休假返回人员
     */
    @TableField(value = "cn_returned")
    private Integer cnReturned;

    /**
     * 中方新入职人员
     */
    @TableField(value = "cn_new_hires")
    private Integer cnNewHires;

    /**
     * 回国人员-离职
     */
    @TableField(value = "returnees_resigned")
    private Integer returneesResigned;

    /**
     * 回国人员-当月休假
     */
    @TableField(value = "returnees_leave_month")
    private Integer returneesLeaveMonth;

    /**
     * 回国人员-跨月休假
     */
    @TableField(value = "returnees_leave_cross")
    private Integer returneesLeaveCross;

    /**
     * 回国人员-其他
     */
    @TableField(value = "returnees_other")
    private Integer returneesOther;

    /**
     * 外方年度定员
     */
    @TableField(value = "foreign_annual_quota")
    private Integer foreignAnnualQuota;

    /**
     * 外方本月末在册
     */
    @TableField(value = "foreign_end_month_count")
    private Integer foreignEndMonthCount;

    /**
     * 外方现场人员
     */
    @TableField(value = "foreign_on_site")
    private Integer foreignOnSite;

    /**
     * 外方新入职人员
     */
    @TableField(value = "foreign_new_hires")
    private Integer foreignNewHires;

    /**
     * 外方离职人员
     */
    @TableField(value = "foreign_resigned")
    private Integer foreignResigned;

    /**
     * 外方临时工
     */
    @TableField(value = "foreign_temp")
    private Integer foreignTemp;

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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getInitialCount() {
        return initialCount;
    }

    public void setInitialCount(Integer initialCount) {
        this.initialCount = initialCount;
    }

    public Integer getEndMonthCount() {
        return endMonthCount;
    }

    public void setEndMonthCount(Integer endMonthCount) {
        this.endMonthCount = endMonthCount;
    }

    public Integer getCnAnnualQuota() {
        return cnAnnualQuota;
    }

    public void setCnAnnualQuota(Integer cnAnnualQuota) {
        this.cnAnnualQuota = cnAnnualQuota;
    }

    public Integer getCnEndMonthCount() {
        return cnEndMonthCount;
    }

    public void setCnEndMonthCount(Integer cnEndMonthCount) {
        this.cnEndMonthCount = cnEndMonthCount;
    }

    public Integer getCnOnSite() {
        return cnOnSite;
    }

    public void setCnOnSite(Integer cnOnSite) {
        this.cnOnSite = cnOnSite;
    }

    public Integer getCnReturned() {
        return cnReturned;
    }

    public void setCnReturned(Integer cnReturned) {
        this.cnReturned = cnReturned;
    }

    public Integer getCnNewHires() {
        return cnNewHires;
    }

    public void setCnNewHires(Integer cnNewHires) {
        this.cnNewHires = cnNewHires;
    }

    public Integer getReturneesResigned() {
        return returneesResigned;
    }

    public void setReturneesResigned(Integer returneesResigned) {
        this.returneesResigned = returneesResigned;
    }

    public Integer getReturneesLeaveMonth() {
        return returneesLeaveMonth;
    }

    public void setReturneesLeaveMonth(Integer returneesLeaveMonth) {
        this.returneesLeaveMonth = returneesLeaveMonth;
    }

    public Integer getReturneesLeaveCross() {
        return returneesLeaveCross;
    }

    public void setReturneesLeaveCross(Integer returneesLeaveCross) {
        this.returneesLeaveCross = returneesLeaveCross;
    }

    public Integer getReturneesOther() {
        return returneesOther;
    }

    public void setReturneesOther(Integer returneesOther) {
        this.returneesOther = returneesOther;
    }

    public Integer getForeignAnnualQuota() {
        return foreignAnnualQuota;
    }

    public void setForeignAnnualQuota(Integer foreignAnnualQuota) {
        this.foreignAnnualQuota = foreignAnnualQuota;
    }

    public Integer getForeignEndMonthCount() {
        return foreignEndMonthCount;
    }

    public void setForeignEndMonthCount(Integer foreignEndMonthCount) {
        this.foreignEndMonthCount = foreignEndMonthCount;
    }

    public Integer getForeignOnSite() {
        return foreignOnSite;
    }

    public void setForeignOnSite(Integer foreignOnSite) {
        this.foreignOnSite = foreignOnSite;
    }

    public Integer getForeignNewHires() {
        return foreignNewHires;
    }

    public void setForeignNewHires(Integer foreignNewHires) {
        this.foreignNewHires = foreignNewHires;
    }

    public Integer getForeignResigned() {
        return foreignResigned;
    }

    public void setForeignResigned(Integer foreignResigned) {
        this.foreignResigned = foreignResigned;
    }

    public Integer getForeignTemp() {
        return foreignTemp;
    }

    public void setForeignTemp(Integer foreignTemp) {
        this.foreignTemp = foreignTemp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}