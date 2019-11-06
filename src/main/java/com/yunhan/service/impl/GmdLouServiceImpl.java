package com.yunhan.service.impl;

import com.yunhan.entity.GmdLou;
import com.yunhan.entity.pageCount;
import com.yunhan.mapper.GmdLouMapper;
import com.yunhan.mapper.GmdMapper;
import com.yunhan.service.GmdLouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GmdLouServiceImpl implements GmdLouService {
    @Autowired
    private GmdLouMapper gmdLouMapper;
    @Override
    public List<Map> selectAll(pageCount pageCount, GmdLou gmdLou) {
        int begin=pageCount.getLimit()*(pageCount.getPage()-1);
        int end=pageCount.getLimit()*pageCount.getPage()-begin;
        Map<String,Object> map=new HashMap<>();
        map.put("begin",begin);
        map.put("end",end);
        map.put("buildingname",gmdLou.getBuildingname());
        return gmdLouMapper.selectAll(map);
    }

    @Override
    public int selectCount(GmdLou gmdLou) {
        return gmdLouMapper.selectCount(gmdLou);
    }

    @Override
    public int delLou(Integer buildingid) {
        return gmdLouMapper.delLou(buildingid);
    }

    @Override
    public int delqLou(Integer buildingid) {
        return gmdLouMapper.delqLou(buildingid);
    }

    @Override
    public int addLou(GmdLou gmdLou) {
        return gmdLouMapper.addLou(gmdLou);
    }

    @Override
    public int selAddlou(String buildingname) {
        return gmdLouMapper.selAddlou(buildingname);
    }

    @Override
    public GmdLou selbuildingid(Integer buildingid) {
        return gmdLouMapper.selbuildingid(buildingid);
    }

    @Override
    public int upLou(GmdLou gmdLou) {
        return gmdLouMapper.upLou(gmdLou);
    }
}
