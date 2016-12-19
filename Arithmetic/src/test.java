import java.util.Iterator;

public class test {
    public static void main(String[] args){
        stack<String> stackInit = new stack<String>();
        stackInit.push("1");
        stackInit.push("2");
        stackInit.push("3");
        stackInit.push("4");
        stackInit.push("5");

        stackInit.convert();
        Iterator iter = stackInit.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
