package tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // 创建根节点
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");

        // 手动创建测试
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);

        tree.setRoot(node1);
        System.out.println("前序遍历：");
        tree.preOrder(); // 1, 2, 3, 4

        System.out.println("中序遍历：");
        tree.infixOrder(); // 2, 1, 3, 4

        System.out.println("后序遍历：");
        tree.postOrder(); // 2, 4, 3, 1


    }
}
