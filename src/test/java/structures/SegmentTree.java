package structures;

import java.util.function.BiFunction;

class SegmentTree<TYPE> {

    private final TYPE[] tree;
    private final int n;
    private final BiFunction<TYPE, TYPE, TYPE> merger;

    static <TYPE> SegmentTree<TYPE> fromArray(TYPE[] values, BiFunction<TYPE, TYPE, TYPE> merger) {
        return new SegmentTree<>(values, merger);
    }

    public TYPE query(int from, int to) {
        assert from >= 0 && from < n;
        assert to >= 0 && to < n;
        assert from <= to;

        return query(0, 0, n - 1, from, to);
    }

    @SuppressWarnings("unchecked") // tree is within the class => safe
    private SegmentTree(TYPE[] values, BiFunction<TYPE, TYPE, TYPE> merger) {
        n = values.length;
        tree = (TYPE[])new Object[4 * n];
        this.merger = merger;
        buildTree(values, 0, 0, n - 1);
    }

    private void buildTree(TYPE[] values, int index, int lo, int hi) {
        if (lo == hi) {
            tree[index] = values[lo];
            return;
        }
        int mid = lo + (hi - lo) / 2;
        buildTree(values, left(index), lo, mid);
        buildTree(values, right(index), mid + 1, hi);

        tree[index] = merger.apply(tree[left(index)], tree[right(index)]);
    }

    private TYPE query(int index, int lo, int hi, int from, int to) {
        if (lo > to || hi < from)
            return null;

        if (from <= lo && hi <= to)
            return tree[index];

        int mid = lo + (hi - lo) / 2;

        if (from > mid)
            return query(right(index), mid + 1, hi, from, to);
        else if (to <= mid)
            return query(left(index), lo, mid, from, to);

        TYPE left = query(left(index), lo, mid, from, mid);
        TYPE right = query(right(index), mid + 1, hi, mid + 1, to);

        return merger.apply(left, right);
    }

    private static int left(int index) {return 2 * index + 1;}

    private static int right(int index) {return 2 * index + 2;}
}
