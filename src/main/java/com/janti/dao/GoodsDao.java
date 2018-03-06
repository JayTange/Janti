package com.janti.dao;

import com.janti.domain.GoodsVo;
import com.janti.domain.SeckillGoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author janti
 */
@Mapper
public interface GoodsDao {
    @Select("select g.*, sg.seckill_price, sg.stock_count, sg.start_time, sg.end_time from seckill_goods sg left join goods g on sg.goods_id=g.id")
    List<GoodsVo> listGoodsVo();

    @Select("select g.*, sg.seckill_price, sg.stock_count, sg.start_time, sg.end_time from seckill_goods sg left join goods g on sg.goods_id=g.id where g.id={goodsId}")
    GoodsVo getGoodsVoByGoodsId(@Param("goodsId")long goodsId);

    @Update("update seckill_goods set stock_count=stock_count-1 where goods_id=#{goodsId} and stock_count>0")
    int reduceStock(SeckillGoodsVo g);

    @Update("update seckill_goods set stock_count = #{stockCount} where goods_id = #{goodsId}")
    public int resetStock(SeckillGoodsVo g);
}
