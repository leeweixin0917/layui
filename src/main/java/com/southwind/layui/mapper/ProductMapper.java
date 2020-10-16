package com.southwind.layui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.southwind.layui.entity.Product;
import com.southwind.layui.vo.ProductBarVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper extends BaseMapper<Product> {
    @Select("SELECT p.name,sum(quantity) count FROM mmall.order_detail od, mmall.product p where od.product_id = p.id group by product_id;")
    public List<ProductBarVO> findAllProductBarVO();
}
