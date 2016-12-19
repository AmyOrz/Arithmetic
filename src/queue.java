public class queue<E>{
    private class Node{
        E value;
        Node next;
    }
    private Node first;
    private Node last;
    private int totalCount = 0;

    public boolean isEmpty(){
        return  first == null;
    }
    public int size(){
        return totalCount;
    }
    public void push(E value){
        Node oldLast = last;
        last = new Node();
        last.value = value;
        last.next = null;
        if(isEmpty())first = last;
        else oldLast.next = last;
        totalCount++;
    }
    public E pop(){
        Node oldFirst = first;
        first = first.next;
        if(isEmpty())last = null;
        totalCount--;
        return oldFirst.value;
    }
}
