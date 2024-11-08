package linkedlist.singlelinkeklist;


// ����ڵ����
public class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    // ������
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // ���
    @Override
    public String toString() {
        return "[" + no + " name: " + name + " nickname: " + nickname + "]";
    }
}
