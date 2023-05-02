import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public abstract class MyTree  implements  ITreeBuilder{


public Node root;
public String type;

MyTree(String type){
        root = null;
        this.type = type;
}

private class Node {

        Node pLeft;
        Node pRight;
        Object data;
        Node() {
                pLeft = null;
                pRight = null;
        }

        Node(Object data) {
                this.data = data;
                pLeft = null;
                pRight = null;
        }




}



public void del(int index) {
        MyIterator iter = (MyIterator) getIterator();
        for(int i = 0; i < index - 1; i++){
                if(iter.hasNext()) {
                        iter.next();
                }
        }
        if(iter.hasNext()) {
                delFromData(root,  iter.next().data);
        }
}

private Node delFromData(Node root, Object data) {

        if(root == null) return root;

        if(comapareTo(root.data, data) == 1) {
                root.pLeft = delFromData(root.pLeft, data);
        } else if(comapareTo(root.data, data) == -1) {
                root.pRight = (delFromData(root.pRight, data));
        } else {
                if(root.pLeft == null && root.pRight == null) {
                        return null;
                } else if(root.pLeft == null) {
                        return  root.pRight;
                } else if(root.pRight == null) {
                        return  root.pLeft;
                } else {
                        Object minValue = minValue(root.pRight);
                        root.data = (minValue);
                        root.pRight=(delFromData( root.pRight, minValue));
                }
        }

        return root;
}

private Object minValue(Node node) {

        if(node.pLeft != null) {
                return minValue(node.pLeft);
        }
        return node.data;
}


public Object get(int index) {
        MyIterator iter = (MyIterator) getIterator();
        for(int i =0; i < index - 1; i++){
                if(iter.hasNext()) {
                        iter.next();
                }
        }
        if(iter.hasNext())return iter.next().data;
        else return null;
}


public void add(Object data) {
        if(root != null){
        addR(root, data);
        }else{
        root = new Node(data);
        }
}

private void addR(Node cur, Object data) {
        if(comapareTo(cur.data, data)==0) return;
        else if(comapareTo(cur.data, data) == 1){
            if(cur.pLeft == null) {
                cur.pLeft = new Node(data);

            }
            else addR(cur.pLeft, data);
        }else if(comapareTo(cur.data, data) == -1){
            if(cur.pRight == null){

                cur.pRight= new Node(data);
            }
            else addR(cur.pRight, data);
        }
}


public MyTree balance() {
        MyTreeFactory f = new MyTreeFactory ();
        MyTree result = f.createTree(type);
        MyIterator iter = (MyIterator) getIterator();
        ArrayList<Object> myvalues = new ArrayList<>();
        Object temp = null;
        while(iter.hasNext()) myvalues.add( iter.next().data);


        while (!myvalues.isEmpty()){
            result.add(myvalues.get(myvalues.size()/2));
            myvalues.remove(myvalues.size()/2);
        }
        return result;
}
    private void balanceH(ArrayList<Object> myvalues) {
        ArrayList<Object> myvaluesR = new ArrayList<>();
        ArrayList<Object> myvaluesL = new ArrayList<>();
        if (myvalues.size() !=0){
            this.add(myvalues.get(myvalues.size()/2));
        }
        for(int i = 0; i < myvalues.size(); i++){
            if(i < myvalues.size()/2){
                myvaluesR.add(myvalues.get(i));
            }else
            if(i > myvalues.size()/2){
                myvaluesL.add(myvalues.get(i));
            }
        }
        balanceH(myvaluesR);
        balanceH(myvaluesL);
    }

    public void print(){
        levelOrderTraversalUsingRecursion(root);
    }

    public void levelOrderTraversalUsingRecursion(Node node) {
        if (node == null) {
            return;
        }

        int height = getHeightOfTree(node);

        for(int i = 0; i <= height; i++) {
            printAtGivenLevel(node, i + 1);
            System.out.println();
        }
    }

    public int getHeightOfTree(Node node) {
        if(node == null){
            return -1;
        }

        return Math.max(getHeightOfTree(node.pLeft), getHeightOfTree(node.pRight)) + 1;
    }

    public void printAtGivenLevel(Node node, int level) {
        if(node == null) {
            System.out.print (" ________ ");
            return;
        }

        if(level == 1) {
            System.out.print(node.data + " ");
            return;
        }

        printAtGivenLevel(node.pLeft, level - 1);
        printAtGivenLevel(node.pRight, level - 1);
    }


public Iterator getIterator() {
        return new MyIterator(root);
        }

private class MyIterator implements Iterator{

    private Stack<Node> stack;

    public MyIterator(Node root){
        stack  =new Stack<>();
        pushAll(root);
    }

    private void pushAll(Node root){

        while (root!=null) {
            stack.push(root);
            root = root.pLeft;
        }
    }


    public boolean hasNext() {
        return !stack.isEmpty();
    }


    public Node next() {
        Node node = stack.pop();
        pushAll(node.pRight);
        return  node;
    }
}
}