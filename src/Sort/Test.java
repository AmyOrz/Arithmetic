package Sort;

import utils.StdIn;
import utils.StdOut;
import utils.StdRandom;
import utils.Stopwatch;

public class Test {
    public static void main(String[] args){
        int N = StdIn.readInt();
        int[] array = new int[N];
        for(int i  = 0;i<N;i++){
            array[i] = StdRandom.uniform(N+10);
        }
        Stopwatch watch = new Stopwatch();
        Sort s = new HeapSort(array);
        s.sort();
        StdOut.println(watch.elapsedTime()+" second");
    }
}
