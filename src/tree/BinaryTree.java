package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    // ?????
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    // ??????
    public void preOrder() {
        if (root != null)
            root.preOrder();
        else
            System.out.println("tree is null");
    }

    // ???????
    public void infixOrder() {
        if (root != null)
            root.infixOrder();
        else
            System.out.println("tree is null");
    }

    // ???????
    public void postOrder() {
        if (root != null)
            root.postOrder();
        else
            System.out.println("tree is null");
    }


    // ??? ???? ???? ????????
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


    // ???洢??????
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

    // ???????????? [1,2,3,4,5,6] => infix[4,2,5,1,6,3] => 4,5,6,3 ?п??????
    // ???? thread_binary_tree



    // ??????н??????
    public int nodeOfNumber() {
        return this.nodeOfNumber(this.root);
    }
    public int nodeOfNumber(HeroNode node) {
        if (node == null) return 0;
        return 1 + nodeOfNumber(node.getLeft()) + nodeOfNumber(node.getRight());
    }
    // ????????????
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
    // ?????K????????
    public int getKLeaveOfNumber(int k) {
        return getKLeaveOfNumber(this.root, k);
    }
    public int getKLeaveOfNumber(HeroNode node, int k) {
        if (node == null) return 0;
        if (k == 1 && node != null) return 1;
        return getKLeaveOfNumber(node.getLeft(), k - 1) + getKLeaveOfNumber(node.getRight(), k - 1);
    }
    // ?????????????
    public int height() {
        return height(this.root);
    }
    public int height(HeroNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }
    // ?????no???????????
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
    // ???????(1.????  2.????)
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


    // ?ж???????????????????? ??????????????????????????????????????ε??????????
    public boolean isCompleteTree() {
        // ????????????????????????????
        HeroNode node = this.root;
        Queue<HeroNode> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            // ????????ó????
            HeroNode top = queue.poll();
            if (top != null) {
                queue.add(top.getLeft());
                queue.add(top.getRight());
            } else {
                // ??????????????????????????????????? node node node ... node node null null null ... null
                // ?? node ??????? null
                break;
            }
        }
        // ????????????????? null????????????????????
        while (!queue.isEmpty()) {
            HeroNode top = queue.poll();
            if (top != null) {
                return false;
            }
        }
        return true;
    }






    // ?ж?????????????
    public boolean isSameTree(HeroNode otherRoot) {
        HeroNode thisRoot = this.root;
        HeroNode otherRoot2 = otherRoot;
        return isSameTree(thisRoot, otherRoot2);
    }
    public boolean isSameTree(HeroNode thisRoot, HeroNode otherRoot) {
        if (thisRoot == null && otherRoot == null) return true;
        if (thisRoot == null) return false;
        if (otherRoot == null) return false;
        // ???????????????????
        if (!thisRoot.getName().equals(otherRoot.getName())) return false;
        // ???????????????????????
        if (!isSameTree(thisRoot.getLeft(), otherRoot.getLeft())) return false;
        if (!isSameTree(thisRoot.getRight(), otherRoot.getRight())) return false;
        return true;
    }






    // ?ж?????????????????????
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



    // ?ж?????????????????(2 functions)
    // ??????????????????????????????????1??????????????????????????????
    public boolean isBanlanceTree(HeroNode thisRoot) {

        return true;
    }
    // ?ж?????????????????(????????)
    public boolean isBanlanceTree2(HeroNode thisRoot) {
        if (thisRoot == null) return false;
        // ?????????????????
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




    // ?ж????????????????
    public boolean isSymmetricTree(HeroNode thisRoot) {
        // ?·??????????????????????????????????????????????????????????????????? => ????
        if (thisRoot == null) return false;
        // ????????????????
        turnOneTree(thisRoot.getRight());
        boolean flag = isSameTree(thisRoot.getLeft(), thisRoot.getRight());
        if (flag)
            return true;
        return false;
    }
    public boolean isSymmetricTree(HeroNode left, HeroNode right) {
        // ???????????????
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (!left.getName().equals(right.getName())) return false;
        return isSameTree(left.getLeft(),right.getRight()) && isSameTree(left.getRight(), right.getLeft());
    }






    // ??????????????????????????????(2 functions)
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





    // ?????????????????????????
    public static HeroNode lowestCommonAncestor(HeroNode root, HeroNode p, HeroNode q) {
        // ?·???????????????????·????????·?????б??
        // ?·????
        
        return null;
    }


}
