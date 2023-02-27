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
        
        ArrayList<Pair> pl = new ArrayList<>();
        
        for(int i = 0; i < points.length; i++){
            pl.add(new Pair(points[i][0], points[i][1]));
        }
        
        for(int i = 0; i < pl.size(); i++){
            int distance = (int)(Math.pow(pl.get(i).x,2)) + (int)(Math.pow(pl.get(i).y,2));    
            map.put(pl.get(i),distance);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        
        for(Pair tba:map.keySet()){
            pq.add(tba);
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int[][] ans = new int[pq.size()][2];
        
        ArrayList<Pair> res = new ArrayList<>();
        
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        
        for(int i = 0; i < res.size(); i++){
            ans[i][0] = res.get(i).x;
            ans[i][1] = res.get(i).y;
        }
        
        return ans;
    }
}