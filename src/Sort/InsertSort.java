package Sort;
public class InsertSort extends Sort{
    public InsertSort(int[] array){
        super(array);
    }
    @Override
    void sort() {
        for(int i = 1;i<len;i++){
            for(int j = i;j>0 && array[j] < array[j-1];j--){
                exchange(j,j-1);
            }
        }
    }
}
