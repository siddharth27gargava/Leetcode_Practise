class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        res.add(new ArrayList());
        
        for(int num : nums){
            int n = res.size();
            for(int j = 0; j < n; j++){
                //copy list
                List<Integer> temp = new ArrayList(res.get(j));
                
                //number add
                temp.add(num);
                
                //add subset in result list
                res.add(temp);
            }
        }
        
        return res;
    }
}