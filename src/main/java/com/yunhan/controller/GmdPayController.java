package com.yunhan.controller;

import com.yunhan.entity.*;
import com.yunhan.service.GmdPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

@Controller
public class GmdPayController {
    @Autowired
    private GmdPayService gmdPayService;
    @RequestMapping("gpay")
    public String gpay(){
        return "gpay";
    }

    @RequestMapping("gpaylistDate")
    @ResponseBody
    public tableResult<Map> listData(pageCount pageCount, com.yunhan.entity.GmdPay gmdPay){
        System.out.print(gmdPay.getPatitemstname());
        tableResult<Map> result=new tableResult<>();
        List<Map> list=gmdPayService.selectAll(pageCount,gmdPay);
        //设置表格有多少条数据
        int count=gmdPayService.selectCount(gmdPay);
        result.setData(list);
        result.setCount(count);
        return result;
    }
    @RequestMapping("/delPay")
    @ResponseBody
    public tableResult<com.yunhan.entity.GmdPay> delPay(Integer payitemsid){
        gmdPayService.delPay(payitemsid);
        tableResult result=new tableResult();
        result.setMsg("删除成功");
        return result;

    }
    @RequestMapping("/addgpay")
    public String addgpay(com.yunhan.entity.GmdPay gmdPay, Model model){
        List<com.yunhan.entity.GmdPay> sp=gmdPayService.selPayitemst(gmdPay);
        List<com.yunhan.entity.GmdPay> sm=gmdPayService.selMetert(gmdPay);
        List<com.yunhan.entity.GmdPay> si= gmdPayService.selItems(gmdPay);
        model.addAttribute("sp",sp);
        model.addAttribute("sm",sm);
        model.addAttribute("si",si);
        return "addgpay";
    }
    @RequestMapping("addPay")
    @ResponseBody
    public com.yunhan.entity.ResultOne<com.yunhan.entity.GmdPay> addPay(com.yunhan.entity.GmdPay gmdPay){
        int a=gmdPayService.selPay(gmdPay);
        com.yunhan.entity.ResultOne result=new com.yunhan.entity.ResultOne();
        if(a>0){
            result.setMsg("已存在");
          result.setData(false);
        }else {
            gmdPayService.addPay(gmdPay);
            result.setMsg("添加成功");
            result.setData(true);

        }
        return result;
    }
    @RequestMapping("selUp")
    public String selUp(com.yunhan.entity.GmdPay gmdPay, Integer payitemsid , Model model){
        List<com.yunhan.entity.GmdPay> selp=gmdPayService.selPayitemst(gmdPay);
        List<com.yunhan.entity.GmdPay> selm=gmdPayService.selMetert(gmdPay);
        List<com.yunhan.entity.GmdPay> seli= gmdPayService.selItems(gmdPay);
        List<com.yunhan.entity.GmdPay> sel=gmdPayService.selUp(payitemsid);
        model.addAttribute("selp",selp);
        model.addAttribute("selm",selm);
        model.addAttribute("seli",seli);
        model.addAttribute("sel",sel);
        return "gupdatepay";
    }
    @RequestMapping("/upPay")
    @ResponseBody
    public com.yunhan.entity.ResultOne<com.yunhan.entity.GmdPay> upPay(com.yunhan.entity.GmdPay gmdPay){


        com.yunhan.entity.ResultOne result=new com.yunhan.entity.ResultOne();

            gmdPayService.upPay(gmdPay);
            result.setMsg("修改成功");
            result.setData(true);


        return result;

    }


}
