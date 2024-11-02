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
     * 向排序树中添加元素
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
     * 输出排序树的前序遍历
     */
    public void preOrder() {
        if (root == null) return;
        this.getRoot().preOrder(root);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        if (root == null) return;
        this.getRoot().levelOrder();
    }


}
