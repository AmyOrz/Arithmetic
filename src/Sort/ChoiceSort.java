package Sort;

public class ChoiceSort extends Sort{
    public ChoiceSort(int[] array){
        super(array);
    }
    public void sort(){
        for(int i = 0;i<len-1;i++){
            int min = i;
            for(int j = i+1;j<len;j++){
                if(lower(array[j],array[min])){
                    min = j;
                }
            }
            if(i != min){
                exchange(i,min);
            }
        }
    }
}
