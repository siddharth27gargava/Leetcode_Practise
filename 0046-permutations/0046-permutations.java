class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        
        List<Integer> numlist = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            numlist.add(nums[i]);
        }
        generate(0,res,numlist);
        return res;
    }
    
    public void generate(int idx, List<List<Integer>> res, List<Integer> numlist){
        if(idx == numlist.size()){
            res.add(new ArrayList(numlist));
            return;
        }
        
        for(int i = idx; i < numlist.size(); i++){
            Collections.swap(numlist,idx,i);
            generate(idx + 1, res, numlist);
            Collections.swap(numlist,i,idx);
        }
    }
}