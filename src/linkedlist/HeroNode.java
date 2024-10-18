package linkedlist;


// 定义节点对象
public class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    // 构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 输出
    @Override
    public String toString() {
        return " " + no + " name: " + name + " nickname: " + nickname;
    }
}
