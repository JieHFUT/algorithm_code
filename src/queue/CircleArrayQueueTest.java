package queue;

import java.util.Scanner;

public class CircleArrayQueueTest {
    public static void main(String[] args) {

        System.out.println("����������ɻ��ζ��У�");
        // ����һ�����ζ���
        CircleArrayQueue queue = new CircleArrayQueue(3);

        char input = ' '; // �����û�����
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("s(show): ��ʾ����");
            System.out.println("e(exit): �˳�����");
            System.out.println("a(add): ������ݵ�����");
            System.out.println("g(get): �Ӷ���ȡ������");
            System.out.println("h(head): �鿴����ͷ������");

            // �����û�����Ĳ���
            input = scanner.next().charAt(0);
            switch (input) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("������Ҫ��ӵ����ݣ�");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g':
                    try {
                        System.out.println("ȡ����������: " + queue.getQueue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("����ͷ����������: " + queue.headQueue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    scanner.close();
                    flag = false;
                    break;
            }

        }
        System.out.println("exit");
    }
}
