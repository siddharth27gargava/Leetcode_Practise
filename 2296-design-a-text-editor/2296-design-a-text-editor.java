public class TextEditor {
    private StringBuilder left;
    private StringBuilder right;

    public TextEditor() {
        left = new StringBuilder();
        right = new StringBuilder();    
    }
    
    public void addText(String text) {
        left.append(text);
    }
    
    public int deleteText(int k) {
        int count = Math.min(left.length(), k);
        left.setLength(left.length() - count);
        return count;
    }
    
    public String cursorLeft(int k) {
        int actualMove = Math.min(k, left.length());
        right.insert(0, left.substring(left.length() - actualMove)); // Move characters from the end of 'left' to the start of 'right'
        left.delete(left.length() - actualMove, left.length());
        return left.substring(Math.max(left.length() - 10, 0));
    }
    
    public String cursorRight(int k) {
        int actualMove = Math.min(k, right.length());
        left.append(right.substring(0, actualMove)); // Move characters from the start of 'right' to the end of 'left'
        right.delete(0, actualMove);
        return left.substring(Math.max(0, left.length() - 10));
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
