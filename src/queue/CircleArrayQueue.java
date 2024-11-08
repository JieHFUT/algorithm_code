package queue;
// ����һ�����ζ���
public class CircleArrayQueue {

    private int maxSize; // ��ʾ������������
    private int front;
    private int rear;
    private int[] array;

    // ���ζ��еĹ��췽��
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }


    // �ж϶����Ƿ�����
    public boolean isFull() {
        return front == (rear + 1) % maxSize;
    }

    // �ж϶����Ƿ�Ϊ��
    public boolean isEmpty() {
        return front == rear;
    }

    // ������ݵ�����
    public void add(int value) {
        // �ж϶����Ƿ�����
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        array[rear] = value;
        rear = (rear + 1) % maxSize;
    }

    // ��ȡ���е����ݣ�������
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int ret = array[front];
        front = (front + 1) % maxSize;
        return ret;
    }

    // ��ʾ���е���������
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

    // �����ǰ������Ч���ݵĸ���
    public int useSize() {
        return (rear + maxSize - front) % maxSize;
    }


    // ��ʾ���е�ͷ����
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return array[front];
    }

}
