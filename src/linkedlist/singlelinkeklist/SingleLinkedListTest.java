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

    }
}
