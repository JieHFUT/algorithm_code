package tree.threadbinarytree;

import java.util.ArrayList;
import java.util.List;

public class ThreadBinaryTree {

    // ���ڵ�
    private HeroNode root;
    private HeroNode prev; // ������¼ node ��ǰ���ڵ��ֵ
    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // ��д�Զ��������������������ķ���
    public void threadBinaryTree(HeroNode node) {
        if (node == null) return;
        // ����������
        threadBinaryTree(node.getLeft());
        // �����ڵ�
        // ���ǽڵ� left
        if (node.getLeft() == null) {
            node.setLeft(prev);
            node.setLeftType(1);
        }
        // ���ǽڵ� right
        if (prev != null && prev.getRight() == null) {
            prev.setRight(node);
            prev.setRightType(1);
        }
        prev = node;
        // ����������
        threadBinaryTree(node.getRight());
    }
    // ����������������
    public void threadTreeList() {
        HeroNode node = this.root;
        if (node == null) throw new RuntimeException("Tree is empty");
        while (node != null) {
            // һֱ����
            while (node.getLeft() != null)
                node = node.getLeft();
            // �Ѿ����������
            System.out.println(node);
            if (node.getLeftType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }

    }

    // ǰ�����
    public void preOrder() {
        if (root != null)
            root.preOrder();
        else
            System.out.println("tree is null");
    }

    // �������
    public void infixOrder() {
        if (root != null)
            root.infixOrder();
        else
            System.out.println("tree is null");
    }

    // �������
    public void postOrder() {
        if (root != null)
            root.postOrder();
        else
            System.out.println("tree is null");
    }


    // ǰ�� ���� ���� ��������
    public HeroNode preSearch(int toFind) {
        if (root != null)
            return this.root.preSearch(toFind);
        throw new RuntimeException("tree is null");
    }
    public HeroNode infixSearch(int toFind) {
        if (root != null)
            return this.root.infixSearch(toFind);
        throw new RuntimeException("tree is null");
    }
    public HeroNode postSearch(int toFind) {
        if (root != null)
            return this.root.postSearch(toFind);
        throw new RuntimeException("tree is null");
    }

    // delete node
    public void deleteByNo(int no) {
        if (this.root == null)
            throw new RuntimeException("tree is null");
        if (this.root.getNo() == no) {
            this.root = null;
            return;
        }
        this.root.deleteByNo(no);
    }


    // ǰ��洢������
    public static List<tree.HeroNode> preOrderToList(tree.HeroNode[] array) {
        return preOrderToList(array, 0);
    }

    public static List<tree.HeroNode> preOrderToList(tree.HeroNode[] array, int index) {
        if (array == null || array.length == 0)
            throw new RuntimeException("array is null or empty");
        List<tree.HeroNode> list = new ArrayList<>();

        list.add(array[index]);

        if (index * 2 + 1 < array.length) {
            List<tree.HeroNode> leftList = preOrderToList(array, index * 2 + 1);
            list.addAll(leftList);
        }
        if (index * 2 + 2 < array.length) {
            List<tree.HeroNode> rightList = preOrderToList(array, index * 2 + 2);
            list.addAll(rightList);
        }
        return list;
    }

    // ������������ [1,2,3,4,5,6] => infix[4,2,5,1,6,3] => 4,5,6,3 �п�ָ����
    //


}
