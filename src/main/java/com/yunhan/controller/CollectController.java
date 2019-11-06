package com.yunhan.controller;
import com.yunhan.entity.Collectreport;
import com.yunhan.entity.tableResult;
import com.yunhan.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yunhan.entity.pageCount;
import java.util.List;
import java.util.Map;

@Controller
public class CollectController {
    @Autowired
    private CollectService collectService;
    @RequestMapping("feereports")
    public String meter(){
        return "feereport";
    }
    @RequestMapping("selcol")
    @ResponseBody
    public tableResult<Map> selcol(pageCount pageCount,Collectreport collectreport){
        tableResult<Map> result=new tableResult<>();
        String aaa=collectreport.getTesth();
        String Cbegin="";
        String Cend="";
        if(aaa!="" && aaa!=null){
            String arr[]= aaa.split("~");
            Cbegin=arr[0];
            Cend=arr[1];
        }
        collectreport.setCbegin(Cbegin);
        collectreport.setCend(Cend);
        List<Map> listcol=collectService.selcol(pageCount,collectreport);
        int colcount=collectService.selcolCount(collectreport);
        result.setData(listcol);
        result.setCount(colcount);
        return result;
    }
}
