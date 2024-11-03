package avl;


/**
 * ClassName: AVLTree
 * Package: avl
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/11/3 19:59
 * @Version 1.0
 */
public class AVLTree {

    private Node root;
    public AVLTree() {}
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

    // ������ĸ߶�
    public int height() {
        if (root == null) return 0;
        return root.height();
    }
    public int leftHeight() {
        if (root == null) throw new RuntimeException("tree is empty");
        return root.leftHeight();
    }
    public int rightHeight() {
        if (root == null) throw new RuntimeException("tree is empty");
        return root.rightHeight();
    }

}
