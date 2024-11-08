package linkedlist.doublelinkedlist;

public class DoubleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    // ����˫������ķ���
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


    // ��ӽڵ㵽��������
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


    // �޸Ľڵ����Ϣ������ no �ڵ������ģ��� no ���ܸ��� ==========
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
            System.out.printf("û���ҵ� %d �ڵ�", newNode.no);
        }
    }


    // ɾ���ڵ�  ֱ���ң��ҵ�����ɾ������
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
