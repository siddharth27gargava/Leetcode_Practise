class Solution {
    public int maxProfit(int[] prices) {
        int minPrc = Integer.MAX_VALUE;
        int maxPrf = Integer.MIN_VALUE;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrc){
                minPrc = prices[i];
            }
            
            if(prices[i] - minPrc > maxPrf){
                maxPrf = prices[i] - minPrc;
            }
        }
        
        return maxPrf;
    }
}