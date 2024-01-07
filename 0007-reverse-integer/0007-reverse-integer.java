class Solution {
    public int reverse(int x) {
        
        boolean neg = x < 0;
        
        x = Math.abs(x);
        int rev = 0;
        while(x>0){
            if(Integer.MAX_VALUE/10 < rev){
                return 0;
            }
            
            int rem = x % 10;
            rev = rev*10 + rem;
            x = x/10;
        }
        
        if(neg){
            return -rev;
        }
        
        return rev;
    }
}