import java.net.InterfaceAddress;

public class Main {



    public static void main(String[] args) {

        MyTreeFactory f = new MyTreeFactory ();
        MyTree tree = f.createTree("String");


        tree.add("asfasf");
        tree.add("asfasfasfasfasf");
        tree.add("asfasfasfasfasfasfasf");
        tree.add("asfasfasfasfasfff");
        tree.add("l");

        System.out.println(tree.get(2));
        tree.del(2);
        System.out.println(tree.get(2));
        tree.add("llasfasdfasfasfasfasfasfasf");
        tree.add("lefffffffffffff");
        tree.add("fzfasdasd");
        tree.add("lfaasfafasfasfasfasf");
        tree.add("lffgsasfdasdasdasddasdaf");

        System.out.println(tree.get(2));
        tree.print();
    }
}

