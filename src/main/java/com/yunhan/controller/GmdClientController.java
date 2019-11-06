package com.yunhan.controller;

import com.yunhan.entity.*;
import com.yunhan.service.GmdClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

@Controller
public class GmdClientController {
    @Autowired
    private GmdClientService gmdClientService;
    @RequestMapping("gclient")
    public String meter(){
        return  "gclient";
    }
    //   查询数据
    @RequestMapping("gclistData")
    @ResponseBody
    public tableResult<Map> listData(pageCount pageCount, com.yunhan.entity.GmdClient gmdClient){

        tableResult<Map> result=new tableResult<>();
        List<Map> list=gmdClientService.selectAll(pageCount,gmdClient);
        //设置表格有多少条数据
        int count=gmdClientService.selectCount(gmdClient);
        result.setData(list);
        result.setCount(count);
        return result;
    }

    @RequestMapping("addgclient")
    public String addgclient(com.yunhan.entity.GmdClient gmdClient, Model model){
       List<com.yunhan.entity.GmdClient> ed= gmdClientService.seleducation(gmdClient);
       model.addAttribute("ed",ed);
        return "addgclient";
    }
    //执行添加
    @RequestMapping("/addClient")
    @ResponseBody
    public com.yunhan.entity.ResultOne<com.yunhan.entity.GmdClient> addClient(com.yunhan.entity.GmdClient gmdClient){
        com.yunhan.entity.ResultOne result=new com.yunhan.entity.ResultOne();
       int a= gmdClientService.selAddc(gmdClient);
        if(a>0){
            result.setMsg("用户已存在");
            result.setData(false);

        }else {
            gmdClientService.addBank(gmdClient);
            gmdClientService.addClient(gmdClient);
            gmdClientService.addRelat(gmdClient);

            result.setMsg("添加成功");
            result.setData(true);
        }
        return result;
    }
    @RequestMapping("/delClient")
    @ResponseBody
    public tableResult<com.yunhan.entity.GmdClient> delClient(Integer clientmessageid){
        gmdClientService.delClient(clientmessageid);
        tableResult result=new tableResult();
        result.setMsg("删除成功");
        return result;

    }
    //修改时查询
    @RequestMapping("/selUpClient")
    public String selUpClient(Integer clientmessageid, Model model, com.yunhan.entity.GmdClient gmdClient){
       List<com.yunhan.entity.GmdClient> gc= gmdClientService.selUpClient(clientmessageid);
      List<com.yunhan.entity.GmdClient> ge= gmdClientService.seleducation(gmdClient);
      List<com.yunhan.entity.GmdClient>gb=gmdClientService.selBank(gmdClient);
       model.addAttribute("gc",gc);
       model.addAttribute("ge",ge);
       model.addAttribute("gb",gb);
       return "gupdateclient";

    }
    //执行修改
    @RequestMapping("upClient")
    @ResponseBody
    public com.yunhan.entity.ResultOne<com.yunhan.entity.GmdClient> upClient(com.yunhan.entity.GmdClient gmdClient){
        com.yunhan.entity.ResultOne result=new com.yunhan.entity.ResultOne();
        int a= gmdClientService.selAddc(gmdClient);
        if(a>0){
            result.setMsg("用户已存在");
            result.setData(false);
        }else {
            gmdClientService.upRelation(gmdClient);
            gmdClientService.upClient(gmdClient);
            result.setMsg("修改成功");
            result.setData(true);
        }
        return result;

    }



}
