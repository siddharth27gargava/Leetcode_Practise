class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = getMax(piles);
        int ans = hi;
        
        while(lo <= hi){
            int mid = (lo+hi)/2;
            int hours = 0;
            for(int i = 0; i < piles.length; i++){
                hours += (Math.ceil((double)piles[i]/mid));
            }
            
            if(hours <= h){
                ans = Math.min(ans, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return ans;
    }
    
    public int getMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            if(max < piles[i]){
                max = piles[i];
            }
        }
        
        return max;
    }
}