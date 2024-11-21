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


    /**
     * 根据用户的输入，生成一个小孩出圈的顺序
     * @param startNo 表示从第几个小孩开始数数
     * @param countNo 表示数几下
     * @param nums 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNo, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("Invalid input");
            return;
        }
        Boy helper = first;

        // 先让 helper 指向最后一个节点
        while(true) {
            if (helper.getNext() == first)
                break;
            helper = helper.getNext();
        }

        for (int i = 0; i < startNo -1 ; i++) {
            helper = helper.getNext();
            first = first.getNext();
        }
        //当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while(true) {
            if (first == helper) {
                break; // 说明圈里目前只剩下一个节点了
            }
            for (int i = 0; i < countNo - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("需要出圈的是 %d\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后一个出圈的是 %d\n", helper.getNo());
    }

}
