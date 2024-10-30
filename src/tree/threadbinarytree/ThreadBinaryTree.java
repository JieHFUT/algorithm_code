package tree.threadbinarytree;

import java.util.ArrayList;
import java.util.List;

public class ThreadBinaryTree {

    // 根节点
    private HeroNode root;
    private HeroNode prev; // 用来记录 node 的前驱节点的值
    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 编写对二叉树进行中序线索化的方法
    public void threadBinaryTree(HeroNode node) {
        if (node == null) return;
        // 遍历左子树
        threadBinaryTree(node.getLeft());
        // 遍历节点
        // 考虑节点 left
        if (node.getLeft() == null) {
            node.setLeft(prev);
            node.setLeftType(1);
        }
        // 考虑节点 right
        if (prev != null && prev.getRight() == null) {
            prev.setRight(node);
            prev.setRightType(1);
        }
        prev = node;
        // 遍历右子树
        threadBinaryTree(node.getRight());
    }
    // 遍历线索化二叉树
    public void threadTreeList() {
        HeroNode node = this.root;
        if (node == null) throw new RuntimeException("Tree is empty");
        while (node != null) {
            // 一直向左
            while (node.getLeft() != null)
                node = node.getLeft();
            // 已经到了最左边
            System.out.println(node);
            if (node.getLeftType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }

    }

    // 前序遍历
    public void preOrder() {
        if (root != null)
            root.preOrder();
        else
            System.out.println("tree is null");
    }

    // 中序遍历
    public void infixOrder() {
        if (root != null)
            root.infixOrder();
        else
            System.out.println("tree is null");
    }

    // 后序遍历
    public void postOrder() {
        if (root != null)
            root.postOrder();
        else
            System.out.println("tree is null");
    }


    // 前序 中序 后序 遍历查找
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


    // 前序存储二叉树
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

    // 线索化二叉树 [1,2,3,4,5,6] => infix[4,2,5,1,6,3] => 4,5,6,3 有空指针域
    //


}
