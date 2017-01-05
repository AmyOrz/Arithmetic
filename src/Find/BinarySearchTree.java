package Find;
public class BinarySearchTree<Key extends Comparable<Key>,Value> {
    private Node root;
    private class Node{
        private Key key;
        private Value val;
        private Node left,right;
        private int len;
        public Node(Key key,Value val,int N){
            this.key = key;
            this.val = val;
            this.len = N;
        }
    }
    public void put(Key key,Value val){
        root = _put(root,key,val);
    }
    private Node _put(Node head,Key key,Value val){
        if(head == null)return new Node(key,val,1);
        int compareVal = key.compareTo(head.key);
        if(compareVal < 0)
            head.left = _put(head.left,key,val);
        else if(compareVal > 0)
            head.right = _put(head.right,key,val);
        else
            head.val = val;
        head.len = _size(head.left) + _size(head.right) + 1;
        return head;
    }
    public Value get(Key key){
        return _get(root,key);
    }
    public Key min(){
        Node head = root;
        while(head.left != null){
            head = head.left;
        }
        return head.key;
    }
    public Key max(){
        Node head = root;
        while (head.right != null){
            head = head.right;
        }
        return head.key;
    }
    public Key floor(Key key){
        Node x = _floor(root,key);
        if(x == null)return null;
        return x.key;
    }
    public Key ceiling(Key key){
        Node x = _ceiling(root,key);
        if(x == null)return null;
        return x.key;
    }
    public int size(){
        return _size(root);
    }
    private Node _ceiling(Node head,Key key){
        if(head == null)return null;
        int compareVal = key.compareTo(head.key);
        if(compareVal == 0)return head;
        else if(compareVal > 0)return _ceiling(head.right,key);

        Node temp = _ceiling(head.left,key);
        if(temp != null)return temp;
        else return head;

    }
    private Node _floor(Node head,Key key){
        if(head == null)return null;
        int compareVal = key.compareTo(head.key);
        if(compareVal == 0)return head;
        if(compareVal < 0)return _floor(head.left,key);

        Node temp = _floor(head.right,key);
        if(temp != null)return temp;
        else return head;
    }
    private Value _get(Node head,Key key){
        if(head == null)return null;
        int compareVal = key.compareTo(head.key);
        if(compareVal < 0)return _get(head.left,key);
        else if(compareVal > 0)return _get(head.right,key);
        else return head.val;
    }
    private int _size(Node node){
        if(node == null)return 0;
        else return node.len;
    }
}
