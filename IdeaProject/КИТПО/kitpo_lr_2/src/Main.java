import java.net.InterfaceAddress;

public class Main {



    public static void main(String[] args) {

        MyTreeFactory f = new MyTreeFactory ();
        MyTree tree = f.createTree("String");
        TreeView treeView = new TreeView();
        treeView.create(tree);
    }
}

