class Solution {
    public int longestConsecutive(int[] nums) {
        //use a hashset and add numbers
        //loop through the array and first check if num-1 doesn't exists in set, then traverse with while loop to check if num+1 exists and increment accordingly
        HashSet<Integer> set = new HashSet<>();
        
        if(nums.length == 0){
            return 0;
        }
        
        for(int num : nums){
            set.add(num);
        }
        
        int longest = 1;
        for(int num : nums){
            if(!set.contains(num - 1)){
                int count = 1;
                while(set.contains(num + 1)){
                    num++;
                    count++;
                }
                
                longest = Math.max(longest,count);
            }
        }
        
        return longest;
    }
}