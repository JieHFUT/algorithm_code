package linkedlist.doublelinkedlist;

public class DoubleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    // 遍历双向链表的方法
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
        newNode.prev = current;
    }


    // 修改节点的信息，根据 no 节点来更改，即 no 不能更改 ==========
    public void update(HeroNode newNode) {
        if (head.next == null) {
            System.out.println("linkeklist is empty");
            return;
        }
        HeroNode current = head.next;
        boolean flag = false;

        while(true) {
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


    // 删除节点  直接找，找到自我删除即可
    public void del(int no) {
        if (head.next == null) {
            System.out.println("linkeklist is empty");
        }
        HeroNode current = head.next;
        boolean flag = false;
        while(true) {
            if (current == null) {
                break;
            }
            if (current.no == no) {
                flag = true;
                break;
            }
            current = current.next;
        }
        if (flag) {
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        } else {
            System.out.println("can't find the node");
        }

    }













































}
