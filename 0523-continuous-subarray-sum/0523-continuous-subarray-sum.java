class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // O(n2)
        // traverse left and right

        // for (int start = 0; start < nums.length; start++) {
        //     int sum = 0;
        //     for (int end = start; end < nums.length; end++) {
        //         sum += nums[end];
        //         if ((end - start + 1) >= 2 && sum % k == 0) {
        //             return true;
        //         }
        //     }
        // }

        // O(n) logic : if we have found multiple prefixes with remainder as same, that
        // means we found
        // subarray which is multiple of k

        // this means we iterate through arr, keep summing, track the remainder, if we
        // find
        // remainder present in our hashmap -> check for the distance i - get(rem) >= 2;
        // return true
        // if rem not present, then add it in our hashmap

        // add 0->-1

        HashMap<Integer, Integer> rem_mapped_to_position = new HashMap<>();
        rem_mapped_to_position.put(0,-1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int rem = sum % k;
            if (rem_mapped_to_position.containsKey(rem)) {
                if (i - rem_mapped_to_position.get(rem) >= 2) {
                    return true;
                }
            }

            if(!rem_mapped_to_position.containsKey(rem)){
                rem_mapped_to_position.put(rem, i);
            }
        }

        return false;
    }
}