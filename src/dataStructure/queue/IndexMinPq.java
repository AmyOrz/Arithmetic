package dataStructure.queue;
class IndexMinPQ<Key extends Comparable<Key>> {
    private int maxN;        // maximum number of elements on PQ
    private int n;           // number of elements on PQ
    private int[] heaps;        // 一级索引二叉堆
    private int[] heapIndexs;        // 索引数组，映射key数组索引对应pq二叉堆的位置
    private Key[] keys;      // 对象数组

    public IndexMinPQ(int maxN) {
        if (maxN < 0) throw new IllegalArgumentException();
        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];
        heaps = new int[maxN + 1];
        heapIndexs = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++)
            heapIndexs[i] = -1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        return heapIndexs[i] != -1;
    }

    public int size() {
        return n;
    }

    public void insert(int i, Key key) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        n++;
        heapIndexs[i] = n;
        heaps[n] = i;
        keys[i] = key;
        swim(n);
    }

    public int minIndex() {
        if (n == 0) return 0;
        return heaps[1];
    }

    public Key minKey() {
        if (n == 0) return null;
        return keys[heaps[1]];
    }

    public int delMin() {
        if (n == 0) return 0;
        int min = heaps[1];
        exch(1, n--);
        sink(1);
        assert min == heaps[n + 1];
        heapIndexs[min] = -1;        // delete
        keys[min] = null;    // to help with garbage collection
        heaps[n + 1] = -1;        // not needed
        return min;
    }

    public Key keyOf(int i) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        if (!contains(i)) return null;
        else return keys[i];
    }

    public void changeKey(int i, Key key) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        if (!contains(i)) return;
        keys[i] = key;
        swim(heapIndexs[i]);
        sink(heapIndexs[i]);
    }

    @Deprecated
    public void change(int i, Key key) {
        changeKey(i, key);
    }

    public void decreaseKey(int i, Key key) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        if (!contains(i)) return;
        if (keys[i].compareTo(key) <= 0)
            throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
        keys[i] = key;
        swim(heapIndexs[i]);
    }


    public void increaseKey(int i, Key key) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        if (!contains(i)) return;
        if (keys[i].compareTo(key) >= 0)
            throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
        keys[i] = key;
        sink(heapIndexs[i]);
    }

    public void delete(int i) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        if (!contains(i)) return;
        int index = heapIndexs[i];
        exch(index, n--);
        swim(index);
        sink(index);
        keys[i] = null;
        heapIndexs[i] = -1;
    }


    private boolean greater(int i, int j) {
        return keys[heaps[i]].compareTo(keys[heaps[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = heaps[i];
        heaps[i] = heaps[j];
        heaps[j] = swap;
        heapIndexs[heaps[i]] = i;
        heapIndexs[heaps[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}


