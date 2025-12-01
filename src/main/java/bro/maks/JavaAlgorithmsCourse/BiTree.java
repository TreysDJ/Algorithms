package bro.maks.JavaAlgorithmsCourse;

import java.util.Scanner;

public class BiTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BiTree tree = new BiTree();
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Stop")) {
                break;
            }
            if (command.equals("Insert")) {
                int x = scanner.nextInt();
                scanner.nextLine();
                tree.insert(x);
                System.out.println("Successfully");
            }
            if (command.equals("Search")) {
                int x = scanner.nextInt();
                scanner.nextLine();
                if (tree.contains(x)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
            if (command.equals("print")) {
                tree.print();
            }
            if (command.equals("destroy")) {
                tree.clear();
                System.out.println("Successfully");
            }
        }
    }

    private Node root = null;

    static class Node {
        int key;
        Node l;
        Node r;


        public Node(int key) {
            this.key = key;
            this.l = null;
            this.r = null;
        }
    }

    public void clear() {
        this.root = null;

    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insertRecursiveVoid(root, key);
        }
    }

    public boolean contains(int key) {
        return containsRecursive(root, key);
    }

    public void print() {
        printRecursive(root);
    }

    public void printRecursive(Node n) {
        if (n == null) {
            return;
        }
        printRecursive(n.l);

        System.out.println(n.key);

        printRecursive(n.r);
    }

    public void insertRecursiveVoid(Node n, int key) {
        if (key == n.key) {
            return;
        }
        if (key < n.key) {
            if (n.l != null) {
                insertRecursiveVoid(n.l, key);
            } else {
                n.l = new Node(key);
            }
        } else {
            if (n.r != null) {
                insertRecursiveVoid(n.r, key);
            } else {
                n.r = new Node(key);
            }
        }
    }

    public boolean containsRecursive(Node n, int key) {
        if (n == null) {
            return false;
        }
        if (key == n.key) {
            return true;
        }
        if (key > n.key) {
            return containsRecursive(n.r, key);
        } else {
            return containsRecursive(n.l, key);
        }
    }
}
