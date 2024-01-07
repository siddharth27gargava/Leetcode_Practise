class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        for(int i = 0; i <= n; i++){
            ans[i] = countone(i);
        }
        
        return ans;
    }
    
    public int countone(int num){
        int count = 0;
        while(num > 0){
            if((num & 1) == 1){
                count++;
            }
            
            num = num >>> 1;
        }
        
        return count;
    }
    
    public int convertoB(int num){
        
        int bnum = 0;
        int count = 0;
        
        while(num > 0){
            int rem = num % 2;
            bnum = bnum + ((int)(Math.pow(10,count)) * rem);
            count++;
            num = num/2;
         }
        
        return bnum;
    }
}