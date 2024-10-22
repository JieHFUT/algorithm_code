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

    }
    // 将字符串转成 arraylist 存储起来
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


    public static String midToBehind(String suffixExpression) {  // 如：2+(2+4)*4-5
        // 1.

        // 2.

        // 3.

        // 4.

        return null;
    }
}

