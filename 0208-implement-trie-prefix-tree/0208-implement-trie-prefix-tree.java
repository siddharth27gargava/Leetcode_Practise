class Trie {

    class Node{
        char data;
        HashMap<Character,Node> map;
        boolean isTerminal;
        
        public Node(char data, boolean isTerminal){
            this.data = data;
            this.isTerminal = isTerminal;
            this.map = new HashMap<>();
        }
    }
    
    int numWords;
    Node root;
    
    public Trie() {
        this.root = new Node('\0',false);
        this.numWords = 0;
    }
    
    public void insert(String word) {
         this.addWord(this.root,word);
    }
    
    public void addWord(Node root, String word){
        //Base-Case
        if(word.length() == 0){
            if(root.isTerminal){
                
            } else {
                root.isTerminal = true;
                numWords++;
            }
            return;
        }
        
        //SW
        char cc = word.charAt(0);
        String ros = word.substring(1);
        Node child = root.map.get(cc);
        if(child == null){
            child = new Node(cc,false);
            root.map.put(cc,child);
        }
        
        this.addWord(child,ros);
    }
    
    public boolean search(String word) {
        return this.search(this.root,word);
    }
    
    public boolean search(Node parent, String word){
        //Base Case
        if(word.length() == 0){
            if(parent.isTerminal){
                return true;
            } else {
                return false;
            }
        }
        
        char cc = word.charAt(0);
        String ros = word.substring(1);
        Node child = parent.map.get(cc);
        if(child == null){
            return false;
        }
        
        return this.search(child,ros);
    }
    
    public boolean startsWith(String prefix) {
        return this.startsWith(this.root,prefix);
    }
    
    public boolean startsWith(Node parent, String prefix) {
        //Base-Case
        if(prefix.length() == 0){
            return true;
        }
        
        //SW
        char cc = prefix.charAt(0);
        String ros = prefix.substring(1);
        Node child = parent.map.get(cc);
        if(child == null){
            return false;
        }
        
        return this.startsWith(child,ros);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */