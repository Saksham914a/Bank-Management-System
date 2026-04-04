package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField tField2;
    JPasswordField pField3;
    JButton button1, button2, button3;

    public Login() {
        super("Bank Management System");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630, 350, 100, 100);
        add(iimage);

        label1 = new JLabel("Welcome To ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(240, 125, 450, 40);
        add(label1);

        label2 = new JLabel("Card No: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setBounds(150, 190, 375, 30);
        add(label2);

        tField2 = new JTextField(15);
        tField2.setFont(new Font("Arial", Font.BOLD, 14));
        tField2.setBounds(325, 190, 230, 30);
        add(tField2);

        label3 = new JLabel("PIN: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Ralway", Font.BOLD, 28));
        label3.setBounds(150, 250, 375, 30);
        add(label3);

        pField3 = new JPasswordField(15);
        pField3.setFont(new Font("Arial", Font.BOLD, 14));
        pField3.setBounds(325, 250, 230, 30);
        add(pField3);

        button1 = new JButton("SIGN IN");
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300, 300, 100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("SIGN UP");
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(300, 350, 230, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("CLEAR");
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(430, 300, 100, 30);
        button3.addActionListener(this);
        add(button3);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0, 850, 480);
        add(iiimage);

        setLayout(null);
        setSize(850, 480);
        setLocation(300, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {
                String cardNumber = tField2.getText().trim();
                String pin = String.valueOf(pField3.getPassword()).trim();

                if (cardNumber.isEmpty() || pin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter Card Number and PIN");
                    return;
                }

                Connn c = new Connn();
                String q = "select * from login where card_number = ? and pin = ?";

                PreparedStatement ps = c.connection.prepareStatement(q);
                ps.setString(1, cardNumber);
                ps.setString(2, pin);

                ResultSet resultSet = ps.executeQuery();

                if (resultSet.next()) {
                    setVisible(false);
                    new main_Class(pin);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

                resultSet.close();
                ps.close();

            } else if (e.getSource() == button2) {
                new Signup();
                setVisible(false);

            } else if (e.getSource() == button3) {
                tField2.setText("");
                pField3.setText("");
            }
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Operation failed: " + E.getMessage());
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
