package Sort;

public class HeapSort extends Sort{
    public HeapSort(int[] arr){
        super(arr);
        int[] newArr = new int[arr.length+1];
        len = newArr.length;
        for(int i = 1;i<len;i++){
            newArr[i] = arr[i-1];
        }
        array = newArr;
    }
    void sort() {
        int N = len-1;
        for(int i = len/2;i>=1;i--)
            sink(i,N);

        while(N > 1){
            exchange(1,N--);
            sink(1,N);
        }
    }
    void sink(int target,int N){
        if(target<0 || target>=N)return;
        while((2*target+1)<=N){
            int temp = 2*target;
            if(lower(array[temp], array[temp + 1])) temp++;
            if (lower(array[temp], array[target])) return;
            exchange(target,temp);
            target = temp;
        }
    }
}
