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


    // 前序 中序 后序 三种查找方法
    public HeroNode preSearch(int toFind) {
        System.out.println("in preSearch");
        if (toFind == this.getNo()) return this;
        // 左、右递归
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

    // 二叉树的节点删除
    


}
