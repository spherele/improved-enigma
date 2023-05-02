trait ITreeBuilder
{
  def ParseValue(str: String): Any
  def comapareTo(obj1: Any, obj2: Any): Int
  def Clone(): MyTree
}
