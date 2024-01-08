import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ButtonGroup;
public class Main extends JFrame {
        public static void main(String[] args) {
                SwingUtilities.invokeLater(() -> {
                        JFrame window = new JFrame();
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        window.setSize(900, 500);
                        window.setTitle("Goth note");
                        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\oraza\\Downloads\\goth man.jpg");
                        window.setIconImage(icon);
                        window.getContentPane().setBackground(Color.BLACK);
                        window.setLocationRelativeTo(null);

                        // Text area
                        JTextArea textArea = new JTextArea();
                        textArea.setForeground(Color.RED);
                        textArea.setBackground(Color.BLACK);
                        //textArea.setFont(new Font("Minster No 1", Font.PLAIN, 33));//only english font
                        textArea.setFont(new Font("Schwabacher",Font.PLAIN,33));//with two font
                        textArea.setFont(new Font("Minister No 1",Font.PLAIN,33));
                        textArea.setCaretColor(Color.MAGENTA);

                        //textArea.setFont(new Font("HelmswaldPost",Font.PLAIN,33));
                        //saveButton.setText("change");

                        // Scroll pane
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        scrollPane.getVerticalScrollBar().setBackground(Color.black);
                        scrollPane.getHorizontalScrollBar().setBackground(Color.black);
                        window.add(scrollPane, BorderLayout.CENTER);
                        window.setVisible(true);

                        JOptionPane.showMessageDialog(window, "\uD835\uDD82\uD835\uDD8A\uD835\uDD91\uD835\uDD88\uD835\uDD94\uD835\uDD92\uD835\uDD8A \uD835\uDD99\uD835\uDD94 \uD835\uDD92\uD835\uDD9E \uD835\uDD8B\uD835\uDD8E\uD835\uDD97\uD835\uDD98\uD835\uDD99 \uD835\uDD95\uD835\uDD97\uD835\uDD94\uD835\uDD8F\uD835\uDD8A\uD835\uDD88\uD835\uDD99", "", JOptionPane.INFORMATION_MESSAGE);

                        // Save button
                        JButton saveButton = new JButton("\uD835\uDD7E\uD835\uDD86\uD835\uDD9B\uD835\uDD8A");
                        saveButton.setForeground(Color.RED);
                        saveButton.setBackground(Color.BLACK);
                        //Change font button
                        JMenuBar menubar = new JMenuBar();
                        UIManager.put("MenuBar.background",Color.BLACK);
                        JMenu menu = new JMenu("Font");
                        menu.setForeground(Color.RED);
                        menubar.setLayout(new GridBagLayout());
                        menubar.add(menu);
                        menu.setBorderPainted(true);
                        UIManager.put("PopupMenu.border",BorderFactory.createLineBorder(Color.WHITE));
//подменю
                        UIManager.put("MenuItem.selectionForeground",Color.WHITE);//for menuItem1--------------
                        UIManager.put("MenuItem.selectionBackground",Color.BLACK);
                        JMenuItem menuItem1 = new JMenuItem("Goth",KeyEvent.VK_N);
                        menuItem1.setBackground(Color.BLACK);
                        menuItem1.setForeground(Color.RED);
                        menuItem1.setContentAreaFilled(false);
                        UIManager.put("MenuItem.selectionBackground",Color.BLACK); //for menuItem2--------------
                        UIManager.put("MenuItem.selectionForeground",Color.WHITE);
                        menu.add(menuItem1);
                        JMenuItem menuItem2 = new JMenuItem("Goth2",KeyEvent.VK_0);
                        menuItem2.setBackground(Color.BLACK);
                        menuItem2.setForeground(Color.RED);

                        menu.add(menuItem2);
                        menuItem2.setEnabled(true);
                        window.setJMenuBar(menubar);
                        //Buttons SIZEs place
                        saveButton.addActionListener(e -> {
                                JFileChooser fileChooser = new JFileChooser();
                                int option = fileChooser.showSaveDialog(window);
                                if (option == JFileChooser.APPROVE_OPTION) {
                                        File file = fileChooser.getSelectedFile();
                                        saveTextToFile(textArea.getText(), file);
                                        JOptionPane.showMessageDialog(window, "\uD835\uDD7F\uD835\uDD8A\uD835\uDD9D\uD835\uDD99 \uD835\uDD98\uD835\uDD86\uD835\uDD9B\uD835\uDD8A\uD835\uDD89 \uD835\uDD98\uD835\uDD9A\uD835\uDD88\uD835\uDD88\uD835\uDD8A\uD835\uDD98\uD835\uDD98\uD835\uDD8B\uD835\uDD9A\uD835\uDD91\uD835\uDD91\uD835\uDD9E!");
                                }
                        });
                        menuItem1.addActionListener(e ->{
                                textArea.setFont(new Font("Minster No 1",Font.PLAIN,33));
                        });
                        menuItem2.addActionListener(e ->{
                                textArea.setFont(new Font("Schwabacher",Font.PLAIN,33));
                        });

                        window.add(saveButton, BorderLayout.SOUTH);
                });
        }

        private static void saveTextToFile(String text, File file) {
                try (FileWriter writer = new FileWriter(file)) {
                        writer.write(text);
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}
