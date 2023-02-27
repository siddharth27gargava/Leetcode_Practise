class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0){
            return null;
        }

        List<List<Integer>> ans = new ArrayList<>();

        findCombination(candidates,0, target, new ArrayList<>(), ans);

        return ans;
    }
    
    public void findCombination(int[] candidates, int idx, int target, List<Integer> curr, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        
        for(int i = idx; i < candidates.length; i++){
            if(candidates[i] <= target){
                curr.add(candidates[i]);
                findCombination(candidates, i, target - candidates[i], curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
}