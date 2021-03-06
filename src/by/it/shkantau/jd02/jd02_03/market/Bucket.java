package by.it.shkantau.jd02.jd02_03.market;

import java.util.HashMap;
import java.util.Map;

class Bucket {

   private Map<Goods, Double> goodsInBucket = new HashMap<>();

   void putGoods(Goods goods, Double count){
       goodsInBucket.put(goods, count);
   }

   double getTotalSum(){
       double totalSum = 0;

       for (Map.Entry<Goods, Double> entry : goodsInBucket.entrySet()) {
           totalSum += entry.getKey().getCost() * entry.getValue();
       }
       return totalSum;
   }

    Map<Goods, Double> getGoodsInBucket() {
       return goodsInBucket;
   }

   public void setGoodsInBucket(Map<Goods, Double> goodsInBucket) {
       this.goodsInBucket = goodsInBucket;
   }
}
