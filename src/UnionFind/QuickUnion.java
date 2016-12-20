package UnionFind;
public class QuickUnion extends UnionFind{
    public QuickUnion(int nodeCount){
        super(nodeCount);
    }
    public void unionTwoNode(int first,int last){
        int fRoot = find(first);
        int lRoot = find(last);
        if(fRoot == lRoot)return;

        nodeIds[fRoot] = lRoot;

        nodeCount--;
    }
    public int find(int target){
        while(target != nodeIds[target]){
            target = nodeIds[target];
        }
        return target;
    }
    public boolean connected(int first,int last){
        return nodeIds[first] == nodeIds[last];
    }
}
