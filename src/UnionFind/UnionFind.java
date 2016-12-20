package UnionFind;

public abstract class UnionFind {
    protected int nodeCount;
    protected int[] nodeIds;
    public UnionFind(int nodeCount){
        this.nodeCount = nodeCount;
        nodeIds = new int[nodeCount];
        for(int i = 0;i<nodeCount;i++){
            nodeIds[i] = i;
        }
    }
    public int count() {
        return nodeCount;
    }
    public abstract void unionTwoNode(int first,int last);
    public abstract int find(int target);
    public abstract boolean connected(int first,int last);
}
