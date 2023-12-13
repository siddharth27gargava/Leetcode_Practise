class Solution {
    
    public class Pair{
        int r;
        int c;
        
        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
        
        @Override
        public boolean equals(Object o) {
            //if (this == o) return true;
            //if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return r == pair.r && c == pair.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
    
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        HashSet<Pair> visit = new HashSet<>();
        Deque<Pair> q = new LinkedList();
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(rooms[r][c] == 0){
                    Pair np = new Pair(r,c);
                    q.addLast(np);
                    visit.add(np);
                }
            }
        }
        
        int dist = 0;
        while(!q.isEmpty()){
            int qs = q.size();
            for(int i = 0; i < qs; i++){
                Pair rm = q.removeFirst();
                
                rooms[rm.r][rm.c] = dist;
                
                addRoom(rm.r+1,rm.c,rooms,visit,q);
                addRoom(rm.r-1,rm.c,rooms,visit,q);
                addRoom(rm.r,rm.c+1,rooms,visit,q);
                addRoom(rm.r,rm.c-1,rooms,visit,q);
            }
            
            dist++;
        }
    }
    
    public void addRoom(int r, int c, int[][] rooms, HashSet<Pair> visit, Deque<Pair> q){
        if(r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || visit.contains(new Pair(r,c)) || rooms[r][c] == -1){
            return;
        }
        
        Pair np = new Pair(r,c);
        visit.add(np);
        q.addLast(np);
        
    }
}