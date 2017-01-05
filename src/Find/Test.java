package Find;

import utils.StdIn;
import utils.StdOut;

import java.util.TreeMap;

public class Test {
    public static void main(String[] args){
        BinarySearchTree<String,Integer> st = new BinarySearchTree<>();
        for(int i = 0;i<6;i++){
            String key = StdIn.readString();
            st.put(key,i);
        }
        StdOut.print(st.get("a"));
        StdOut.print(st.get("q"));
        StdOut.print(st.min());
        StdOut.print(st.max());
        TreeMap
    }
}
