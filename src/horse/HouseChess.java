package horse;

import java.awt.*;
import java.util.ArrayList;

/**
 * ClassName: HouseChess
 * Package: horse
 * Description:
 * ��̤����
 * @Author jieHFUT
 * @Create 2024/11/7 22:52
 * @Version 1.0
 */
public class HouseChess {

    public static void main(String[] args) {
        System.out.println("��ʿ�����㷨����ʼ����~~");
        X = 8;
        Y = 8;
        int row = 1;
        int col = 1;
        int[][] chessBoard = new int[X][Y];
        isVisited = new boolean[X * Y];

        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard, row - 1, col - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("����ʱ: " + (end - start) + " ����");

        //������̵�������
        for(int[] rows : chessBoard) {
            for(int step: rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }

    }






















    // ��ʾ���̵�����
    private static int X;
    // ��ʾ���̵�����
    private static int Y;
    // ����һ����������������̵ĸ���λ���Ƿ񱻷��ʹ�
    private static boolean[] isVisited;
    // ʹ��һ�����ԣ�����Ƿ����̵�����λ�ö������ʹ�
    private static boolean isFinished;


    /**
     * �����ʿ���ε��㷨
     * @param chessBoard
     * @param row ���ڵڼ��У��±꣩
     * @param col ���ڵڼ��У��±꣩
     * @param step ��ʼֵΪ 1
     */
    public static void traversalChessBoard(int[][] chessBoard, int row, int col, int step) {
        chessBoard[row][col] = step;
        isVisited[row * X + col] = true;
        // �ҵ���ǰλ�ÿ����ߵ���һ��λ�õļ���
        ArrayList<Point> next = next(new Point(col, row));
        // ���������ߵ�λ�ã�����ߵ�ͨ�ͼ������߲�ͨ�ͻ���
        while (!next.isEmpty()) {
            // ����õ����Է��ʵ���һ����
            Point p = next.get(0);
            if (!isVisited[p.y * X + p.x]) {
                // ���û�б����ʹ�
                traversalChessBoard(chessBoard, p.y, p.x, step + 1);
            }
        }
        /**
         * step < X * Y
         * 1. ����Ŀǰ��û������
         * 2. ����Ŀǰ���ڻ���
         */
        if (step < X * Y && !isFinished) {
            // ˵��û�����
            chessBoard[row][col] = 0;
            isVisited[row * X + col] = false;
        } else {
            isFinished = true;
        }
    }

    /**
     * ���ܣ� ���ݵ�ǰλ��(Point����)�����������������Щλ��(Point)�������뵽һ��������(ArrayList), �����8��λ��
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        //����һ��ArrayList
        ArrayList<Point> ps = new ArrayList<Point>();
        //����һ��Point
        Point p1 = new Point();
        //��ʾ���������5���λ��
        if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y -1) >= 0) {
            ps.add(new Point(p1));
        }
        //�ж����������6���λ��
        if((p1.x = curPoint.x - 1) >=0 && (p1.y=curPoint.y-2)>=0) {
            ps.add(new Point(p1));
        }
        //�ж����������7���λ��
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //�ж����������0���λ��
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //�ж����������1���λ��
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //�ж����������2���λ��
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //�ж����������3���λ��
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //�ж����������4���λ��
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }



















}
