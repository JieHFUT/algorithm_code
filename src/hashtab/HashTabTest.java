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
            System.out.println("add: ��ӹ�Ա");
            System.out.println("list: ��ʾ��Ա");
            System.out.println("find: Ѱ�ҹ�Ա");
            System.out.println("exit: �˳�����");
            input = scanner.next();
            switch (input) {
                case "add":
                    System.out.println("����id:");
                    int id = scanner.nextInt();
                    System.out.println("��������:");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    tab.addEmp(emp);
                    break;
                case "list":
                    tab.list();
                    break;
                case "find":
                    System.out.println("����ҪѰ�ҵĹ�ԱID");
                    int toFind = scanner.nextInt();
                    if (tab.findEmpById(toFind) != null)
                        System.out.println("��Ա������:" + tab.findEmpById(toFind).name);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("ָ������");
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
        // ��ʼ��ÿһ������
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }


    public void addEmp(Emp emp) {
        // ����Ա�� id �õ���Ա��Ӧ�÷�������������
        int index = hashFun(emp.id);
        // �����������ӷ���
        empLinkedLists[index].add(emp);
    }
    public int hashFun(int id) {
        return id % size;
    }

    // ���� hashtab
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    // ����
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
    // ָ���һ��Ԫ�ص� head
    private Emp head;
    // ��ӹ�Ա������(�ٶ��ӵ����һ��)
    public void add(Emp emp) {
        // ��ӵ�һ��
        if (head == null) {
            head = emp;
            return;
        }
        // ���ǵ�һ��
        Emp current = head;
        while (current.next != null) {
            current = current.next;
        }
        // ��ʱ current.next == null
        current.next = emp;
    }

    // ����
    public void list(int no) {
        if (head == null) {
            System.out.println("��" + (no+1) + "d������Ϊ��");
            return;
        }
        System.out.print("��" + (no+1) + "���������ϢΪ:");
        Emp current = head;
        while (current != null) {
            System.out.printf("=> id=%d, name=%s\t", current.id, current.name);
            current = current.next;
        }
        System.out.println();
    }

    // ���� ID �����ҹ�Ա
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