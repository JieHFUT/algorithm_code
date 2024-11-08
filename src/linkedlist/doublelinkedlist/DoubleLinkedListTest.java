package linkedlist.doublelinkedlist;


public class DoubleLinkedListTest {
    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();

        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        list.addInTail(hero1);
        list.addInTail(hero2);
        list.addInTail(hero3);
        list.addInTail(hero4);

        list.list();
        list.update(new HeroNode(4, "如云龙", "公孙胜"));
        System.out.println("修改...");
        list.list();
        list.del(3);
        System.out.println("删除...");
        list.list();

    }
}
