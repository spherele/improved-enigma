import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TreeView extends JFrame implements View {
    static protected JFrame main_frame;
    static protected JButton add = new JButton("Добавить"),
            del = new JButton("Удалить"), search = new JButton("Найти"), save = new JButton("Сохранить"),
            get = new JButton("Загрузить"), balance = new JButton("Балансировка");
    static protected JTextField area = new JTextField();
    static protected JTextArea  myTreeText = new JTextArea(50, 100);
    static protected JTextField result=  new JTextField("");
    static protected JPanel  myPanel;
    static final private int HEIGHT = 600;
    static final private int WIDTH = 1200;
    protected MyTree tree;
    @Override
    public void create(MyTree mytree) {
        MyTreeFactory f = new MyTreeFactory ();
        tree = f.createTree(mytree.type);
        tree.copy(mytree);
        main_frame = new JFrame("ЛР2");
        main_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        main_frame.setResizable(false);
        main_frame.requestFocus();
        main_frame.setFocusTraversalKeysEnabled(false);
        Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
        main_frame.setSize(WIDTH, HEIGHT);
        main_frame.setLocation(screen_size.width / 4, screen_size.height / 4);

        create_panel();
        main_frame.setVisible(true);
    }
    private void create_panel(){

        myPanel = new JPanel( new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();




        constraints.fill = GridBagConstraints.HORIZONTAL;


        constraints.weightx = 0.5;
        constraints.gridx   = 1  ;  // нулевая ячейка таблицы по вертикали
        constraints.gridy   = 0  ;
        myPanel.add(area, constraints);
        constraints.weightx = 0.5;
        constraints.gridx   = 2  ;  // нулевая ячейка таблицы по вертикали
        constraints.gridy   = 0  ;
        myPanel.add(search, constraints);
        constraints.weightx = 0.5;
        constraints.gridx   = 3  ;  // нулевая ячейка таблицы по вертикали
        constraints.gridy   = 0  ;
        myPanel.add(add, constraints);
        constraints.weightx = 0.5;
        constraints.gridx   = 4  ;  // нулевая ячейка таблицы по вертикали
        constraints.gridy   = 0  ;
        myPanel.add(del, constraints);
        constraints.weightx = 0.5;
        constraints.gridwidth = 1;
        constraints.gridx   = 1  ;  // нулевая ячейка таблицы по вертикали
        constraints.gridy   = 1  ;

        result.setEditable(false);
        myPanel.add(result, constraints);
        constraints.weightx = 0.5;
        constraints.gridwidth = 1;
        constraints.gridx   = 3  ;  // нулевая ячейка таблицы по вертикали
        constraints.gridy   = 1  ;


        myPanel.add(save, constraints);
        constraints.weightx = 0.5;
        constraints.gridwidth = 1;
        constraints.gridx   = 2  ;  // нулевая ячейка таблицы по вертикали
        constraints.gridy   = 1  ;


        myPanel.add(balance, constraints);
        constraints.weightx = 0.5;
        constraints.gridwidth = 1;
        constraints.gridx   = 4  ;  // нулевая ячейка таблицы по вертикали
        constraints.gridy   = 1  ;


        myPanel.add(get, constraints);
        constraints.weighty = 5;
        constraints.ipady = 450;
        constraints.gridwidth = 5;
        constraints.gridx   = 0  ;  // нулевая ячейка таблицы по вертикали
        constraints.gridy   = 2  ;


        String a = tree.seeTree;
        myTreeText.setText(a);
        myTreeText.setEditable(false);
        myPanel.add(myTreeText, constraints);




        main_frame.add(myPanel);
        main_frame.repaint();


        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            tree.add(area.getText());
            tree.print();
            String a1 = tree.seeTree;
            myTreeText.setText(a1);
            main_frame.repaint();
            }
        });
        del.addActionListener(e -> {

            tree.del(Integer.parseInt(area.getText()));
            tree.print();
            String a1 = tree.seeTree;
            myTreeText.setText(a1);
            main_frame.repaint();
        });
        balance.addActionListener(e -> {

            tree.copy(tree.balance());
            tree.print();
            String a1 = tree.seeTree;
            myTreeText.setText(a1);
            main_frame.repaint();
        });
        search.addActionListener(e -> {


            String cur = "Элемент : "  +  tree.get(Integer.parseInt(area.getText()));
           result.setText(cur);
            String a1 = tree.seeTree;
            myTreeText.setText(a1);
            main_frame.repaint();
        });

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    try {
                        FileOutputStream f = new FileOutputStream(file);
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        o.writeObject(tree);
                        o.close();
                        f.close();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });
        get.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    try {
                        FileInputStream fi = new FileInputStream(file);
                        ObjectInputStream oi = new ObjectInputStream(fi);

                        MyTree pr1 = (MyTree) oi.readObject();
                        tree.copy(pr1);
                        String a1 = tree.seeTree;
                        myTreeText.setText(a1);
                        oi.close();
                        fi.close();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }
}
