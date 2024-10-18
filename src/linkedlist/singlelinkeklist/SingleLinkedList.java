package linkedlist.singlelinkeklist;

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

}
