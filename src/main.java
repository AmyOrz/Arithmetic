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
        //Symbol symbolInit = new Symbol();
       // Double result = symbolInit.getSymbolOperation("(1+(2*3))");

        int[] a =  new int[10000000];
        int sum = 0;
        Stopwatch timer = new Stopwatch();
        for(int i = 0 ;i<10000000;i++){
            a[i] = i;
            sum += a[i];
        }
        System.out.println(timer.elapsedTime());
    }
}
