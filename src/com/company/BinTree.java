package com.company;

class Node<T1, T2>{
    T1 key;
    T2 value;
    Node<T1, T2> left;
    Node<T1, T2> right;

    Node(T1 key, T2 value){
        this.key = key;
        this.value = value;
        right = null;
        left = null;
    }

    @Override
    public String toString(){
        return "(" + this.key + ", " + this.value + ") ";
    }
}

public class BinTree<T1 extends Comparable<T1>, T2 extends Comparable<T2>> {
    Node<T1, T2> root;

    BinTree(T1 key, T2 value) {
        root = new Node(key, value);
    }

    BinTree() {
        root = null;
    }

    public void add(T1 key, T2 value) {
        Node<T1, T2> r = root, curVer = null;
        Node<T1, T2> anotherNode = new Node<T1, T2>(key, value);
        while (r != null) {
            int cmpRes = key.compareTo(r.key);
            if (cmpRes == 0) {
                r.value = value;
                return;
            } else {
                curVer = r;
                if (cmpRes >= 0) r = r.right;
                else r = r.left;
            }
        }
        if (curVer == null) root = anotherNode;
        else {
            if (key.compareTo(curVer.key) < 0) curVer.left = anotherNode;
            else curVer.right = anotherNode;
        }
    }

    public void remove(T1 key){
        Node<T1, T2> r = root, curVer = null;
        while (r != null) {
            int cmpRes = key.compareTo(r.key);
            if (cmpRes == 0) break;
            else {
                curVer = r;
                if (cmpRes >= 0) r = r.right;
                else r = r.left;
            }
        }
        if(r == null) return;
        if(r.right == null){
            if(curVer == null) root = r.left;
            else{
                if(r == curVer.left) curVer.left = r.left;
                else curVer.right = r.left;
            }
        }
        else{
            curVer = null;
            Node<T1, T2> n = r.right;
            while(n.left != null){
                curVer = n;
                n = n.left;
            }
            if(curVer != null) curVer.left = n.right;
            else r.right = n.right;
            r.key = n.key;
            r.value = n.value;
        }
    }

    public Node<T1, T2> minV(Node<T1, T2> root){
        return root.left == null ? root : minV(root.left);
    }

    public Node<T1, T2> maxV(Node<T1, T2> root){
        return root.right == null ? root : maxV(root.right);
    }

    public T2 getValue(T1 key) {
        Node<T1, T2> r = root;
        while (r != null) {
            int cmpRes = key.compareTo(r.key);
            if (cmpRes == 0) return r.value;
            else if (cmpRes >= 0) r = r.right;
            else r = r.left;
        }
        return null;
    }
}
