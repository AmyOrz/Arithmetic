package Find;

import utils.StdOut;

import java.util.Queue;

public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] values;
    private int len;
    public BinarySearchST(int N){
        keys = (Key[])new Comparable[N];
        values = (Value[])new Object[N];
    }
    public Value get(Key key){
        if(isEmpty())return null;
        int i = rank(key);
        if(i < len && keys[i].compareTo(key) == 0)
            return values[i];
        else
            return null;
    }
    public void put(Key key,Value value){
        int i = rank(key);
        if(i < len && keys[i].compareTo(key) == 0){
            values[i] = value;
            return;
        }
        for(int j = len;j>i;j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        len++;
        _increaseArr();
    }
    public void delete(Key key){
        int i = rank(key);
        if(i < len && keys[i].compareTo(key) == 0){
            for(int j = i;j<len;j++){
                keys[j] = keys[j+1];
                values[j] = values[j+1];
            }
            keys[len-1] = null;
            values[len-1]=null;
            len--;
            _shrinkArr();
        }
    }
    public int rank(Key key){
        int lo = 0;
        int hi = len - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int compareVal = key.compareTo(keys[mid]);
            if(compareVal < 0)hi = mid - 1;
            else if(compareVal > 0)lo = mid + 1;
            else return mid;
        }
        return lo;
    }
    public void show(){
        for(int i = 0;i<len;i++) {
            StdOut.print(keys[i] + " " + values[i] + " -- ");
        }
        StdOut.println();
    }
    public Key ceiling(Key key){
        return keys[rank(key)];
    }
    public Key floor(Key key){
        return keys[rank(key)-1];
    }
    public Key min(){
        return keys[0];
    }
    public Key max(){
        return keys[len-1];
    }
    public Key select(int key){
        return keys[key];
    }
    public int size(){
        return len;
    }
    public boolean isEmpty(){
        return len == 0;
    }
    void _increaseArr(){
        if(len == keys.length){
            Key[] newKeys = (Key[])new Comparable[len*2];
            Value[] newVals = (Value[])new Object[len*2];
            for(int i = 0;i<len;i++){
                newKeys[i] = keys[i];
                newVals[i] = values[i];
            }
            keys = newKeys;
            values = newVals;
        }
    }
    void _shrinkArr(){
        if(len == keys.length/4){

        }
    }
}
