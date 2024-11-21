package stack;

import java.util.Scanner;


// 处理多位数的时候
public class Calculator2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        System.out.println("请输入计算表达式：");
        String input = sc.nextLine(); // "7-3+2*3-6"  = 4
        int index = 0;
        String keepNum = "";
        while(true) {
            // 获得此时字符串的首个元素
            char ch = input.charAt(index);
            // 判断是不是运算符
            if(ArrayStack.isOper(ch)) {
                // 是运算符，获得该元素的优先级和 operStack 栈中的栈顶比较
                // operStack 是空的直接入栈
                // 如果 operStack 为非空的，并且该运算符的优先级小于等于栈顶的运算符的优先级 => 计算
                if(!operStack.isEmpty() && ArrayStack.priority(ch)
                        <= ArrayStack.priority(operStack.peek())) {
                    // 优先级低 => 计算
                    // 1. 取出 numStack 中的两个数字和当前 operStack.peek() 进行运算，运算结果存入 numStack，ch 存入 operStack
                    numStack.push(ArrayStack.cal(numStack.pop(), numStack.pop(), operStack.pop()));
                    operStack.push(ch);
                } else {
                    operStack.push(ch);
                }
            } else {
                // ch 是数字
                // numStack.push(Integer.parseInt(String.valueOf(ch)));
                // 在处理多位数的时候，需要向后看一位，如果下一位是数字，就继续扫描，否则就直接入栈
                keepNum += ch;
                if (index == input.length() - 1) {
                    // 当前的 ch 已经是 input 的最后一个字符了
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    // 对下一个字符进行判断
                    if(ArrayStack.isOper(input.charAt(index + 1))) {
                        // 下一个字符是运算符，直接将该 keepNum push 到 numStack 中   "1" "343"
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= input.length())
                break;
        }

        // 然后对两个栈进行出栈 => 计算最终结果
        while(true) {
            if (operStack.isEmpty())
                break;
            numStack.push(ArrayStack.cal(numStack.pop(), numStack.pop(), operStack.pop()));
        }
        // 此时 numStack 中剩下的那一个就是结果
        System.out.printf("计算结果是：%d", numStack.pop());
    }
}
