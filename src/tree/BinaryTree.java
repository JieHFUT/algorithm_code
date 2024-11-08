package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    // ���ڵ�
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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

    // ������������ [1,2,3,4,5,6] => infix[4,2,5,1,6,3] => 4,5,6,3 �п�ָ����
    // ���� thread_binary_tree



    // ��ȡ���нڵ�ĸ���
    public int nodeOfNumber() {
        return this.nodeOfNumber(this.root);
    }
    public int nodeOfNumber(HeroNode node) {
        if (node == null) return 0;
        return 1 + nodeOfNumber(node.getLeft()) + nodeOfNumber(node.getRight());
    }
    // ��ȡҶ�ӽڵ�ĸ���
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
    // ��ȡ��K��ڵ�ĸ���
    public int getKLeaveOfNumber(int k) {
        return getKLeaveOfNumber(this.root, k);
    }
    public int getKLeaveOfNumber(HeroNode node, int k) {
        if (node == null) return 0;
        if (k == 1 && node != null) return 1;
        return getKLeaveOfNumber(node.getLeft(), k - 1) + getKLeaveOfNumber(node.getRight(), k - 1);
    }
    // ��ȡ�������ĸ߶�
    public int height() {
        return height(this.root);
    }
    public int height(HeroNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }
    // �����no��Ԫ���Ƿ����
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
    // �������(1.����  2.�ǵݹ�)
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


    // �ж�һ�����ǲ�����ȫ������ ��Ҷ���ֻ�ܳ�������ײ�����㣬����ײ�Ҷ�������ڴεײ�Ҷ�������
    public boolean isCompleteTree() {
        // �������һֱ�Žڵ㣬ֱ�����ֵ�һ���սڵ�
        HeroNode node = this.root;
        Queue<HeroNode> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            // �Ӷ������ó��ڵ�
            HeroNode top = queue.poll();
            if (top != null) {
                queue.add(top.getLeft());
                queue.add(top.getRight());
            } else {
                // �����һ����ȫ�����������ŵ�������Ӧ���� node node node ... node node null null null ... null
                // �� node ֮�䲻�ᴩ�� null
                break;
            }
        }
        // ���������ʣ�µĲ�ȫ�� null����˵���䲻����ȫ������
        while (!queue.isEmpty()) {
            HeroNode top = queue.poll();
            if (top != null) {
                return false;
            }
        }
        return true;
    }






    // �ж��������Ƿ���ͬ
    public boolean isSameTree(HeroNode otherRoot) {
        HeroNode thisRoot = this.root;
        HeroNode otherRoot2 = otherRoot;
        return isSameTree(thisRoot, otherRoot2);
    }
    public boolean isSameTree(HeroNode thisRoot, HeroNode otherRoot) {
        if (thisRoot == null && otherRoot == null) return true;
        if (thisRoot == null) return false;
        if (otherRoot == null) return false;
        // ����������ڵ��ֵ��һ��
        if (!thisRoot.getName().equals(otherRoot.getName())) return false;
        // �������ڵ��ֵһ�����Ƚ��ӽڵ�
        if (!isSameTree(thisRoot.getLeft(), otherRoot.getLeft())) return false;
        if (!isSameTree(thisRoot.getRight(), otherRoot.getRight())) return false;
        return true;
    }






    // �ж�һ�����Ƿ��������һ����
    public boolean isSubTree(HeroNode otherRoot) {
        HeroNode thisRoot = this.root;
        HeroNode otherRoot2 = otherRoot;
        return isSubTree(thisRoot, otherRoot2);
    }
    public boolean isSubTree(HeroNode thisRoot, HeroNode otherRoot) {


        return true;
    }
    // �ж��Ƿ��Ǹ߶�ƽ��Ķ�����(2 functions)
    public boolean isBalanceTree() {
        return false;
    }
    // �ж�һ�Ŷ������Ƿ���Գ�
    public boolean isSymmetricTree() {
        return false;
    }
    // ��һ������ÿһ���ڵ�����ҽڵ��ָ�򷴹���(2 functions)
    public void turnOneTree() {

    }
    // �ҵ�����ָ���ڵ�����Ĺ�������
    public static HeroNode lowestCommonAncestor(HeroNode p, HeroNode q) {
        return null;
    }


}
