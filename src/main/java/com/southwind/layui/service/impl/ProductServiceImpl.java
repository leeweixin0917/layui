package com.southwind.layui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.southwind.layui.entity.Product;
import com.southwind.layui.entity.ProductCategory;
import com.southwind.layui.mapper.ProductCategoryMapper;
import com.southwind.layui.mapper.ProductMapper;
import com.southwind.layui.service.ProductService;
import com.southwind.layui.vo.DataVO;
import com.southwind.layui.vo.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public DataVO<ProductVO> findData(Integer page,Integer limit) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");

        IPage<Product> productIPage = new Page<>(page,limit);
        IPage<Product> result = productMapper.selectPage(productIPage,null);
        dataVO.setCount(result.getTotal());
        List<Product> productList = result.getRecords();
        List<ProductVO> productVOList = new ArrayList<>();
        for (Product product : productList) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(product,productVO);
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategoryleveloneId());
            ProductCategory productCategory = productCategoryMapper.selectOne(wrapper);
            if(productCategory!=null){
                productVO.setCategorylevelone(productCategory.getName());
            }
            wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategoryleveltwoId());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if(productCategory!=null){
                productVO.setCategoryleveltwo(productCategory.getName());
            }
            wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategorylevelthreeId());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if(productCategory!=null){
                productVO.setCategorylevelthree(productCategory.getName());
            }
            productVOList.add(productVO);
        }
        dataVO.setData(productVOList);
        return dataVO;
    }
}
