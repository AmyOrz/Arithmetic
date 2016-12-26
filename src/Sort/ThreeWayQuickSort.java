package Sort;

/**
 * 3 way quick sort.resolve a most of repeat number
 */
public class ThreeWayQuickSort extends Sort{
    public ThreeWayQuickSort(int[] array){
        super(array);
    }

    @Override
    void sort() {
        sort(0,len-1);
    }
    void sort(int lower,int hight){
        if(hight <= lower)return;

        int lt = lower;
        int i = lower + 1;
        int gt = hight;
        int temp = array[lower];

        while (i <= gt){
            int cmp = compareTo(array[i],temp);
            if(cmp < 0)exchange(lt++,i++);
            else if(cmp > 0)exchange(i,gt--);
            else i++;
        }
        sort(lower,lt-1);
        sort(gt+1,hight);
    }
}
