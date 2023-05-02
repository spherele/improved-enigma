import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class StrNode implements Node{

    private String data;
    private StrNode pLeft;
    private StrNode pRight;
    private StrNode root;

    StrNode(){
        pLeft = null;
        pRight= null;
        root = null;
    }

    StrNode(StrNode intNode){
        pLeft = (StrNode) intNode.getpLeft();
        pRight= (StrNode) intNode.getpRight();
        root = (StrNode) intNode.getRoot();
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = (String) data;
    }



    @Override
    public void setRoot(Node cur) {
        this.root = (StrNode) cur;
    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public void setpRight(Node cur) {
        this.pRight = (StrNode) cur;
    }

    @Override
    public void setpLeft(Node cur) {
        this.pLeft = (StrNode) cur;
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
        return (this.data.compareTo((String)cur.getData()));

    }

    @Override
    public void del(int index) {
        StrIterator iter = (StrIterator) getIterator();
        for(int i =0; i < index - 1; i++){
            if(iter.hasNext()) {
                iter.next();
            }
        }
        if(iter.hasNext()) {
            delFromData(root, (String) iter.next().getData());
        }
    }

    private StrNode delFromData(StrNode root, String data) {

        if(root == null) return root;

        if(data.compareTo((String) root.getData()) < 0) {
            root.setpLeft(delFromData((StrNode) root.getpLeft(), data));
        } else if(data.compareTo((String) root.getData()) > 0) {
            root.setpRight(delFromData((StrNode) root.getpRight(), data));
        } else {
            if(root.getpLeft() == null && root.getpRight() == null) {
                return null;
            } else if(root.getpLeft() == null) {

                return (StrNode) root.getpRight();
            } else if(root.getpRight() == null) {

                return (StrNode) root.getpLeft();
            } else {
                String minValue = minValue(root.getpRight());
                root.setData(minValue);
                root.setpRight(delFromData((StrNode) root.getpRight(), minValue));
            }
        }

        return root;
    }

    private String minValue(Node node) {

        if(node.getpLeft() != null) {
            return minValue(node.getpLeft());
        }
        return (String) node.getData();
    }

    @Override
    public Node get(int index) {
        StrIterator iter = (StrIterator) getIterator();
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
            StrNode cur = new StrNode();
            cur.setData(data);
            root.addR(cur);
        }else{
            root = new StrNode();
            root.setData(data);
        }
    }

    public void addR(Node cur) {
        if(this.comparableTo(cur)==0) return;
        else if(this.comparableTo(cur) > 0){
            if(this.getpLeft() == null) this.setpLeft(cur);
            else this.getpLeft().addR(cur);
        }else if(this.comparableTo(cur) < 0){
            if(this.getpRight() == null) this.setpRight(cur);
            else this.getpRight().addR(cur);
        }
    }

    @Override
    public Node balance() {
        StrIterator iter = (StrIterator) getIterator();
        ArrayList<String> myvalues = new ArrayList<>();
        while(iter.hasNext()) myvalues.add((String) iter.next().getData());
        StrNode temp  = new StrNode();
        Collections.sort( myvalues);
        while(!myvalues.isEmpty()){
            temp.add(myvalues.get(myvalues.size()/2));
            myvalues.remove(myvalues.size()/2);
        }
        return temp;
    }


    @Override
    public Iterator getIterator() {
        return new StrIterator(root);
    }

    private class StrIterator implements Iterator{

        private Stack<StrNode> stack;

        public StrIterator(StrNode root){
            stack  =new Stack<>();
            pushAll(root);
        }

        private void pushAll(StrNode root){

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
        public StrNode next() {
            StrNode node = stack.pop();
            pushAll(node.pRight);
            return  node;
        }
    }
}