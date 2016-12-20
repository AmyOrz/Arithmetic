package UnionFind;

import utils.StdOut;

public class QuickFind extends UnionFind{

    public QuickFind(int nodeCount){
        super(nodeCount);
    }

    public void unionTwoNode(int first,int last){
        int fId = find(first);
        int lId = find(last);
        if(fId == lId)return;

        for(int i = 0;i<nodeIds.length;i++){
            if(nodeIds[i] == fId){
                nodeIds[i] = lId;
            }
        }
        nodeCount--;
    }
    public int find(int target){
        return nodeIds[target];
    }
    public boolean connected(int first,int last){
        return nodeIds[first] == nodeIds[last];
    }

}
