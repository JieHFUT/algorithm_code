package horse;

import java.awt.*;
import java.util.ArrayList;

/**
 * ClassName: HouseChess
 * Package: horse
 * Description:
 * 马踏棋盘
 * @Author jieHFUT
 * @Create 2024/11/7 22:52
 * @Version 1.0
 */
public class HouseChess {

    public static void main(String[] args) {
        System.out.println("骑士周游算法，开始运行~~");
        X = 8;
        Y = 8;
        int row = 1;
        int col = 1;
        int[][] chessBoard = new int[X][Y];
        isVisited = new boolean[X * Y];

        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard, row - 1, col - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时: " + (end - start) + " 毫秒");

        //输出棋盘的最后情况
        for(int[] rows : chessBoard) {
            for(int step: rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }

    }






















    // 表示棋盘的列数
    private static int X;
    // 表示棋盘的行数
    private static int Y;
    // 创建一个数组用来标记棋盘的各个位置是否被访问过
    private static boolean[] isVisited;
    // 使用一个属性，标记是否棋盘的所有位置都被访问过
    private static boolean isFinished;


    /**
     * 完成骑士周游的算法
     * @param chessBoard
     * @param row 马在第几行（下标）
     * @param col 马在第几列（下标）
     * @param step 初始值为 1
     */
    public static void traversalChessBoard(int[][] chessBoard, int row, int col, int step) {
        chessBoard[row][col] = step;
        isVisited[row * X + col] = true;
        // 找到当前位置可以走的下一个位置的集合
        ArrayList<Point> next = next(new Point(col, row));
        // 遍历可以走的位置，如果走的通就继续，走不通就回溯
        while (!next.isEmpty()) {
            // 逐个拿到可以访问的下一个点
            Point p = next.get(0);
            if (!isVisited[p.y * X + p.x]) {
                // 如果没有被访问过
                traversalChessBoard(chessBoard, p.y, p.x, step + 1);
            }
        }
        /**
         * step < X * Y
         * 1. 棋盘目前还没有走完
         * 2. 棋盘目前正在回溯
         */
        if (step < X * Y && !isFinished) {
            // 说明没有完成
            chessBoard[row][col] = 0;
            isVisited[row * X + col] = false;
        } else {
            isFinished = true;
        }
    }

    /**
     * 功能： 根据当前位置(Point对象)，计算马儿还能走哪些位置(Point)，并放入到一个集合中(ArrayList), 最多有8个位置
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        //创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<Point>();
        //创建一个Point
        Point p1 = new Point();
        //表示马儿可以走5这个位置
        if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y -1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走6这个位置
        if((p1.x = curPoint.x - 1) >=0 && (p1.y=curPoint.y-2)>=0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走7这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走0这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走1这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走2这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走3这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走4这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }



















}
