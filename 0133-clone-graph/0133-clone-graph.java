/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        //HashMap - clone
        //Add values in hashmap
        //Clone would try to neighbours while checking the hashmap
        HashMap<Node, Node> OtNmap = new HashMap<>();
        
        if(node == null){
            return null;
        }
        
        return dfs(node, OtNmap);
    }
    
    public Node dfs(Node node, HashMap<Node, Node> OtNmap){
        
        //Check if map already contains clone, return cloned value
        if(OtNmap.containsKey(node)){
            return OtNmap.get(node);
        }
        
        //If not in map, then create a new node and add it to map
        Node copy = new Node(node.val);
        OtNmap.put(node,copy);
        
        //Make copies of every neighbour of that node
        for(Node nei : node.neighbors){
            //populate the neighbors of the new copy with dfs which means creating news
            //nodes and adding it in map and neighbor
            copy.neighbors.add(dfs(nei, OtNmap)); 
        }
        
        return copy;
    }
}