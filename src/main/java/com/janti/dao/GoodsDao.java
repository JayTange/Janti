package com.janti.dao;

import com.janti.domain.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author janti
 */
@Mapper
public interface GoodsDao {
    @Select("select g.*, sg.seckill_price, sg.stock_count,sg.start_time,sg.end_time from seckill_goods sg left join goods g on sg.goods_id=g.id")
    List<GoodsVo> listGoodsVo();
}
