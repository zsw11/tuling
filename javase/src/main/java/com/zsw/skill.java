package com.zsw;

/**
 * @author zsw
 * @date 2022/1/6 11:23
 * @Company: 广州市两棵树网络科技有限公司  利用redis原子性秒杀demo
 */
public class skill {
    public static void main(String[] args) {
        /**

         * 方法 4

         * 商品的数量 等其他信息 先保存 到 Redis

         * 检查库存 与 减少库存 不是原子性，  以 increment > 0 为准      *

         * @param req

         */

        @Override
        public void placeOrder3(PlaceOrderReq req) {
            String key = "product:" + req.getProductId();
            // 先检查 库存是否充足
            Integer num = (Integer) redisService.get(key);
            if (num < req.getNum()) {
                logger.info("库存不足 1");
            } else{
                //不可在这里下单减库存，否则导致数据不安全， 情况类似 方法1；
            }

            //减少库存
            long value = redisService.increment(key, -req.getNum().longValue());

            //库存充足
            if (value >= 0) {
                logger.info("成功抢购 ! ");
                //TODO 真正减 扣 库存 等操作 下单等操作  ,这些操作可用通过 MQ 或 其他方式
                place2(req);
            } else {
                //库存不足，需要增加刚刚减去的库存
                redisService.increment(key, req.getNum().longValue());
                logger.info("库存不足 2 ");
            }
        }
    }
   /* 分析：利用Redis increment 的原子操作，保证库存安全。事先需要把库存的数量等其他信息保存到Redis，并保证更新库存的时候，更新Redis。

    进来的时候 先 get 库存数量是否充足，再执行 increment。以 increment > 0 为准。检查库存 与 减少库存 不是原子性的。检查库存的时候技术库存充足也不可下单；否则造成库存不安全，原来类似 方法1. increment 是个原子操作，已这个为准。

            redisService.increment(key, -req.getNum().longValue()) >= 0 说明库存充足，可以下单。

            redisService.increment(key, -req.getNum().longValue()) < 0 的时候 不能下单，次数库存不足。并且需要 回加刚刚减去的库存数量，否则会导致刚才减扣的数量 一直买不出去。数据库与缓存的库存不一致。*/
}
