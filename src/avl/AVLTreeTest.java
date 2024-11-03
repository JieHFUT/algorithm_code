package avl;

/**
 * ClassName: AVLTreeTest
 * Package: avl
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/11/3 19:59
 * @Version 1.0
 */
public class AVLTreeTest {
    public static void main(String[] args) {

        AVLTree avlTree = new AVLTree();
        int[] arr = new int[]{4,3,6,5,7,8};

        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        avlTree.preOrder();
        System.out.println("树的高度为：" + avlTree.height());
        System.out.println("树的左高度为：" + avlTree.leftHeight());
        System.out.println("树的右高度为：" + avlTree.rightHeight());

    }
}
