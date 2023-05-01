public interface Node{
    Object getData();
    void setData(Object Data);
    void setRoot(Node cur);
    Node getRoot();
    void setpRight(Node cur);
    void setpLeft(Node cur);
    Node getpLeft();
    Node getpRight();
    int comparableTo(Node cur);
    void del(int index);
    Node get(int index);
    void add(Object data);
    Iterator getIterator();
    void addR(Node cur);
    Node balance();
}