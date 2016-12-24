package Sort;

/**
 * standard quick sort
 */

public class QuickSort extends Sort {
    public QuickSort(int[] array){
        super(array);
    }
    @Override
    void sort() {
        sort(0,len-1);
    }
    void sort(int lower,int hight){
        if(hight <= lower)return;
        int j = _partition(lower,hight);
        sort(lower,j-1);
        sort(j+1,hight);
    }

    int _partition(int lower,int hight){
        int i = lower,j = hight+1;
        int temp = array[lower];
        while (true){
            i = _findNumberGreatThanTemp(i,temp);
            j = _findNumberLessThanTemp(j,temp);
            if(i >= j)break;
            exchange(i,j);
        }
        exchange(lower,j);
        return j;
    }
    int _findNumberLessThanTemp(int j,int temp){
        while (array[--j] > temp);
        return j;
    }
    int _findNumberGreatThanTemp(int i,int temp){
        while (array[++i] < temp);
        return i;
    }
}
