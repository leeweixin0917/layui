package com.southwind.layui.service;

import com.southwind.layui.vo.BarVO;
import com.southwind.layui.vo.DataVO;
import com.southwind.layui.vo.PieVO;
import com.southwind.layui.vo.ProductVO;

import java.util.List;

public interface ProductService {
    public DataVO<ProductVO> findData(Integer page,Integer limit);
    public BarVO getBarVO();
    public List<PieVO> getPieVO();
}
