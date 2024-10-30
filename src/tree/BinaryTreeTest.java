package tree;

import java.util.List;

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

        /*
        System.out.println("前序遍历：");
        tree.preOrder(); // 1, 2, 3, 4

        System.out.println("中序遍历：");
        tree.infixOrder(); // 2, 1, 3, 4

        System.out.println("后序遍历：");
        tree.postOrder(); // 2, 4, 3, 1
        System.out.println("======================================");


        System.out.println("pre search=> ");
        System.out.println("the result is: " + tree.preSearch(4));


        System.out.println("infix search=> ");
        System.out.println("the result is: " + tree.infixSearch(4));

        System.out.println("post search=> ");
        System.out.println("the result is: " + tree.postSearch(4));

        System.out.println("删除节点之前：");
        tree.preOrder();
        System.out.println("删除节点之后：");
        tree.deleteByNo(3);
        tree.preOrder();*/

        // 将树的前序遍历转化为 arraylist
        HeroNode node5 = new HeroNode(5, "宋江");
        HeroNode node6 = new HeroNode(6, "吴用");
        HeroNode node7 = new HeroNode(7, "卢俊义");
        HeroNode node8 = new HeroNode(8, "林冲");
        HeroNode node9 = new HeroNode(9, "宋江");
        HeroNode node10 = new HeroNode(10, "吴用");
        HeroNode node11 = new HeroNode(11, "卢俊义");
        HeroNode node12 = new HeroNode(12, "林冲");
        // 将该数组变成树以后在存储在 arraylist 中
        HeroNode[] heroNodes = new HeroNode[]{node5, node6, node7, node8, node9, node10, node11, node12};
        List<HeroNode> list = BinaryTree.preOrderToList(heroNodes);
        for(HeroNode heroNode : list){
            System.out.println(heroNode);
        }

        // 获得树的节点个数
        System.out.println("tree's node number is: " + tree.nodeOfNumber());
        // 获得树的叶子节点的个数
        System.out.println("tree's level node number is: " + tree.getLeaveOfNumber());



    }
}
