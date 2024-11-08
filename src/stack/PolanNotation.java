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

        // 定义一个逆波兰表达式
        String suffixExpression = "30 10 + 5 * 6 -";
        // 将字符串转成 arraylist 存储起来
        List<String> list = getListFromString(suffixExpression);
        // 将该 list 传递给 caclulate()，返回逆波兰表达式的计算结果
        System.out.println("直接逆序计算的结果是：" + caclulate(list));
        // 中缀表达式 => 后缀表达式
        List<String> list2 = getListFromMidSuffixExpression("4+(36+4)*2-4");
        System.out.println("中序转list: " + list2); // [4, +, (, 36, +, 4, ), *, 2, -, 4]
        System.out.println("中序转逆序计算的结果是: " + caclulate(midToBehind("4+(36+4)*2-4")));


    }
    // 将字符串转成 arraylist 存储起来  "30 10 + 5 * 6 -"  =>  [30, 10, +, 5, *, 6, -]
    public static List<String> getListFromString(String suffixExpression) {
        String[] expressions = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String expression : expressions) {
            list.add(expression);
        }
        return list;
    }
    // 根据传递进来的 list 数组计算其结果
    public static int caclulate(List<String> list) {
        // 创建一个栈，用于存储 list 中的数值
        Stack<String> stack = new Stack<>();
        for(String item : list) {
            // item 就是需要进栈或者出栈计算的元素
            if(item.matches("\\d+")) { // 匹配多位数
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
        // 此时栈中只剩下一个元素
        return Integer.parseInt(stack.pop());
    }

    // 中缀表达式转换为后缀表达式
    public static List<String> midToBehind(String suffixExpression) {  // 如：2+(2+4)*4-5
        // 1. 初始化两个栈, 遇到操作数直接入栈
        // 2. 如果遇到运算符时(比较运算符的优先级)
        //    1. 如果运算符栈是空的或者该运算符是 “(” 直接入栈
        //    2. 如果运算符的优先级比栈顶的运算符的优先级高，也直接压入栈(小括号不算运算符)
        //    3. 否则将运算符栈顶的运算符弹出并压入到操作数栈中 => 再次转入到 2-1 步骤，与运算符栈的栈顶比较
        // 3. 如果遇到左括号 “(” 直接压入运算符栈，如果遇到右括号 “)” 依次弹出运算符栈顶的运算符，直到遇到左括号，此时将这一对括号丢弃
        // 4. 重以上复步骤，直到表达式的最右边，将运算符栈中的运算符依次弹出并且压入到操作数栈中
        // 5. 将操作数栈中的元素出栈，得到的结果就是该后缀表达式的逆序
        int i = 0; // 用于遍历 list
        List<String> list = getListFromMidSuffixExpression(suffixExpression); // [4, +, (, 36, +, 4, ), *, 2, -, 4]
        Stack<String> operStack = new Stack<>(); // 用于存储运算符
        List<String> arrayList = new ArrayList<>(); // 用于存储操作数
        for (String item : list) {
            // 对于每一个元素, 如果是数字就直接进入 arraylist
            if (item.matches("\\d+")) {
                arrayList.add(item);
            } else if (item.equals("(") || operStack.isEmpty()) {
                operStack.push(item);
            } else if (item.equals(")")) {
                // 如果遇到右括号 “)” 依次弹出运算符栈顶的运算符，直到遇到左括号，此时将这一对括号丢弃
                while(!operStack.peek().equals("(")) {
                    arrayList.add(operStack.pop());
                }
                operStack.pop();
            } else {
                // 比较优先级,如果运算符的优先级比栈顶的运算符的优先级高，也直接压入栈
                while(!operStack.isEmpty() && PolanNotation.operPriority(item) <=
                        PolanNotation.operPriority(operStack.peek())) {
                    // 将栈中的运算符出栈，然后 add 进 arraylist 中
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

    // 将一个正常的中序字符串转换为一个 list
    public static List<String> getListFromMidSuffixExpression(String suffixExpression) {
        // "4+(36+4)*2-4"  => [4, +, (, 36, +, 4, ), *, 2, -, 4]
        int i = 0; // 索引，用来遍历该字符串
        List<String> list = new ArrayList<>();
        while(true) {
            if (suffixExpression.equals("")) return list;
            if(suffixExpression.charAt(i) < 48 || suffixExpression.charAt(i) > 57) {
                // 说明该字符不是数字，直接添加到 list 中
                list.add("" + suffixExpression.charAt(i++));
            }else {
                StringBuffer str = new StringBuffer();
                while(i < suffixExpression.length() && suffixExpression.charAt(i) >= 48 && suffixExpression.charAt(i) <= 57) {
                    // 该位置的字符是数字并且没有越界
                    str.append(suffixExpression.charAt(i++));
                }
                list.add(str.toString());
            }
            if (i == suffixExpression.length()) break;
        }
        return list;
    }

    // 返回一个运算符对应的优先级
    public static int operPriority(String operation) {
        if(operation.equals("+") || operation.equals("-"))
            return 1;
        if(operation.equals("*") || operation.equals("/"))
            return 2;
        return 0;
    }
}

