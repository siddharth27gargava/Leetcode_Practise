class Solution {
    public String minWindow(String s, String t) {
        
        String ans = "";
        
        //base case
        if(s.length() == 0 || t.length() == 0 || t.length() > s.length()){
            return ans;
        }
        
        //count for tmap
        HashMap<Character, Integer> tmap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char tcc = t.charAt(i);
            tmap.put(tcc,tmap.getOrDefault(tcc,0) + 1);
        }
        
        HashMap<Character,Integer> smap = new HashMap<>();
        
        //declare mct and dmct
        int mct = 0;
        int dmct = t.length();
        
        //declare left and right
        int left = -1;
        int right = -1;
        
        //start with while-true and booleans
        while(true){
            boolean floop1 = false;
            boolean floop2 = false;
            
             //acquire with while mct < dmct
            while(right < s.length()-1 && mct < dmct){
                right++;
                char scc = s.charAt(right);
                
                smap.put(scc,smap.getOrDefault(scc,0) + 1);
                
                //increment mct
                if(smap.getOrDefault(scc,0) <= tmap.getOrDefault(scc,0)){
                mct++;
                }
                
                floop1 = true;
            }
            
            while(left < right && mct == dmct){
                
                //calc pot-ans and release from left
                String potans = s.substring(left+1,right+1);
                if(potans.length() < ans.length() || ans.length() == 0){
                    ans = potans;
                }
                
                left++;
                char scc = s.charAt(left);
                
                if(smap.get(scc) > 1){
                    smap.put(scc,smap.get(scc) - 1);
                } else {
                    smap.remove(scc);
                }
                
                //remove val from mct
                if(smap.getOrDefault(scc,0) < tmap.getOrDefault(scc,0)){
                    mct--;
                }
                
                floop2 = true;
                
            }
            
            if(floop1 == false && floop2 == false){
                break;
            }
        }
        
        return ans;
    }
}