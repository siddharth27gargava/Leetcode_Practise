class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        
        generate(0,nums,ans,new ArrayList<Integer>());
        
        return ans;
    }
    
    public void generate(int idx, int[] nums, List<List<Integer>> result, List<Integer> curr){
        //Base Case when idx reaches till length of nums
        if(idx == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        
        //Include the idx in subset
        curr.add(nums[idx]);
        generate(idx+1,nums,result,curr);
        
        //Don't include
        curr.remove(curr.size() - 1);
        generate(idx + 1,nums,result,curr);
    }
}