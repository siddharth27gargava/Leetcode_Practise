class Solution {
    
    int[] par;
    int[] rank;
    
    public int[] findRedundantConnection(int[][] edges) {
        //O(n)
        //Remove the redundant edge which occurs last in the input 
        //Union Find with Rank
        // Par = [1,2,3]
        //Rank = [1,1,1]
        
        //after 1st edge traversal 
        //Par = [1,1,3]
        //Rank= [2,1,1]
        
        //after 2nd edge traveral
        //Par = [1,1,1]
        //Rank= [3,1,1]
        
        //Find : find for the nodes of a vertice if they have same parent - then that becomes redundant
        
        // int[] ans = new int[2];
        
        par = new int[edges.length+1];
        for(int i = 1; i <= edges.length; i++){
            par[i] = i;
        }
        
        rank = new int[edges.length+1];
        for(int i = 1; i <= edges.length; i++){
            rank[i] = 1;
        }
        
        for(int[] vertice : edges){
            if(!union(vertice[0],vertice[1],par,rank)){
                return vertice;
            }
        }
        
        return new int[2];
        
    }
    
    public int find(int n, int[] par){
        int p = par[n];
        while(p != par[p]){
            par[p] = par[par[p]];
            p = par[p];
        }
        
        return p;
    }
    
    public boolean union(int n1, int n2, int[] par, int[] rank){
        int p1 = find(n1,par);
        int p2 = find(n2,par);
        
        if(p1 == p2){
            return false;
        }
        
        if(rank[p1] > rank[p2]){
            par[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        
        return true;
    }
}