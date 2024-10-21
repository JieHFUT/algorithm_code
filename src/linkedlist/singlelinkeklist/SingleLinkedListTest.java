package linkedlist.singlelinkeklist;

public class SingleLinkedListTest {
    public static void main(String[] args) {

        SingleLinkedList linkedList = new SingleLinkedList();

        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //加入
//        linkedList.addInTail(hero4);
//        linkedList.addInTail(hero2);
//        linkedList.addInTail(hero1);
//        linkedList.addInTail(hero3);
//        linkedList.list();
//        [4 name: 林冲 nickname: 豹子头]
//        [2 name: 卢俊义 nickname: 玉麒麟]
//        [1 name: 宋江 nickname: 及时雨]
//        [3 name: 吴用 nickname: 智多星]

        linkedList.addOrderByNo(hero2);
        linkedList.addOrderByNo(hero4);
        linkedList.addOrderByNo(hero3);
        linkedList.addOrderByNo(hero1);
        linkedList.list();

        linkedList.reverse1(linkedList.getHead());
        System.out.println("====== 反转 1 ==========");
        linkedList.list();

        linkedList.reverse2(linkedList.getHead());
        System.out.println("====== 反转 2 ==========");
        linkedList.list();

        System.out.println("逆向打印");
        linkedList.printFromLast(linkedList.getHead());

        HeroNode hero11 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero22 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode hero33 = new HeroNode(5, "吴用", "智多星");
        HeroNode hero44 = new HeroNode(7, "林冲", "豹子头");
        HeroNode hero55 = new HeroNode(2, "宋江", "及时雨");
        HeroNode hero66 = new HeroNode(5, "卢俊义", "玉麒麟");
        HeroNode hero77 = new HeroNode(8, "吴用", "智多星");
        HeroNode hero88 = new HeroNode(9, "林冲", "豹子头");

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
