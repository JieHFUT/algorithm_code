package stack;

public class ArrayStack {

    private int maxSize; //  ���ڼ�¼ջ�Ĵ�С

    private int top = -1; // ���ڱ�ʾջ��Ԫ������λ��

    private int[] stack;

    // ���췽��
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // �ж�ջ��
    public boolean isFull() {
        return top == maxSize - 1;
    }
    // �ж�ջ��
    public boolean isEmpty() {
        return top == -1;
    }

    // ��ջ
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = value;
    }
    // ��ջ
    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        int ret = stack[top];
        top--;
        return ret;
    }

    //��ʾջ�����[����ջ]�� ����ʱ����Ҫ��ջ����ʼ��ʾ����
    public void list() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
        System.out.println();
    }

    // ���ص�ǰջ����ֵ
    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return stack[top];
    }

    /////////////////////////////////////////////////////////////////////
    //��������������ȼ������ȼ��ǳ���Ա��ȷ��, ���ȼ�ʹ�����ֱ�ʾ
    //����Խ�������ȼ���Խ��.
    public static int priority(int oper){
        if(oper == '*' || oper == '/') return 1;
        if(oper == '+' || oper == '-') return 0;
        return -1;
    }

    // �ж��ǲ���һ���������
    public static boolean isOper(char oper) {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    // ����
    public static int cal(int num1, int num2, int oper) {

        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
            default:
                return 0;
        }
    }

}