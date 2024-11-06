package kruskal;


// 用来表示一条边的信息
public class Link {
    String start;
    String end;
    int weight;

    public Link(String start, String end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Link [start=" + start + ", end=" + end + ", weight=" + weight + "]";
    }
}
