class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        
        List<List<Integer>> res = new ArrayList<>();
        
        helper(0,candidates,target,res,new ArrayList<>());
        
        return res;
    }
    
    public void helper(int idx, int[] candidates, int target, List<List<Integer>> res, List<Integer> curr){
        
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if(target <= 0 || idx >= candidates.length){
            return;
        }
        
        int prev = -1;
        
        for(int i = idx; i < candidates.length; i++){
            //check for dup
            if(prev == candidates[i]){
                continue;
            }
            
            //include
            curr.add(candidates[i]);
            helper(i + 1, candidates, target - candidates[i], res, curr);

            //exclude
            curr.remove(curr.size() - 1);
            //helper(i + 1, candidates, target, res, curr);
            
            prev = candidates[i];
        }
        
    }
}