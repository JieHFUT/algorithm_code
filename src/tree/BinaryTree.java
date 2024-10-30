package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    // 根节点
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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
    public static List<HeroNode> preOrderToList(HeroNode[] array) {
        return preOrderToList(array, 0);
    }

    public static List<HeroNode> preOrderToList(HeroNode[] array, int index) {
        if (array == null || array.length == 0)
            throw new RuntimeException("array is null or empty");
        List<HeroNode> list = new ArrayList<>();

        list.add(array[index]);

        if (index * 2 + 1 < array.length) {
            List<HeroNode> leftList = preOrderToList(array, index * 2 + 1);
            list.addAll(leftList);
        }
        if (index * 2 + 2 < array.length) {
            List<HeroNode> rightList = preOrderToList(array, index * 2 + 2);
            list.addAll(rightList);
        }
        return list;
    }

    // 线索化二叉树 [1,2,3,4,5,6] => infix[4,2,5,1,6,3] => 4,5,6,3 有空指针域
    // 见包 thread_binary_tree



    // 获取树中节点的个数
    public int nodeOfNumber() {
        return this.nodeOfNumber(this.root);
    }
    public int nodeOfNumber(HeroNode node) {
        if (node == null) return 0;
        return 1 + nodeOfNumber(node.getLeft()) + nodeOfNumber(node.getRight());
    }
    // 获取叶子节点的个数
    public int getLeaveOfNumber() {
        return this.getLeaveOfNumber(this.root);
    }
    public static int leaveOfNumber;
    public int getLeaveOfNumber(HeroNode node) {
        if (node == null) return leaveOfNumber;
        if (node.getLeft() == null && node.getRight() == null) leaveOfNumber++;
        getLeaveOfNumber(node.getLeft());
        getLeaveOfNumber(node.getRight());
        return leaveOfNumber;
    }
    public int getLeaveOfNumber2(HeroNode node) {
        if (node == null) return 0;
        if (node.getLeft() == null && node.getRight() == null) return 1;
        return getLeaveOfNumber2(node.getLeft()) +
                getLeaveOfNumber2(node.getRight());
    }
    // 获取第K层节点的个数
    public int getKLeaveOfNumber(int k) {
        
        return 0;
    }
    // 获取二叉树的高度
    public int height() {
        return 0;
    }
    // 检测编号no的元素是否存在
    public HeroNode findByNo(int no) {
        return null;
    }
    // 层序遍历(1.递归  2.非递归)
    public void levelOrder() {

    }
    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree() {
        return false;
    }
    // 判断两棵树是否相同
    public boolean isSameTree(HeroNode otherRoot) {
        return false;
    }
    // 判断一棵树是否包含另外一棵树
    public boolean isSubTree(HeroNode otherRoot) {
        return false;
    }
    // 判断是否是高度平衡的二叉树(2 functions)
    public boolean isBalanceTree() {
        return false;
    }
    // 判断一颗二叉树是否轴对称
    public boolean isSymmetricTree() {
        return false;
    }
    // 将一棵树的每一个节点的左右节点的指向反过来(2 functions)
    public void turnOneTree() {

    }
    // 找到两个指定节点最近的公共祖先
    public static HeroNode lowestCommonAncestor(HeroNode p, HeroNode q) {
        return null;
    }


}
