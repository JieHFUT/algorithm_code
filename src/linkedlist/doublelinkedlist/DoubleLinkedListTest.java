package linkedlist.doublelinkedlist;


public class DoubleLinkedListTest {
    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();

        //���в���
        //�ȴ����ڵ�
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

        list.addInTail(hero1);
        list.addInTail(hero2);
        list.addInTail(hero3);
        list.addInTail(hero4);

        list.list();
        list.update(new HeroNode(4, "������", "����ʤ"));
        System.out.println("�޸�...");
        list.list();
        list.del(3);
        System.out.println("ɾ��...");
        list.list();

    }
}
