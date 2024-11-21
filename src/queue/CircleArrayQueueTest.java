package queue;

import java.util.Scanner;

public class CircleArrayQueueTest {
    public static void main(String[] args) {

        System.out.println("测试数组完成环形队列：");
        // 创建一个环形队列
        CircleArrayQueue queue = new CircleArrayQueue(3);

        char input = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");

            // 接收用户输入的操作
            input = scanner.next().charAt(0);
            switch (input) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入要添加的数据：");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g':
                    try {
                        System.out.println("取出的数据是: " + queue.getQueue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("队列头部的数据是: " + queue.headQueue());
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
