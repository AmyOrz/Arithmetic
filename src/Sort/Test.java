package Sort;

import utils.StdIn;
import utils.StdOut;
import utils.StdRandom;
import utils.Stopwatch;

public class Test {
    public static void main(String[] agrs){
        int N = StdIn.readInt();
        int[] array = new int[N];
        for(int i  = 0;i<N;i++){
            array[i] = StdRandom.uniform(N+10);
        }
        StdOut.println();
        Stopwatch watch = new Stopwatch();
        Sort s = new MergeSort(array);
        s.sort();
        StdOut.println(watch.elapsedTime()+" second");

        s.show();

        Stopwatch w = new Stopwatch();
        Sort s2 = new ChoiceSort(array);
        s2.sort();
        StdOut.println(w.elapsedTime()+"second");
        //s.show();

    }
}
