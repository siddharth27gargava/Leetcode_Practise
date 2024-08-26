class Solution {
    public int numIdenticalPairs(int[] nums) {
        if(nums.length < 2){
            return 0;
        }

        HashMap<Integer, Integer> fmap = new HashMap<>();

        for(int val : nums){
            fmap.put(val, fmap.getOrDefault(val, 0) + 1);
        }

        int sum = 0;

        for(int key : fmap.keySet()){
            if (fmap.get(key) > 1) {
                sum += getBCoeff(fmap.get(key));
            }
        }

        return sum;
    }

    public int getBCoeff(int n){
        return (n * (n-1))/2;
    }
}