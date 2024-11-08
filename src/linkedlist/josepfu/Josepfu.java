package linkedlist.josepfu;

// 约瑟夫问题(单向环形链表)
public class Josepfu {
    public static void main(String[] args) {

        CircleSingleLinkedList circle = new CircleSingleLinkedList();
        circle.addBoy(10);
        circle.showBoy();

        CircleSingleLinkedList circle2 = new CircleSingleLinkedList();
        circle2.addBoy(5);
        circle2.countBoy(1,2,5);


    }
}
