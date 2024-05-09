class Trie {
    
    class Node{
        char data;
        boolean isTerminal;
        HashMap<Character, Node> children;
        
        Node(char data, boolean isTerminal){
            this.data = data;
            this.isTerminal = isTerminal;
            this.children = new HashMap<>();
        }
    }
    
    Node root;
    int numWords;
    
    public Trie() {
        this.root = new Node('\0',false);
        this.numWords = 0;
    }
    
    public void insert(String word) {
        this.insert(this.root,word);
    }
    
    private void insert(Node parent, String word){
        
        //BCase
        if(word.length() == 0){
            if(!parent.isTerminal){
                parent.isTerminal = true;
                this.numWords++;
            }
            return;
        }
        
        //SWork
        char cc = word.charAt(0);
        String ros = word.substring(1);
        Node child = parent.children.get(cc);
        if(child == null){
            child = new Node(cc,false);
            parent.children.put(cc,child);
        }
        
        //RWork
        this.insert(child,ros);
    }
    
    public boolean search(String word) {
        return this.search(this.root,word);
    }
    
    private boolean search(Node parent, String word){
         //BCase
        if(word.length() == 0){
            if(parent.isTerminal){
                return true;
            } else {
                return false;
            }
        }
        
        //Swork
        char cc = word.charAt(0);
        String ros = word.substring(1);
        Node child = parent.children.get(cc);
        if(child == null){
            return false;
        }
        
        return this.search(child,ros);
    }
    
    public boolean startsWith(String prefix) {
        return this.startsWith(this.root,prefix);
    }
    
    private boolean startsWith(Node parent, String prefix){
         //BCase
        if(prefix.length() == 0){
           return true;
        }
        
        //Swork
        char cc = prefix.charAt(0);
        String ros = prefix.substring(1);
        Node child = parent.children.get(cc);
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