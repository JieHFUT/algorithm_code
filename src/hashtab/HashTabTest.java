package hashtab;

import java.util.Scanner;

/**
 * ClassName: HashTabTest
 * Package: hashtab
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/10/27 21:31
 * @Version 1.0
 */
public class HashTabTest {
    public static void main(String[] args) {
        HashTab tab = new HashTab(7);

        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 寻找雇员");
            System.out.println("exit: 退出程序");
            input = scanner.next();
            switch (input) {
                case "add":
                    System.out.println("输入id:");
                    int id = scanner.nextInt();
                    System.out.println("输入姓名:");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    tab.addEmp(emp);
                    break;
                case "list":
                    tab.list();
                    break;
                case "find":
                    System.out.println("输入要寻找的雇员ID");
                    int toFind = scanner.nextInt();
                    if (tab.findEmpById(toFind) != null)
                        System.out.println("雇员姓名是:" + tab.findEmpById(toFind).name);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("指令有误");
                    break;
            }
        }
    }
}


class HashTab {
    private int size;
    private EmpLinkedList[] empLinkedLists;
    public HashTab(int size) {
        super();
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        // 初始化每一条链表
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }


    public void addEmp(Emp emp) {
        // 根据员工 id 得到该员工应该放在哪条链表上
        int index = hashFun(emp.id);
        // 调用链表的添加方法
        empLinkedLists[index].add(emp);
    }
    public int hashFun(int id) {
        return id % size;
    }

    // 遍历 hashtab
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    // 查找
    public Emp findEmpById(int id) {
        int index = hashFun(id);

        if (empLinkedLists[index].findEmpById(id) == null) {
            System.out.println("the tab doesn't has the emp");
            return null;
        } else
            return empLinkedLists[index].findEmpById(id);
    }
}



class EmpLinkedList {
    // 指向第一个元素的 head
    private Emp head;
    // 添加雇员到链表(假定加到最后一个)
    public void add(Emp emp) {
        // 添加第一个
        if (head == null) {
            head = emp;
            return;
        }
        // 不是第一个
        Emp current = head;
        while (current.next != null) {
            current = current.next;
        }
        // 此时 current.next == null
        current.next = emp;
    }

    // 遍历
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no+1) + "d条链表为空");
            return;
        }
        System.out.print("第" + (no+1) + "条链表的信息为:");
        Emp current = head;
        while (current != null) {
            System.out.printf("=> id=%d, name=%s\t", current.id, current.name);
            current = current.next;
        }
        System.out.println();
    }

    // 根据 ID 来查找雇员
    public Emp findEmpById(int id) {
        if (head == null) return null;
        Emp current = head;
        while (current != null) {
            if (current.id == id)
                return current;
            current = current.next;
        }
        return null;
    }
}


class Emp {
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}