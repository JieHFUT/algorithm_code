package binarysorttree;

import javax.net.ssl.SSLContext;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: Node
 * Package: binarysorttree
 * Description:
 * ����������
 * @Author jieHFUT
 * @Create 2024/11/1 22:09
 * @Version 1.0
 */
public class Node implements Comparable<Node>{


    private int value;
    private Node left;
    private Node right;


    public Node(int value) { this.value = value; }
    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
    public Node getLeft() { return left;}
    public void setLeft(Node left) { this.left = left; }
    public Node getRight() { return right; }
    public void setRight(Node right) { this.right = right; }


    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    public void preOrder(Node root) {
        System.out.println(root);
        if (root.left != null)
            preOrder(root.left);
        if (root.right != null)
            preOrder(root.right);
    }


    // �������ݣ�ͬʱ�����������
    public void add(Node toAdd) {
        if (this.compareTo(toAdd) < 0) {
            // ������еĽڵ��Ҫ���ӵĽڵ�Ԫ��С
            // �������������Ƚ�
            if(this.right == null)
                this.right = toAdd;
            else
                this.right.add(toAdd);
        } else {
            // ������еĽڵ��Ҫ���ӵĽڵ�Ԫ�ش�
            // ���������Ƚ�
            if (this.left == null)
                this.left = toAdd;
            else
                this.left.add(toAdd);
        }
    }


    // �������
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(this);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    /**
     * ����ֵ���ҵ��ڵ㣬���û���ҵ��ͷ��� null
     * @param value
     * @return
     */
    public Node search(int value) {
        return search(this, value);
    }
    public Node search(Node node, int value) {
        // 1. ���Ҫ�ҵ�ֵ���ڸýڵ���
        if (node.value == value) return node;
        // 2. ���Ҫ�ҵ�ֵ�ȸýڵ��ֵ������ҵݹ飬���������ݹ�
        if (node.value > value) {
            if (node.left != null)
                return search(node.left, value);
            else
                return null;
        } else {
            if (node.right != null)
                return search(node.right, value);
            else
                return null;
        }
    }

    /**
     * ���Ҹýڵ�ĸ��׽ڵ㣬û�и��ڵ����û���ҵ��ýڵ�ͷ��� null
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (this.value == value) return null;

        if (this.left != null && this.left.value == value) {
            // �ýڵ�����ӽڵ���� target
            return this;
        } else if (this.right != null && this.right.value == value) {
            // �ýڵ�����ӽڵ���� target
            return this;
        } else {
            // �ýڵ���ӽڵ㲻��Ҫ�ҵĽڵ㣬����Ѱ��
            if (this.value > value && this.left != null) {
                return this.left.searchParent(value);
            } else if (this.value <= value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }



}