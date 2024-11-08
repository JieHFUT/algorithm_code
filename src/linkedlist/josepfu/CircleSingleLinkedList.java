package linkedlist.josepfu;

// ����һ�����ε�������
public class CircleSingleLinkedList {

    // ����һ�� first �ڵ�
    private Boy first;


    // ���С���ڵ㣬������������
    public void addBoy (int nums) {
        // ����У��
        if(nums < 1) return;

        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            // ���ݱ�ţ�����С���ڵ�
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    // ������ǰ�����б����еĽڵ� N ���ˣ��� M ��ʼ, ÿ�� K ����һ��
    public void showBoy() {
        if (first == null) return;
        Boy curBoy = first;
        while (true) {
            System.out.print(curBoy.getNo() + "\t");
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
        System.out.println();
    }


    /**
     * �����û������룬����һ��С����Ȧ��˳��
     * @param startNo ��ʾ�ӵڼ���С����ʼ����
     * @param countNo ��ʾ������
     * @param nums ��ʾ����ж���С����Ȧ��
     */
    public void countBoy(int startNo, int countNo, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("Invalid input");
            return;
        }
        Boy helper = first;

        // ���� helper ָ�����һ���ڵ�
        while(true) {
            if (helper.getNext() == first)
                break;
            helper = helper.getNext();
        }

        for (int i = 0; i < startNo -1 ; i++) {
            helper = helper.getNext();
            first = first.getNext();
        }
        //��С������ʱ����first �� helper ָ��ͬʱ ���ƶ�  m  - 1 ��, Ȼ���Ȧ
        //������һ��ѭ��������֪��Ȧ��ֻ��һ���ڵ�
        while(true) {
            if (first == helper) {
                break; // ˵��Ȧ��Ŀǰֻʣ��һ���ڵ���
            }
            for (int i = 0; i < countNo - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("��Ҫ��Ȧ���� %d\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("���һ����Ȧ���� %d\n", helper.getNo());
    }

}
