package com.yunhan.entity;

public class MeterCharge {
    private Integer meterID;
    private int auditStatus;
    private String homeNO;
    private String clientName;
    private int payitemsId;
    private String meterReadTime;
    private int utility;
    private String meterReadStatus;
    private String chargeStandard;
    private double total;
    private String remark;

    public Integer getMeterID() {
        return meterID;
    }

    public void setMeterID(Integer meterID) {
        this.meterID = meterID;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(int auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getHomeNO() {
        return homeNO;
    }

    public void setHomeNO(String homeNO) {
        this.homeNO = homeNO;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getPayitemsId() {
        return payitemsId;
    }

    public void setPayitemsId(int payitemsId) {
        this.payitemsId = payitemsId;
    }

    public String getMeterReadTime() {
        return meterReadTime;
    }

    public void setMeterReadTime(String meterReadTime) {
        this.meterReadTime = meterReadTime;
    }

    public int getUtility() {
        return utility;
    }

    public void setUtility(int utility) {
        this.utility = utility;
    }

    public String getMeterReadStatus() {
        return meterReadStatus;
    }

    public void setMeterReadStatus(String meterReadStatus) {
        this.meterReadStatus = meterReadStatus;
    }

    public String getChargeStandard() {
        return chargeStandard;
    }

    public void setChargeStandard(String chargeStandard) {
        this.chargeStandard = chargeStandard;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
