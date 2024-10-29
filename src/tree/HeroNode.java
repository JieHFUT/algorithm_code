package tree;


// 树的节点
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





    // 前序遍历的方法
    public void preOrder() {
        // 先输出父亲节点
        System.out.println(this);
        if (left != null)
            left.preOrder();
        if (right != null)
            right.preOrder();
    }

    // 中序遍历的方法
    public void infixOrder() {
        if (left != null)
            left.infixOrder();
        System.out.println(this);
        if (right != null)
            right.infixOrder();
    }

    // 后序遍历的方法
    public void postOrder() {
        if (left != null)
            left.postOrder();
        if (right != null)
            right.postOrder();
        System.out.println(this);
    }


}
