package com.janti.rediskey;

/**
 * @author tangj
 * @date 2018/3/7 21:13
 */
public class GoodsKey extends BasePrefix {
    private GoodsKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static GoodsKey getGoodsList = new GoodsKey(60*60, "goodslist");
    public static GoodsKey getGoodsDetail = new GoodsKey(60*60, "goodsdetail");
    public static GoodsKey getSeckillGoodsStock = new GoodsKey(0, "goodstock");
}
