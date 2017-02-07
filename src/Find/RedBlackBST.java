package Find;
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

   private Node put(Node head,Key key,Val val){
      if(head == null){
         return new Node(key,val,Red,1);
      }
      
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
