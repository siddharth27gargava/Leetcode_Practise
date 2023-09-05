class Solution {
    public int maxProfit(int[] prices) {
        //get the hishest stock arr
        //calc the max difference
        int minP = Integer.MAX_VALUE;
        int totD = Integer.MIN_VALUE;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minP){
                minP = prices[i];
            }
            
            if(prices[i] - minP >= totD){
                totD = prices[i] - minP;
            }
        }
        
        return totD;
    }
}