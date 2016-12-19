import java.util.LinkedList;
import java.util.Stack;

public class Symbol {
    private Stack<String> symbolStack = new Stack<String>();
    private Stack<Double>  valueStack = new Stack<Double>();
    public Double getSymbolOperation(String symbolString){
        for(int i = 0;i<symbolString.length();i++){
            String str = symbolString.substring(i,i+1);
            if(str.equals("+")) symbolStack.push("+");
            else if(str.equals("-")) symbolStack.push(str);
            else if(str.equals("*")) symbolStack.push(str);
            else if(str.equals("/")) symbolStack.push(str);
            else if(str.equals(")")){
                Double Value = valueStack.pop();
                String strInStackTop = symbolStack.pop();
                if(strInStackTop.equals("+"))Value = valueStack.pop() + Value;
                else if(strInStackTop.equals("-"))Value = valueStack.pop() - Value;
                else if(strInStackTop.equals("*"))Value = valueStack.pop() * Value;
                else if(strInStackTop.equals("/"))Value = valueStack.pop() / Value;

                valueStack.push(Value);
            }else if(!str.equals("(")){
                valueStack.push(Double.parseDouble(str));
            }
        }
        return valueStack.pop();
    }
}
