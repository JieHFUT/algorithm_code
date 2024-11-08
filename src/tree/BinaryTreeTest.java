package tree;

import java.util.List;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // �������ڵ�
        HeroNode node1 = new HeroNode(1, "�ν�");
        HeroNode node2 = new HeroNode(2, "����");
        HeroNode node3 = new HeroNode(3, "¬����");
        HeroNode node4 = new HeroNode(4, "�ֳ�");

        // �ֶ���������
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        tree.setRoot(node1);

        /*
        System.out.println("ǰ�������");
        tree.preOrder(); // 1, 2, 3, 4

        System.out.println("���������");
        tree.infixOrder(); // 2, 1, 3, 4

        System.out.println("���������");
        tree.postOrder(); // 2, 4, 3, 1
        System.out.println("======================================");


        System.out.println("pre search=> ");
        System.out.println("the result is: " + tree.preSearch(4));


        System.out.println("infix search=> ");
        System.out.println("the result is: " + tree.infixSearch(4));

        System.out.println("post search=> ");
        System.out.println("the result is: " + tree.postSearch(4));

        System.out.println("ɾ���ڵ�֮ǰ��");
        tree.preOrder();
        System.out.println("ɾ���ڵ�֮��");
        tree.deleteByNo(3);
        tree.preOrder();*/

        // ������ǰ�����ת��Ϊ arraylist
        HeroNode node5 = new HeroNode(5, "�ν�");
        HeroNode node6 = new HeroNode(6, "����");
        HeroNode node7 = new HeroNode(7, "¬����");
        HeroNode node8 = new HeroNode(8, "�ֳ�");
        HeroNode node9 = new HeroNode(9, "�ν�");
        HeroNode node10 = new HeroNode(10, "����");
        HeroNode node11 = new HeroNode(11, "¬����");
        HeroNode node12 = new HeroNode(12, "�ֳ�");
        // �������������Ժ��ڴ洢�� arraylist ��
        HeroNode[] heroNodes = new HeroNode[]{node5, node6, node7, node8, node9, node10, node11, node12};
        List<HeroNode> list = BinaryTree.preOrderToList(heroNodes);
        for(HeroNode heroNode : list){
            System.out.println(heroNode);
        }

        // ������Ľڵ����
        System.out.println("tree's node number is: " + tree.nodeOfNumber());
        // �������Ҷ�ӽڵ�ĸ���
        System.out.println("tree's level node number is: " + tree.getLeaveOfNumber());

        System.out.println("�����ǲ�������Ľ��: ");
        List<List<HeroNode>> levelOrderByList= tree.levelOrderByList();
        for (List<HeroNode> levelList : levelOrderByList) {
            for (HeroNode heroNode : levelList) {
                System.out.println(heroNode);
            }
        }


    }
}
