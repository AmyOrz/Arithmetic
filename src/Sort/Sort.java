package Sort;

import utils.StdOut;

public abstract class Sort {
    protected int[] array;
    protected int len;
    public Sort(int[] array){
        this.array = array;
        len = array.length;
    }
    protected boolean lower(int i,int j){
        return i<j;
    }
    protected void exchange(int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    protected void show(){
        for(int i = 0,len = array.length;i<len;i++){
            StdOut.print(array[i]+" ");
        }
        StdOut.println();
    }
    protected boolean isSorted(){
        for(int i = 1,len = array.length;i<len;i++){
            if(lower(array[i],array[i-1]))return false;
        }
        return true;
    }
    protected int compareTo(int value,int target){
        if(value < target)return -1;
        else if(value == target)return 0;
        else return 1;
    }
    abstract void sort();
}
