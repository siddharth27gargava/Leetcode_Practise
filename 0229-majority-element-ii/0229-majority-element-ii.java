class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //at max there can be just two elements which can appear 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        int limit = nums.length/3;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > limit){
                ans.add(entry.getKey());
            }
        }

        return ans;
    }
}