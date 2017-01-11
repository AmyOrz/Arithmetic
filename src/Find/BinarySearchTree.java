package Find;

import utils.StdOut;

/**
 * 二叉查找树实现字符表，效率最坏为O(n)。
 */
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
            left = null;
            right = null;
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
        return _min(root).key;
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
    public Key select(int k){
        if(k < 0 || k > size())return null;
        return _select(root,k).key;
    }
    public int lowerTarget(Key key){
        return _rank(root,key);
    }
    public void delMin(){
        root = _delMin(root);
    }
    public void delete(Key key){
        root = _delete(root,key);
    }
    public int size(){
        return _size(root);
    }
    public void preShow(){
        _preShow(root);
    }
    private Node _delete(Node head,Key key){
        if(head == null)return null;
        int compareVal = key.compareTo(head.key);
        if(compareVal > 0)head.right = _delete(head.right,key);
        else if(compareVal < 0)head.left = _delete(head.left,key);
        else{
            if(head.left == null)return head.right;
            if(head.right == null)return head.left;
            Node temp = head;
            head = _min(temp.right);
            head.right = _delMin(temp.right);
            head.left = temp.left;
        }
        head.len = _size(head.left)+_size(head.right)+1;
        return head;
    }
    private Node _min(Node head){
        while(head.left != null){
            head = head.left;
        }
        return head;
    }
    private Node _delMin(Node head){
        if(head.left == null)return head.right;
        head.left = _delMin(head.left);
        return head;
    }
    private int _rank(Node head,Key key){
        if(head == null)return 0;
        int compareVal = key.compareTo(head.key);
        if(compareVal < 0)return _rank(head.left,key);
        else if(compareVal > 0)return 1+_size(head.left)+_rank(head.right,key);
        else return _size(head.left);
    }
    private void _preShow(Node head){
        if(head == null)return;
        _preShow(head.left);
        StdOut.print(head.key+"--");
        _preShow(head.right);
    }
    private Node _select(Node head,int k){
        if(head == null)return null;
        int temp = _size(head.left);
        if(temp > k)return _select(head.left,k);
        else if(temp < k)return _select(head.right,k-temp-1);
        else return head;
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
