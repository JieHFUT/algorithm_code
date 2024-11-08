package linkedlist.singlelinkeklist;

public class SingleLinkedListTest {
    public static void main(String[] args) {

        SingleLinkedList linkedList = new SingleLinkedList();

        //���в���
        //�ȴ����ڵ�
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

        //����
//        linkedList.addInTail(hero4);
//        linkedList.addInTail(hero2);
//        linkedList.addInTail(hero1);
//        linkedList.addInTail(hero3);
//        linkedList.list();
//        [4 name: �ֳ� nickname: ����ͷ]
//        [2 name: ¬���� nickname: ������]
//        [1 name: �ν� nickname: ��ʱ��]
//        [3 name: ���� nickname: �Ƕ���]

        linkedList.addOrderByNo(hero2);
        linkedList.addOrderByNo(hero4);
        linkedList.addOrderByNo(hero3);
        linkedList.addOrderByNo(hero1);
        linkedList.list();

        linkedList.reverse1(linkedList.getHead());
        System.out.println("====== ��ת 1 ==========");
        linkedList.list();

        linkedList.reverse2(linkedList.getHead());
        System.out.println("====== ��ת 2 ==========");
        linkedList.list();

        System.out.println("�����ӡ");
        linkedList.printFromLast(linkedList.getHead());

        HeroNode hero11 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero22 = new HeroNode(3, "¬����", "������");
        HeroNode hero33 = new HeroNode(5, "����", "�Ƕ���");
        HeroNode hero44 = new HeroNode(7, "�ֳ�", "����ͷ");
        HeroNode hero55 = new HeroNode(2, "�ν�", "��ʱ��");
        HeroNode hero66 = new HeroNode(5, "¬����", "������");
        HeroNode hero77 = new HeroNode(8, "����", "�Ƕ���");
        HeroNode hero88 = new HeroNode(9, "�ֳ�", "����ͷ");

        SingleLinkedList list2 = new SingleLinkedList();
        list2.addOrderByNo(hero11);
        list2.addOrderByNo(hero22);
        list2.addOrderByNo(hero33);
        list2.addOrderByNo(hero44);
        SingleLinkedList list3 = new SingleLinkedList();
        list3.addOrderByNo(hero55);
        list3.addOrderByNo(hero66);
        list3.addOrderByNo(hero77);
        list3.addOrderByNo(hero88);

        HeroNode heroNode = new SingleLinkedList().combine(list2.getHead(), list3.getHead());
        SingleLinkedList list4 = new SingleLinkedList();
        list4.addInTail(heroNode.next);
        list4.list();

    }
}
