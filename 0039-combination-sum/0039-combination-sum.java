class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        List<List<Integer>> res = new ArrayList<>();
        
        helper(0,candidates,target,res,new ArrayList<>());
        
        return res;
        
    }
    
    public void helper(int idx, int[] arr, int target, List<List<Integer>> res, List<Integer> curr){
        
        //Base Case-1
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        //Base Case-2
        if(idx >= arr.length || target < 0){
            return;
        }
        
        //include
        curr.add(arr[idx]);
        helper(idx,arr,target - arr[idx],res,curr);
        
        //exclude - don't want to include arr[i] ever again
        curr.remove(curr.size() - 1);
        helper(idx + 1,arr,target,res,curr);
        
    }
    
    
}