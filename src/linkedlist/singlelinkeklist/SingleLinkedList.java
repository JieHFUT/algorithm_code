package linkedlist.singlelinkeklist;

import java.util.Iterator;
import java.util.Stack;

// ����SingleLinkedList �������ǵ�Ӣ��
public class SingleLinkedList {

    //�ȳ�ʼ��һ��ͷ�ڵ�, ͷ�ڵ㲻Ҫ��, ����ž��������
    private HeroNode head = new HeroNode(0, "", "");

    //����ͷ�ڵ�
    public HeroNode getHead() {
        return head;
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
        return;
    }

    // �������򽫽ڵ���뵽������
    public void addOrderByNo(HeroNode newNode) {
        HeroNode current = head;
        boolean flag = false; // flag��־Ҫ��ӵĽڵ�����Ƿ��Ѿ�����
        while(true) {
            if (current.next == null) {
                // current �Ѿ������һ������
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
            System.out.printf("׼�������Ӣ�۱��: %d �Ѿ����ڣ�", newNode.no);
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // �޸Ľڵ����Ϣ������ no �ڵ������ģ��� no ���ܸ���
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
            System.out.printf("û���ҵ� %d �ڵ�", newNode.no);
        }
    }

    // ɾ���ڵ�
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

    // ��ʾ�ڵ㡾������
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
    // ��ȡ�����������Ч�ڵ�ĸ����������ͷ�ڵ㲻ͳ��ͷ�ڵ㣩

    /**
     *
     * @param head �����ͷ�ڵ�
     * @return ���صľ�����Ч�ڵ�ĸ���
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

    // ���ҵ������еĵ�����k����� �����������⡿
    // 1. �ȱ���һ�ߵõ����� length���ٱ����� length - k
    public HeroNode findLastIndexNode1(HeroNode head, int index) {
        if (head.next == null) {
            return null; // ����Ϊ��
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
    // 2. ʹ�ÿ���ָ�뷽��
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

    // ������ķ�ת[��Ѷ������]
    // 1. ˫ָ��
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
    // 2. ���뷨
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


    // ��β��ͷ��ӡ������[�ٶ�������]
    // 1. ʹ��ջ���
    // 2. �Ƚ�������ת������Ȼ���ٱ��������ǻ��ƻ�����ṹ��
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


    // �ϲ���������ĵ������ϲ�֮���������Ȼ����
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
