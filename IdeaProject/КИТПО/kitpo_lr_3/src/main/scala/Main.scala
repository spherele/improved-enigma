import java.io.BufferedReader
import java.io.InputStreamReader

object Main
{
  def _View(factory: MyTreeFactory, str: String) = {
    var tree = factory.createTree(str);

    var streamReader = new InputStreamReader(System.in);
    var bufferedReader = new BufferedReader(streamReader);

    println("Заполняем дервео.");
    for (i <- 0 to 3)
    {
      println("Введите значение: ");
      var objStr: String = bufferedReader.readLine();
      tree.push(tree.ParseValue(objStr));
      println();

    }
    println("\nВыводим список с помощью цикла foreach.");
    for(obj <- tree)
    {
      print(obj + " ");
    }
    println();
    println("\nВыводим список.");
    tree.myprint()

    var tree_b = factory.createTree(str);
    println("\nВыводим сбалансированный список.");
    tree_b = tree.balanse()


    tree_b.myprint()


    tree_b.del(1)
    println("\nВыводим сбалансированный список c удаленным вторым по логическому номеру элементом.");
    tree_b.myprint()



  }

  def main(args: Array[String]): Unit  = {
    var factory: MyTreeFactory = new MyTreeFactory();

    _View(factory, "String");
    _View(factory, "Integer");
  }


}
