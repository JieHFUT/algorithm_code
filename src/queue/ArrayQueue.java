package queue;

/**
 * ʹ������ģ����б�дһ�� Queue
 */
public class ArrayQueue {

    private int maxSize; // ��ʾ������������
    private int front; // ��ʾ����Ķ���ͷ����
    private int rear; // ��ʶ����Ķ���β����
    private int[] array; // ���ڴ洢����

    // ��������Ĺ�����
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1; // ָ�����ͷ����������front��ָ�����ͷ��ǰһ��λ��.
        this.rear = -1; // ָ�����β��ָ�����β������(�����Ƕ������һ������)
        this.array = new int[maxSize];
    }

    // �ж϶����Ƿ�Ϊ��
    public boolean isEmpty() {
        return front == rear;
    }

    // �ж϶���������
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // ������ݵ�����
    public void addQueue(int element) {
        // �ж������Ƿ�����
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        array[++rear] = element;
    }

    // ��ȡ���е����ݣ�������
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return array[++front];
    }

    // ��ʾ���е���������
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

    // ��ʾ���е�ͷ����
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return array[front + 1];
    }

}

