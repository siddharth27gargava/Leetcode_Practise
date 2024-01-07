public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            //Instead of modding - do a (n & 1) == 1
            if((n & 1) == 1){
                count++;
            }
            n = n >>> 1;
        }

        return count;
    }
}