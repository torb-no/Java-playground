import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JTextField nameField;
    private JTextField ageField;
    private JTextArea outputArea;

    public MainFrame() {
        super("In The Court Of The Crimson King");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Name")); // 0,0
        inputPanel.add(nameField = new JTextField()); // 0,1
        inputPanel.add(new JLabel("Age")); // 1,0
        inputPanel.add(ageField = new JTextField()); // 1,1

        // Output panel
        JPanel outputPanel = new JPanel();
        outputPanel.add(outputArea = new JTextArea(10, 30));

        // Top panel
        JPanel topPanel = new JPanel();
//        topPanel.setLayout(new BorderLayout());
        topPanel.add(inputPanel, BorderLayout.WEST);
        topPanel.add(outputPanel, BorderLayout.EAST);

        // Container
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(topPanel, BorderLayout.NORTH);

        JButton button = new JButton("Clicky clicky!");
        button.addActionListener(new ButtonListener());
        container.add(button, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String s = nameField.getText() + " is " + ageField.getText() + " years old \n";
            outputArea.append(s);
            nameField.setText("");
            ageField.setText("");
        }
    }

}
