package Find;

import utils.StdIn;
import utils.StdOut;

public class Test {
    public static void main(String[] args){
        BinarySearchTree<String,Integer> st = new BinarySearchTree<>();
        for(int i = 0;i<9;i++){
            String key = StdIn.readString();
            st.put(key,i);
        }
        st.preShow();

        StdOut.println("fck:"+st.select(4));
    }
}
