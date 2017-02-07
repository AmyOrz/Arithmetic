package dataStructure.queue;

import utils.StdOut;

//max priority queue  最大优先队列
public class MaxPQ {
    private int[] array;
    private int len = 0;
    public MaxPQ(int N){
        array = new int[N+1];
    }
    public boolean isEmpty(){
        return len == 0;
    }
    public int size(){
        return len;
    }
    public void insert(int target){
        if(len+1 == array.length){
            int[] newArr = new int[(len+1) * 2];
            for(int i = 1;i<len+1;i++){
                newArr[i] = array[i];
            }
            array = newArr;
        }
        array[++len] = target;

        swim(len);
    }
    public int delMax(){
        if(len-1 == array.length/4){
            int[] newArr = new int[(len-1) * 2];
            for(int i = 1;i < len+1;i++){
                newArr[i] = array[i];
            }
            array = newArr;
        }
        int max = array[1];
        _exchange(1,len--);
        array[len+1] = 0;
        sink(1);
        return max;
    }
    public void show(){
        for(int i = 0,len = array.length;i<len;i++){
            StdOut.print(array[i] + " ");
        }
    }
    private void swim(int k){
        while(k>1 && _lessThan(k/2,k)){
            _exchange(k,k/2);
            k = k/2;
        }
    }
    private void sink(int k){
        while (2*k <= len){
            int temp = 2*k;
            if(temp <= len)
                if(_lessThan(temp,temp+1))temp++;

            if(_lessThan(temp,k))break;
            _exchange(k,temp);
            k = temp;
        }
    }
    private void _exchange(int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private boolean _lessThan(int i,int j){
        return array[i] < array[j];
    }
}
