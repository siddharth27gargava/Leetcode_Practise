class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        HashSet<Integer> good = new HashSet<>();
        for(int[] t: triplets){
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]){
                continue;
            }
            for(int i = 0; i < 3; i++){
                if(t[i] == target[i]){
                    good.add(i);
                }
            }
        }
        
        if(good.size() != 3){
            return false;
        }
        
        return true;
    }
}