class Solution {
    public int maxProfit(int[] prices) {
        int minPrc = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for(int num : prices){
            if (num < minPrc) {
                minPrc = num;
            }

            if (num - minPrc > maxProfit) {
                maxProfit = num - minPrc;
            }
        }

        return maxProfit;
    }
}