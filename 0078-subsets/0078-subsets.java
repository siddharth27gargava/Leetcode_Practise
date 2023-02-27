class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        generate(0,res, new ArrayList(), nums);
        return res;
    }
    
    public void generate(int idx, List<List<Integer>> res, List<Integer> curr, int[] nums){
        res.add(new ArrayList(curr));
        
        for(int i = idx; i < nums.length; i++){
            curr.add(nums[i]);
            generate(i + 1, res, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
    
}