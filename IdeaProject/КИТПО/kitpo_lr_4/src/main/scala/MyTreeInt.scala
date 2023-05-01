class MyTreeInt(val newType: String) extends MyTree {
  _type = newType
  override def ParseValue(str: String): Any = {
    return str.toInt
  }

  override def Clone(): MyTree = {
    return new MyTreeInt("Integer")
  }

  override def comapareTo(obj1: Any, obj2: Any): Int = {
    if (obj1.asInstanceOf[Int] < obj2.asInstanceOf[Int]) return -1
    else if (obj1.asInstanceOf[Int] == obj2.asInstanceOf[Int]) return 0
    else return 1
  }
}