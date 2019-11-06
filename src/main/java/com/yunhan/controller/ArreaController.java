package com.yunhan.controller;

import com.yunhan.entity.Arrearage;
import com.yunhan.entity.Users;
import com.yunhan.entity.pageCount;
import com.yunhan.entity.tableResult;
import com.yunhan.service.ArreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
@Controller
public class ArreaController {
    @Autowired
    private ArreaService arreaService;
    @RequestMapping("arrearages")
    public String meter(){
        return "arreareport";
    }
    //查询数据
    @RequestMapping("selArea")
    @ResponseBody
    public tableResult<Map> listData(pageCount pageCount, Arrearage arrearage){
        tableResult<Map> result=new tableResult<>();
        List<Map> list=arreaService.selArea(pageCount,arrearage);
        //设置表格有多少条数据
        int count=arreaService.selCount(arrearage);
        result.setData(list);
        result.setCount(count);
        return result;
    }
}