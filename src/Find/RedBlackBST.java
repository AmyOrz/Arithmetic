package Find;
public class RedBlackBST<Key extends Comparable<Key>,Val>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int N;
    private class Node{
        private Key key;
        private Val val;
        private Node left,right;
        private boolean color;
        private int len;
        public Node(Key key,Val val,boolean color,int len){
            this.key = key;
            this.val = val;
            this.color = color;
            this.len = len;
            this.left = null;
            this.right = null;
        }
    }
    //the red black tree function
    public void put(Key key,Val val){
        if(key == null)
            throw new NullPointerException("argument the key is null");
        root = put(root,key,val);
        root.color = BLACK;
    }
    private Node put(Node head,Key key,Val val){
        if(head == null)
            return new Node(key,val,RED,1);
        int compareVal = key.compareTo(head.key);
        if(compareVal > 0)head.right = put(head.right,key,val);
        else if(compareVal < 0)head.left = put(head.left,key,val);
        else head.val = val;

        if(isRed(head.right) && !isRed(head.left)){
            head = rotateLeft(head);
        }else if(isRed(head.left) && isRed(head.left.left)){
            head = rotateRight(head);
        }else if(isRed(head.left) && isRed(head.right)){
            flipColor(head);
        }
        head.len = size(head.left) + size(head.right) + 1;
        return head;
    }
    private void flipColor(Node head){
        head.color = RED;
        head.left.color = BLACK;
        head.right.color = BLACK;
    }
    private Node rotateLeft(Node head){
        Node temp = head.right;
        head.right = temp.left;
        temp.left = head;
        temp.color = head.color;
        head.color = RED;
        temp.len = head.len;
        head.len = 1 + size(head.left) + size(head.right);
        return temp;
    }
    private Node rotateRight(Node head){
        Node temp = head.left;
        head.left = temp.right;
        temp.right = head;
        temp.color = head.color;
        head.color = BLACK;
        temp.len = head.len;
        head.len = 1 + size(head.right) + size(head.left);
        return temp;
    }

    //the binary search tree common function
    public Val get(Key key){
        if(key == null)
            throw new NullPointerException("argument the key is null");
        return get(root,key);
    }
    public boolean isContain(Key key){
        return get(key) != null;
    }
    public boolean isEmpty(){
        return root == null; //return size() == 0;
    }
    public int size(){
        return size(root);
    }

    private Val get(Node head,Key key){
        if(head == null)return null;
        int compareVal = key.compareTo(head.key);
        if(compareVal > 0)return get(head.right,key);
        else if(compareVal < 0)return get(head.left,key);
        else return head.val;
    }

    private boolean isRed(Node head){
        if(head == null)return false;

        return head.color == RED;
    }
    private int size(Node head){
        if(head == null)return 0;
        return head.len;
    }
}
