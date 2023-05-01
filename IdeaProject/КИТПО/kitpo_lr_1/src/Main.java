import java.net.InterfaceAddress;

public class Main {


        public static void main(String[] args) {

        Tree tree = new Tree();
        StrNode strTree = (StrNode) tree.create("string");
        int a = 1;
        int b = 100;
        strTree.add(RandomString.getAlphaNumericString(a + (int) (Math.random() * b)));
        strTree.add(RandomString.getAlphaNumericString(a + (int) (Math.random() * b)));
        strTree.add(RandomString.getAlphaNumericString(a + (int) (Math.random() * b)));
        strTree.add(RandomString.getAlphaNumericString(a + (int) (Math.random() * b)));
        strTree.add(RandomString.getAlphaNumericString(a + (int) (Math.random() * b)));
        System.out.println(strTree.get(3).getData());
        strTree.del(3);
        System.out.println(strTree.get(3).getData());
        System.out.println(strTree.get(1).getData());
        System.out.println(strTree.get(2).getData());
        System.out.println(strTree.get(3).getData());



    }
}

