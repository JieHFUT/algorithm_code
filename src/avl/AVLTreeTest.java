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
        int[] arr = new int[]{10, 5, 15, 8};

        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        avlTree.add(new Node(9));
//        System.out.println("���ĸ߶�Ϊ��" + avlTree.height());
//        System.out.println("������߶�Ϊ��" + avlTree.leftHeight());
//        System.out.println("�����Ҹ߶�Ϊ��" + avlTree.rightHeight());
    }
}