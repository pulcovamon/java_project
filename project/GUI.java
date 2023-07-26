package project;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {

    private JLabel label;
    private JLabel display_field;
    private JFrame frame;
    private JPanel panel;
    private JPanel content_panel;
    private JPanel title_panel;
    private String name = "Hill Giant";

    public GUI() {
        frame = new JFrame();

        Color background_color = new Color(20, 20, 20);
        Color inner_background_color = new Color(30, 30, 30);
        Color text_color = new Color(80, 150, 180);
        Font f1 = new Font(Font.MONOSPACED, Font.BOLD, 40);
        Font f2 = new Font(Font.MONOSPACED, Font.PLAIN, 25);
        Font f3 = new Font(Font.MONOSPACED, Font.PLAIN, 16);

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
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.setLayout(new GridLayout(0, 1));

        panel.setBackground(background_color);
        panel.setForeground(text_color);

        title_panel = new JPanel();
        title_panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        title_panel.setLayout(new FlowLayout());
        title_panel.add(display_field);
        title_panel.add(label);
        title_panel.setBackground(background_color);

        panel.add(title_panel);

        ArrayList<JPanel> monsters = new ArrayList<>();
        ArrayList<JLabel> monster_names_label = new ArrayList<>();
        ArrayList<String> monster_names = new ArrayList<>();

        ArrayList<Integer> monster_max_HP = new ArrayList<>();
        ArrayList<Integer> monster_current_HP = new ArrayList<>();
        ArrayList<Integer> monster_AC = new ArrayList<>();
        ArrayList<Integer> monster_attack_bonus = new ArrayList<>();
        ArrayList<Dice> monster_damage_roll = new ArrayList<>();

        ArrayList<JLabel> monster_max_HP_label = new ArrayList<>();
        ArrayList<JLabel> monster_current_HP_label = new ArrayList<>();
        ArrayList<JLabel> monster_AC_Label = new ArrayList<>();
        ArrayList<JLabel> monster_attack_bonus_Label = new ArrayList<>();
        ArrayList<JLabel> monster_damage_roll_label = new ArrayList<>();

        // HashMap<String, ArrayList<>> monsters_map = new HashMap<>();

        content_panel = new JPanel();
        content_panel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 20));
        content_panel.setLayout(new GridLayout(0, 3, 20, 20));
        content_panel.setBackground(background_color);
        content_panel.setForeground(text_color);

        for (int i = 0; i < 5; i++) {
            monster_names.add("Hill Giant " + i);
            monster_names_label.add(new JLabel(monster_names.get(i)));
            monster_names_label.get(i).setFont(f2);
            monster_names_label.get(i).setForeground(text_color);

            monster_max_HP.add(50);
            monster_max_HP_label.add(new JLabel("Max HP: " + monster_max_HP.get(i)));
            monster_max_HP_label.get(i).setFont(f3);
            monster_max_HP_label.get(i).setForeground(text_color);

            monster_current_HP.add(50);
            monster_current_HP_label.add(new JLabel("Current HP: " + monster_current_HP.get(i)));
            monster_current_HP_label.get(i).setFont(f3);
            monster_current_HP_label.get(i).setForeground(text_color);

            monsters.add(new JPanel());
            monsters.get(i).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            monsters.get(i).setLayout(new GridLayout(0, 1, 5, 5));
            monsters.get(i).setBackground(inner_background_color);
            monsters.get(i).setForeground(text_color);
            monsters.get(i).add(monster_names_label.get(i));
            monsters.get(i).add(monster_max_HP_label.get(i));
            monsters.get(i).add(monster_current_HP_label.get(i));
            content_panel.add(monsters.get(i));
        }

        panel.add(content_panel);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("DnD Monsters");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Huge snake");
    }

}
