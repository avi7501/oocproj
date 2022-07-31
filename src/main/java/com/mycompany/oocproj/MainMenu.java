package com.mycompany.oocproj;

/* Authors:
4SO19CS021 - Ankith Thomas
4SO19CS034 - Avinash Muralidharan
4SO19CS037 - Binse Varghese
4SO19CS054 - Glen Rebello
 */
import javax.swing.*; //Imports needed for methods used
import java.awt.*;
import java.util.*;
import javax.swing.Timer;
import java.text.DateFormat;
import java.awt.event.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.time.LocalDateTime;

public class MainMenu {

    public static String[][] Visit = new String[50][7]; //Declaration and initialisation of public static variables used in MainMenu class
    public static String[][] VisitTab = new String[50][6];
    public static String[][] Send = new String[50][12];
    public static String[] date = new String[50];
    public static String[] month = new String[50];
    public static String[] year = new String[50];
    public static int[] check = new int[50];
    public static int[] check2 = new int[50];
    public static int Num = 100;
    public static int i = -1, r = -1, l = -1, j = -1, z = -1, flag = 0;

    MainMenu() {
        JFrame mainmenu = new JFrame("Healthcare System Database"); //Main Menu frame declaration
        mainmenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color g = new Color(51, 51, 51);
        Color f = new Color(77, 77, 77);
        Color b = new Color(64, 64, 64);
        Color cmoon = new Color(255, 255, 102);
        mainmenu.getContentPane().setBackground(g);

        JPanel p = new JPanel(); //Plus Logo
        p.setSize(480, 1080);
        p.setBackground(b);
        p.setLayout(null);
        mainmenu.add(p);

        JLabel Title2 = new JLabel("Welcome, Administrator"); //Welcome
        Title2.setBounds(42, 115, 400, 150);
        Title2.setForeground(Color.white);
        Title2.setFont(Title2.getFont().deriveFont(32f));
        p.add(Title2);

        JLabel Title3 = new JLabel("Current Date & Time:"); //Welcome
        Title3.setBounds(42, 190, 400, 150);
        Title3.setForeground(Color.white);
        Title3.setFont(Title3.getFont().deriveFont(20f));
        p.add(Title3);

        JLabel Time = new JLabel();//Time
        Time.setBounds(42, 220, 300, 150);
        Time.setForeground(Color.white);
        Time.setFont(Time.getFont().deriveFont(20f));
        p.add(Time);

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Time.setText(DateFormat.getDateTimeInstance().format(new Date()));
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();

        JLabel Sun = new JLabel("☀");
        Sun.setBounds(160, 300, 300, 300);
        Sun.setForeground(Color.yellow);
        Sun.setFont(Sun.getFont().deriveFont(200f));

        JLabel Moon = new JLabel("🌙");
        Moon.setBounds(150, 300, 300, 300);
        Moon.setForeground(cmoon);
        Moon.setFont(Moon.getFont().deriveFont(160f));

        if (LocalDateTime.now().getHour() >= 6 && LocalDateTime.now().getHour() <= 18) {

            p.add(Sun);
        } else {
            p.add(Moon);
        }

        JButton AddNew = new JButton("Add Patient to Database"); //Adding buttons to main menu
        AddNew.setBounds(923, 200, 200, 50);
        AddNew.setBackground(b);
        AddNew.setForeground(Color.white);
        AddNew.setFocusable(false);
        AddNew.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JButton Search = new JButton("Search For a Patient");
        Search.setBounds(923, 275, 200, 50);
        Search.setBackground(b);
        Search.setForeground(Color.white);
        Search.setFocusable(false);
        Search.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JButton Delete = new JButton("Delete Patient Details");
        Delete.setBounds(923, 425, 200, 50);
        Delete.setBackground(b);
        Delete.setForeground(Color.white);
        Delete.setFocusable(false);
        Delete.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JButton Edit = new JButton("Edit Patient Details");
        Edit.setBounds(923, 350, 200, 50);
        Edit.setBackground(b);
        Edit.setForeground(Color.white);
        Edit.setFocusable(false);
        Edit.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JButton View = new JButton("View Database");
        View.setBounds(923, 500, 200, 50);
        View.setBackground(b);
        View.setForeground(Color.white);
        View.setFocusable(false);
        View.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JButton visit = new JButton("View All Visits");
        visit.setBounds(923, 570, 200, 50);
        visit.setBackground(b);
        visit.setForeground(Color.white);
        visit.setFocusable(false);
        visit.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        JButton Logout = new JButton("Logout");
        Logout.setBounds(1420, 25, 85, 30);
        Logout.setBackground(b);
        Logout.setForeground(Color.white);
        Logout.setFocusable(false);
        Logout.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        mainmenu.add(AddNew);
        mainmenu.add(Edit);
        mainmenu.add(Search);
        mainmenu.add(Delete);
        mainmenu.add(View);
        mainmenu.add(visit);
        mainmenu.add(Logout);

        mainmenu.setLayout(null);
        mainmenu.setVisible(true);

        AddNew.addActionListener(new ActionListener() { //Add Patient button functionality

            public void actionPerformed(ActionEvent e) {
                JFrame AddBox = new JFrame("Add New Patient"); //Add patient screen declaration
                AddBox.setSize(900, 600);
                Color g = new Color(51, 51, 51);
                Color f = new Color(77, 77, 77);
                Color b = new Color(64, 64, 64);
                AddBox.getContentPane().setBackground(g);
                AddBox.setLocationRelativeTo(null);
                Font font = new Font("Verdana", Font.BOLD, 12);

                JLabel AddInfo = new JLabel("Enter Patient Details: "); //Label and Text Field declarations for taking various inputs for a patient
                AddInfo.setBounds(30, 25, 600, 40);
                AddInfo.setForeground(Color.white);
                AddInfo.setFont(AddInfo.getFont().deriveFont(32f));
                AddBox.add(AddInfo);

                JLabel FNamelbl = new JLabel("First Name:");
                FNamelbl.setBounds(30, 100, 160, 20);
                FNamelbl.setForeground(Color.white);
                FNamelbl.setFont(font);
                AddBox.add(FNamelbl);

                JTextField FNamebox = new JTextField();
                FNamebox.setBounds(200, 100, 150, 20);
                FNamebox.setForeground(Color.white);
                FNamebox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                FNamebox.setBackground(f);
                AddBox.add(FNamebox);

                JLabel LNamelbl = new JLabel("Last Name:");
                LNamelbl.setBounds(30, 150, 160, 20);
                LNamelbl.setForeground(Color.white);
                LNamelbl.setFont(font);
                AddBox.add(LNamelbl);

                JTextField LNamebox = new JTextField();
                LNamebox.setBounds(200, 150, 150, 20);
                LNamebox.setForeground(Color.white);
                LNamebox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                LNamebox.setBackground(f);
                AddBox.add(LNamebox);

                JLabel Phnlbl = new JLabel("Phone:");
                Phnlbl.setBounds(30, 200, 120, 20);
                Phnlbl.setForeground(Color.white);
                Phnlbl.setFont(font);
                AddBox.add(Phnlbl);

                JTextField Phnbox = new JTextField();
                Phnbox.setBounds(200, 200, 150, 20);
                Phnbox.setForeground(Color.white);
                Phnbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                Phnbox.setBackground(f);
                AddBox.add(Phnbox);

                JLabel Emaillbl = new JLabel("Email:");
                Emaillbl.setBounds(30, 250, 80, 20);
                Emaillbl.setForeground(Color.white);
                Emaillbl.setFont(font);
                AddBox.add(Emaillbl);

                JTextField Emailbox = new JTextField();
                Emailbox.setBounds(200, 250, 150, 20);
                Emailbox.setForeground(Color.white);
                Emailbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                Emailbox.setBackground(f);
                AddBox.add(Emailbox);

                JLabel Bgrplbl = new JLabel("Blood Group:");
                Bgrplbl.setBounds(30, 300, 200, 20);
                Bgrplbl.setForeground(Color.white);
                Bgrplbl.setFont(font);
                AddBox.add(Bgrplbl);

                String Bgrps[] = {"A+", "B+", "O+", "AB+", "A-", "B-", "O-", "AB-"};
                JComboBox cmbBgrp = new JComboBox(Bgrps);
                cmbBgrp.setBounds(200, 300, 50, 20);
                cmbBgrp.setForeground(Color.white);
                cmbBgrp.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                cmbBgrp.setBackground(f);
                AddBox.add(cmbBgrp);

                JLabel Addresslbl = new JLabel("Address:");
                Addresslbl.setBounds(30, 350, 150, 20);
                Addresslbl.setForeground(Color.white);
                Addresslbl.setFont(font);
                AddBox.add(Addresslbl);

                JTextField Addressbox = new JTextField();
                Addressbox.setBounds(200, 350, 400, 100);
                Addressbox.setForeground(Color.white);
                Addressbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                Addressbox.setBackground(f);
                AddBox.add(Addressbox);

                JLabel AgeLabel = new JLabel("Age (in years):");
                AgeLabel.setBounds(500, 100, 160, 20);
                AgeLabel.setForeground(Color.white);
                AgeLabel.setFont(font);
                AddBox.add(AgeLabel);

                JTextField AgeBox = new JTextField();
                AgeBox.setBounds(670, 100, 35, 20);
                AgeBox.setForeground(Color.white);
                AgeBox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                AgeBox.setBackground(f);
                AddBox.add(AgeBox);

                JLabel WeightLabel = new JLabel("Weight (in KGs):");
                WeightLabel.setBounds(500, 150, 160, 20);
                WeightLabel.setForeground(Color.white);
                WeightLabel.setFont(font);
                AddBox.add(WeightLabel);

                JTextField WeightBox = new JTextField();
                WeightBox.setBounds(670, 150, 45, 20);
                WeightBox.setForeground(Color.white);
                WeightBox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                WeightBox.setBackground(f);
                AddBox.add(WeightBox);

                JLabel HeightLabel = new JLabel("Height (in cms):");
                HeightLabel.setBounds(500, 200, 160, 20);
                HeightLabel.setForeground(Color.white);
                HeightLabel.setFont(font);
                AddBox.add(HeightLabel);

                JTextField HeightBox = new JTextField();
                HeightBox.setBounds(670, 200, 45, 20);
                HeightBox.setForeground(Color.white);
                HeightBox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                HeightBox.setBackground(f);
                AddBox.add(HeightBox);

                JLabel GenderLabel = new JLabel("Gender:");
                GenderLabel.setBounds(500, 250, 160, 20);
                GenderLabel.setForeground(Color.white);
                GenderLabel.setFont(font);
                AddBox.add(GenderLabel);

                String Genders[] = {"Male", "Female", "Other"};
                JComboBox cmbGender = new JComboBox(Genders);
                cmbGender.setBounds(670, 250, 75, 20);
                cmbGender.setForeground(Color.white);
                cmbGender.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                cmbGender.setBackground(f);
                AddBox.add(cmbGender);

                JButton OK = new JButton("OK");
                OK.setBounds(400, 500, 75, 50);
                OK.setBackground(b);
                OK.setForeground(Color.white);
                OK.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                AddBox.add(OK);

                JButton Back = new JButton("Back");
                Back.setBounds(750, 25, 85, 30);
                Back.setBackground(b);
                Back.setForeground(Color.white);
                Back.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                Back.setFont(Back.getFont().deriveFont(10f));
                AddBox.add(Back);

                OK.addActionListener(new ActionListener() { //OK button functionality

                    public void actionPerformed(ActionEvent e) {

                        if (FNamebox.getText().equals("")) { //Warning option panes for wrong inputs and exceptions
                            UIManager um = new UIManager();
                            um.put("OptionPane.messageForeground", Color.white);
                            um.put("OptionPane.background", g);
                            um.put("Panel.background", g);
                            JOptionPane.showMessageDialog(null, "Please enter a first name.", "", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        if (LNamebox.getText().equals("")) {
                            UIManager um = new UIManager();
                            um.put("OptionPane.messageForeground", Color.white);
                            um.put("OptionPane.background", g);
                            um.put("Panel.background", g);
                            JOptionPane.showMessageDialog(null, "Please enter a last name.", "", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        if (Phnbox.getText().equals("")) {
                            UIManager um = new UIManager();
                            um.put("OptionPane.messageForeground", Color.white);
                            um.put("OptionPane.background", g);
                            um.put("Panel.background", g);
                            JOptionPane.showMessageDialog(null, "Please enter a phone number.", "", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        if (Emailbox.getText().equals("")) {
                            UIManager um = new UIManager();
                            um.put("OptionPane.messageForeground", Color.white);
                            um.put("OptionPane.background", g);
                            um.put("Panel.background", g);
                            JOptionPane.showMessageDialog(null, "Please enter an Email.", "", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        if (Addressbox.getText().equals("")) {
                            UIManager um = new UIManager();
                            um.put("OptionPane.messageForeground", Color.white);
                            um.put("OptionPane.background", g);
                            um.put("Panel.background", g);
                            JOptionPane.showMessageDialog(null, "Please enter an address.", "", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        if (AgeBox.getText().equals("")) {
                            UIManager um = new UIManager();
                            um.put("OptionPane.messageForeground", Color.white);
                            um.put("OptionPane.background", g);
                            um.put("Panel.background", g);
                            JOptionPane.showMessageDialog(null, "Please enter an age.", "", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        try {

                            if (Integer.parseInt(AgeBox.getText()) < 0 || Integer.parseInt(AgeBox.getText()) > 121) {
                                UIManager um = new UIManager();
                                um.put("OptionPane.messageForeground", Color.white);
                                um.put("OptionPane.background", g);
                                um.put("Panel.background", g);
                                JOptionPane.showMessageDialog(null, "Please enter a valid age.", "", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }

                        } catch (NumberFormatException m) {
                            UIManager um = new UIManager();
                            um.put("OptionPane.messageForeground", Color.white);
                            um.put("OptionPane.background", g);
                            um.put("Panel.background", g);
                            JOptionPane.showMessageDialog(null, "Please enter a valid age.", "", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        try {

                            if (WeightBox.getText().equals("")) {
                                UIManager um = new UIManager();
                                um.put("OptionPane.messageForeground", Color.white);
                                um.put("OptionPane.background", g);
                                um.put("Panel.background", g);
                                JOptionPane.showMessageDialog(null, "Please enter a weight.", "", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }
                        } catch (NumberFormatException m) {
                            UIManager um = new UIManager();
                            um.put("OptionPane.messageForeground", Color.white);
                            um.put("OptionPane.background", g);
                            um.put("Panel.background", g);
                            JOptionPane.showMessageDialog(null, "Please enter a valid weight.", "", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        if (HeightBox.getText().equals("")) {
                            UIManager um = new UIManager();
                            um.put("OptionPane.messageForeground", Color.white);
                            um.put("OptionPane.background", g);
                            um.put("Panel.background", g);
                            JOptionPane.showMessageDialog(null, "Please enter a height.", "", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        try {
                            if (Integer.parseInt(HeightBox.getText()) < 0 || Integer.parseInt(HeightBox.getText()) > 250) {
                                UIManager um = new UIManager();
                                um.put("OptionPane.messageForeground", Color.white);
                                um.put("OptionPane.background", g);
                                um.put("Panel.background", g);
                                JOptionPane.showMessageDialog(null, "Please enter a valid height.", "", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }
                        } catch (NumberFormatException m) {
                            UIManager um = new UIManager();
                            um.put("OptionPane.messageForeground", Color.white);
                            um.put("OptionPane.background", g);
                            um.put("Panel.background", g);
                            JOptionPane.showMessageDialog(null, "Please enter a valid height.", "", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                        i++; //Getting inputs from Text fields and incrementing database index
                        Num++;
                        Send[i][0] = "A" + Num;
                        Send[i][1] = FNamebox.getText();
                        Send[i][2] = LNamebox.getText();
                        Send[i][3] = Phnbox.getText();
                        Send[i][4] = Emailbox.getText();
                        Send[i][5] = Bgrps[cmbBgrp.getSelectedIndex()];
                        Send[i][6] = Addressbox.getText();
                        Send[i][7] = AgeBox.getText();
                        Send[i][8] = WeightBox.getText();
                        Send[i][9] = HeightBox.getText();
                        Send[i][10] = Genders[cmbGender.getSelectedIndex()];
                        Send[i][11] = String.format("%.1f", ((Float.parseFloat(WeightBox.getText()) / Float.parseFloat(HeightBox.getText()) / Float.parseFloat(HeightBox.getText())) * 10000));

                        UIManager um = new UIManager();
                        um.put("OptionPane.button.background", Color.RED);
                        um.put("OptionPane.messageForeground", Color.white);
                        um.put("OptionPane.background", g);
                        um.put("Panel.background", g);
                        JOptionPane.showMessageDialog(null, "Added to Database.", "", JOptionPane.INFORMATION_MESSAGE); //Confirmation box
                        AddBox.dispose();
                        new Database(i, Send[i][0], Send[i][1], Send[i][2], Send[i][3], Send[i][4], Send[i][5], Send[i][6], Send[i][7], Send[i][8], Send[i][9], Send[i][10], Send[i][11]); //Function call from Database class with inputs arguments 
                    }
                });

                Back.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        AddBox.dispose(); //Button to back to main menu
                    }
                });

                AddBox.setLayout(null);
                AddBox.setVisible(true);
            }
        });

        Search.addActionListener(new ActionListener() { //Search Button functionality
            public void actionPerformed(ActionEvent e) {
                JFrame d = new JFrame("Search For a Patient"); //Search prompt frame declaration
                d.setSize(300, 300);
                d.getContentPane().setBackground(g);
                d.setLocationRelativeTo(null);

                JLabel IDlbl = new JLabel("Enter ID of the patient to be searched: "); //Getting patient ID to search for patient
                IDlbl.setBounds(40, 40, 250, 100);
                IDlbl.setForeground(Color.white);
                d.add(IDlbl);

                JTextField IDbox = new JTextField();
                IDbox.setBounds(105, 115, 75, 25);
                IDbox.setForeground(Color.white);
                IDbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                IDbox.setBackground(f);
                d.add(IDbox);

                JButton bOK = new JButton("OK");
                bOK.setBounds(105, 150, 75, 25);
                bOK.setBackground(b);
                bOK.setForeground(Color.white);
                bOK.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                d.add(bOK);

                JButton Back = new JButton("Back");
                Back.setBounds(215, 25, 60, 25);
                Back.setBackground(b);
                Back.setForeground(Color.white);
                Back.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                Back.setFont(Back.getFont().deriveFont(10f));
                d.add(Back);

                bOK.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String SearchID = new String(IDbox.getText());
                        Database.Search(SearchID); //Sending patient ID to function which displays patient details
                    }
                });

                Back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { //Button to back to main menu
                        d.dispose();
                    }
                });

                d.setLayout(null);
                d.setVisible(true);
            }
        });

        View.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //Button to view database
                new Database();
            }
        });

        Edit.addActionListener(new ActionListener() { //Edit button functionality
            public void actionPerformed(ActionEvent e) {
                JFrame d = new JFrame("Edit Patient Details"); //Declaring frame for edit prompt
                d.setSize(300, 300);
                d.getContentPane().setBackground(g);
                d.setLocationRelativeTo(null);

                JLabel IDlbl = new JLabel("Enter ID of the entry to be edited: "); //Taking patient ID of the entry to be edited
                IDlbl.setBounds(50, 40, 250, 100);
                IDlbl.setForeground(Color.white);
                d.add(IDlbl);

                JTextField IDbox = new JTextField();
                IDbox.setBounds(105, 115, 75, 25);
                IDbox.setForeground(Color.white);
                IDbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                IDbox.setBackground(f);
                d.add(IDbox);

                JButton bOK = new JButton("OK");
                bOK.setBounds(105, 150, 75, 25);
                bOK.setBackground(b);
                bOK.setForeground(Color.white);
                bOK.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                d.add(bOK);

                JButton Back = new JButton("Back");
                Back.setBounds(215, 25, 60, 25);
                Back.setBackground(b);
                Back.setForeground(Color.white);
                Back.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                Back.setFont(Back.getFont().deriveFont(10f));
                d.add(Back);

                bOK.addActionListener(new ActionListener() { //OK button functionality
                    public void actionPerformed(ActionEvent e) {
                        String SearchID = new String(IDbox.getText()); //Storing ID in String
                        d.dispose();
                        Database.Edit(SearchID); //Sending ID string to function which allows edit
                    }
                });

                Back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { //Button to go back to main menu
                        d.dispose();
                    }
                });

                d.setLayout(null);
                d.setVisible(true);
            }
        });

        Delete.addActionListener(new ActionListener() { //Delete button functionality

            public void actionPerformed(ActionEvent e) {
                JFrame d = new JFrame("Delete Patient Details"); //Delete prompt frame declaration
                d.setSize(300, 300);
                d.getContentPane().setBackground(g);
                d.setLocationRelativeTo(null);

                JLabel IDlbl = new JLabel("Enter ID of the patient to be deleted: "); //Taking patient ID input to delete said entry
                IDlbl.setBounds(50, 40, 250, 100);
                IDlbl.setForeground(Color.white);
                d.add(IDlbl);

                JTextField IDbox = new JTextField();
                IDbox.setBounds(105, 115, 75, 25);
                IDbox.setForeground(Color.white);
                IDbox.setBackground(f);
                d.add(IDbox);

                JButton bOK = new JButton("OK");
                bOK.setBounds(105, 150, 75, 25);
                bOK.setBackground(b);
                bOK.setForeground(Color.white);
                bOK.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                d.add(bOK);

                JButton Back = new JButton("Back");
                Back.setBounds(215, 25, 60, 25);
                Back.setBackground(b);
                Back.setForeground(Color.white);
                Back.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                Back.setFont(Back.getFont().deriveFont(10f));
                d.add(Back);

                bOK.addActionListener(new ActionListener() { //OK button functionality
                    public void actionPerformed(ActionEvent e) {
                        String SearchID = new String(IDbox.getText()); //Storing ID of entry to be deleted
                        d.dispose();

                        int ind = 0, flag1 = 0;

                        for (int k = 0; k < 50; k++) { //Finding index of entry in database
                            if (SearchID.equalsIgnoreCase(Send[k][0])) {
                                ind = k;
                                flag1 = 1;
                            }
                        }

                        if (flag1 == 1) { //If entry found, then ID and size sent to deletion function 
                            Database.Delete(SearchID, i);

                            for (int k = ind; k < i; k++) { //Local deletion algorithm
                                Send[k][0] = Send[k + 1][0];
                                Send[k][1] = Send[k + 1][1];
                                Send[k][2] = Send[k + 1][2];
                                Send[k][3] = Send[k + 1][3];
                                Send[k][4] = Send[k + 1][4];
                                Send[k][5] = Send[k + 1][5];
                                Send[k][6] = Send[k + 1][6];
                                Send[k][7] = Send[k + 1][7];
                                Send[k][8] = Send[k + 1][8];
                                Send[k][9] = Send[k + 1][9];
                                Send[k][10] = Send[k + 1][10];
                                Send[k][11] = Send[k + 1][11];
                            }
                            Send[i][0] = null;
                            Send[i][1] = null;
                            Send[i][2] = null;
                            Send[i][3] = null;
                            Send[i][4] = null;
                            Send[i][5] = null;
                            Send[i][6] = null;
                            Send[i][7] = null;
                            Send[i][8] = null;
                            Send[i][9] = null;
                            Send[i][10] = null;
                            Send[i][11] = null;
                            i--;
                        } else {
                            UIManager um = new UIManager(); //Prompt if patient does not exist in DB
                            um.put("OptionPane.messageForeground", Color.white);
                            um.put("OptionPane.background", g);
                            um.put("Panel.background", g);
                            JOptionPane.showMessageDialog(null, "Patient does not exist.", "", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });

                Back.addActionListener(new ActionListener() { //Button to go back to main menu
                    public void actionPerformed(ActionEvent e) {
                        d.dispose();
                    }
                });

                d.setLayout(null);
                d.setVisible(true);
            }
        });

        visit.addActionListener(new ActionListener() { //Visit database button functionality
            public void actionPerformed(ActionEvent e) {
                JFrame vframe = new JFrame("Healthcare System Database"); //Visit frame declaration
                vframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
                Color f = new Color(77, 77, 77);
                Color b = new Color(64, 64, 64);
                Color m = new Color(38, 38, 38);
                vframe.getContentPane().setBackground(g);
                vframe.setLocationRelativeTo(null);
                Font font = new Font("Arial", Font.PLAIN, 12);
                Font font2 = new Font("Verdana", Font.PLAIN, 16);

                JMenuBar mbar = new JMenuBar();
                mbar.setBounds(0, 0, 1920, 30);
                mbar.setBackground(m);
                mbar.setFocusable(false);
                mbar.setBorder(BorderFactory.createLineBorder(f));
                vframe.add(mbar);

                JMenu file = new JMenu("File"); //Menubar and menu elements declaration
                file.setBackground(m);
                file.setForeground(Color.white);
                file.setFocusable(false);
                file.setBorder(BorderFactory.createEmptyBorder());
                mbar.add(file);

                JMenuItem add = new JMenuItem("Add Visit");
                add.setBackground(m);
                add.setForeground(Color.white);
                add.setFocusable(false);
                add.setBorder(BorderFactory.createEmptyBorder());
                file.add(add);

                JMenuItem edit = new JMenuItem("Edit Visit");
                edit.setBackground(m);
                edit.setForeground(Color.white);
                edit.setBorder(BorderFactory.createEmptyBorder());
                file.add(edit);

                JMenuItem delete = new JMenuItem("Delete Visit");
                delete.setBackground(m);
                delete.setForeground(Color.white);
                delete.setBorder(BorderFactory.createEmptyBorder());
                file.add(delete);

                JMenu view = new JMenu("View");
                view.setBackground(m);
                view.setForeground(Color.white);
                view.setFocusable(false);
                view.setBorder(BorderFactory.createEmptyBorder());
                mbar.add(view);

                JMenuItem fdetails = new JMenuItem("View Full Details");
                fdetails.setBackground(m);
                fdetails.setForeground(Color.white);
                fdetails.setFocusable(false);
                fdetails.setBorder(BorderFactory.createEmptyBorder());
                view.add(fdetails);

                String[] columns = {"SL No", "Date", "Patient ID", "Department", "Type", "Payment"}; //Visit table column string
                JTable Table = new JTable(VisitTab, columns) { //Creation of visit table
                    private static final long serialVersionUID = 1L;

                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                ;
                };
                Table.setBackground(f);//change the backgroung color of the table
                Table.setForeground(Color.white);//change the color of text in table
                Table.setGridColor(g);  //change table border color         
                Table.getTableHeader().setBackground(b);//getting the table headers and changing the background color        
                Table.getTableHeader().setForeground(Color.white);//getting the table header and changin the header text        
                Table.getTableHeader().setBorder(BorderFactory.createLineBorder(g));//changing the header border color
                Table.getTableHeader().setReorderingAllowed(false);
                Table.getTableHeader().setResizingAllowed(false);
                Table.setSelectionBackground(b);//Change selection color
                Table.setSelectionForeground(Color.white);//To keep the text color white even when seleted
                Table.setFocusable(false);
                JScrollPane scrPane = new JScrollPane(Table);
                scrPane.setBounds(50, 50, 1440, 600);
                scrPane.setBackground(b);//change the scroll pane bg
                scrPane.setBorder(BorderFactory.createEmptyBorder()); //removing the scroll pane borders        
                scrPane.getVerticalScrollBar().setBackground(f);//change the scroll bar bg color      
                scrPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                    protected JButton createDecreaseButton(int orientation)//change the up button color
                    {
                        JButton button = super.createDecreaseButton(orientation);
                        button.setBackground(b);
                        return button;
                    }

                    protected JButton createIncreaseButton(int orientation)//change the down button color
                    {
                        JButton button = super.createIncreaseButton(orientation);
                        button.setBackground(b);
                        return button;
                    }

                    protected void configureScrollBarColors()//change the scroll bar color
                    {
                        this.thumbColor = b;
                    }
                });
                vframe.add(scrPane);
                JButton OK = new JButton("OK");
                OK.setBounds(720, 700, 75, 35);
                OK.setBackground(f);
                OK.setFocusable(false);
                OK.setForeground(Color.white);
                OK.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                vframe.add(OK);

                OK.addActionListener(new ActionListener() { //OK button functionality
                    public void actionPerformed(ActionEvent e) {
                        vframe.dispose();
                    }
                });

                add.addActionListener(new ActionListener() { //Add menu element functionality
                    public void actionPerformed(ActionEvent e) {
                        String dates[] = new String[32];
                        String years[] = new String[72];
                        JFrame AddVisit = new JFrame("Add a Visit"); //Declaring Add visit frame
                        AddVisit.getContentPane().setBackground(g);
                        AddVisit.setSize(900, 700);
                        Color g = new Color(51, 51, 51);
                        Color f = new Color(77, 77, 77);
                        Color b = new Color(64, 64, 64);

                        JLabel AddInfo = new JLabel("Enter Visit Details: "); //Declaration of labels and textfields for inputs
                        AddInfo.setBounds(30, 25, 600, 40);
                        AddInfo.setForeground(Color.white);
                        AddInfo.setFont(AddInfo.getFont().deriveFont(24f));
                        AddVisit.add(AddInfo);

                        JLabel IDlbl = new JLabel("ID");
                        IDlbl.setBounds(30, 100, 50, 25);
                        IDlbl.setForeground(Color.white);
                        AddVisit.add(IDlbl);

                        JTextField idb = new JTextField();
                        idb.setBounds(80, 100, 75, 25);
                        idb.setForeground(Color.white);
                        idb.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        idb.setBackground(f);
                        AddVisit.add(idb);

                        JLabel datetime = new JLabel("Date");
                        datetime.setBounds(30, 150, 160, 20);
                        datetime.setForeground(Color.white);
                        AddVisit.add(datetime);

                        int q = 1;
                        for (int h = 0; h <= 30; h++, q++) {

                            dates[h] = "" + q + "";
                        }
                        JComboBox cmbdates = new JComboBox(dates);
                        cmbdates.setBounds(200, 150, 150, 20);
                        cmbdates.setBackground(f);
                        cmbdates.setForeground(Color.white);
                        AddVisit.add(cmbdates);

                        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                        JComboBox cmbmonth = new JComboBox(months); //Comboboxes for date 
                        cmbmonth.setBounds(400, 150, 150, 20);
                        cmbmonth.setBackground(f);
                        cmbmonth.setForeground(Color.white);
                        AddVisit.add(cmbmonth);

                        for (int i = 0, k = 1950; k <= 2021; k++) {
                            years[i] = "" + k + "";
                            i++;
                        }

                        JComboBox cmbyear = new JComboBox(years);
                        cmbyear.setBounds(600, 150, 150, 20);
                        cmbyear.setBackground(f);
                        cmbyear.setForeground(Color.white);
                        AddVisit.add(cmbyear);

                        JLabel department = new JLabel("Department:");
                        department.setBounds(30, 200, 160, 20);
                        department.setForeground(Color.white);
                        AddVisit.add(department);

                        String departments[] = {"General", "Dental", "Neurology", "Cardiology", "Dermatology", "Gynaecology", "Pediatric", "Ophthalmology"};
                        JComboBox cmbdep = new JComboBox(departments); //Combobox for department
                        cmbdep.setBounds(200, 200, 150, 20);
                        cmbdep.setBackground(f);
                        cmbdep.setForeground(Color.white);
                        AddVisit.add(cmbdep);

                        JLabel description = new JLabel("Enter the description:");
                        description.setBounds(30, 250, 130, 20);
                        description.setForeground(Color.white);
                        AddVisit.add(description);

                        JTextArea descbox = new JTextArea();
                        descbox.setBounds(200, 250, 150, 100);
                        descbox.setForeground(Color.white);
                        descbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        descbox.setBackground(f);
                        AddVisit.add(descbox);

                        JLabel type = new JLabel("Type of visit: ");
                        type.setBounds(30, 370, 120, 20);
                        type.setForeground(Color.white);
                        AddVisit.add(type);

                        JRadioButton Apt = new JRadioButton("Appointment"); //Radio buttons for visit type
                        Apt.setBounds(200, 370, 100, 30);
                        Apt.setForeground(Color.white);
                        Apt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        Apt.setBackground(g);
                        AddVisit.add(Apt);

                        JRadioButton follow = new JRadioButton("Follow-up");
                        follow.setBounds(400, 370, 75, 30);
                        follow.setForeground(Color.white);
                        follow.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        follow.setBackground(g);
                        AddVisit.add(follow);

                        JRadioButton Routine = new JRadioButton("Routine");
                        Routine.setBounds(600, 370, 75, 30);
                        Routine.setForeground(Color.white);
                        Routine.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        Routine.setBackground(g);
                        AddVisit.add(Routine);

                        ButtonGroup bgtype = new ButtonGroup();
                        bgtype.add(Apt);
                        bgtype.add(follow);
                        bgtype.add(Routine);

                        JLabel paymt = new JLabel("Payment:");
                        paymt.setBounds(30, 430, 120, 20);
                        paymt.setForeground(Color.white);
                        AddVisit.add(paymt);

                        JCheckBox paid = new JCheckBox("Paid"); //Checkboxes for Payment type
                        paid.setBounds(200, 430, 75, 30);
                        paid.setForeground(Color.white);
                        paid.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        paid.setBackground(g);
                        AddVisit.add(paid);

                        JCheckBox pending = new JCheckBox("Pending");
                        pending.setBounds(400, 430, 75, 30);
                        pending.setForeground(Color.white);
                        pending.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        pending.setBackground(g);
                        AddVisit.add(pending);

                        ButtonGroup bgpaymt = new ButtonGroup();
                        bgpaymt.add(paid);
                        bgpaymt.add(pending);

                        JLabel presc = new JLabel("Enter the prescription:");
                        presc.setBounds(30, 530, 130, 20);
                        presc.setForeground(Color.white);
                        AddVisit.add(presc);

                        JTextArea prescbox = new JTextArea();
                        prescbox.setBounds(200, 530, 150, 70);
                        prescbox.setForeground(Color.white);
                        prescbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        prescbox.setBackground(f);
                        AddVisit.add(prescbox);

                        JButton ok = new JButton("OK");
                        ok.setBounds(725, 600, 75, 35);
                        ok.setBackground(b);
                        ok.setForeground(Color.white);
                        ok.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        AddVisit.add(ok);

                        ok.addActionListener(new ActionListener() { //OK button functionality

                            public void actionPerformed(ActionEvent e) {

                                if (idb.getText().equals("")) { //Warning prompts for empty input and exception handling
                                    UIManager um = new UIManager();
                                    um.put("OptionPane.messageForeground", Color.white);
                                    um.put("OptionPane.background", g);
                                    um.put("Panel.background", g);
                                    JOptionPane.showMessageDialog(null, "Please enter a Patient ID.", "", JOptionPane.INFORMATION_MESSAGE);
                                    return;
                                }

                                int c = 0;

                                for (int m = 0; m <= i; m++) {
                                    if (idb.getText().equalsIgnoreCase(Send[m][0])) {
                                        c = 1;
                                    }
                                }

                                if (c != 1) {
                                    UIManager um = new UIManager();
                                    um.put("OptionPane.messageForeground", Color.white);
                                    um.put("OptionPane.background", g);
                                    um.put("Panel.background", g);
                                    JOptionPane.showMessageDialog(null, "Patient does not exist.", "", JOptionPane.INFORMATION_MESSAGE);
                                    return;
                                }

                                if (bgtype.getSelection() == null) {
                                    UIManager um = new UIManager();
                                    um.put("OptionPane.messageForeground", Color.white);
                                    um.put("OptionPane.background", g);
                                    um.put("Panel.background", g);
                                    JOptionPane.showMessageDialog(null, "Please select a visit type.", "", JOptionPane.INFORMATION_MESSAGE);
                                    return;
                                }

                                if (bgpaymt.getSelection() == null) {
                                    UIManager um = new UIManager();
                                    um.put("OptionPane.messageForeground", Color.white);
                                    um.put("OptionPane.background", g);
                                    um.put("Panel.background", g);
                                    JOptionPane.showMessageDialog(null, "Please select a payment status.", "", JOptionPane.INFORMATION_MESSAGE);
                                    return;
                                }

                                if (descbox.getText().equals("")) {
                                    UIManager um = new UIManager();
                                    um.put("OptionPane.messageForeground", Color.white);
                                    um.put("OptionPane.background", g);
                                    um.put("Panel.background", g);
                                    JOptionPane.showMessageDialog(null, "Please enter a description.", "", JOptionPane.INFORMATION_MESSAGE);
                                    return;
                                }

                                if (prescbox.getText().equals("")) {
                                    UIManager um = new UIManager();
                                    um.put("OptionPane.messageForeground", Color.white);
                                    um.put("OptionPane.background", g);
                                    um.put("Panel.background", g);
                                    JOptionPane.showMessageDialog(null, "Please enter a prescription.", "", JOptionPane.INFORMATION_MESSAGE);
                                    return;
                                }

                                r++;
                                z++;
                                date[r] = dates[cmbdates.getSelectedIndex()]; //Storing inputs into variables
                                month[r] = months[cmbmonth.getSelectedIndex()];
                                year[r] = years[cmbyear.getSelectedIndex()];
                                Visit[r][0] = date[r] + " " + month[r] + " " + year[r];
                                Visit[r][1] = idb.getText().toUpperCase();
                                Visit[r][2] = departments[cmbdep.getSelectedIndex()];
                                Visit[r][3] = descbox.getText();
                                if (Apt.isSelected() == true) {
                                    Visit[r][4] = "Appointment";
                                    check[r] = 1;
                                } else if (follow.isSelected() == true) {
                                    Visit[r][4] = "Follow-Up";
                                    check[r] = 2;
                                } else if (Routine.isSelected() == true) {
                                    Visit[r][4] = "Routine";
                                    check[r] = 3;
                                }

                                if (paid.isSelected() == true) {
                                    Visit[r][5] = "Paid";
                                    check2[r] = 1;
                                } else if (pending.isSelected() == true) {
                                    Visit[r][5] = "Pending";
                                    check2[r] = 2;
                                }
                                Visit[r][6] = prescbox.getText();

                                VisitTab[r][0] = z + 1 + ""; //Sending inputs to table String
                                VisitTab[r][1] = Visit[r][0];
                                VisitTab[r][2] = Visit[r][1];
                                VisitTab[r][3] = Visit[r][2];
                                VisitTab[r][4] = Visit[r][4];
                                VisitTab[r][5] = Visit[r][5];

                                UIManager um = new UIManager();
                                um.put("OptionPane.button.background", Color.RED);
                                um.put("OptionPane.messageForeground", Color.white);
                                um.put("OptionPane.background", g);
                                um.put("Panel.background", g);
                                JOptionPane.showMessageDialog(null, "Added to Database.", "", JOptionPane.INFORMATION_MESSAGE); //Confirmation prompt
                                AddVisit.dispose();
                                SwingUtilities.updateComponentTreeUI(vframe);
                            }

                        });

                        AddVisit.setLayout(null);
                        AddVisit.setLocationRelativeTo(null);
                        AddVisit.setVisible(true);
                    }
                });

                edit.addActionListener(new ActionListener() { //Edit menu element functionality
                    public void actionPerformed(ActionEvent e) {
                        JFrame edbx = new JFrame("View Full Details"); //Edit prompt frame declaration
                        edbx.setSize(300, 300);
                        edbx.getContentPane().setBackground(g);
                        edbx.setLocationRelativeTo(null);

                        JLabel IDlbl = new JLabel("Enter Sl. No. of the visit to be edited: "); //Taking input of Sl No of visit to edit
                        IDlbl.setBounds(50, 40, 250, 100);
                        IDlbl.setForeground(Color.white);
                        edbx.add(IDlbl);

                        JTextField slbox = new JTextField();
                        slbox.setBounds(105, 115, 75, 25);
                        slbox.setForeground(Color.white);
                        slbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        slbox.setBackground(f);
                        edbx.add(slbox);

                        JButton bOK = new JButton("OK");
                        bOK.setBounds(105, 150, 75, 25);
                        bOK.setBackground(b);
                        bOK.setForeground(Color.white);
                        bOK.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        edbx.add(bOK);

                        bOK.addActionListener(new ActionListener() { //OK button functionality
                            public void actionPerformed(ActionEvent e) {
                                int o = 0;
                                int eflag = 0;
                                String ssl = new String(slbox.getText());
                                for (int k = 0; k <= r; k++) {
                                    if (ssl.equals(VisitTab[k][0])) { //Checking Sl No using loop and editing at that index
                                        o = k;
                                        eflag = 1;
                                        String dates[] = new String[32];
                                        String years[] = new String[72];
                                        JFrame evisit = new JFrame("Edit Visit Details");
                                        evisit.getContentPane().setBackground(g);
                                        evisit.setSize(900, 700);
                                        Color g = new Color(51, 51, 51);
                                        Color f = new Color(77, 77, 77);
                                        Color b = new Color(64, 64, 64);
                                        JLabel AddInfo = new JLabel("Enter Visit Details: "); //Taking input again for already entered visit with values retained
                                        AddInfo.setBounds(30, 25, 600, 40);
                                        AddInfo.setForeground(Color.white);
                                        AddInfo.setFont(AddInfo.getFont().deriveFont(24f));
                                        evisit.add(AddInfo);

                                        JLabel IDlbl = new JLabel("ID");
                                        IDlbl.setBounds(30, 100, 50, 25);
                                        IDlbl.setForeground(Color.white);
                                        evisit.add(IDlbl);

                                        JTextField idb = new JTextField(Visit[o][1]);
                                        idb.setBounds(80, 100, 75, 25);
                                        idb.setForeground(Color.white);
                                        idb.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                        idb.setBackground(f);
                                        evisit.add(idb);

                                        JLabel datetime = new JLabel("Date");
                                        datetime.setBounds(30, 150, 160, 20);
                                        datetime.setForeground(Color.white);
                                        evisit.add(datetime);

                                        int q = 1;
                                        for (int h = 0; h <= 30; h++, q++) {

                                            dates[h] = "" + q + "";
                                        }
                                        JComboBox cmbdates = new JComboBox(dates);
                                        cmbdates.setBounds(200, 150, 150, 20);
                                        cmbdates.setBackground(f);
                                        cmbdates.setSelectedItem(date[o]);
                                        cmbdates.setForeground(Color.white);
                                        evisit.add(cmbdates);

                                        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                                        JComboBox cmbmonth = new JComboBox(months);
                                        cmbmonth.setBounds(400, 150, 150, 20);
                                        cmbmonth.setSelectedItem(month[o]);
                                        cmbmonth.setBackground(f);
                                        cmbmonth.setForeground(Color.white);
                                        evisit.add(cmbmonth);

                                        for (int i = 0, u = 1950; u <= 2021; u++) {
                                            years[i] = "" + u + "";
                                            i++;
                                        }

                                        JComboBox cmbyear = new JComboBox(years);
                                        cmbyear.setBounds(600, 150, 150, 20);
                                        cmbyear.setSelectedItem(year[o]);
                                        cmbyear.setBackground(f);
                                        cmbyear.setForeground(Color.white);
                                        evisit.add(cmbyear);

                                        JLabel department = new JLabel("Department:");
                                        department.setBounds(30, 200, 160, 20);
                                        department.setForeground(Color.white);
                                        evisit.add(department);

                                        String departments[] = {"General", "Dental", "Neurology", "Cardiology", "Dermatology", "Gynaecology", "Pediatric", "Ophthalmology"};
                                        JComboBox cmbdep = new JComboBox(departments);
                                        cmbdep.setBounds(200, 200, 150, 20);
                                        cmbdep.setSelectedItem(Visit[o][2]);
                                        cmbdep.setBackground(f);
                                        cmbdep.setForeground(Color.white);
                                        evisit.add(cmbdep);

                                        JLabel description = new JLabel("Enter the description:");
                                        description.setBounds(30, 250, 130, 20);
                                        description.setForeground(Color.white);
                                        evisit.add(description);

                                        JTextArea descbox = new JTextArea(Visit[o][3]);
                                        descbox.setBounds(200, 250, 150, 100);
                                        descbox.setForeground(Color.white);
                                        descbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                        descbox.setBackground(f);
                                        evisit.add(descbox);

                                        JLabel type = new JLabel("Type of visit: ");
                                        type.setBounds(30, 370, 120, 20);
                                        type.setForeground(Color.white);
                                        evisit.add(type);

                                        JRadioButton Apt = new JRadioButton("Appointment");
                                        Apt.setBounds(200, 370, 100, 30);
                                        Apt.setForeground(Color.white);
                                        Apt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                        Apt.setBackground(g);
                                        evisit.add(Apt);

                                        JRadioButton follow = new JRadioButton("Follow-up");
                                        follow.setBounds(400, 370, 75, 30);
                                        follow.setForeground(Color.white);
                                        follow.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                        follow.setBackground(g);
                                        evisit.add(follow);

                                        JRadioButton Routine = new JRadioButton("Routine");
                                        Routine.setBounds(600, 370, 75, 30);
                                        Routine.setForeground(Color.white);
                                        Routine.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                        Routine.setBackground(g);
                                        evisit.add(Routine);

                                        ButtonGroup bgtype = new ButtonGroup();
                                        bgtype.add(Apt);
                                        bgtype.add(follow);
                                        bgtype.add(Routine);

                                        switch (check[o]) { //Switch cases to check which option was selected
                                            case 1:
                                                Apt.setSelected(true);
                                                break;

                                            case 2:
                                                follow.setSelected(true);
                                                break;

                                            case 3:
                                                Routine.setSelected(true);
                                                break;
                                        }

                                        JLabel paymt = new JLabel("Payment:");
                                        paymt.setBounds(30, 430, 120, 20);
                                        paymt.setForeground(Color.white);
                                        evisit.add(paymt);

                                        JCheckBox paid = new JCheckBox("Paid");
                                        paid.setBounds(200, 430, 75, 30);
                                        paid.setForeground(Color.white);
                                        paid.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                        paid.setBackground(g);
                                        evisit.add(paid);

                                        JCheckBox pending = new JCheckBox("Pending");
                                        pending.setBounds(400, 430, 75, 30);
                                        pending.setForeground(Color.white);
                                        pending.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                        pending.setBackground(g);
                                        evisit.add(pending);

                                        ButtonGroup bgpaymt = new ButtonGroup();
                                        bgpaymt.add(paid);
                                        bgpaymt.add(pending);

                                        switch (check2[o]) {
                                            case 1:
                                                paid.setSelected(true);
                                                break;

                                            case 2:
                                                pending.setSelected(true);
                                                break;
                                        }

                                        JLabel presc = new JLabel("Enter the prescription:");
                                        presc.setBounds(30, 530, 130, 20);
                                        presc.setForeground(Color.white);
                                        evisit.add(presc);

                                        JTextArea prescbox = new JTextArea(Visit[o][6]);
                                        prescbox.setBounds(200, 530, 150, 70);
                                        prescbox.setForeground(Color.white);
                                        prescbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                        prescbox.setBackground(f);
                                        evisit.add(prescbox);

                                        JButton ok = new JButton("OK");
                                        ok.setBounds(725, 600, 75, 35);
                                        ok.setBackground(b);
                                        ok.setForeground(Color.white);
                                        ok.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                        evisit.add(ok);

                                        l = o;

                                        ok.addActionListener(new ActionListener() { //OK button functionality

                                            public void actionPerformed(ActionEvent e) {

                                                if (idb.getText().equals("")) { //Warning option panes for wrong inputs and exceptions
                                                    UIManager um = new UIManager();
                                                    um.put("OptionPane.messageForeground", Color.white);
                                                    um.put("OptionPane.background", g);
                                                    um.put("Panel.background", g);
                                                    JOptionPane.showMessageDialog(null, "Please enter a Patient ID.", "", JOptionPane.INFORMATION_MESSAGE);
                                                    return;
                                                }

                                                int c = 0;

                                                for (int m = 0; m <= i; m++) {
                                                    if (idb.getText().equalsIgnoreCase(Send[m][0])) {
                                                        c = 1;
                                                    }
                                                }

                                                if (c != 1) {
                                                    UIManager um = new UIManager();
                                                    um.put("OptionPane.messageForeground", Color.white);
                                                    um.put("OptionPane.background", g);
                                                    um.put("Panel.background", g);
                                                    JOptionPane.showMessageDialog(null, "Patient does not exist.", "", JOptionPane.INFORMATION_MESSAGE);
                                                    return;
                                                }

                                                if (bgtype.getSelection() == null) {
                                                    UIManager um = new UIManager();
                                                    um.put("OptionPane.messageForeground", Color.white);
                                                    um.put("OptionPane.background", g);
                                                    um.put("Panel.background", g);
                                                    JOptionPane.showMessageDialog(null, "Please select a visit type.", "", JOptionPane.INFORMATION_MESSAGE);
                                                    return;
                                                }

                                                if (bgpaymt.getSelection() == null) {
                                                    UIManager um = new UIManager();
                                                    um.put("OptionPane.messageForeground", Color.white);
                                                    um.put("OptionPane.background", g);
                                                    um.put("Panel.background", g);
                                                    JOptionPane.showMessageDialog(null, "Please select a payment status.", "", JOptionPane.INFORMATION_MESSAGE);
                                                    return;
                                                }

                                                if (descbox.getText().equals("")) {
                                                    UIManager um = new UIManager();
                                                    um.put("OptionPane.messageForeground", Color.white);
                                                    um.put("OptionPane.background", g);
                                                    um.put("Panel.background", g);
                                                    JOptionPane.showMessageDialog(null, "Please enter a description.", "", JOptionPane.INFORMATION_MESSAGE);
                                                    return;
                                                }

                                                if (prescbox.getText().equals("")) {
                                                    UIManager um = new UIManager();
                                                    um.put("OptionPane.messageForeground", Color.white);
                                                    um.put("OptionPane.background", g);
                                                    um.put("Panel.background", g);
                                                    JOptionPane.showMessageDialog(null, "Please enter a prescription.", "", JOptionPane.INFORMATION_MESSAGE);
                                                    return;
                                                }

                                                date[l] = dates[cmbdates.getSelectedIndex()]; //Storing inputs in corresponding string
                                                month[l] = months[cmbmonth.getSelectedIndex()];
                                                year[l] = years[cmbyear.getSelectedIndex()];
                                                Visit[l][0] = date[l] + " " + month[l] + " " + year[l];
                                                Visit[l][1] = idb.getText().toUpperCase();
                                                Visit[l][2] = departments[cmbdep.getSelectedIndex()];
                                                Visit[l][3] = descbox.getText();
                                                if (Apt.isSelected() == true) {
                                                    Visit[l][4] = "Appointment";
                                                    check[l] = 1;
                                                } else if (follow.isSelected() == true) {
                                                    Visit[l][4] = "Follow-Up";
                                                    check[l] = 2;
                                                } else if (Routine.isSelected() == true) {
                                                    Visit[l][4] = "Routine";
                                                    check[l] = 3;
                                                }
                                                if (paid.isSelected() == true) {
                                                    Visit[l][5] = "Paid";
                                                    check2[l] = 1;
                                                } else if (pending.isSelected() == true) {
                                                    Visit[l][5] = "Pending";
                                                    check2[l] = 2;
                                                }
                                                Visit[l][6] = prescbox.getText();

                                                VisitTab[l][0] = l + 1 + ""; //Assigning strings to table row strings
                                                VisitTab[l][1] = Visit[l][0];
                                                VisitTab[l][2] = Visit[l][1];
                                                VisitTab[l][3] = Visit[l][2];
                                                VisitTab[l][4] = Visit[l][4];
                                                VisitTab[l][5] = Visit[l][5];

                                                UIManager um = new UIManager();
                                                um.put("OptionPane.messageForeground", Color.white);
                                                um.put("OptionPane.background", g);
                                                um.put("Panel.background", g);
                                                JOptionPane.showMessageDialog(null, "Added to Database.", "", JOptionPane.INFORMATION_MESSAGE);
                                                evisit.dispose();
                                                SwingUtilities.updateComponentTreeUI(vframe);
                                            }

                                        }
                                        );

                                        evisit.setLayout(null);
                                        evisit.setLocationRelativeTo(null);
                                        evisit.setVisible(true);
                                        edbx.dispose();
                                    }
                                }

                                if (eflag == 0) {
                                    UIManager um = new UIManager();
                                    um.put("OptionPane.messageForeground", Color.white);
                                    um.put("OptionPane.background", g);
                                    um.put("Panel.background", g);
                                    JOptionPane.showMessageDialog(null, "Visit not found.", "", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        });

                        edbx.setLayout(null);
                        edbx.setLocationRelativeTo(null);
                        edbx.setVisible(true);
                    }
                });

                delete.addActionListener(new ActionListener() { //Delete menubar element functionality

                    public void actionPerformed(ActionEvent e) {
                        JFrame d = new JFrame("Delete Visit Details"); //Declaring frame for delete visit frame
                        d.setSize(300, 300);
                        d.getContentPane().setBackground(g);
                        d.setLocationRelativeTo(null);

                        JLabel IDlbl = new JLabel("Enter Sl. No. to be deleted: "); //Taking Sl No of visit to be deleted
                        IDlbl.setBounds(50, 40, 250, 100);
                        IDlbl.setForeground(Color.white);
                        d.add(IDlbl);

                        JTextField IDbox = new JTextField(); //Labels and textfields declared to take in input
                        IDbox.setBounds(105, 115, 75, 25);
                        IDbox.setForeground(Color.white);
                        IDbox.setBackground(f);
                        d.add(IDbox);

                        JButton bOK = new JButton("OK");
                        bOK.setBounds(105, 150, 75, 25);
                        bOK.setBackground(b);
                        bOK.setForeground(Color.white);
                        bOK.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        d.add(bOK);

                        JButton Back = new JButton("Back");
                        Back.setBounds(215, 25, 60, 25);
                        Back.setBackground(b);
                        Back.setForeground(Color.white);
                        Back.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        Back.setFont(Back.getFont().deriveFont(10f));
                        d.add(Back);

                        bOK.addActionListener(new ActionListener() { //OK button functionality
                            public void actionPerformed(ActionEvent e) {

                                int dflag = 0;

                                String SearchID = new String(IDbox.getText()); //Check if visit no of a particular Sl No. exists and perform delete algorithm if it does
                                for (int k = 0; k <= r; k++) {
                                    if (SearchID.equals(VisitTab[k][0])) {
                                        j = k;
                                        dflag = 1;
                                    }
                                }

                                if (dflag == 1) {
                                    for (int h = j; h <= r; h++) {
                                        Visit[h][0] = Visit[h + 1][0];
                                        Visit[h][1] = Visit[h + 1][1];
                                        Visit[h][2] = Visit[h + 1][2];
                                        Visit[h][3] = Visit[h + 1][3];
                                        Visit[h][4] = Visit[h + 1][4];
                                        Visit[h][5] = Visit[h + 1][5];
                                        Visit[h][6] = Visit[h + 1][6];

                                        VisitTab[h][0] = VisitTab[h + 1][0];
                                        VisitTab[h][1] = Visit[h][0];
                                        VisitTab[h][2] = Visit[h][1];
                                        VisitTab[h][3] = Visit[h][2];
                                        VisitTab[h][4] = Visit[h][4];
                                        VisitTab[h][5] = Visit[h][5];
                                    }
                                    r--;
                                    SwingUtilities.updateComponentTreeUI(vframe);
                                    d.dispose();
                                } else {
                                    UIManager um = new UIManager();
                                    um.put("OptionPane.messageForeground", Color.white);
                                    um.put("OptionPane.background", g);
                                    um.put("Panel.background", g);
                                    JOptionPane.showMessageDialog(null, "Visit not found.", "", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        });

                        Back.addActionListener(new ActionListener() { //Back button to go back to visit table 
                            public void actionPerformed(ActionEvent e) {
                                d.dispose();
                            }
                        });

                        d.setLayout(null);
                        d.setVisible(true);
                    }
                });

                fdetails.addActionListener(new ActionListener() { //View full details menubar element functionality

                    public void actionPerformed(ActionEvent e) {
                        JFrame d = new JFrame("View Full Details"); //Frame declaration
                        d.setSize(300, 300);
                        d.getContentPane().setBackground(g);
                        d.setLocationRelativeTo(null);

                        JLabel sllbl = new JLabel("Enter Sl. No. of the visit to be viewed: "); //Taking in Sl No. of visit using textfield and labels
                        sllbl.setBounds(50, 40, 250, 100);
                        sllbl.setForeground(Color.white);
                        d.add(sllbl);

                        JTextField slbox = new JTextField();
                        slbox.setBounds(105, 115, 75, 25);
                        slbox.setForeground(Color.white);
                        slbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        slbox.setBackground(f);
                        d.add(slbox);

                        JButton bOK = new JButton("OK");
                        bOK.setBounds(105, 150, 75, 25);
                        bOK.setBackground(b);
                        bOK.setForeground(Color.white);
                        bOK.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        d.add(bOK);

                        bOK.addActionListener(new ActionListener() { //OK button functionality
                            public void actionPerformed(ActionEvent e) {

                                int fflag = 0, ff = 0;

                                String Searchsl = new String(slbox.getText());
                                d.dispose();

                                for (int k = 0; k <= r; k++) {
                                    if (Searchsl.equals(VisitTab[k][0])) { //checks if visit with a particular Sl No exists
                                        ff = k;
                                        fflag = 1;
                                    }
                                }

                                if (fflag == 1) {
                                    JFrame dets = new JFrame("Visit Details"); //If visit exists, displays a frame with all details using labels
                                    dets.getContentPane().setBackground(g);
                                    dets.setSize(900, 700);
                                    dets.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    Font font = new Font("Segoe UI", Font.PLAIN, 19);

                                    JLabel AddInfo = new JLabel("Details of Visit (Sl. No: " + VisitTab[ff][0] + ")");
                                    AddInfo.setBounds(30, 25, 600, 40);
                                    AddInfo.setForeground(Color.white);
                                    AddInfo.setFont(AddInfo.getFont().deriveFont(28f));
                                    dets.add(AddInfo);

                                    JLabel datetime = new JLabel("Date: " + Visit[ff][0]);
                                    datetime.setBounds(30, 100, 600, 30);
                                    datetime.setForeground(Color.white);
                                    datetime.setFont(font);
                                    dets.add(datetime);

                                    JLabel id = new JLabel("Patient ID: " + Visit[ff][1]);
                                    id.setBounds(30, 175, 600, 30);
                                    id.setForeground(Color.white);
                                    id.setFont(font);
                                    dets.add(id);

                                    JLabel department = new JLabel("Department: " + Visit[ff][2]);
                                    department.setBounds(30, 250, 600, 30);
                                    department.setForeground(Color.white);
                                    department.setFont(font);
                                    dets.add(department);

                                    JLabel description = new JLabel("Description: " + Visit[ff][3]);
                                    description.setBounds(30, 325, 600, 30);
                                    description.setForeground(Color.white);
                                    description.setFont(font);
                                    dets.add(description);

                                    JLabel type = new JLabel("Type of visit: " + Visit[ff][4]);
                                    type.setBounds(30, 400, 600, 30);
                                    type.setForeground(Color.white);
                                    type.setFont(font);
                                    dets.add(type);

                                    JLabel paymt = new JLabel("Payment: " + Visit[ff][5]);
                                    paymt.setBounds(30, 475, 600, 30);
                                    paymt.setForeground(Color.white);
                                    paymt.setFont(font);
                                    dets.add(paymt);

                                    JLabel presc = new JLabel("Prescription: " + Visit[ff][6]);
                                    presc.setBounds(30, 550, 600, 30);
                                    presc.setForeground(Color.white);
                                    presc.setFont(font);
                                    dets.add(presc);

                                    JButton ok = new JButton("OK");
                                    ok.setBounds(725, 600, 75, 35);
                                    ok.setBackground(b);
                                    ok.setForeground(Color.white);
                                    ok.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                    dets.add(ok);

                                    ok.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) { //OK button close frame
                                            dets.dispose();
                                        }
                                    });
                                    dets.setLayout(null);
                                    dets.setLocationRelativeTo(null);
                                    dets.setVisible(true);
                                } else {
                                    UIManager um = new UIManager();
                                    um.put("OptionPane.messageForeground", Color.white);
                                    um.put("OptionPane.background", g);
                                    um.put("Panel.background", g);
                                    JOptionPane.showMessageDialog(null, "Invalid Sl. No.", "", JOptionPane.INFORMATION_MESSAGE); //Prompt shown if visit doesn't exist 

                                    d.dispose();
                                }
                            }
                        });
                        d.setLayout(null);
                        d.setLocationRelativeTo(null);
                        d.setVisible(true);
                    }
                });
                vframe.setLayout(null);
                vframe.setLocationRelativeTo(null);
                vframe.setVisible(true);
            }
        }
        );
        Logout.addActionListener(new ActionListener() { //Logout button functionality in main menu
            public void actionPerformed(ActionEvent e) {
                UIManager um = new UIManager();
                um.put("OptionPane.messageForeground", Color.white);
                um.put("OptionPane.background", g);
                um.put("Panel.background", g);
                JOptionPane.showMessageDialog(null, "Logout Successful.", "", JOptionPane.INFORMATION_MESSAGE); //Confirmation of logging out
                mainmenu.dispose();
                new LogIn();
            }
        });
    }
}
