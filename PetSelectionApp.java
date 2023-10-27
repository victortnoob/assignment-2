import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PetSelectionApp {
    private JFrame frame;
    private JPanel panel;
    private JLabel petLabel;
    private ButtonGroup buttonGroup;

    public PetSelectionApp() {
        frame = new JFrame("Pet Selection App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        panel = new JPanel();
        frame.add(panel);

        buttonGroup = new ButtonGroup();

        createRadioButton("Cat", "cat.png");
        createRadioButton("Dog", "dog.png");
        createRadioButton("Bird", "bird.png");
        createRadioButton("Fish", "fish.png");
        createRadioButton("Turtle", "turtle.png");

        petLabel = new JLabel();
        panel.add(petLabel);

        frame.setVisible(true);
    }

    private void createRadioButton(String petName, String imageName) {
        JRadioButton radioButton = new JRadioButton(petName);
        radioButton.setActionCommand(imageName);

        radioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String imageName = e.getActionCommand();
                showSelectedPet(imageName);
            }
        });

        buttonGroup.add(radioButton);
        panel.add(radioButton);
    }

    private void showSelectedPet(String imageName) {
        ImageIcon icon = new ImageIcon(imageName);
        petLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PetSelectionApp();
            }
        });
    }
}