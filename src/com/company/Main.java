package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        BinTree bt = new BinTree();
        bt.add(8, 2);
        bt.add(4, 5);
        bt.add(12, 4);
        bt.add(10, 12);
        bt.add(15, 10);
        bt.add(11, 20);
        bt.add(14, 1);
        bt.add(9, 7);
        bt.add(1, 8);
        bt.add(5, 6);
        System.out.println("Вершина с минимальным ключом: " + bt.minV(bt.root));
        System.out.println("Вершина с максимальным ключом: " + bt.maxV(bt.root));
        System.out.println("Вывод всех вершин обходом в глубину (прямым обходом):");
        DFS(bt);
        bt.remove(10);
        System.out.println("Вывод всех вершин прямым обходом:");
        DFS(bt);
        System.out.println("Вывод всех вершин обходом в ширину:");
        BFS(bt);
    }

    static void DFS(BinTree bt){
        if(bt.root == null) return;
        Stack<Node> st = new Stack<Node>();
        st.push(bt.root);
        while(!st.empty()){
            Node nd = st.peek();
            st.pop();
            System.out.println(nd);
            if(nd.right != null) st.push(nd.right);
            if(nd.left != null) st.push(nd.left);
        }
    }

    static void BFS(BinTree bt){
        if(bt.root == null) return;
        Node v = bt.root;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(v);
        while(!queue.isEmpty()){
            Node q = queue.peek();
            System.out.println(q);
            queue.remove();
            if(q.left != null) queue.add(q.left);
            if(q.right != null) queue.add(q.right);
        }
    }
}
