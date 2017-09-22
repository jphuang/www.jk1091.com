package com.jk1091.www.controller;

import com.jk1091.www.bean.Data;
import com.jk1091.www.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright (C), 2017-2017, 真知码
 * FileName: IndexController
 * Author:   jphuang
 * Date:     2017/9/22 13:56
 * Description: index
 */
@Controller
public class IndexController {
    @Autowired
    private DataService dataService;
    @RequestMapping("fuli")
    public String index(ModelMap model,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer pageSize){
        List<Data> list = dataService.list(pageSize, page - 1);
        model.put("list", list);
        return "index";
    }
}
