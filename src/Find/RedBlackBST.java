package Find;

import com.sun.org.apache.regexp.internal.RE;

public class RedBlackBST<Key extends Comparable<Key>,Val>{
   private static final boolean Red = true;
   private static final boolean Black = true;
   private Node root;

   private class Node{
      private Key key;
      private Val val;
      private Node left,right;
      private int size;
      private boolean color;

      public Node(Key key,Val val,boolean color,int size){
         this.key = key;
         this.val = val;
         this.size = size;
         this.color = color;
      }
   }

   /**
    * return the number of key-value pairs in this symbol table
    */
   public int size(){
      return size(root);
   }

   /**
    * is this symbol table is empty?
    */
   public boolean isEmpty(){
      return root == null;
   }

   /**
    * return the value associated with the given key
    */
   public Val get(Key key){
      if(key == null)
         throw new NullPointerException("argument to get() is null");
      return get(root,key);
   }

   /**
    * does this symbol table contain the given key?
    */
   public boolean contains(Key key){
      return get(key) != null;
   }

   /**
    * insert into this symbol table with the given key and value
    */
   public void put(Key key,Val val){
      if(key == null)
         throw new NullPointerException("first argument to put is null");

      if(val == null){
         delete(key);
         return;
      }
      root = put(root,key,val);
      root.color = Black;
   }

   /**
    * remove the specified key and its associated value from this symbol table
    */
   public void delete(Key key){
      if(key == null)
         throw new NullPointerException("argument to delete is null");

      if(!contains(key))
         return;

      if(!isRed(root.left) && !isRed(root.right))
         root.color = Red;

      root = delete(root,key);
      if(isEmpty()){
         root.color = Black;
      }
   }
   private Node delete(Node head,Key key){
      int compareVal = key.compareTo(head.key);
      if(compareVal < 0){
         if(!isRed(head.left) && !isRed(head.left.left)){
            head = moveRedLeft(head);
         }
         head.left = delete(head.left,key);
      }else{
         if(isRed(head.left)){
            head = rotateRight(head);
         }
         if(compareVal == 0 && (head.right == null)){
            return null;
         }
         if(!isRed(head.right) && !isRed(head.right.left)){
            head = moveRedRight(head);
         }
         if(compareVal == 0){
            Node x = min(head.right);
            head.key = x.key;
            head.val = x.val;
            head.right = deleteMin(head.right);
         }else {
            head.right = delete(head.right,key);
         }
      }
      return balance(head);
   }
   private Node min(Node head){
      if(head.left == null){
         return head;
      }else{
          return min(head.left);
      }
   }
   private Node deleteMin(Node head){
      if(head.left == null){
         return null;
      }
      if(!isRed(head.left) && !isRed(head.left.left)){
         head = moveRedRight(head);
      }
      head.left = deleteMin(head.left);
      return balance(head);
   }
   private Node moveRedLeft(Node head){
      flipColor(head);
      if(isRed(head.right.left)){
         head.right = rotateRight(head.right);
         head = rotateLeft(head);
         flipColor(head);
      }
      return head;
   }
   private Node moveRedRight(Node head){
      flipColor(head);
      if(isRed(head.left.left)){
         head = rotateRight(head);
         flipColor(head);
      }
      return head;
   }
   private Node balance(Node head){
      if(isRed(head.right)){
         head = rotateLeft(head);
      }
      if(isRed(head.left) && isRed(head.left.left)){
         head = rotateRight(head);
      }
      if(isRed(head.left) && isRed(head.right)){
         flipColor(head);
      }
      head.size = size(head.left) + size(head.right) + 1;
      return head;
   }
   private Node put(Node head,Key key,Val val){
      if(head == null){
         return new Node(key,val,Red,1);
      }
      int compareVal = key.compareTo(head.key);
      if(compareVal < 0)head.left = put(head.left,key,val);
      else if(compareVal > 0)head.right = put(head.right,key,val);
      else head.val = val;

      return balance(head);
   }
   private Node rotateLeft(Node head){
      Node x = head.right;
      head.right = x.left;
      x.left = head;
      x.color = head.color;
      head.color = Red;
      x.size = head.size;
      head.size = size(head.left) + size(head.right) + 1;
      return x;
   }
   private Node rotateRight(Node head){
      Node x = head.left;
      head.left = x.right;
      x.right = head;
      x.color = head.color;
      head.color = Red;
      x.size = head.size;
      head.size = size(head.left) + size(head.right) + 1;
      return x;
   }
   private void flipColor(Node head){
      head.color = !head.color;
      head.left.color = !head.left.color;
      head.right.color = !head.right.color;
   }
   private Val get(Node head,Key key){
      while(head != null){
         int compareVal = key.compareTo(head.key);
         if(compareVal < 0)
            head = head.left;
         else if(compareVal > 0)
             head = head.right;
         else
            return head.val;
      }
      return null;
   }
   private boolean isRed(Node head){
      if(head == null)return false;
      return head.color == Red;
   }
   private int size(Node head){
      if(head == null)return 0;
      return head.size;
   }
}
