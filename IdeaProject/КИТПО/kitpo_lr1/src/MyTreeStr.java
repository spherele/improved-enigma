public class MyTreeStr extends MyTree  {
    MyTreeStr(String type) {
        super(type);
    }

    @Override
    public Object parseValue(String str) {
        return (str);
    }

    @Override
    public int comapareTo(Object obj1, Object obj2) {
        String str1 = (String) obj1;
        String str2 = (String) obj2;

        if(str1.length() == str2.length()) return 0;
        else if(str1.length() > str2.length()){

            return 1;
        }
        else {

            return  -1;
        }

    }
}
