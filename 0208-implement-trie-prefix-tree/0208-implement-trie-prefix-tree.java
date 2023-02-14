class Trie {

    public class Node{
        char data;
        boolean isTerminal;
        HashMap<Character, Node> children;

        Node(char data, boolean isTerminal){
            this.data = data;
            this.isTerminal = isTerminal;
            this.children = new HashMap<>();
        }
    }
    
    int numWords;
    Node root;
    
    
    public Trie() {
        this.root = new Node('\0', false);
        this.numWords = 0;
    }
    
    public void insert(String word) {
        this.addWord(this.root, word);
    }
    
    public void addWord(Node parent, String word){
        
        if(word.length() == 0){
            if(parent.isTerminal){
                
            } else {
                parent.isTerminal = true;
                numWords++;
            }
            
            return;
        }
        
        char cc = word.charAt(0);
        String ros = word.substring(1);
        Node child = parent.children.get(cc);
        if(child == null){
            child = new Node(cc,false);
            parent.children.put(cc,child);
        }
        
        this.addWord(child,ros);
    }
    
    public boolean search(String word) {
        return this.search(this.root, word);
    }
    
    public boolean search(Node parent, String word){
        if(word.length() == 0){
            if(parent.isTerminal){
                return true;
            } else {
                return false;
            }
        }
        
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
    
    public boolean startsWith(Node parent, String prefix){
        if(prefix.length() == 0){
            return true;
        }
        
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