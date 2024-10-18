package com.cisdi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cisdi.PoiTrainingApplication;
import java.io.Serializable;
import java.util.Date;

/**
 * 物资采购月报
 * @TableName Mcccc_op_materials_purchasing
 */
@TableName(value ="Mcccc_op_materials_purchasing")
public class MccccOpMaterialsPurchasingEntity extends PoiTrainingApplication implements Serializable {
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
     * 物资名称
     */
    @TableField(value = "material_name")
    private String materialName;

    /**
     * 规格型号
     */
    @TableField(value = "spec_model")
    private String specModel;

    /**
     * 单位
     */
    @TableField(value = "unit")
    private String unit;

    /**
     * 单价
     */
    @TableField(value = "unit_price")
    private Double unitPrice;

    /**
     * 本月采购量
     */
    @TableField(value = "monthly_qty")
    private Double monthlyQty;

    /**
     * 采购金额(美元)
     */
    @TableField(value = "monthly_amount_usd")
    private Double monthlyAmountUsd;

    /**
     * 采购地
     */
    @TableField(value = "purchase_location")
    private String purchaseLocation;

    /**
     * 采购形式
     */
    @TableField(value = "purchase_form")
    private String purchaseForm;

    /**
     * 本年累计采购数量
     */
    @TableField(value = "yearly_qty")
    private Double yearlyQty;

    /**
     * 本年累计采购金额(美元)
     */
    @TableField(value = "yearly_amount_usd")
    private Double yearlyAmountUsd;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getSpecModel() {
        return specModel;
    }

    public void setSpecModel(String specModel) {
        this.specModel = specModel;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getMonthlyQty() {
        return monthlyQty;
    }

    public void setMonthlyQty(Double monthlyQty) {
        this.monthlyQty = monthlyQty;
    }

    public Double getMonthlyAmountUsd() {
        return monthlyAmountUsd;
    }

    public void setMonthlyAmountUsd(Double monthlyAmountUsd) {
        this.monthlyAmountUsd = monthlyAmountUsd;
    }

    public String getPurchaseLocation() {
        return purchaseLocation;
    }

    public void setPurchaseLocation(String purchaseLocation) {
        this.purchaseLocation = purchaseLocation;
    }

    public String getPurchaseForm() {
        return purchaseForm;
    }

    public void setPurchaseForm(String purchaseForm) {
        this.purchaseForm = purchaseForm;
    }

    public Double getYearlyQty() {
        return yearlyQty;
    }

    public void setYearlyQty(Double yearlyQty) {
        this.yearlyQty = yearlyQty;
    }

    public Double getYearlyAmountUsd() {
        return yearlyAmountUsd;
    }

    public void setYearlyAmountUsd(Double yearlyAmountUsd) {
        this.yearlyAmountUsd = yearlyAmountUsd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}