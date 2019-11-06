package com.yunhan.entity;
import java.io.Serializable;
import java.util.function.DoubleBinaryOperator;

public class Arrearage implements Serializable {
    private String  loucengno;
    private String roomno;
    private String roomarea;
    private String clientname;
    private String phone;
    private Integer payitemsid;
    private String patitemsname;
    private double payitemsmoney;
    public String getLoucengno() {
        return loucengno;
    }
    public void setLoucengno(String loucengno) {
        this.loucengno = loucengno;
    }
    public String getRoomno() {
        return roomno;
    }
    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getRoomarea() {
        return roomarea;
    }

    public void setRoomarea(String roomarea) {
        this.roomarea = roomarea;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPayitemsid() {
        return payitemsid;
    }

    public void setPayitemsid(Integer payitemsid) {
        this.payitemsid = payitemsid;
    }

    public String getPatitemsname() {
        return patitemsname;
    }

    public void setPatitemsname(String patitemsname) {
        this.patitemsname = patitemsname;
    }

    public double getPayitemsmoney() {
        return payitemsmoney;
    }

    public void setPayitemsmoney(double payitemsmoney) {
        this.payitemsmoney = payitemsmoney;
    }





//    private double Arrearage;
//    private double liquidated;
//    private double balance;
//    private double assessment;
//    private double propertyFee;
//    private double electricFee;
//    private double waterFee;
//    private double gasFee;
   // private double garbageFee;

//    public double getArrearage() {
//        return Arrearage;
//    }
//
//    public void setArrearage(double arrearage) {
//        Arrearage = arrearage;
//    }
//
//    public double getLiquidated() {
//        return liquidated;
//    }
//
//    public void setLiquidated(double liquidated) {
//        this.liquidated = liquidated;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public double getAssessment() {
//        return assessment;
//    }
//
//    public void setAssessment(double assessment) {
//        this.assessment = assessment;
//    }
//
//    public double getPropertyFee() {
//        return propertyFee;
//    }
//
//    public void setPropertyFee(double propertyFee) {
//        this.propertyFee = propertyFee;
//    }
//
//    public double getElectricFee() {
//        return electricFee;
//    }
//
//    public void setElectricFee(double electricFee) {
//        this.electricFee = electricFee;
//    }
//
//    public double getWaterFee() {
//        return waterFee;
//    }
//
//    public void setWaterFee(double waterFee) {
//        this.waterFee = waterFee;
//    }
//
//    public double getGasFee() {
//        return gasFee;
//    }
//
//    public void setGasFee(double gasFee) {
//        this.gasFee = gasFee;
//    }
//
//    public double getGarbageFee() {
//        return garbageFee;
//    }
//
//    public void setGarbageFee(double garbageFee) {
//        this.garbageFee = garbageFee;
//    }
//
//    public double getOtherProperty() {
//        return otherProperty;
//    }
//
//    public void setOtherProperty(double otherProperty) {
//        this.otherProperty = otherProperty;
//    }
//
//    public double getOtherService() {
//        return otherService;
//    }
//
//    public void setOtherService(double otherService) {
//        this.otherService = otherService;
//    }
//
//    public double getSewageCharges() {
//        return sewageCharges;
//    }
//
//    public void setSewageCharges(double sewageCharges) {
//        this.sewageCharges = sewageCharges;
//    }
//
//    public String getRemark() {
//        return remark;
//    }
//
//    public void setRemark(String remark) {
//        this.remark = remark;
//    }
//    private double otherProperty;
//    private double otherService;
//    private double sewageCharges;
//    private String remark;

}
