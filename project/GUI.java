package project;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {

    private JLabel label;
    private JLabel display_field;
    private JFrame frame;
    private JPanel panel;
    private JPanel content_panel;
    private String name = "Hill Giant";

    public GUI() {
        frame = new JFrame();

        Color background_color = new Color(20, 20, 20);
        Color inner_background_color = new Color(30, 30, 30);
        Color text_color = new Color(80, 150, 180);
        Font f1 = new Font(Font.MONOSPACED, Font.BOLD, 40);
        Font f2 = new Font(Font.MONOSPACED, Font.PLAIN, 25);

        ImageIcon dice_image_icon = new ImageIcon("/home/monika/Desktop/programming/java/DM_organizer/project/d20.png");
        Image dice_image = dice_image_icon.getImage().getScaledInstance(
                dice_image_icon.getIconWidth() / 10,
                dice_image_icon.getIconHeight() / 10,
                Image.SCALE_SMOOTH);
        dice_image_icon = new ImageIcon(dice_image);

        display_field = new JLabel(dice_image_icon);

        label = new JLabel("Monsters");
        label.setForeground(text_color);
        label.setFont(f1);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 50));
        panel.setLayout(new GridLayout());

        panel.setBackground(background_color);
        panel.setForeground(text_color);

        panel.add(display_field, BorderLayout.WEST);
        panel.add(label, BorderLayout.CENTER);

        JLabel name_label = new JLabel(name);
        name_label.setFont(f2);
        name_label.setForeground(text_color);
        content_panel = new JPanel();
        content_panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        // content_panel.setLayout(new GridLayout());
        content_panel.add(name_label);
        content_panel.setBackground(inner_background_color);
        content_panel.setForeground(text_color);

        panel.add(content_panel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("DnD Monsters");
        frame.pack();
        frame.setVisible(true);

        /*
         * JButton button = new JButton("Click me!");
         * button.addActionListener(this);
         * panel.add(button);
         */
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Huge snake");
    }

}
