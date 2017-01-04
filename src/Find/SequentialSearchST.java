package Find;

public class SequentialSearchST<Key extends Comparable<Key>,Value> implements STInterface<Key extends Comparable<Key>,Value>{
    private Node first;
    private class Node{
        Key key;
        Value value;
        Node next;
        public Node(Key key,Value value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public void put(Key key,Value value){
        if(value == null)return;

        for(Node n = first;n != null;n = n.next){
            if(n.key.equals(key)){
                n.value = value;
                return;
            }
        }
        first = new Node(key,value,first);
    }
    public Value get(Key key){
        for(Node n = first;n != null;n = n.next){
            if(n.key.equals(key))
                return n.value;
        }
        return null;
    }

    public void delete(Key key){
        if(first.key.equals(key)){
            first = first.next;
            return;
        }
        for(Node n = first;n != null;n = n.next){
            if(n.next.key.equals(n.key)){
                n.next = n.next.next;
                break;
            }
        }
    }
    public boolean contains(Key key){
        Node temp = first;
        while (temp != null){
            if(temp.key.equals(key))return true;
            temp = temp.next;
        }
        return false;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        int i = 0;
        for(Node n = first;n != null;n = n.next){
            i++;
        }
        return i;
    }
}
