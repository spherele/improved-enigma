class MyTreeFactory {
  def createTree(_type: String): MyTree =
  {
    var list: MyTree = null;

    _type match
    {
      case "String" =>
      {
        list = new MyTreeStr(_type)
      }
      case "Integer" =>
      {
        //list = new MyTreeInt(_type)
      }
    }
    return list
  }
}