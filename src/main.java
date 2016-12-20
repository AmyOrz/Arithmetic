import utils.Stopwatch;

public class main {
    public int Recursion(int target){
        if(target == 1)return 1;
        else{
            return Recursion(target-1)+target;
        }
    }
    public int getAccumulation(int target)
    {
        return (target+1)*target/2;
    }
    public static void  main(String[] args){
        //dataStructure.symbol.Symbol symbolInit = new dataStructure.symbol.Symbol();
       // Double result = symbolInit.getSymbolOperation("(1+(2*3))");
        Stopwatch timer = new Stopwatch();
        for(int i = 0 ;i<1000000;i++){
        }
        System.out.println(timer.elapsedTime());
    }
}
