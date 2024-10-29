package tree;

public class BinaryTree {

    // 根节点
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    // 前序遍历
    public void preOrder() {
        if (root != null)
            root.preOrder();
        else
            System.out.println("tree is null");
    }

    // 中序遍历
    public void infixOrder() {
        if (root != null)
            root.infixOrder();
        else
            System.out.println("tree is null");
    }

    // 后序遍历
    public void postOrder() {
        if (root != null)
            root.postOrder();
        else
            System.out.println("tree is null");
    }


    // 前序 中序 后序 遍历查找
    public HeroNode preSearch(int toFind) {
        if (root != null)
            return this.root.preSearch(toFind);
        throw new RuntimeException("tree is null");
    }
    public HeroNode infixSearch(int toFind) {
        if (root != null)
            return this.root.infixSearch(toFind);
        throw new RuntimeException("tree is null");
    }
    public HeroNode postSearch(int toFind) {
        if (root != null)
            return this.root.postSearch(toFind);
        throw new RuntimeException("tree is null");
    }




}
