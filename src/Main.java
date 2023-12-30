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
                        window.setTitle("Блокнот");
                        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\oraza\\Downloads\\goth man.jpg");
                        window.setIconImage(icon);
                        window.getContentPane().setBackground(Color.BLACK);
                        window.setLocationRelativeTo(null);

                        // Text area
                        JTextArea textArea = new JTextArea();
                        textArea.setForeground(Color.WHITE);
                        textArea.setBackground(Color.BLACK);
                        textArea.setFont(new Font("Minster No 1", Font.PLAIN, 33));

                        // Scroll pane
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                        window.add(scrollPane, BorderLayout.CENTER);
                        window.setVisible(true);

                        JOptionPane.showMessageDialog(window, "Welcome to my first project", "", JOptionPane.INFORMATION_MESSAGE);

                        // Save button
                        JButton saveButton = new JButton("Save");
                        saveButton.addActionListener(e -> {
                                JFileChooser fileChooser = new JFileChooser();
                                int option = fileChooser.showSaveDialog(window);
                                if (option == JFileChooser.APPROVE_OPTION) {
                                        File file = fileChooser.getSelectedFile();
                                        saveTextToFile(textArea.getText(), file);
                                        JOptionPane.showMessageDialog(window, "Text saved successfully!");
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