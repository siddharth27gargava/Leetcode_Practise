class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int h : hand){
            map.put(h,map.getOrDefault(h,0) + 1);
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        //Find min value in logn times
        for(int h : hand){
            q.add(h);
        }
        
        while(!q.isEmpty()){
            int min_val = q.poll();
            
            if(map.get(min_val) == 0){
                continue;
            }
            
            for(int i = min_val; i < min_val + groupSize; i++){
                if(!map.containsKey(i) || map.get(i) == 0){
                    return false;
                }
                
                map.put(i,map.get(i) - 1);
            }
        }
        
        return true;
    }
}