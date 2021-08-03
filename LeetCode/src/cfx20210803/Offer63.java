package cfx20210803;

public class Offer63 {

    /**
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int currentProfit = 0;
        int currentMinPrice = Integer.MAX_VALUE;
        for(int price : prices){
            if(currentMinPrice > price){
                currentMinPrice = price;
            }
            if(price - currentMinPrice > currentProfit){
                currentProfit = price - currentMinPrice;
            }
        }
        return currentProfit;
    }
}
