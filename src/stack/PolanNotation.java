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
        System.out.println("计算的结果是：" + caclulate(list));
        // 中缀表达式 => 后缀表达式
        String behind = midToBehind(suffixExpression);

    }
    // 将字符串转成 arraylist 存储起来  "30 10 + 5 * 6 -"  =>  ["30", "10", "+", "5", "*", "6"]
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
    public static String midToBehind(String suffixExpression) {  // 如：2+(2+4)*4-5
        // 1. 初始化两个栈, 遇到操作数直接入栈
        // 2. 如果遇到运算符时(比较运算符的优先级)
        //    1. 如果运算符栈是空的或者该运算符是 “(” 直接入栈
        //    2. 如果运算符的优先级比栈顶的运算符的优先级高，也直接压入栈(小括号不算运算符)
        //    3. 否则将运算符栈顶的运算符弹出并压入到操作数栈中 => 再次转入到 2-1 步骤，与运算符栈的栈顶比较
        // 3. 如果遇到左括号 “(” 直接压入运算符栈，如果遇到右括号 “)” 依次弹出运算符栈顶的运算符，直到遇到左括号，此时将这一对括号丢弃
        // 4. 重以上复步骤，直到表达式的最右边，将运算符栈中的运算符依次弹出并且压入到操作数栈中
        // 5. 将操作数栈中的元素出栈，得到的结果就是该后缀表达式的逆序
        int i = 0; // 用于遍历 list
        List<String> list = getListFromMidSuffixExpression(suffixExpression);

        return null;
    }

    // 将一个正常的中序字符串转换为一个 list
    public static List<String> getListFromMidSuffixExpression(String suffixExpression) {
        // "4+(36+4)*2-4"  => ["4", "(", "36", "+", "4", ")", "*", "2", "-", "4"]

        return null;
    }
}

