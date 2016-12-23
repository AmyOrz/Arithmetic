package Sort;

public class MergeSort extends Sort{
    private int[] tempArr;
    public MergeSort(int[] array){
        super(array);
        tempArr = new int[len];
    }

    @Override
    void sort() {
        sortUp(0,len-1);
//        sortDown();
    }
    void sortDown(){
        for(int sz = 1;sz<len;sz = sz + sz){
            for(int lo = 0;lo<len-sz;lo += sz + sz){
                merge(lo,lo+sz-1,Math.min(lo+sz+sz-1,len-1));
            }
        }
    }
    void sortUp(int lower,int hight){
        if(hight <= lower)return;

        int middle = lower + (hight - lower)/2;
        sortUp(lower,middle);
        sortUp(middle+1,hight);
        merge(lower,middle,hight);
    }
    void merge(int lower,int middle,int hight){
        int i = lower;
        int j = middle + 1;
        for(int k = lower;k<=hight;k++){
            tempArr[k] = array[k];
        }
        for(int k = lower;k<=hight;k++){
            if(i>middle){
                array[k] = tempArr[j++];
            }else if(j>hight){
                array[k] = tempArr[i++];
            }else if(tempArr[i] > tempArr[j]){
                array[k] = tempArr[j++];
            }else{
                array[k] = tempArr[i++];
            }
        }
    }
}
