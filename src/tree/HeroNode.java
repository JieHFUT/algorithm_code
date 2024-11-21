package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 树的节点
public class HeroNode {

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public HeroNode getRight() {
        return right;
    }
    public void setRight(HeroNode right) {
        this.right = right;
    }
    public HeroNode getLeft() {
        return left;
    }
    public void setLeft(HeroNode left) {
        this.left = left;
    }


    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }





    // 前序遍历的方法
    public void preOrder() {
        // 先输出父亲节点
        System.out.println(this);
        if (left != null)
            left.preOrder();
        if (right != null)
            right.preOrder();
    }

    // 中序遍历的方法
    public void infixOrder() {
        if (left != null)
            left.infixOrder();
        System.out.println(this);
        if (right != null)
            right.infixOrder();
    }

    // 后序遍历的方法
    public void postOrder() {
        if (left != null)
            left.postOrder();
        if (right != null)
            right.postOrder();
        System.out.println(this);
    }


    // 前序 中序 后序 三种查找方法
    public HeroNode preSearch(int toFind) {
        System.out.println("in preSearch");
        if (toFind == this.getNo()) return this;
        // 左、右递归
        HeroNode result = null;
        if (this.left != null)
            result = this.left.preSearch(toFind);
        if (result != null) return result;
        if (this.right != null)
            result = this.right.preSearch(toFind);
        if (result != null) return result;
        return result;
    }

    public HeroNode infixSearch(int toFind) {
        System.out.println("in infixSearch");
        HeroNode result = null;
        if (this.left != null)
            result =  this.left.infixSearch(toFind);
        if (result != null) return result;
        if (toFind == this.getNo()) return this;
        if (this.right != null)
            result =  this.right.infixSearch(toFind);
        if (result != null) return result;
        return result;
    }

    public HeroNode postSearch(int toFind) {
        System.out.println("in postSearch");
        HeroNode result = null;
        if (this.left != null)
            result =  this.left.postSearch(toFind);
        if (result != null) return result;
        if (this.right != null)
            result = this.right.postSearch(toFind);
        if (result != null) return result;
        if (toFind == this.getNo()) return this;
        return result;
    }


    // 二叉树的节点删除，如果删除的是叶子节点，则删除该节点
    // 如果要删除的是非叶子节点，直接删除该子树
    //                      => 即如果某个节点的左子节点不为空，并且左子节点就是要删除的节点，就删除左子树，return
    //                      => 即如果某个节点的右子节点不为空，并且右子节点就是要删除的节点，就删除左子树，return
    //                      => 如果左右节点都没有满足上述条件，就需要递归左右子树
    //                      => 如果树只有 root 节点，就将这个树置空
    //                      => 如果找不到要删除的节点，就直接 return
    public void deleteByNo(int no) {

        if (this.getLeft() != null && this.getLeft().getNo() == no) {
            this.setLeft(null);
            return;
        }
        if (this.getRight() != null && this.getRight().getNo() == no) {
            this.setRight(null);
            return;
        }
        // 递归
        if (this.getLeft() != null)
            this.getLeft().deleteByNo(no);
        if (this.getRight() != null)
            this.getRight().deleteByNo(no);
    }

    // 顺序存储二叉树
    // 要求二叉树的节点以数组的方式来存放，但是在遍历数组的时候仍然可以按照树的前，中，后序遍历
    // 二叉树按照第一个为 0 编号
    // 第 n 个元素的左子节点是 2*n+1
    // 第 n 个元素的右子节点是 2*n+2
    // 第 n 个元素的父亲节点是 (n-1)/2




}
