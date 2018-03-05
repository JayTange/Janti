package com.janti.domain;

import java.util.Date;

/**
 * @author janti
 */
public class SeckillGoodsVo {

    // 秒杀商品ID
    private Long id;
    // 商品ID
    private Long goodsId;
    // 秒杀价
    private Double seckillPrice;
    // 库存数量
    private Integer stockCount;
    // 秒杀开始时间
    private Date startTime;
    // 秒杀结束时间
    private Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Double getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Double seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "SeckillGoodsVo{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", seckillPrice=" + seckillPrice +
                ", stockCount=" + stockCount +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
