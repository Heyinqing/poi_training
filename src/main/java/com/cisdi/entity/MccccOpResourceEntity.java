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
 * @TableName Mcccc_op_resource
 */
@TableName(value ="Mcccc_op_resource")
public class MccccOpResourceEntity extends PoiTrainingApplication implements Serializable {
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
     * 新资源储量分类-一级
     */
    @TableField(value = "mineral_reserve_type")
    private String mineralReserveType;

    /**
     * 新资源储量分类-二级
     */
    @TableField(value = "reserve_quantity_type")
    private String reserveQuantityType;

    /**
     * 中段
     */
    @TableField(value = "midsection")
    private String midsection;

    /**
     * 矿石量（t）
     */
    @TableField(value = "ore_volume")
    private Double oreVolume;

    /**
     * 地质品位-Pb（%）
     */
    @TableField(value = "lead_grade")
    private Double leadGrade;

    /**
     * 地质品位-Zn（%）
     */
    @TableField(value = "zinc_grade")
    private Double zincGrade;

    /**
     * 金属量-Pb（t）
     */
    @TableField(value = "lead_content")
    private Double leadContent;

    /**
     * 金属量-Zn（t）
     */
    @TableField(value = "zinc_content")
    private Double zincContent;

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

    public String getMineralReserveType() {
        return mineralReserveType;
    }

    public void setMineralReserveType(String mineralReserveType) {
        this.mineralReserveType = mineralReserveType;
    }

    public String getReserveQuantityType() {
        return reserveQuantityType;
    }

    public void setReserveQuantityType(String reserveQuantityType) {
        this.reserveQuantityType = reserveQuantityType;
    }

    public String getMidsection() {
        return midsection;
    }

    public void setMidsection(String midsection) {
        this.midsection = midsection;
    }

    public Double getOreVolume() {
        return oreVolume;
    }

    public void setOreVolume(Double oreVolume) {
        this.oreVolume = oreVolume;
    }

    public Double getLeadGrade() {
        return leadGrade;
    }

    public void setLeadGrade(Double leadGrade) {
        this.leadGrade = leadGrade;
    }

    public Double getZincGrade() {
        return zincGrade;
    }

    public void setZincGrade(Double zincGrade) {
        this.zincGrade = zincGrade;
    }

    public Double getLeadContent() {
        return leadContent;
    }

    public void setLeadContent(Double leadContent) {
        this.leadContent = leadContent;
    }

    public Double getZincContent() {
        return zincContent;
    }

    public void setZincContent(Double zincContent) {
        this.zincContent = zincContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}