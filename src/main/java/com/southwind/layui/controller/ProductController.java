package com.southwind.layui.controller;

import com.southwind.layui.mapper.ProductMapper;
import com.southwind.layui.service.ProductService;
import com.southwind.layui.vo.BarVO;
import com.southwind.layui.vo.DataVO;
import com.southwind.layui.vo.PieVO;
import com.southwind.layui.vo.ProductBarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;
    @RequestMapping("/list")
    @ResponseBody
    public DataVO list(Integer page,Integer limit){
        return productService.findData(page, limit);
    }
    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }
    @RequestMapping("/barVO")
    @ResponseBody
    public BarVO getBarVO(){
        return productService.getBarVO();
    }
//    @RequestMapping("/pieVO")
//    @ResponseBody
//    public List<PieVO> getPieVO(){
//        return productService.getPieVO();
//    }
    @RequestMapping("/pieVO")
    @ResponseBody
    public List<ProductBarVO> getPieVO() {
        return productMapper.findAllProductBarVO();
    }
}
