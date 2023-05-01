public class MyTreeFactory {

    public MyTree createTree(String type){
        MyTree tree = null;

        switch (type)
        {
            case "String":
            {
                tree = new MyTreeStr(type);
                break;
            }
            case "Integer": {
                tree = new MyTreeInt(type);
                break;
            }
        }

        return tree;
    }
}
