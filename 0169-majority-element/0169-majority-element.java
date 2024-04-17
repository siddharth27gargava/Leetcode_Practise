class Solution {
    public int majorityElement(int[] nums) {
    HashMap<Integer,Integer> map = new HashMap<>();
        
    for(int i = 0; i < nums.length; i++){
       if(map.containsKey(nums[i])){
           int of = map.get(nums[i]);
           int nf = of + 1;
           map.put(nums[i],nf);
            } else {
           map.put(nums[i],1);
       } 
        }
        
        int ans = 0;
        Set<Integer> keys = map.keySet();
        for(int key : keys){
            if(map.get(key) > (nums.length/2)){
                ans = key;
            }
        }
        
        return ans;
    }
}