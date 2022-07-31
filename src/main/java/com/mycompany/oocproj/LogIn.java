package com.mycompany.oocproj;

/* Authors:
4SO19CS021 - Ankith Thomas
4SO19CS034 - Avinash Muralidharan
4SO19CS037 - Binse Varghese
4SO19CS054 - Glen Rebello
*/

import java.util.*; //Imports needed for methods used
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogIn { //Class definition
    
    LogIn() { //Constructor definition
        JFrame main = new JFrame("Healthcare System Database"); //Login frame declaration                                   
        main.setSize(800, 600);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color g = new Color(51, 51, 51);
        Color f = new Color(77, 77, 77);
        Color b = new Color(64, 64, 64);
        main.getContentPane().setBackground(g);
        Font font = new Font("Segoe UI", Font.BOLD, 28);
        main.setLocationRelativeTo(null);

        JPanel p = new JPanel(); //half panel
        p.setSize(400, 600);
        p.setBackground(b);
        p.setLayout(null);
        main.add(p);

        JPanel c1 = new JPanel(); //Plus logo
        c1.setSize(100, 20);
        c1.setBackground(Color.red);
        c1.setLocation(150, 290);
        c1.setLayout(null);
        p.add(c1);

        JPanel c2 = new JPanel();
        c2.setSize(20, 100);
        c2.setBackground(Color.red);
        c2.setLocation(190, 250);
        c2.setLayout(null);
        p.add(c2);

        JPanel c3 = new JPanel();
        c3.setSize(110, 30);
        c3.setBackground(Color.white);
        c3.setLocation(145, 285);
        c3.setLayout(null);
        p.add(c3);

        JPanel c4 = new JPanel();
        c4.setSize(30, 110);
        c4.setBackground(Color.white);
        c4.setLocation(185, 245);
        c4.setLayout(null);
        p.add(c4);

        JLabel Title = new JLabel("Healthcare System"); //Title
        Title.setBounds(80, 80, 250, 150);
        Title.setForeground(Color.white);
        Title.setFont(font);
        
        JLabel Title2 = new JLabel("Database"); //Title2
        Title2.setBounds(138, 125, 250, 150);
        Title2.setForeground(Color.white);
        Title2.setFont(font);

        JLabel LoginText = new JLabel("Please enter your credentials"); //Login space
        LoginText.setBounds(450, 150, 300, 150);
        LoginText.setForeground(Color.white);
        LoginText.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        JLabel L1 = new JLabel("Username: ");
        L1.setBounds(450, 250, 100, 30);
        L1.setForeground(Color.white);
        L1.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        JLabel L2 = new JLabel("Password: ");
        L2.setBounds(450, 300, 100, 30);
        L2.setForeground(Color.white);
        L2.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        JTextField User = new JTextField();
        User.setBounds(525, 250, 150, 30);
        User.setForeground(Color.white);
        User.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        User.setBackground(f);

        JPasswordField Pass = new JPasswordField();
        Pass.setBounds(525, 300, 150, 30);
        Pass.setForeground(Color.white);
        Pass.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Pass.setBackground(f);

        JButton LoginButton = new JButton("Login");
        LoginButton.setBounds(575, 340, 50, 30);
        LoginButton.setBackground(b);
        LoginButton.setForeground(Color.white);
        LoginButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JButton Exit = new JButton("Exit");
        Exit.setBounds(700, 500, 60, 30);
        Exit.setBackground(b);
        Exit.setForeground(Color.white);
        Exit.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        main.add(User);
        main.add(Pass);
        main.add(LoginButton);
        main.add(Exit);
        p.add(Title);
        p.add(Title2);
        main.add(LoginText);
        main.add(L1);
        main.add(L2);

        main.setLayout(null);
        main.setVisible(true);

        LoginButton.addActionListener(new ActionListener() { //Login Button functionality

            public void actionPerformed(ActionEvent e) {

                if (User.getText().equalsIgnoreCase("admin") && Arrays.equals(Pass.getPassword(), new char[]{'a', 'd', 'm', 'i', 'n'})) { //Credentials verification
                    UIManager um = new UIManager();
                    um.put("OptionPane.messageForeground", Color.white);
                    um.put("OptionPane.background", g);
                    um.put("Panel.background", g);
                    JOptionPane.showMessageDialog(null, "Login Successful.", "", JOptionPane.INFORMATION_MESSAGE);
                    main.dispose();
                    new MainMenu();
                } else {
                    UIManager um = new UIManager();
                    um.put("OptionPane.messageForeground", Color.white);
                    um.put("OptionPane.background", g);
                    um.put("Panel.background", g);
                    JOptionPane.showMessageDialog(null, "Invalid Credentials.", "", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });

        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //Program closes if exit button is pressed
            }
        });
    }

    public static void main(String args[]) {
        new LogIn(); //Constructor call in main
    }
}
