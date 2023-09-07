class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int i;
        Deque<Integer> q = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();
        
        //1st case
        for(i = 0; i < k; i++){
            while(!q.isEmpty() && nums[i] > nums[q.getLast()]){
                q.removeLast();
            }
            
            q.addLast(i);
        }
        
        //2nd case
        for(;i < nums.length; i++){
            
            al.add(nums[q.getFirst()]);
            
            while(!q.isEmpty() && q.getFirst() <= i - k){
                q.removeFirst();
            }
            
            while(!q.isEmpty() && nums[i] > nums[q.getLast()]){
                q.removeLast();
            }
            
            q.addLast(i);
        }
        
        al.add(nums[q.getFirst()]);
        
        int[] ans = new int[al.size()];
        
        for(int j = 0; j < al.size(); j++){
            ans[j] = al.get(j);
        }
        
        return ans;
        
    }
}