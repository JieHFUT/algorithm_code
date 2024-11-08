package stack;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        System.out.println("�����������ʽ��");
        String input = sc.nextLine(); // "7-3+2*3-6"  = 4
        int index = 0;
        while(true) {
            // ��ô�ʱ�ַ������׸�Ԫ��
            char ch = input.charAt(index);
            // �ж��ǲ��������
            if(ArrayStack.isOper(ch)) {
                // �����������ø�Ԫ�ص����ȼ��� operStack ջ�е�ջ���Ƚ�
                // operStack �ǿյ�ֱ����ջ
                // ��� operStack Ϊ�ǿյģ����Ҹ�����������ȼ�С�ڵ���ջ��������������ȼ� => ����
                if(!operStack.isEmpty() && ArrayStack.priority(ch)
                        <= ArrayStack.priority(operStack.peek())) {
                    // ���ȼ��� => ����
                    // 1. ȡ�� numStack �е��������ֺ͵�ǰ operStack.peek() �������㣬���������� numStack��ch ���� operStack
                    numStack.push(ArrayStack.cal(numStack.pop(), numStack.pop(), operStack.pop()));
                    operStack.push(ch);
                } else {
                    operStack.push(ch);
                }
            } else {
                // ������
                numStack.push(Integer.parseInt(String.valueOf(ch)));
            }
            index++;
            if (index >= input.length())
                break;
        }

        // Ȼ�������ջ���г�ջ => �������ս��
        while(true) {
            if (operStack.isEmpty())
                break;
            numStack.push(ArrayStack.cal(numStack.pop(), numStack.pop(), operStack.pop()));
        }
        // ��ʱ numStack ��ʣ�µ���һ�����ǽ��
        System.out.printf("�������ǣ�%d", numStack.pop());
    }
}
