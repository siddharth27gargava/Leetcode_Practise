class Solution {
    
    public class Pair{
        int x;
        int y;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        HashMap<Pair,Integer> map = new HashMap<>();
        
        ArrayList<Pair> pairlist = new ArrayList<>();
        
        for(int i = 0; i < points.length; i++){
            pairlist.add(new Pair(points[i][0],points[i][1]));
        }
        
        for(int i = 0; i < pairlist.size(); i++){
            map.put(pairlist.get(i), (int)(Math.pow(pairlist.get(i).x,2) + (Math.pow(pairlist.get(i).y,2))));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        
        for(int i = 0; i < pairlist.size(); i++){
            pq.add(pairlist.get(i));
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int[][] ans = new int[k][2];
        
        for(int i = 0; i < ans.length; i++){
            Pair enter = pq.poll();
            ans[i][0] = enter.x;
            ans[i][1] = enter.y;
        }
        
        return ans;
    }
}