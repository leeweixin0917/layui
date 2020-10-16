package com.southwind.layui.service;

import com.southwind.layui.vo.DataVO;
import com.southwind.layui.vo.ProductVO;

public interface ProductService {
    public DataVO<ProductVO> findData(Integer page,Integer limit);
}
