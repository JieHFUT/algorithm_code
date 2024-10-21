package linkedlist.josepfu;

// 创建一个环形单向链表
public class CircleSingleLinkedList {

    // 创建一个 first 节点
    private Boy first;


    // 添加小孩节点，构建环形链表
    public void addBoy (int nums) {
        // 数据校验
        if(nums < 1) return;

        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            // 根据编号，创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    // 遍历当前环形列表所有的节点 N 个人，从 M 开始, 每隔 K 个出一个
    public void showBoy() {
        if (first == null) return;
        Boy curBoy = first;
        while (true) {
            System.out.print(curBoy.getNo() + "\t");
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
        System.out.println();
    }

    // 根据用户的输入，生成一个小孩出圈的顺序
    

}
