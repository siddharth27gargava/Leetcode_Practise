class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //for min eating speed, have the ans value as max possible which in this case would be highest value in array
        int left = 1;
        int right = getMax(piles);
        int ans = right;

        while (left <= right) {
            int mid = (left + right)/2;
            int hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += (Math.ceil((double)piles[i]/mid));
            }

            //let's say mid is 6, which means hours is 6, but we can further extend hours, which means mid should be smaller
            //to make mid smaller we reduce right

            //let's say mid is 3, hours is 10, we have to reduce hours, mid should be bigger, to make mid bigger -> left + 1 
            if(hours <= h){
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}