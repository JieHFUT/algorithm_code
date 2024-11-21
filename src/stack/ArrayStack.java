package stack;

public class ArrayStack {

    private int maxSize; //  用于记录栈的大小

    private int top = -1; // 用于表示栈顶元素索引位置

    private int[] stack;

    // 构造方法
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // 判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }
    // 判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = value;
    }
    // 出栈
    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        int ret = stack[top];
        top--;
        return ret;
    }

    //显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
        System.out.println();
    }

    // 返回当前栈顶的值
    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return stack[top];
    }

    /////////////////////////////////////////////////////////////////////
    //返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
    //数字越大，则优先级就越高.
    public static int priority(int oper){
        if(oper == '*' || oper == '/') return 1;
        if(oper == '+' || oper == '-') return 0;
        return -1;
    }

    // 判断是不是一个运算符号
    public static boolean isOper(char oper) {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    // 计算
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