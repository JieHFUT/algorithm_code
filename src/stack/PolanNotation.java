package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: PolanNotation
 * Package: stack
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/10/22 21:58
 * @Version 1.0
 */
public class PolanNotation {

    public static void main(String[] args) {

        // ����һ���沨�����ʽ
        String suffixExpression = "30 10 + 5 * 6 -";
        // ���ַ���ת�� arraylist �洢����
        List<String> list = getListFromString(suffixExpression);
        // ���� list ���ݸ� caclulate()�������沨�����ʽ�ļ�����
        System.out.println("ֱ���������Ľ���ǣ�" + caclulate(list));
        // ��׺���ʽ => ��׺���ʽ
        List<String> list2 = getListFromMidSuffixExpression("4+(36+4)*2-4");
        System.out.println("����תlist: " + list2); // [4, +, (, 36, +, 4, ), *, 2, -, 4]
        System.out.println("����ת�������Ľ����: " + caclulate(midToBehind("4+(36+4)*2-4")));


    }
    // ���ַ���ת�� arraylist �洢����  "30 10 + 5 * 6 -"  =>  [30, 10, +, 5, *, 6, -]
    public static List<String> getListFromString(String suffixExpression) {
        String[] expressions = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String expression : expressions) {
            list.add(expression);
        }
        return list;
    }
    // ���ݴ��ݽ����� list �����������
    public static int caclulate(List<String> list) {
        // ����һ��ջ�����ڴ洢 list �е���ֵ
        Stack<String> stack = new Stack<>();
        for(String item : list) {
            // item ������Ҫ��ջ���߳�ջ�����Ԫ��
            if(item.matches("\\d+")) { // ƥ���λ��
                stack.push(item);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (item.equals("+"))
                    stack.push(String.valueOf(num1 + num2));
                else if (item.equals("-"))
                    stack.push(String.valueOf(num2 - num1));
                else if(item.equals("*"))
                    stack.push(String.valueOf(num1 * num2));
                else if(item.equals("/"))
                    stack.push(String.valueOf(num2 / num1));
                else
                    throw new RuntimeException("oper is unsupported");
            }
        }
        // ��ʱջ��ֻʣ��һ��Ԫ��
        return Integer.parseInt(stack.pop());
    }

    // ��׺���ʽת��Ϊ��׺���ʽ
    public static List<String> midToBehind(String suffixExpression) {  // �磺2+(2+4)*4-5
        // 1. ��ʼ������ջ, ����������ֱ����ջ
        // 2. ������������ʱ(�Ƚ�����������ȼ�)
        //    1. ��������ջ�ǿյĻ��߸�������� ��(�� ֱ����ջ
        //    2. �������������ȼ���ջ��������������ȼ��ߣ�Ҳֱ��ѹ��ջ(С���Ų��������)
        //    3. ���������ջ���������������ѹ�뵽������ջ�� => �ٴ�ת�뵽 2-1 ���裬�������ջ��ջ���Ƚ�
        // 3. ������������� ��(�� ֱ��ѹ�������ջ��������������� ��)�� ���ε��������ջ�����������ֱ�����������ţ���ʱ����һ�����Ŷ���
        // 4. �����ϸ����裬ֱ�����ʽ�����ұߣ��������ջ�е���������ε�������ѹ�뵽������ջ��
        // 5. ��������ջ�е�Ԫ�س�ջ���õ��Ľ�����Ǹú�׺���ʽ������
        int i = 0; // ���ڱ��� list
        List<String> list = getListFromMidSuffixExpression(suffixExpression); // [4, +, (, 36, +, 4, ), *, 2, -, 4]
        Stack<String> operStack = new Stack<>(); // ���ڴ洢�����
        List<String> arrayList = new ArrayList<>(); // ���ڴ洢������
        for (String item : list) {
            // ����ÿһ��Ԫ��, ��������־�ֱ�ӽ��� arraylist
            if (item.matches("\\d+")) {
                arrayList.add(item);
            } else if (item.equals("(") || operStack.isEmpty()) {
                operStack.push(item);
            } else if (item.equals(")")) {
                // ������������� ��)�� ���ε��������ջ�����������ֱ�����������ţ���ʱ����һ�����Ŷ���
                while(!operStack.peek().equals("(")) {
                    arrayList.add(operStack.pop());
                }
                operStack.pop();
            } else {
                // �Ƚ����ȼ�,�������������ȼ���ջ��������������ȼ��ߣ�Ҳֱ��ѹ��ջ
                while(!operStack.isEmpty() && PolanNotation.operPriority(item) <=
                        PolanNotation.operPriority(operStack.peek())) {
                    // ��ջ�е��������ջ��Ȼ�� add �� arraylist ��
                    arrayList.add(operStack.pop());
                }
                operStack.push(item);
            }
        }
        while(!operStack.isEmpty()) {
            arrayList.add(operStack.pop());
        }
        return arrayList;
    }

    // ��һ�������������ַ���ת��Ϊһ�� list
    public static List<String> getListFromMidSuffixExpression(String suffixExpression) {
        // "4+(36+4)*2-4"  => [4, +, (, 36, +, 4, ), *, 2, -, 4]
        int i = 0; // �����������������ַ���
        List<String> list = new ArrayList<>();
        while(true) {
            if (suffixExpression.equals("")) return list;
            if(suffixExpression.charAt(i) < 48 || suffixExpression.charAt(i) > 57) {
                // ˵�����ַ��������֣�ֱ����ӵ� list ��
                list.add("" + suffixExpression.charAt(i++));
            }else {
                StringBuffer str = new StringBuffer();
                while(i < suffixExpression.length() && suffixExpression.charAt(i) >= 48 && suffixExpression.charAt(i) <= 57) {
                    // ��λ�õ��ַ������ֲ���û��Խ��
                    str.append(suffixExpression.charAt(i++));
                }
                list.add(str.toString());
            }
            if (i == suffixExpression.length()) break;
        }
        return list;
    }

    // ����һ���������Ӧ�����ȼ�
    public static int operPriority(String operation) {
        if(operation.equals("+") || operation.equals("-"))
            return 1;
        if(operation.equals("*") || operation.equals("/"))
            return 2;
        return 0;
    }
}

