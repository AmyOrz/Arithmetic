package UnionFind;
public class QuickUnion extends UnionFind{
    private int[] size;

    public QuickUnion(int nodeCount){
        super(nodeCount);
        size = new int[nodeCount];
        for(int i = 0;i<nodeCount;i++){
            size[i] = 1;
        }
    }
    public void unionTwoNode(int first,int last){
        int firstRoot = find(first);
        int lastRoot = find(last);
        if(firstRoot == lastRoot)return;

        if(size[firstRoot] < size[lastRoot]){
            nodeIds[firstRoot] = lastRoot;
            size[lastRoot] += size[firstRoot];
        }else{
            nodeIds[lastRoot] = firstRoot;
            size[firstRoot] += size[lastRoot];
        }
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
