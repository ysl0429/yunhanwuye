package com.yunhan.controller;

import com.yunhan.entity.*;
import com.yunhan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Map;

@Controller
public class MeterController {
    @Autowired
    private MeterService meterService;
    @Autowired
    private  PayitemsTypesService payitemsTypesService;;
    @Autowired
    private ChargersTService chargersTService;
    @Autowired
    private MeterChargeService meterChargeService;
    @Autowired
    private ReceivablesService receivablesService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private LoucengService loucengService;
    @RequestMapping("meter_reading")
    public String admin(){
        return "meter_reading";
    }
    //查询数据
    @RequestMapping("listData")
    @ResponseBody
    public tableResult<Map> listData(pageCount pageCount, Meter meter){
        tableResult<Map> result=new tableResult<>();
        List<Map> list=meterService.selectAll(pageCount,meter);
        //设置表格有多少条数据
        int count=meterService.selectCount(meter);
        result.setData(list);
        result.setCount(count);
        return result;
    }
    //添加数据
    @RequestMapping("/add")
    public String add(Model model){
        List<Payitems> list=payitemsTypesService.findAll();
        model.addAttribute("list",list);
        List<PayItemsT> pt=chargersTService.findAll();
        model.addAttribute("pt",pt);
        List<Building> query=buildingService.queryBuildingName();
        model.addAttribute("query",query);
        return "add";
    }
   @RequestMapping("/add_louceng")
    public String add_louceng(Integer buildingID,Model model){
        List<Louceng> louceng=loucengService.queryLoucengNo(buildingID);
        model.addAttribute("louceng",louceng);
        return "add";
    }
    @RequestMapping("/add_do")
    @ResponseBody
    public tableResult<Meter> add_do(Meter meter){
        meterService.add_do(meter);
        tableResult result = new tableResult();
        //添加成功页面显示
        result.setMsg("添加成功");
        return result;
    }
    //页面回显
    @RequestMapping("/selectMetersById")
    public String selectMetersById(Integer meterID, Model model){
        Meter meter=meterService.selectMetersById(meterID);
        List<Payitems> type=payitemsTypesService.findAll();
        List<PayItemsT> pt=chargersTService.findAll();
        model.addAttribute("pt",pt);
        model.addAttribute("t",type);
        model.addAttribute("meter",meter);
        return "update";
    }
    @RequestMapping("/update_do")
    @ResponseBody
    public tableResult<Meter> update_do(Meter meter){
        meterService.update_do(meter);
        tableResult result=new tableResult();
        //修改成功页面显示
        result.setMsg("修改成功！");
        return result;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public tableResult<Meter> delete (Integer meterID){
        meterService.delete(meterID);
        tableResult result=new tableResult();
        //删除提示
        result.setMsg("删除成功！");
        return  result;
    }

    //抄表费用
    @RequestMapping("meter_charge")
    public String meter_charge(){
        return "meter_charge";
    }
    //查询数据
    @RequestMapping("listChargeData")
    @ResponseBody
    public tableResult<Map> listData(pageCount pageCount,MeterCharge meterCharge){

        tableResult<Map> result=new tableResult<>();
        List<Map> list=meterChargeService.selAll(pageCount,meterCharge);
        //设置表格有多少条数据
         int count=meterChargeService.selCount(meterCharge);
         result.setData(list);
         result.setCount(count);
        return result;
    }
    //单项审核
    @RequestMapping("audit")
      @ResponseBody
    public tableResult<Map> Audit(Integer meterID){
        meterChargeService.update_do(meterID);
        tableResult result=new tableResult();
        result.setMsg("审核完成");
        return result;
    }
    //多项审核
    @RequestMapping("auditAll")
    @ResponseBody
    public tableResult<Map> AuditAll(Integer[] meterID ){
        meterChargeService.updateAll_do(meterID);
        tableResult result=new tableResult();
        result.setMsg("审核完成");
        return result;
    }
    //撤销审核
    @RequestMapping("reAudit")
    @ResponseBody
    public tableResult<Map> reAudit(Integer meterID ){
        meterChargeService.updateReAudit_do(meterID);
        tableResult result=new tableResult();
        result.setMsg("撤销完成");
        return result;
    }
    //抄表状态
    @RequestMapping("update_true")
    @ResponseBody
    public tableResult<Map> updateTrue(Integer meterID){
        meterChargeService.update_true(meterID);
        tableResult result=new tableResult();
        result.setMsg("启用状态");
        return result;
    }
    //抄表状态
    @RequestMapping("update_false")
    @ResponseBody
    public tableResult<Map> updateFalse(Integer meterID){
        meterChargeService.update_false(meterID);
        tableResult result=new tableResult();
        result.setMsg("禁用状态");
        return result;
    }


    //应收费用
    @RequestMapping("receivables")
    public String receivables(){
        return "receivables";
    }
    //查询数据
    @RequestMapping("listReceivables")
    @ResponseBody
    public tableResult<Map> listData(pageCount pageCount,Receivables receivables){
        tableResult<Map> result=new tableResult<>();
        List<Map> list=receivablesService.selectAll(pageCount,receivables);
        //设置表格有多少条数据
       int count=20;
        result.setData(list);
        result.setCount(count);
        return result;
    }
}
