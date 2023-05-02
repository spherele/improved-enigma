import java.awt.event.ActionEvent

import javax.swing._
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream


class Window extends JFrame {
  private val WIDTH = 270
  private val HEIGHT = 475

  private val panel = new JPanel

  private val btnCreateTree = new JButton("Создать дерево")
  private val btnPushObject = new JButton("Вставить объект в дерево")
  private val btnGetAtIndex = new JButton("Получить объект по индексу")
  private val btnDelAtIndex = new JButton("Удалить объект по индексу")
  private val btnBalance = new JButton("Балансировка дерева")
  private val btnShowTree = new JButton("Показать дерево")
  private val btnSaveFactory = new JButton("Сохранить дерево")
  private val btnLoadFactory = new JButton("Загрузить дерево")

  private val fileName = "factory.dat"
  private val TreeTypes = Array("String", "Integer")

  private val factory = new MyTreeFactory
  var myTree: MyTree = null

  def Init(): Unit = {
    this.setLayout(null)
    this.setSize(WIDTH, HEIGHT)
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    this.setResizable(false)
    panel.setLayout(null)
    panel.setBounds(0, 0, WIDTH, HEIGHT)
    btnCreateTree.setBounds(5, 0, 250, 50)
    panel.add(btnCreateTree)
    btnPushObject.setBounds(5, 55, 250, 50)
    panel.add(btnPushObject)
    btnGetAtIndex.setBounds(5, 110, 250, 50)
    panel.add(btnGetAtIndex)
    btnDelAtIndex.setBounds(5, 165, 250, 50)
    panel.add(btnDelAtIndex)
    btnBalance.setBounds(5, 220, 250, 50)
    panel.add(btnBalance)
    btnShowTree.setBounds(5, 275, 250, 50)
    panel.add(btnShowTree)
    btnSaveFactory.setBounds(5, 330, 250, 50)
    panel.add(btnSaveFactory)
    btnLoadFactory.setBounds(5, 385, 250, 50)
    panel.add(btnLoadFactory)
    this.add(panel)
    this.setVisible(true)
  }

  def EventHandler(): Unit = {
    btnCreateTree.addActionListener((e: ActionEvent) => {
      def foo(e: ActionEvent) = {

        val `type`: String = JOptionPane.showInputDialog(this, "Введите тип дерева:\n" +
          TreeTypes(0) + "\n" + TreeTypes(1),
          TreeTypes(0))
        if (`type` != null && TreeTypes.contains(`type`))
          myTree = factory.createTree(`type`)
        else
          JOptionPane.showMessageDialog(this, "Тип введён неверно!")

      }

      foo(e)
    })
    btnPushObject.addActionListener((e: ActionEvent) => {
      def foo(e: ActionEvent) = {
        if (myTree != null) {
          val obj = JOptionPane.showInputDialog(this, "Введите объект", "0")
          if (obj != null) myTree.push(myTree.ParseValue(obj))
        }
        else JOptionPane.showMessageDialog(this, "Дерево не инициализировано!")
      }

      foo(e)
    })

    btnGetAtIndex.addActionListener((e: ActionEvent) => {
      def foo(e: ActionEvent) = {
        if (myTree != null) {
          val index = JOptionPane.showInputDialog(this, "Введите индекс", "0")
          if (index != null) JOptionPane.showMessageDialog(this, myTree.get_at_index(index.toInt))
        }
        else JOptionPane.showMessageDialog(this, "Дерево не инициализировано!")
      }

      foo(e)
    })
    btnDelAtIndex.addActionListener((e: ActionEvent) => {
      def foo(e: ActionEvent) = {
        if (myTree != null) {
          val index = JOptionPane.showInputDialog(this, "Введите индекс", "0")
          if (index != null) myTree.del(index.toInt)
        }
        else JOptionPane.showMessageDialog(this, "Дерево не инициализировано!")
      }

      foo(e)
    })
    btnBalance.addActionListener((e: ActionEvent) => {
      def foo(e: ActionEvent) = {
        if (myTree != null) {
          myTree = myTree.balanse()
          JOptionPane.showMessageDialog(this, "Дерево сбалансированно!")
        }
        else JOptionPane.showMessageDialog(this, "Дерево не инициализировано!")
      }

      foo(e)
    })
    btnShowTree.addActionListener((e: ActionEvent) => {
      def foo(e: ActionEvent) = {
        if (myTree != null) {
          myTree.myprint()
          JOptionPane.showMessageDialog(this, myTree.myStr)
        }
        else JOptionPane.showMessageDialog(this, "Дерево не инициализировано!")
      }

      foo(e)
    })
    btnSaveFactory.addActionListener((e: ActionEvent) => {
      def foo(e: ActionEvent) = {
        try {
          val oos = new ObjectOutputStream(new FileOutputStream(fileName))
          try if ( myTree != null) {
            oos.writeObject(myTree)
            JOptionPane.showMessageDialog(this, "Дерево успешно сохранено!")
          }
          else JOptionPane.showMessageDialog(this, "Дерево не инициализировано!")
          catch {
            case ex: Exception =>
              println(ex.getMessage)
          } finally if (oos != null) oos.close()
        }
      }

      foo(e)
    })
    btnLoadFactory.addActionListener((e: ActionEvent) => {
      def foo(e: ActionEvent) = {
        try {
          val ois = new ObjectInputStream(new FileInputStream(fileName))
          try {

            val myNewTree: MyTree = ois.readObject.asInstanceOf[MyTree]
            myTree = myNewTree
            JOptionPane.showMessageDialog(this, "Дерево типа " + myTree._type + " успешно загружено!")
          } catch {
            case ex: Exception =>
              JOptionPane.showMessageDialog(this, ex.getMessage)
              println(ex.getMessage)
          } finally if (ois != null) ois.close()
        }
      }

      foo(e)
    })
  }

}