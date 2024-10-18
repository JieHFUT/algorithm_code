package queue;

public class ArrayQueueTest {
    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.addQueue(5);
        queue.addQueue(6);

        System.out.println(queue.getQueue());
        queue.showQueue();
        System.out.println(queue.headQueue());

    }
}
