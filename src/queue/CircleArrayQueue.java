package queue;
// 创建一个环形队列
public class CircleArrayQueue {

    private int maxSize; // 表示数组的最大容量
    private int front;
    private int rear;
    private int[] array;

    // 环形队列的构造方法
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }


    // 判断队列是否已满
    public boolean isFull() {
        return front == (rear + 1) % maxSize;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    // 添加数据到队列
    public void add(int value) {
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        array[rear] = value;
        rear = (rear + 1) % maxSize;
    }

    // 读取队列的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int ret = array[front];
        front = (front + 1) % maxSize;
        return ret;
    }

    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int useSize = useSize();
        for (int i = front; i < front + useSize; i++) {
            System.out.printf("array[%d] = %d\n", i % maxSize, array[i % maxSize]);
        }
    }

    // 求出当前队列有效数据的个数
    public int useSize() {
        return (rear + maxSize - front) % maxSize;
    }


    // 显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return array[front];
    }

}
