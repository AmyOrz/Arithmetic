package UnionFind;

import utils.StdIn;
import utils.StdOut;

public class Test {
    public static void main(String[] args){
        int N = StdIn.readInt();
        UnionFind uf = new QuickUnion(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q)){
                continue;
            }
            uf.unionTwoNode(p,q);
            uf.showDatas();
            StdOut.println(p+":"+q);
        }
        StdOut.println(uf.count()+" component.");
    }
}
