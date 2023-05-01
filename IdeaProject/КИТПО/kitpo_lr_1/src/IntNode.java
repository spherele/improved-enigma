import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class IntNode implements Node{

private int data;
private IntNode pLeft;
private IntNode pRight;
private IntNode root;

        IntNode(){
        pLeft = null;
        pRight= null;
        root = null;
        }

        IntNode(IntNode intNode){
        pLeft = (IntNode) intNode.getpLeft();
        pRight= (IntNode) intNode.getpRight();
        root = (IntNode) intNode.getRoot();
        }

@Override
public Object getData() {
        return data;
        }

@Override
public void setData(Object data) {
        this.data = (int) data;
        }



@Override
public void setRoot(Node cur) {
        this.root = (IntNode) cur;
        }

@Override
public Node getRoot() {
        return root;
        }

@Override
public void setpRight(Node cur) {
        this.pRight = (IntNode) cur;
        }

@Override
public void setpLeft(Node cur) {
        this.pLeft = (IntNode) cur;
        }


@Override
public Node getpLeft() {
        return pLeft;
        }

@Override
public Node getpRight() {
        return pRight;
        }


@Override
public int comparableTo(Node cur) {
        if(this.data == (int)cur.getData()) return 0;
        else if(this.data > (int)cur.getData())return 1;
        else return -1;
        }

@Override
public void del(int index) {
        IntIterator iter = (IntIterator) getIterator();
        for(int i =0; i < index - 1; i++){
        if(iter.hasNext()) {
        iter.next();
        }
        }
        if(iter.hasNext()) {
        delFromData(root, (Integer) iter.next().getData());
        }
        }

private IntNode delFromData(IntNode root, int data) {

        if(root == null) return root;

        if(data < (int)root.getData()) {
        root.setpLeft(delFromData((IntNode) root.getpLeft(), data));
        } else if(data > (int) root.getData()) {
        root.setpRight(delFromData((IntNode) root.getpRight(), data));
        } else {
        if(root.getpLeft() == null && root.getpRight() == null) {
        return null;
        } else if(root.getpLeft() == null) {

        return (IntNode) root.getpRight();
        } else if(root.getpRight() == null) {

        return (IntNode) root.getpLeft();
        } else {
        Integer minValue = minValue(root.getpRight());
        root.setData(minValue);
        root.setpRight(delFromData((IntNode) root.getpRight(), minValue));
        }
        }

        return root;
        }

private Integer minValue(Node node) {

        if(node.getpLeft() != null) {
        return minValue(node.getpLeft());
        }
        return (Integer) node.getData();
        }

@Override
public Node get(int index) {
        IntIterator iter = (IntIterator) getIterator();
        for(int i =0; i < index - 1; i++){
        if(iter.hasNext()) {
        iter.next();
        }
        }
        if(iter.hasNext())return iter.next();
        else return null;
        }

@Override
public void add(Object data) {
        if(root != null){
        IntNode cur = new IntNode();
        cur.setData(data);
        root.addR(cur);
        }else{
        root = new IntNode();
        root.setData(data);
        }
        }

public void addR(Node cur) {
        if(this.comparableTo(cur)==0) return;
        else if(this.comparableTo(cur) == 1){
        if(this.getpLeft() == null) this.setpLeft(cur);
        else this.getpLeft().addR(cur);
        }else if(this.comparableTo(cur) == -1){
        if(this.getpRight() == null) this.setpRight(cur);
        else this.getpRight().addR(cur);
        }
        }

@Override
public Node balance() {
        IntIterator iter = (IntIterator) getIterator();
        ArrayList<Integer> myvalues = new ArrayList<>();
        while(iter.hasNext()) myvalues.add((Integer) iter.next().getData());
        IntNode temp  = new IntNode();
        Collections.sort( myvalues);
        while(!myvalues.isEmpty()){
        temp.add(myvalues.get(myvalues.size()/2));
        myvalues.remove(myvalues.size()/2);
        }
        return temp;
        }


@Override
public Iterator getIterator() {
        return new IntIterator(root);
        }

private class IntIterator implements Iterator{

    private Stack<IntNode> stack;

    public IntIterator(IntNode root){
        stack  =new Stack<>();
        pushAll(root);
    }

    private void pushAll(IntNode root){

        while (root!=null) {
            stack.push(root);
            root = root.pLeft;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public IntNode next() {
        IntNode node = stack.pop();
        pushAll(node.pRight);
        return  node;
    }
}
}