package bro.maks.JavaAlgorithmsCourse;

import java.util.Random;

public class Treap {

    public Treap() {

    }

    public static void main(String[] args) {

    }

    private static Random generator = new Random();

    private static class Node {
        int priority;
        int size;
        int value;
        int maxValue;
        Integer addValue;
        //int key;

        Node l;
        Node r;

        Node(int value) {
            this.value = value;
            this.maxValue = value;
            this.addValue = 0;
            this.l = null;
            this.r = null;
            this.priority = generator.nextInt();
            this.size = 1;
            //this.key = key;
        }
    }

    private Node root = null;

    public static int getSize(Node n) {
        if (n != null) {
            return n.size;
        } else {
            return 0;
        }
    }

    public static int getMaxValue(Node n) {
        if (n != null) {
            return n.maxValue + n.addValue;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private static void update(Node n) {
        if (n != null) {
            push(n);
            n.maxValue = Math.max(Math.max(getMaxValue(n.l), n.value), getMaxValue(n.r));
            n.size = getSize(n.l) + getSize(n.r) + 1;
        }
    }

    private static class SplitResult {
        Node left;
        Node right;

        public SplitResult(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }
    
    private static SplitResult split(Node n, int k) {
        if (n == null) {
            return new SplitResult(null, null);
        }
        push(n);
        if (getSize(n.l) >= k) {
            SplitResult result = split(n.l, k);
            n.l = result.right;
            update(n);
            return new SplitResult(result.left, n);
        } else {
            SplitResult result = split(n.r, k - getSize(n.l) - 1);
            n.r = result.left;
            update(n);
            return new SplitResult(n, result.right);
        }
    }

    static Node merge(Node a, Node b) {
        push(a);
        push(b);
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.priority > b.priority) {
            a.r = merge(a.r, b);
            update(a);
            return a;
        } else {
            b.l = merge(a, b.l);
            update(b);
            return b;
        }
    }

    static void push(Node n) {
        if (n == null || n.addValue == 0) {
            return;
        }

        n.value += n.addValue;
        n.maxValue += n.addValue;

        if (n.l != null) {
            n.l.addValue += n.addValue;
        }
        if (n.r != null) {
            n.r.addValue += n.addValue;
        }
        n.addValue = 0;
    }

    void pushBack(int value) {
        this.root = merge(this.root, new Node(value));
    }

    void pushFront(int value) {
        root = merge(new Node(value), this.root);
    }

    public void insert(int key, int value) {
        SplitResult result = split(root, key);
        Node node = new Node(value);
        Node mergeResult = merge(result.left, node);
        this.root = merge(mergeResult, result.right);
    }

// =========================ДОП МЕТОДЫ=======================================================================

    public int getValue(int index) {
        if (index >= 0 && index < getSize(root)) {
            return get(root, index);
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private int get(Node n, int index) {
        push(n);
        int leftSize = getSize(n.l);

        if (index == leftSize) {
            return n.value;
        }
        if (index < leftSize) {
            return get(n.l, index);
        } else {
            return get(n.r, index - leftSize - 1);
        }
    }

//    ==========FOR STANDART TREAP===================

//    private int keyByIndex(int index) {
//        return keyByIndex(this.root, index);
//    }
//
//    static int keyByIndex(Node n, int index) {
//        int leftSize = getSize(n.l);
//        if (index == leftSize) {
//            return n.key;
//        }
//        if (index < leftSize) {
//            return keyByIndex(n.l, index);
//        } else {
//            return keyByIndex(n.r, index - leftSize - 1);
//        }
//    }
//
//    private int indexByKey(int key) {
//        SplitResult parts = split(this.root, key);
//        int result = getSize(parts.left);
//        this.root = merge(parts.left, parts.right);
//        return result;
//    }

    public int rangeMax(int l, int r) {
        SplitResult firstSplit = split(root, l);
        SplitResult secondSplit = split(firstSplit.right, r - l + 1);
        int result = getMaxValue(secondSplit.left);
        Node merged = merge(secondSplit.left, secondSplit.right);
        this.root = merge(firstSplit.left, merged);
        return result;
    }

    public void rangeAdd(int l, int r, int value) {
        SplitResult firstSplit = split(this.root, l);
        SplitResult secondSplit = split(firstSplit.right, r - l + 1);
        Node rangeNode = secondSplit.left;
        if (rangeNode != null) {
            rangeNode.addValue += value;
        }
        this.root = merge(firstSplit.left, merge(rangeNode, secondSplit.right));
    }

    public void delete(int index) {
        SplitResult lessGreat = split(root, index);
        SplitResult equalGreate = split(lessGreat.right, 1);
        this.root = merge(lessGreat.left, equalGreate.right);
    }

    public void delete(int l, int r) {
        SplitResult lessGreat = split(root, l);
        SplitResult equalGreate = split(lessGreat.right, r - l + 1);
        this.root = merge(lessGreat.left, equalGreate.right);
    }

    public int size() {
        return getSize(this.root);
    }
}
