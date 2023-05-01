public class MyTreeInt extends MyTree {
    MyTreeInt(String type) {
        super(type);
    }

    @Override
    public Object parseValue(String str) {
        return (Integer.parseInt(str));
    }

    @Override
    public int comapareTo(Object obj1, Object obj2) {
        if((Integer) obj1 == (Integer) obj2) return 0;
        else if((Integer) obj1 > (Integer) obj2) return 1;
        else  return -1;
    }
}
