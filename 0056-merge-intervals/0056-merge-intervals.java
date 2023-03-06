class Solution {
    
    public class Pair implements Comparable<Pair>{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Pair o2){
            return this.x - o2.x;
        }
    }
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        
        LinkedList<int[]> ll = new LinkedList<>();
        
        for(int[] interval : intervals){
            if(ll.isEmpty() || ll.getLast()[1] < interval[0]){
                ll.addLast(interval);
            } else{
                ll.getLast()[1] = Math.max(ll.getLast()[1],interval[1]);
            }
        }
        
        return ll.toArray(new int[ll.size()][2]);
    }
}