class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = getMax(piles);
        int result = hi;

        while (hi >= lo){
            int mid = (hi+lo)/2;

            int hours = 0;
            for(int i = 0; i < piles.length; i++){
                hours += (Math.ceil((double)piles[i]/mid));
            }

            if (hours <= h){
                result = Math.min(result,mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return result;
    }
    
    public int getMax(int[] arr){
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}