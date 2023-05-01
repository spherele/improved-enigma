class MyTreeStr(val _type: String) extends MyTree {

  override def ParseValue(str: String): Any = {
    return str
  }

  override def comapareTo(obj1: Any, obj2: Any): Int = {
    if (obj1.asInstanceOf[String].compareTo(obj2.asInstanceOf[String]) < 0) return -1
    else if (obj1.asInstanceOf[String].compareTo(obj2.asInstanceOf[String]) > 0) return 1
    else return 0
  }
    override def Clone(): MyTree = {
      return new MyTreeStr("String")
    }

}