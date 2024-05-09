class Trie {

    class Node{
        char data;
        boolean isTerminal;
        HashMap<Character, Node> children;

        public Node(char data, boolean isTerminal){
            this.data = data;
            this.isTerminal = isTerminal;
            this.children = new HashMap<>();
        }
    }

    Node root;
    int numWords;

    public Trie() {
        this.root = new Node('\0', false);
        this.numWords = 0;
    }
    
    public void insert(String word) {
        this.insert(this.root, word);
    }

    private void insert(Node parent, String word){
        //BCase

        //have we reached the end of the word
        if(word.length() == 0){
            //if the isterminal property is not false
            if(!parent.isTerminal){
                parent.isTerminal = true;
                this.numWords++;
            }
            return;
        }

        //Swork
        char cc = word.charAt(0);
        String ros = word.substring(1);
        //adding that character in child node
        Node child = parent.children.get(cc);
        if (child == null) {
            child = new Node(cc,false);
            parent.children.put(cc, child);
        }

        //recursion work
        //child becomes parent and ros is the word
        this.insert(child, ros);
    }
    
    public boolean search(String word) {
        return this.search(root, word);
    }

    private boolean search(Node parent, String word){
        //base case
        if (word.length() == 0) {
            if (parent.isTerminal) {
                return true;
            } else {
                return false;
            }
        }

        //short work
        char cc = word.charAt(0);
        String ros = word.substring(1);
        Node child = parent.children.get(cc);
        if (child == null) {
            return false;
        }

        //rec-case
        return this.search(child, ros);
    }
    
    public boolean startsWith(String prefix) {
        return this.startsWith(root, prefix);
    }

    private boolean startsWith(Node parent, String prefix){
        //base case
        if (prefix.length() == 0) {
            return true;
        }

        char cc = prefix.charAt(0);
        String ros = prefix.substring(1);
        Node child = parent.children.get(cc);
        if (child == null) {
            return false;
        }

        return this.startsWith(child, ros);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */