package binarysorttree;

/**
 * ClassName: BinarySortTree
 * Package: binarysorttree
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/11/2 20:11
 * @Version 1.0
 */
public class BinarySortTree {

    private Node root;
    public BinarySortTree() {}
    public Node getRoot() {return root;}

    /**
     * �������������Ԫ��
     * @param toAdd
     */
    public void add(Node toAdd) {
        if (toAdd == null) return;
        if (getRoot() == null) {
            root = toAdd;
            return;
        }
        root.add(toAdd);
    }


    /**
     * �����������ǰ�����
     */
    public void preOrder() {
        if (root == null) return;
        this.getRoot().preOrder(root);
    }

    /**
     * �������
     */
    public void levelOrder() {
        if (root == null) return;
        this.getRoot().levelOrder();
    }

    /**
     * ���ҽڵ�
     * @param key
     * @return
     */
    public Node search(int key) {
        if (root == null) return null;
        return root.search(key);
    }

    /**
     * ���Ҹýڵ�ĸ��ڵ�
     * @param key
     * @return
     */
    public Node searchParent(int key) {
        if (root == null) return null;
        return root.searchParent(key);
    }

    public boolean delete(int key) {
        if (root == null) throw new RuntimeException("Tree is empty");
        Node target = search(key);
        if (target == null) {
            System.out.println("don't have target");
            return false;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            // ֻ��һ�����ڵ�
            root = null;
            return true;
        }

        Node parent = searchParent(key);
        // target : Ҫɾ���Ľڵ�
        // parent : Ҫɾ���ڵ�ĸ��ڵ�
        if (target.getLeft() == null && target.getRight() == null) {
            // Ҫɾ������Ҷ�ӽڵ�
            if (parent.getLeft() != null && parent.getLeft().getValue() == key)
                parent.setLeft(null);
            else
                parent.setRight(null);
            return true;
        } else if (target.getLeft() == null) {
            // Ҫɾ���Ľڵ�ֻ��������
            if (parent.getLeft() == target)
                parent.setLeft(target.getRight());
            else
                parent.setRight(target.getRight());
        } else if (target.getRight() == null){
            // Ҫɾ���Ľڵ�ֻ��������
            if (parent.getLeft() == target)
                parent.setLeft(target.getLeft());
            else
                parent.setRight(target.getLeft());
        } else {
            // Ҫɾ���Ľڵ�������������
            int newValue = delRightTreeMin(target.getRight());
            target.setValue(newValue);
        }
        return true;
    }

    /**
     * �ҵ��Ըõ�Ϊ���ڵ��������С�ڵ㣬ɾ������ڵ㲢�ҷ�����ֵ
     * @param node
     * @return
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.getLeft() != null) {
            target = target.getLeft();
        }
        int ret = target.getValue();
        delete(ret);
        return ret;
    }
}
