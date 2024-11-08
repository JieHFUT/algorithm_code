package queue;

/**
 * 使用数组模拟队列编写一个 Queue
 */
public class ArrayQueue {

    private int maxSize; // 表示数组的最大容量
    private int front; // 表示数组的队列头，出
    private int rear; // 标识数组的队列尾，进
    private int[] array; // 用于存储数据

    // 创建数组的构造期
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1; // 指向队列头部，分析出front是指向队列头的前一个位置.
        this.rear = -1; // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
        this.array = new int[maxSize];
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    // 判断队列是已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 添加数据到队列
    public void addQueue(int element) {
        // 判断数组是否已满
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        array[++rear] = element;
    }

    // 获取队列的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return array[++front];
    }

    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    // 显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return array[front + 1];
    }

}

