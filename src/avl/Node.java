package avl;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: Node
 * Package: avl
 * Description:
 * ƽ������� ()
 * @Author jieHFUT
 * @Create 2024/11/3 19:58
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


    // ������ݣ�ͬʱ�����������
    // ����������һ���ڵ�󣬲����� AVL ��������Ҫ��ת
    public void add(Node toAdd) {

        if (value < toAdd.value) {
            // ������еĽڵ��Ҫ��ӵĽڵ�Ԫ��С
            // �������������Ƚ�
            if(this.right == null)
                this.right = toAdd;
            else
                this.right.add(toAdd);
        } else {
            // ������еĽڵ��Ҫ��ӵĽڵ�Ԫ�ش�
            // ���������Ƚ�
            if (this.left == null)
                this.left = toAdd;
            else
                this.left.add(toAdd);
        }
        // ��Ҫ����
        if (rightHeight() - leftHeight() > 1) {
            // ����������������� > �������������� => ��Ҫ�ȶ���������������
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
            }
            leftRotate();
            return;
        }
        // ��Ҫ����
        if (leftHeight() - rightHeight() > 1) {
            // ����������������� > �������������� => ��Ҫ�ȶ���������������
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
            }
            rightRotate();
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
     * ���ص�ǰ�ڵ�����ĸ߶�
     * @return
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * ���ص�ǰ�ڵ���������ĸ߶�
     * @return
     */
    public int leftHeight() {
        if (left == null) return 0;
        return left.height();
    }

    /**
     * ���ص�ǰ�ڵ��������ĸ߶�
     * @return
     */
    public int rightHeight() {
        if (right == null) return 0;
        return right.height();
    }


    /**
     * ����ת
     * ԭ���������ĸ߶� - �������߶� > 1
     */
    public void leftRotate() {
        Node newLeft = new Node(this.value);
        newLeft.left = left;
        newLeft.right = right.left;
        this.value = right.value;
        this.right = right.right;
        this.left = newLeft;
    }

    /**
     * ����ת
     * ԭ���������ĸ߶� - �������߶� > 1
     */
    public void rightRotate() {
        Node newRight = new Node(this.value);
        newRight.right = right;
        newRight.left = left.right;
        this.value = left.value;
        this.left = left.left;
        this.right = newRight;
    }

}
