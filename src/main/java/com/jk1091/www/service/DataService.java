package com.jk1091.www.service;

import com.jk1091.www.bean.Data;
import com.jk1091.www.dao.DataDao;
import com.jk1091.www.util.HttpUtil;
import lombok.extern.log4j.Log4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C), 2017-2017, 真知码
 * FileName: DataService
 * Author:   jphuang
 * Date:     2017/9/22 14:42
 * Description: data service
 */
@Service
@Log4j
@CacheConfig(cacheNames = "data")
public class DataService {
    private String api  = "http://gank.io/api/data/福利/%d/%d";
    @Autowired
    private DataDao dataDao;
    public  void  inserData(){
        int pageSize = 50;
        for (int i = 3; i <50; i++) {
            String result = HttpUtil.get(String.format(api, pageSize, i));
            JSONObject jsonArray = JSONObject.fromObject(result);
            JSONArray results = jsonArray.getJSONArray("results");
            List<Data> list = new ArrayList<>();
            for (Object obj : results) {
                JSONObject data = JSONObject.fromObject(obj);
                Data newdData = newData(data);
                list.add(newdData);
            }
            dataDao.saveAll(list);
        }
    }

    private Data newData(JSONObject data) {
        String desc = data.getString("desc");
        String source = data.getString("source");
        String type = data.getString("type");
        String url = data.getString("url");
        Date now = new Date();
        return  new Data(null,desc,source,type,url, now,now);
    }
    @Cacheable
    public List<Data> list(Integer pageSize,Integer page){
        Pageable pageable = PageRequest.of(page,pageSize);
        return dataDao.findAll(pageable).getContent();
    }
}
