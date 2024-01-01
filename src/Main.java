import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
                        textArea.setForeground(Color.WHITE);
                        textArea.setBackground(Color.BLACK);
                        textArea.setFont(new Font("Minster No 1", Font.PLAIN, 33));//only english font
                        textArea.setFont(new Font("Schwabacher",Font.PLAIN,33));//with two font
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
                        //change font button
                        JButton font = new JButton("\uD835\uDD16\uD835\uDD1E\uD835\uDD2A\uD835\uDD2D\uD835\uDD29\uD835\uDD22 \uD835\uDD17\uD835\uDD22\uD835\uDD35\uD835\uDD31");
                        font.setForeground(Color.RED);
                        font.setBackground(Color.BLACK);
                        //window.add(font,BorderLayout.LINE_END);
                        font.setPreferredSize(new Dimension(-50,50));
                        window.add(font,BorderLayout.PAGE_START);


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
