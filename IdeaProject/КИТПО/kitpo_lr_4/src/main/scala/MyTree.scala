
import java.io.Serializable

import scala.collection.mutable
import scala.collection.mutable.Stack
abstract class MyTree extends   ITreeBuilder with Iterable[Any] with  Serializable
{
  class Node extends  Serializable
  {
    var pLeft: Node = null
    var pRight:  Node = null
    var data: Any = null
  }
  var myStr: String = ""
  var countEl: Int = 0
  var root: Node = null
  var _type: String = null
  def iterator: Iterator[Any] = {
    return new MyTreeIterator() {
    }
  }

  class MyTreeIterator extends Iterator[Any] with Serializable
  {
    var curr: Node = root
    var sizeIt: Int = 0
    var myvalues = Stack[Node]()
    pushAll(curr)

    def pushAll(cur: Node): Unit = {
      var myCur: Node = cur
      while(myCur!=null){
        myvalues.push(myCur)
        myCur = myCur.pLeft
      }
    }

    override def hasNext: Boolean = {
      !myvalues.isEmpty
    }

    override def next(): Any = {
      if (!hasNext) {
        throw new NoSuchElementException()
      }
      var delEl: Node = myvalues.pop()
      pushAll(delEl.pRight)
      return delEl.data
    }
  }

  def push(data: Any): Unit =
  {
    var a: Node = new Node()
    a.data = data
    a.pLeft = null
    a.pRight = null
    if (root == null)
    {
      countEl += 1
      root = a
    } else {
      pushR(root, a)
    }
  }

  def pushR(root: Node, newNode: Node): Unit =
  {

    if (comapareTo(root.data, newNode.data) == 1) {
      if(root.pLeft == null) {
        root.pLeft = newNode
        countEl += 1
      }else pushR(root.pLeft, newNode)
    } else if(comapareTo(root.data, newNode.data) == -1) {
      if(root.pRight == null) {
        root.pRight = newNode
        countEl += 1
      }
      else pushR(root.pRight, newNode)
    }
  }

  def balanse(): MyTree ={
    var items = new Array[Any](countEl)
    var i: Int = 0
    for(obj <- this){
      items(i) = obj
      i += 1
    }


    var l: MyTree = Clone();
    _balanse(items, l);

    return l;
  }

  def _balanse(items: Array[Any], l: MyTree): Unit = {
    var i: Int = 0
    if (items.length != 0){
      l.push(items(items.length / 2))
      var leftSize: Int = items.length / 2
      var rightSize: Int = items.length - leftSize - 1
      var left = new Array[Any](leftSize)
      var right = new Array[Any](rightSize)
      left = CopyArray(items, 0, left, leftSize)
      right = CopyArray(items, leftSize + 1, right, rightSize)
      _balanse(left, l)
      _balanse(right, l)
    }
  }

  def CopyArray(arr: Array[Any], start: Int, newArr: Array[Any], size: Int): Array[Any] = {
    for(i <- start to (start + size - 1)){
      newArr(i - start) = arr(i)
    }
    return newArr
  }

  def myprint(): Unit ={
    myStr = ""
    levelOrderTraversalUsingRecursion(root)
  }

  def get_at_index(index: Int): Any = {
    var h: Node = root;
    var cur: Int = 0;
    for(obj <- this)
    {
      cur+=1;
      if(cur == index) return obj
    }
    return null
  }
  def levelOrderTraversalUsingRecursion(curNode: Node): Unit ={
    if(curNode != null){
      var height = getHeightOfTree(curNode)
      for (i <- 0 to height) {
        printAtGivenLevel(curNode, i + 1)
        myStr += "\n"
      }

    } else myStr =""
  }

  def getHeightOfTree(curNode: Node): Int ={
    var currNode: Node = curNode
    if(currNode ==null) return -1
    return Math.max(getHeightOfTree(currNode.pLeft), getHeightOfTree(currNode.pRight)) + 1
  }

  def printAtGivenLevel(curNode: Node, level: Int): Unit = {

    if(curNode == null){
      myStr += " _ "
    }
    else if (level == 1) {
      myStr +=curNode.data + " "
    }
    else {
      printAtGivenLevel(curNode.pLeft, level - 1)
      printAtGivenLevel(curNode.pRight, level - 1)
    }
  }

  def del(index: Int): Unit ={
    var i: Int = 0
    for (obj <- this) {
      if(i == index) del_from_data( root, obj)
      i += 1
    }
  }
  def del_from_data(node: Node, data: Any): Node ={
    if(node == null) return node
    else{
      if(comapareTo(node.data, data) == 1) {
        node.pLeft = del_from_data(node.pLeft, data)
      } else if(comapareTo(node.data, data) == -1) {
        node.pRight = del_from_data(node.pRight, data)
      } else {
        if(node.pLeft == null && node.pRight == null) {
          return null
        } else if(node.pLeft == null) {
          return  node.pRight
        } else if(node.pRight == null) {
          return  node.pLeft
        } else {

          node.data = minValue(node.pRight)
          node.pRight=del_from_data( node.pRight, minValue(node.pRight))
        }
      }
      return node
    }
  }

  def minValue(node: Node): Any ={

    if(node.pLeft != null) {
      return minValue(node.pLeft)
    }else return node.data
  }

}
