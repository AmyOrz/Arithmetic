package Find;

import utils.StdIn;
import utils.StdOut;

public class Test {
    public static void main(String[] args){
        STInterface<String,Integer> st = new SequentialSearchST<String,Integer>();
        for(int i = 0;!st.isEmpty();i++){
            String key = StdIn.readString();
            st.put(key,i);
        }
        for(String s :st.keys()){
            StdOut.println(s+"--"+st.get(s));
        }
    }
}
