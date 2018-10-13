package com.minkov.app.trees;

import com.minkov.app.base.BinarySearchTreeBase;

import java.util.function.Consumer;

public class NaiveBinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeBase<T> {

    private TreeNode<T> root;

    public NaiveBinarySearchTree() {
        this.root = null;
    }

    @Override
    public void add(T value) {
        if (root == null) {
            root = new TreeNode<>(value);
        } else {
            addTraverse(root, value);
        }
    }

    private void addTraverse(TreeNode<T> node, T value) {
        // go left
        // x,compareTo(y):
        //  -: x < y
        //  0: x == y
        //  +: x > y
        if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode<>(value));
            } else {
                addTraverse(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new TreeNode<>(value));
            } else {
                addTraverse(node.getRight(), value);
            }
        }
    }

    @Override
    public boolean contains(T value) {
        if (root == null) {
            return false;
        }

        return containsTraverse(root, value);
    }

    private boolean containsTraverse(TreeNode<T> node, T value) {
        if (node == null) {
            return false;
        }

        if (value.compareTo(node.getValue()) == 0) {
            return true;
        } else if (value.compareTo(node.getValue()) < 0) {
            return containsTraverse(node.getLeft(), value);
        } else {
            return containsTraverse(node.getRight(), value);
        }
    }

    @Override
    public void remove(T value) {
        TreeNode<T> node = root;

        while (node != null) {
            if (value.compareTo(node.getValue()) == 0) {
                break;
            }

            if (value.compareTo(node.getValue()) < 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }

        if (node == null) {
            return;
        }

        TreeNode<T> replacementNode = node.getLeft();
        while (replacementNode.getRight() != null) {
            replacementNode = replacementNode.getRight();
        }
        // do the replacement

    }

    @Override
    public T search(T value) {
        return searchTraverse(root, value);
    }

    private T searchTraverse(TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.getValue()) == 0) {
            return node.getValue();
        } else if (value.compareTo(node.getValue()) < 0) {
            return searchTraverse(node.getLeft(), value);
        } else {
            return searchTraverse(node.getRight(), value);
        }
    }

    @Override
    public void traverse(Consumer<T> action) {
        preOrder(root, action);
    }

    private void inOrder(TreeNode<T> node, Consumer<T> action) {
        if (node.getLeft() != null) {
            inOrder(node.getLeft(), action);
        }

        // Action
        action.accept(node.getValue());

        if (node.getRight() != null) {
            inOrder(node.getRight(), action);
        }
    }

    private void preOrder(TreeNode<T> node, Consumer<T> action) {
        // Action
        action.accept(node.getValue());

        if (node.getLeft() != null) {
            preOrder(node.getLeft(), action);
        }


        if (node.getRight() != null) {
            preOrder(node.getRight(), action);
        }
    }

    private class TreeNode<T extends Comparable<T>> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T value) {
            setValue(value);
            setLeft(null);
            setRight(null);
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        public TreeNode<T> getRight() {
            return right;
        }

        public void setRight(TreeNode<T> right) {
            this.right = right;
        }
    }
}
