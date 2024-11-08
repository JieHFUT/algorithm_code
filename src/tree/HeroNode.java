package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// ���Ľڵ�
public class HeroNode {

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public HeroNode getRight() {
        return right;
    }
    public void setRight(HeroNode right) {
        this.right = right;
    }
    public HeroNode getLeft() {
        return left;
    }
    public void setLeft(HeroNode left) {
        this.left = left;
    }


    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }





    // ǰ������ķ���
    public void preOrder() {
        // ��������׽ڵ�
        System.out.println(this);
        if (left != null)
            left.preOrder();
        if (right != null)
            right.preOrder();
    }

    // ��������ķ���
    public void infixOrder() {
        if (left != null)
            left.infixOrder();
        System.out.println(this);
        if (right != null)
            right.infixOrder();
    }

    // ��������ķ���
    public void postOrder() {
        if (left != null)
            left.postOrder();
        if (right != null)
            right.postOrder();
        System.out.println(this);
    }


    // ǰ�� ���� ���� ���ֲ��ҷ���
    public HeroNode preSearch(int toFind) {
        System.out.println("in preSearch");
        if (toFind == this.getNo()) return this;
        // ���ҵݹ�
        HeroNode result = null;
        if (this.left != null)
            result = this.left.preSearch(toFind);
        if (result != null) return result;
        if (this.right != null)
            result = this.right.preSearch(toFind);
        if (result != null) return result;
        return result;
    }

    public HeroNode infixSearch(int toFind) {
        System.out.println("in infixSearch");
        HeroNode result = null;
        if (this.left != null)
            result =  this.left.infixSearch(toFind);
        if (result != null) return result;
        if (toFind == this.getNo()) return this;
        if (this.right != null)
            result =  this.right.infixSearch(toFind);
        if (result != null) return result;
        return result;
    }

    public HeroNode postSearch(int toFind) {
        System.out.println("in postSearch");
        HeroNode result = null;
        if (this.left != null)
            result =  this.left.postSearch(toFind);
        if (result != null) return result;
        if (this.right != null)
            result = this.right.postSearch(toFind);
        if (result != null) return result;
        if (toFind == this.getNo()) return this;
        return result;
    }


    // �������Ľڵ�ɾ�������ɾ������Ҷ�ӽڵ㣬��ɾ���ýڵ�
    // ���Ҫɾ�����Ƿ�Ҷ�ӽڵ㣬ֱ��ɾ��������
    //                      => �����ĳ���ڵ�����ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľڵ㣬��ɾ����������return
    //                      => �����ĳ���ڵ�����ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľڵ㣬��ɾ����������return
    //                      => ������ҽڵ㶼û��������������������Ҫ�ݹ���������
    //                      => �����ֻ�� root �ڵ㣬�ͽ�������ÿ�
    //                      => ����Ҳ���Ҫɾ���Ľڵ㣬��ֱ�� return
    public void deleteByNo(int no) {

        if (this.getLeft() != null && this.getLeft().getNo() == no) {
            this.setLeft(null);
            return;
        }
        if (this.getRight() != null && this.getRight().getNo() == no) {
            this.setRight(null);
            return;
        }
        // �ݹ�
        if (this.getLeft() != null)
            this.getLeft().deleteByNo(no);
        if (this.getRight() != null)
            this.getRight().deleteByNo(no);
    }

    // ˳��洢������
    // Ҫ��������Ľڵ�������ķ�ʽ����ţ������ڱ��������ʱ����Ȼ���԰�������ǰ���У��������
    // ���������յ�һ��Ϊ 0 ���
    // �� n ��Ԫ�ص����ӽڵ��� 2*n+1
    // �� n ��Ԫ�ص����ӽڵ��� 2*n+2
    // �� n ��Ԫ�صĸ��׽ڵ��� (n-1)/2




}
