package com.minkov.app.trees;

public class Tree<T> {
    // Head from LinkedList
    TreeNode<T> root;

    public Tree() {
        root = null;
    }

    void add(T value) {
        if (root == null) {
            root = new TreeNode<>(value);
        } else {
            root.children[0] = new TreeNode<>(value);
        }
    }

    void dfs(TreeNode<T> node) {
        for (TreeNode<T> child : node.children) {
            dfs(child);
        }

        // Action step
        System.out.println(node.value);
    }

    class TreeNode<T> {
        T value;

        // prev from LinkedList
        TreeNode<T> parent;

        // next from LinkedList
        TreeNode<T>[] children;

        public TreeNode(T value) {
            this.value = value;
        }
    }
}
