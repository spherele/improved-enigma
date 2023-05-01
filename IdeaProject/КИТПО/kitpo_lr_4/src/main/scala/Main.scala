import java.io.BufferedReader
import java.io.InputStreamReader

object Main
{
  def _View(factory: MyTreeFactory, str: String) = {
    var tree = factory.createTree(str);

    var streamReader = new InputStreamReader(System.in);
    var bufferedReader = new BufferedReader(streamReader);

    println("Заполняем дерево.");
    for (i <- 0 to 3)
    {
      println("Введите значение: ");
      var objStr: String = bufferedReader.readLine();
      tree.push(tree.ParseValue(objStr));
      println();

    }
    println("\nВыводим значения дерева в логическом порядке.");
    for(obj <- tree)
    {
      print(obj + " ");
    }
    println();
    println("\nВыводим дерево.");
    tree.myprint()
    print(tree.myStr)
    var tree_b = factory.createTree(str);
    println("\nВыводим сбалансированное дерево.");
    tree_b = tree.balanse()


    tree_b.myprint()
    print(tree_b.myStr)

    tree_b.del(1)
    println("\nВыводим сбалансированное дерево c удаленным вторым по логическому номеру элементом.");
    tree_b.myprint()
    print(tree_b.myStr)



  }

  def main(args: Array[String]): Unit  = {
    var factory: MyTreeFactory = new MyTreeFactory();

    //_View(factory, "String");
   // _View(factory, "Integer");
   val window = new Window
    window.Init()
    window.EventHandler()
  }


}
