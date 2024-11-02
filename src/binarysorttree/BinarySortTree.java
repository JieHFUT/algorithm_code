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


}
