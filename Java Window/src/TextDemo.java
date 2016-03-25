import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextDemo extends JPanel {

    //private static JComboBox comboBox;
    private static JTextField textField;

    // Create a form with the fields
    public TextDemo() {
        super(new BorderLayout());
        // Panel for the labels
        JPanel labelPanel = new JPanel(new GridLayout(2, 1)); // 2 rows 1 column
        add(labelPanel, BorderLayout.WEST);

        // Panel for the fields
        JPanel fieldPanel = new JPanel(new GridLayout(2, 1)); // 2 rows 1 column
        add(fieldPanel, BorderLayout.CENTER);


        // Textfield
        JLabel labelTextField = new JLabel("Bank account number");
        textField = new JTextField();

        // Add labels
        //labelPanel.add(labelCombo);
        labelPanel.add(labelTextField);

        // Add fields
        //fieldPanel.add(comboBox);
        fieldPanel.add(textField);
    }

    public static void main(String[] args) {
        final TextDemo form = new TextDemo();

        // Button submit
        JButton submit = new JButton("Submit Form");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createIban((String) comboBox.getSelectedItem(), textField.getText());
            }
        });

        // Frame for our test
        JFrame f = new JFrame("Huffman Tree GUI");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(form, BorderLayout.NORTH);

        // Panel with the button
        JPanel p = new JPanel();
        p.add(submit);
        f.getContentPane().add(p, BorderLayout.SOUTH);

        // Show the frame
        f.pack();
        f.setVisible(true);
    }
}