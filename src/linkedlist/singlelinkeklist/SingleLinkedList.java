package linkedlist.singlelinkeklist;

import java.util.Iterator;
import java.util.Stack;

// 定义SingleLinkedList 管理我们的英雄
public class SingleLinkedList {

    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    // 添加节点到单向链表
    public void addInTail(HeroNode newNode) {
        HeroNode current = head;
        while(true) {
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        current.next = newNode;
        return;
    }

    // 根据排序将节点加入到链表中
    public void addOrderByNo(HeroNode newNode) {
        HeroNode current = head;
        boolean flag = false; // flag标志要添加的节点序号是否已经存在
        while(true) {
            if (current.next == null) {
                // current 已经是最后一个几点
                break;
            }
            if (current.next.no > newNode.no) {
                break;
            } else if (current.next.no == newNode.no) {
                flag = true;
                break;
            }
            current = current.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄编号: %d 已经存在！", newNode.no);
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // 修改节点的信息，根据 no 节点来更改，即 no 不能更改
    public void update(HeroNode newNode) {
        if (head.next == null) {
            System.out.println("linkeklist is empty");
            return;
        }
        HeroNode current = head.next;
        boolean flag = false;

        while(flag) {
            if (current == null) {
                break;
            }
            if (current.no == newNode.no) {
                flag = true;
                break;
            }
            current = current.next;
        }
        if (flag) {
            current.name = newNode.name;
            current.nickname = newNode.nickname;
        } else {
            System.out.printf("没有找到 %d 节点", newNode.no);
        }
    }

    // 删除节点
    public void del(int no) {
        if (head.next == null) {
            System.out.println("linkeklist is empty");
        }
        HeroNode current = head.next;
        boolean flag = true;
        while(flag) {
            if (current.next == null) {
                flag = false;
                break;
            }
            if (current.next.no == no) {
                break;
            }
            current = current.next;
        }
        if (flag) {
            current.next = current.next.next;
        } else {
            System.out.println("can't find the node");
        }

    }

    // 显示节点【遍历】
    public void list() {
        if (head.next == null) {
            System.out.println("linkeklist is empty");
            return;
        }
        HeroNode current = head.next;
        while (current != null) {
            System.out.println(current);
            current = current.next;

        }
        System.out.println();
    }



    ////////////////////////////////////////////////////////////////////////
    // 获取到单链表的有效节点的个数（如果带头节点不统计头节点）

    /**
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        HeroNode current = head.next;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

    // 查找单链表中的倒数第k个结点 【新浪面试题】
    // 1. 先遍历一边得到链表 length，再遍历到 length - k
    public HeroNode findLastIndexNode1(HeroNode head, int index) {
        if (head.next == null) {
            return null; // 链表为空
        }
        int length = getLength(head);
        if (length <= 0 || index > length) {
            return null;
        }
        HeroNode current = head.next;
        for (int i = 0; i < length - index; i++) {
            current = current.next;
        }
        return current;
    }
    // 2. 使用快慢指针方法
    public HeroNode findLastIndexNode2(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        HeroNode fast = head.next;
        HeroNode slow = head.next;
        for (int i = 0; i < index; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 单链表的反转[腾讯面试题]
    // 1. 双指针
    public void reverse1(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode prev = head.next;
        HeroNode next = head.next.next;
        prev.next = null;

        while (next != null) {
            HeroNode tmp = next.next;
            next.next = prev;
            prev = next;
            next = tmp;
        }
        head.next = prev;
    }
    // 2. 插入法
    public void reverse2(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode current = head.next;
        HeroNode next = null;
        HeroNode retHead = new HeroNode(0, "", "");
        while (current != null) {
            next = current.next;
            current.next = retHead.next;
            retHead.next = current;
            current = next;
        }
        head.next = retHead.next;
    }


    // 从尾到头打印单链表[百度面试题]
    // 1. 使用栈解决
    // 2. 先将单链表反转过来，然后再遍历（但是会破坏链表结构）
    public void printFromLast(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode current = head.next;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }
        System.out.println();
    }


    // 合并两个有序的单链表，合并之后的链表依然有序
    public HeroNode combine(HeroNode head1, HeroNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        HeroNode list1 = head1.next;
        HeroNode list2 = head2.next;
        HeroNode ret = new HeroNode(0, "", "");
        HeroNode current = ret;
        while (list1 != null && list2 != null) {
            if(list1.no < list2.no) {
                current.next = list1;
                list1 = list1.next;
                current = current.next;
            } else {
                current.next = list2;
                list2 = list2.next;
                current = current.next;
            }
        }
        if (list1 != null) {
            while (list1 != null) {
                current.next = list1;
                list1 = list1.next;
                current = current.next;
            }
        }
        if (list2 != null) {
            while (list2 != null) {
                current.next = list2;
                list2 = list2.next;
                current = current.next;
            }
        }
        return ret;
    }
}
