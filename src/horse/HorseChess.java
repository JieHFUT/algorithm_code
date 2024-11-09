package horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HorseChess {
    public static void main(String[] args) {
        System.out.println("��̤���̿�ʼ����~~~");
        int X = 8; //���̵�����
        int Y = 8; //���̵�����
        int row = 1; //����һ�п�ʼ����
        int col = 1; //����һ�п�ʼ����
        HorseChess hc = new HorseChess(X, Y);
        hc.horseChess(row - 1, col - 1, 1);
        for (int[] aRow : hc.chessBoard) {
            System.out.println(Arrays.toString(aRow));
        }
    }












    // ��̤�����㷨

    // ���̵�����
    private static int X;
    // ���̵�����
    private static int Y;
    // ����ʵ��
    int[][] chessBoard;
    // ��¼����λ���Ƿ񱻷��ʹ�
    private boolean[] isVisited;
    // ��¼�����Ƿ�ȫ���������ʹ�
    private boolean isFinished;
    // ���ڼ�¼���
    // ���췽�������г�ʼ��
    public HorseChess(int X, int Y) {
        this.X = X;
        this.Y = Y;
        this.chessBoard = new int[Y][X];
        this.isVisited = new boolean[X * Y];
    }

    public void horseChess(int row, int col, int step) {
        // ���ȼ�¼ step �������ж�Ӧ�ĵ�
        chessBoard[row][col] = step;
        // ��¼��ʼ�ĵ��� isVisited
        isVisited[row * X + col] = true;
        // ��ÿ�ʼ�����ߵ���һ���ĵ�ļ���
        ArrayList<Point> nextPoints = next(new Point(col, row));

        sort(nextPoints);
        // �����õ����һ����
        while (!nextPoints.isEmpty()) {
            // �����ó������еĵ�
            Point next = nextPoints.remove(0);
            // ��������û�б����ʹ����ͼ�������
            if (!isVisited[next.y * X + next.x]) {
                horseChess(next.y, next.x, step + 1);
            } else {
                // ����㱻���ʹ�
            }
        }
        //�ж�����Ƿ����������ʹ��   step ��Ӧ���ߵĲ����Ƚ� ��
        //���û�дﵽ���������ʾû��������񣬽�����������0
        //˵��: step < X * Y  ���������������
        //1. ���̵�Ŀǰλ��,��Ȼû������
        //2. �õ��ܱߵĵ�ȫ�����꣬���̴���һ�����ݹ���
        if (step < X * Y && !isFinished) {
            // ˵���ߵ����һ���������ڻ��ݣ�����û�гɹ�
            // ��¼�õ㲻��
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
        ArrayList<Point> pointList = new ArrayList<>();
        // �ж��������ܱߵĵ��Ƿ���Լ��뵽������
        //����һ��Point
        Point point = new Point();
        //��ʾ���������5���λ��
        if((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y -1) >= 0) {
            pointList.add(new Point(point));
        }
        //�ж����������6���λ��
        if((point.x = curPoint.x - 1) >=0 && (point.y=curPoint.y-2)>=0) {
            pointList.add(new Point(point));
        }
        //�ж����������7���λ��
        if ((point.x = curPoint.x + 1) < X && (point.y = curPoint.y - 2) >= 0) {
            pointList.add(new Point(point));
        }
        //�ж����������0���λ��
        if ((point.x = curPoint.x + 2) < X && (point.y = curPoint.y - 1) >= 0) {
            pointList.add(new Point(point));
        }
        //�ж����������1���λ��
        if ((point.x = curPoint.x + 2) < X && (point.y = curPoint.y + 1) < Y) {
            pointList.add(new Point(point));
        }
        //�ж����������2���λ��
        if ((point.x = curPoint.x + 1) < X && (point.y = curPoint.y + 2) < Y) {
            pointList.add(new Point(point));
        }
        //�ж����������3���λ��
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y + 2) < Y) {
            pointList.add(new Point(point));
        }
        //�ж����������4���λ��
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y + 1) < Y) {
            pointList.add(new Point(point));
        }
        return pointList;
    }


    //���ݵ�ǰ���һ�������е���һ����ѡ��λ�ã����зǵݼ�����, ���ٻ��ݵĴ���
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                // TODO Auto-generated method stub
                //��ȡ��o1����һ��������λ�ø���
                int count1 = next(o1).size();
                //��ȡ��o2����һ��������λ�ø���
                int count2 = next(o2).size();
                if(count1 < count2) {
                    return -1;
                } else if (count1 == count2) {
                    return 0;
                } else {
                    return 1;
                }
            }

        });
    }





}
