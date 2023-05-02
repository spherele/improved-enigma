








public class Tree {
    public Node create(String typeOfData){
        switch (typeOfData) {
            case "integer":
                return new IntNode();
            case "string":
                return new StrNode();
            default:
                return null;
        }
    }

}
