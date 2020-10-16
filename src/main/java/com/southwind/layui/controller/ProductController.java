package com.southwind.layui.controller;

import com.southwind.layui.service.ProductService;
import com.southwind.layui.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/list")
    @ResponseBody
    public DataVO list(Integer page,Integer limit){
        return productService.findData(page, limit);
    }
    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }
}
