package dataStructure.stack;

import java.util.Iterator;

public class stack<E> implements Iterable<E>{
    private Node first;
    private int totalCount;
    private class Node{
        E value;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return totalCount;
    }
    public void push(E value){
        Node oldFirst = first;
        first = new Node();
        first.value = value;
        first.next = oldFirst;
        totalCount++;
    }
    public E pop(){
        Node oldFirst = first;
        first = first.next;
        totalCount--;
        return oldFirst.value;
    }
    public E peek(){
        if(isEmpty())return null;
        else return first.value;
    }
    public Node getFirst(){
        return first;
    }
    public void delete(int target){
        int k = 0;
        Node currentNode = first;
        if(target == 0){
            first = first.next;
        }else {
            while (currentNode != null) {
                if (++k == target) {
                    currentNode.next = currentNode.next.next;
                }
                currentNode = currentNode.next;
            }
        }
    }
    public void removeAfter(E target){
        Node currentNode = first;
        while(currentNode != null){
            if(currentNode.value == target){
                currentNode.next = currentNode.next.next;
                break;
            }
            currentNode = currentNode.next;
        }
    }
    public void insertAfter(E target,E key){
        Node currenNode = first;
        while(currenNode != null){
            if(currenNode.value == target){
                Node newNode = new Node();
                newNode.value = key;
                newNode.next = currenNode.next;
                currenNode.next = newNode;
            }
            currenNode = currenNode.next;
        }
    }
    public boolean find(Node head,E key){
        while(head != null){
            if(head.value == key){
                return true;
            }
            head = head.next;
        }
        return false;
    }
    public void convert()
    {
        first = _convert(first);
    }
    private Node reverse(Node head){
        if(head == null)return null;
        if(head.next == null)return head;

        Node first = head;
        Node second = null;
        while(first != null){
            Node temp = first.next;
            first.next = second;
            second = first;
            first = temp;
        }
        return second;
    }

    private Node _convert(Node head){
        if(head == null)return null;
        if(head.next == null)return head;

        Node first = head;
        Node result = null;
        while(first != null){
            Node second = first.next;
            first.next = result;
            result = first;
            first = second;
        }
        return result;
    }
    public Iterator<E> iterator(){
        return new Iter();
    }
    private class Iter implements Iterator<E>{
        private Node currentNode = first;
        public E next(){
            Node oldFirst = currentNode;
            currentNode = currentNode.next;
            return oldFirst.value;
        }
        public boolean hasNext(){
            return currentNode != null;
        }
    }
}
