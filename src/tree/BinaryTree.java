package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        return getKLeaveOfNumber(this.root, k);
    }
    public int getKLeaveOfNumber(HeroNode node, int k) {
        if (node == null) return 0;
        if (k == 1 && node != null) return 1;
        return getKLeaveOfNumber(node.getLeft(), k - 1) + getKLeaveOfNumber(node.getRight(), k - 1);
    }
    // 获取二叉树的高度
    public int height() {
        return height(this.root);
    }
    public int height(HeroNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }
    // 检测编号no的元素是否存在
    public HeroNode findByNo(int no) {
        return this.findByNo(this.root, no);
    }
    public HeroNode findByNo(HeroNode node, int no) {
        if (node == null) return null;
        if (node.getNo() == no) return node;
        if (findByNo(node.getLeft(), no) != null)
            return findByNo(node.getLeft(), no);
        if (findByNo(node.getRight(), no) != null)
            return findByNo(node.getRight(), no);
        return null;
    }
    // 层序遍历(1.队列  2.非递归)
    public void levelOrderByQueue() {
        Queue<HeroNode> queue = new LinkedList<>();
        HeroNode node = this.root;
        if (node == null) return;
        queue.add(node);
        while(true) {
            if (queue.isEmpty())
                break;
            HeroNode top = queue.peek();
            System.out.println(queue.poll());
            if (top.getLeft() != null)
                queue.add(top.getLeft());
            if (top.getRight() != null)
                queue.add(top.getRight());
        }

    }
    public List<List<HeroNode>> levelOrderByList() {
        return levelOrderByList(this.root);
    }
    public List<List<HeroNode>> levelOrderByList(HeroNode node) {
        List<List<HeroNode>> result = new ArrayList<>();
        List<HeroNode> firstLevel = new ArrayList<>();
        firstLevel.add(node);
        result.add(firstLevel);
        int level = 0;

        while (true) {
            List<HeroNode> toFind = result.get(level);
            List<HeroNode> nextLevel = new ArrayList<>();
            for (HeroNode n : toFind) {
                if (n.getLeft() != null)
                    nextLevel.add(n.getLeft());
                if (n.getRight() != null)
                    nextLevel.add(n.getRight());
            }
            level++;
            if (nextLevel.isEmpty())
                break;
            result.add(nextLevel);
        }
        return result;
    }


    // 判断一棵树是不是完全二叉树 ：叶结点只能出现在最底层的两层，且最底层叶结点均处于次底层叶结点的左侧
    public boolean isCompleteTree() {
        // 向队列中一直放节点，直到出现第一个空节点
        HeroNode node = this.root;
        Queue<HeroNode> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            // 从队列中拿出节点
            HeroNode top = queue.poll();
            if (top != null) {
                queue.add(top.getLeft());
                queue.add(top.getRight());
            } else {
                // 如果是一个完全二叉树，被放到队列里应该是 node node node ... node node null null null ... null
                // 在 node 之间不会穿插 null
                break;
            }
        }
        // 如果队列中剩下的不全是 null，就说明其不是完全二叉树
        while (!queue.isEmpty()) {
            HeroNode top = queue.poll();
            if (top != null) {
                return false;
            }
        }
        return true;
    }






    // 判断两棵树是否相同
    public boolean isSameTree(HeroNode otherRoot) {
        HeroNode thisRoot = this.root;
        HeroNode otherRoot2 = otherRoot;
        return isSameTree(thisRoot, otherRoot2);
    }
    public boolean isSameTree(HeroNode thisRoot, HeroNode otherRoot) {
        if (thisRoot == null && otherRoot == null) return true;
        if (thisRoot == null) return false;
        if (otherRoot == null) return false;
        // 如果这两个节点的值不一样
        if (!thisRoot.getName().equals(otherRoot.getName())) return false;
        // 这两个节点的值一样，比较子节点
        if (!isSameTree(thisRoot.getLeft(), otherRoot.getLeft())) return false;
        if (!isSameTree(thisRoot.getRight(), otherRoot.getRight())) return false;
        return true;
    }






    // 判断一棵树是否包含另外一棵树
    public boolean isSubTree(HeroNode otherRoot) {
        HeroNode thisRoot = this.root;
        HeroNode otherRoot2 = otherRoot;
        return isSubTree(thisRoot, otherRoot2);
    }
    public boolean isSubTree(HeroNode thisRoot, HeroNode otherRoot) {
        if (thisRoot == null) return false;
        if (isSameTree(thisRoot, otherRoot)) return true;
        return isSubTree(thisRoot.getLeft(), otherRoot.getLeft()) || isSubTree(thisRoot.getRight(), otherRoot.getRight());
    }



    // 判断是否是高度平衡的二叉树(2 functions)
    // 高度平衡就是说一个节点的两颗子树的高度差不大于1，并且其两颗子树也是高度平衡的二叉树
    public boolean isBanlanceTree(HeroNode thisRoot) {

        return true;
    }
    // 判断是否是高度平衡的二叉树(第二种方法)
    public boolean isBanlanceTree2(HeroNode thisRoot) {
        if (thisRoot == null) return false;
        // 获取其两颗子树的高度
        int leftHeight = height(thisRoot.getLeft());
        int rightHeight = height(thisRoot.getRight());
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        boolean left = false;
        boolean right = false;
        if (thisRoot.getLeft() != null) {
            left = isBanlanceTree2(thisRoot.getLeft());
        }
        if (thisRoot.getRight() != null) {
            right = isBanlanceTree2(thisRoot.getRight());
        }
        return left && right;
    }




    // 判断一颗二叉树是否轴对称
    public boolean isSymmetricTree(HeroNode thisRoot) {
        // 思路：将其一颗子树的左右全部反过来，如果反过来的子树和另外一颗子树是相同的树 => 轴对称
        if (thisRoot == null) return false;
        // 将其右子树反过来
        turnOneTree(thisRoot.getRight());
        boolean flag = isSameTree(thisRoot.getLeft(), thisRoot.getRight());
        if (flag)
            return true;
        return false;
    }
    public boolean isSymmetricTree(HeroNode left, HeroNode right) {
        // 一棵树的左右子树
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (!left.getName().equals(right.getName())) return false;
        return isSameTree(left.getLeft(),right.getRight()) && isSameTree(left.getRight(), right.getLeft());
    }






    // 将一棵树的每一个节点的左右节点的指向反过来(2 functions)
    public void turnOneTree(HeroNode thisRoot) {
        if (thisRoot == null) return;
        swap(thisRoot);
        if (thisRoot.getLeft() != null) turnOneTree(thisRoot.getLeft());
        if (thisRoot.getRight() != null) turnOneTree(thisRoot.getRight());
    }
    public void swap(HeroNode node) {
        HeroNode temp = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(temp);
    }





    // 找到两个指定节点最近的公共祖先
    public static HeroNode lowestCommonAncestor(HeroNode root, HeroNode p, HeroNode q) {
        // 思路一：找到通往这两个节点的路径，然后对路径进行比对
        // 思路二：

        return null;
    }


}