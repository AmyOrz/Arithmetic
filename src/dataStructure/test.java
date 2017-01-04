package dataStructure;

import dataStructure.queue.MaxPQ;

public class test {
    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(10);
        pq.insert(1);
        pq.insert(3);
        pq.insert(2);
        pq.insert(1);
        pq.insert(2);
        pq.insert(1);
        pq.insert(1);
        pq.insert(1);
        pq.insert(1);
        pq.insert(3);
        pq.insert(1);
        pq.insert(1);
        pq.insert(3);
        pq.insert(1);
        pq.insert(3);
        pq.insert(4);
        pq.insert(3);
        pq.insert(1);
        pq.insert(4);
        pq.insert(2);
        pq.insert(1);
        pq.insert(1);
        pq.show();
    }
}
