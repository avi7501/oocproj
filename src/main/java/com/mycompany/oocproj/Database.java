package com.mycompany.oocproj;

/* Authors:
4SO19CS021 - Ankith Thomas
4SO19CS034 - Avinash Muralidharan
4SO19CS037 - Binse Varghese
4SO19CS054 - Glen Rebello
 */
import javax.swing.*;//Imports for the methods
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class Database {

    public static int Num = 100;//Declaration and initialisation of public static variables used in Database class
    public static String[][] data = new String[50][12];
    public static int l = -1;
    public static int j = -1;
    public static int flag = 0;

    Database(int i, String ID, String FName, String LName, String Phone, String Email, String BloodGroup, String Address, String Age, String Weight, String Height, String Gender, String BMI) {//Class constructor declaration with parameters
        JFrame view = new JFrame("Healthcare System Database");//Patient Database frame
        view.getContentPane().setBackground(Color.white);
        view.setSize(800, 800);
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Font font = new Font("Arial", Font.PLAIN, 24);
        Color g = new Color(51, 51, 51); //Custom colours
        Color f = new Color(77, 77, 77);
        Color b = new Color(64, 64, 64);

        String[] columns = {"ID", "First Name", "Last Name", "Phone", "Email", "Blood Group", "Address", "Age (years)", "Weight (kg)", "Height (cm)", "Gender", "BMI"};//String containing table column headings

        data[i][0] = ID; //Storing values from parameters into 2d string araray
        data[i][1] = FName;
        data[i][2] = LName;
        data[i][3] = Phone;
        data[i][4] = Email;
        data[i][5] = BloodGroup;
        data[i][6] = Address;
        data[i][7] = Age;
        data[i][8] = Weight;
        data[i][9] = Height;
        data[i][10] = Gender;
        data[i][11] = BMI;

        JTable Table = new JTable(data, columns) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {//Disabling editing for cells of the table
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
        Table.getTableHeader().setReorderingAllowed(false);//Reordering is disabled
        Table.getTableHeader().setResizingAllowed(false);//Resizing is disabled
        Table.setSelectionBackground(b);//Change selection color
        Table.setSelectionForeground(Color.white);//To keep the text color white evn when seleted
        Table.setFocusable(false);//Removes the focus border
        JScrollPane scrPane = new JScrollPane(Table);
        scrPane.setBounds(50, 50, 1440, 600);
        scrPane.setBackground(b);//change the scroll pane bg
        scrPane.setBorder(BorderFactory.createEmptyBorder()); //removing the scroll pane borders        
        scrPane.getVerticalScrollBar().setBackground(f);//change the scroll bar bg color      
        scrPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            protected JButton createDecreaseButton(int orientation)//change the scroll up button color
            {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(Color.red);
                return button;
            }

            protected JButton createIncreaseButton(int orientation)//change the scroll down button color
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
        view.add(scrPane);//Adding scroll pane to frame

        view.getContentPane().setBackground(g);   //Changing the frame colour
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setLayout(null);
        view.setVisible(true);

        JButton OK = new JButton("OK"); //Adding button to frame
        OK.setBounds(720, 700, 75, 35);
        OK.setBackground(b);//Changing the button background
        OK.setForeground(Color.white);//Changing font colour in the button
        OK.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        OK.setFocusable(false);
        view.add(OK);

        OK.addActionListener(new ActionListener() {//Button Action listenter
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
    }

    Database() { //Class constructor declaration 
        JFrame view = new JFrame("Healthcare System Database");//Patient Database frame
        view.getContentPane().setBackground(Color.white);
        view.setSize(800, 800);
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Font font = new Font("Arial", Font.PLAIN, 24);
        Color g = new Color(51, 51, 51);
        Color f = new Color(77, 77, 77);
        Color b = new Color(64, 64, 64);

        String[] columns = {"ID", "First Name", "Last Name", "Phone", "Email", "Blood Group", "Address", "Age (years)", "Weight (kg)", "Height (cm)", "Gender", "BMI"};//String containing table column headings

        JTable Table = new JTable(data, columns) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {//Disabling editing for cells of the table
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
        Table.getTableHeader().setReorderingAllowed(false);//Reordering is disabled
        Table.getTableHeader().setResizingAllowed(false);//Resizing is disabled
        Table.setSelectionBackground(b);//Change selection color
        Table.setSelectionForeground(Color.white);//To keep the text color white evn when seleted
        Table.setFocusable(false);//Removes the focus border
        JScrollPane scrPane = new JScrollPane(Table);
        scrPane.setBounds(50, 50, 1440, 600);
        scrPane.setBackground(b);//change the scroll pane bg
        scrPane.setBorder(BorderFactory.createEmptyBorder()); //removing the scroll pane borders        
        scrPane.getVerticalScrollBar().setBackground(f);//change the scroll bar bg color      
        scrPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            protected JButton createDecreaseButton(int orientation)//change the scroll up button color
            {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(b);
                return button;
            }

            protected JButton createIncreaseButton(int orientation)//change the  scroll down button color
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
        view.add(scrPane);//Adding scoll pane to patient database frame

        view.getContentPane().setBackground(g);//Changing frame background colour
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setLayout(null);
        view.setVisible(true);

        JButton OK = new JButton("OK");//Adding button to the frame
        OK.setBounds(720, 700, 75, 35);
        OK.setBackground(f);
        OK.setForeground(Color.white);
        OK.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        OK.setFocusable(false);
        view.add(OK);

        OK.addActionListener(new ActionListener() {//Adding  acttion listener for the button in the frame
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
    }

    public static void Edit(String SearchID) {//Declaring Edit Function
        Color g = new Color(51, 51, 51);
        for (int k = 0; k < 50; k++) {
            if (SearchID.equalsIgnoreCase(data[k][0])) {//Comparing the entered patient id with the patient ids entered already in the database
                l = k;
                flag = 1;
            }
        }

        if (flag == 1) {
            JFrame AddBox = new JFrame("Edit Patient Details");  // Frame for adding new edtited patient details
            AddBox.setSize(900, 600);
            AddBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Color f = new Color(77, 77, 77);
            Color b = new Color(64, 64, 64);
            AddBox.getContentPane().setBackground(g);
            AddBox.setLocationRelativeTo(null);
            Font font = new Font("Verdana", Font.BOLD, 12);

            JLabel AddInfo = new JLabel("Edit Patient Details: ");//Label and Text Field declarations for taking the new edited patient details
            AddInfo.setBounds(30, 25, 600, 40);
            AddInfo.setForeground(Color.white);
            AddInfo.setFont(AddInfo.getFont().deriveFont(32f));
            AddBox.add(AddInfo);

            JLabel FNamelbl = new JLabel("First Name:");
            FNamelbl.setBounds(30, 100, 160, 20);
            FNamelbl.setForeground(Color.white);
            FNamelbl.setFont(font);
            AddBox.add(FNamelbl);

            JTextField FNamebox = new JTextField(data[l][1]);
            FNamebox.setBounds(200, 100, 150, 20);
            FNamebox.setForeground(Color.white);
            FNamebox.setBorder(BorderFactory.createEmptyBorder());
            FNamebox.setBackground(f);
            AddBox.add(FNamebox);

            JLabel LNamelbl = new JLabel("Last Name:");
            LNamelbl.setBounds(30, 150, 160, 20);
            LNamelbl.setForeground(Color.white);
            LNamelbl.setFont(font);
            AddBox.add(LNamelbl);

            JTextField LNamebox = new JTextField(data[l][2]);
            LNamebox.setBounds(200, 150, 150, 20);
            LNamebox.setForeground(Color.white);
            LNamebox.setBorder(BorderFactory.createEmptyBorder());
            LNamebox.setBackground(f);
            AddBox.add(LNamebox);

            JLabel Phnlbl = new JLabel("Phone:");
            Phnlbl.setBounds(30, 200, 120, 20);
            Phnlbl.setForeground(Color.white);
            Phnlbl.setFont(font);
            AddBox.add(Phnlbl);

            JTextField Phnbox = new JTextField(data[l][3]);
            Phnbox.setBounds(200, 200, 150, 20);
            Phnbox.setForeground(Color.white);
            Phnbox.setBorder(BorderFactory.createEmptyBorder());
            Phnbox.setBackground(f);
            AddBox.add(Phnbox);

            JLabel Emaillbl = new JLabel("Email:");
            Emaillbl.setBounds(30, 250, 80, 20);
            Emaillbl.setForeground(Color.white);
            Emaillbl.setFont(font);
            AddBox.add(Emaillbl);

            JTextField Emailbox = new JTextField(data[l][4]);
            Emailbox.setBounds(200, 250, 150, 20);
            Emailbox.setForeground(Color.white);
            Emailbox.setBorder(BorderFactory.createEmptyBorder());
            Emailbox.setBackground(f);
            AddBox.add(Emailbox);

            JLabel Bgrplbl = new JLabel("Blood Group:");
            Bgrplbl.setBounds(30, 300, 200, 20);
            Bgrplbl.setForeground(Color.white);
            Bgrplbl.setFont(font);
            AddBox.add(Bgrplbl);

            String Bgrps[] = {"A+", "B+", "O+", "AB+", "A-", "B-", "O-", "AB-"};//String array for blood group combo box
            JComboBox cmbBgrp = new JComboBox(Bgrps);//Blood group combo box
            cmbBgrp.setSelectedItem(data[l][5]);
            cmbBgrp.setBounds(200, 300, 50, 20);
            cmbBgrp.setBackground(f);
            cmbBgrp.setForeground(Color.white);
            AddBox.add(cmbBgrp);

            JLabel Addresslbl = new JLabel("Address:");
            Addresslbl.setBounds(30, 350, 150, 20);
            Addresslbl.setForeground(Color.white);
            Addresslbl.setFont(font);
            AddBox.add(Addresslbl);

            JTextField Addressbox = new JTextField(data[l][6]);
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

            JTextField AgeBox = new JTextField(data[l][7]);
            AgeBox.setBounds(670, 100, 35, 20);
            AgeBox.setForeground(Color.white);
            AgeBox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            AgeBox.setBackground(f);
            AddBox.add(AgeBox);

            JLabel WeightLabel = new JLabel("Weight (in kg):");
            WeightLabel.setBounds(500, 150, 160, 20);
            WeightLabel.setForeground(Color.white);
            WeightLabel.setFont(font);
            AddBox.add(WeightLabel);

            JTextField WeightBox = new JTextField(data[l][8]);
            WeightBox.setBounds(670, 150, 45, 20);
            WeightBox.setForeground(Color.white);
            WeightBox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            WeightBox.setBackground(f);
            AddBox.add(WeightBox);

            JLabel HeightLabel = new JLabel("Height (in cm):");
            HeightLabel.setBounds(500, 200, 160, 20);
            HeightLabel.setForeground(Color.white);
            HeightLabel.setFont(font);
            AddBox.add(HeightLabel);

            JTextField HeightBox = new JTextField(data[l][9]);
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

            String Genders[] = {"Male", "Female", "Other"};//String for gender combo box
            JComboBox cmbGender = new JComboBox(Genders);//Gender combo box
            cmbGender.setSelectedItem(data[l][10]);
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
            Back.setBounds(800, 25, 60, 25);
            Back.setBackground(b);
            Back.setForeground(Color.white);
            Back.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Back.setFont(Back.getFont().deriveFont(10f));
            AddBox.add(Back);

            OK.addActionListener(new ActionListener() {//Action Listener for button in frame
                public void actionPerformed(ActionEvent e) {

                    if (FNamebox.getText().equals("")) {
                        UIManager um = new UIManager();
                        um.put("OptionPane.messageForeground", Color.white);//Message dialog box custom font color
                        um.put("OptionPane.background", g);//Message dialog box custom background color
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

                    try {//Exception Handing 

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

                    data[l][1] = FNamebox.getText();//Storing values from parameters into 2d string araray
                    data[l][2] = LNamebox.getText();
                    data[l][3] = Phnbox.getText();
                    data[l][4] = Emailbox.getText();
                    data[l][5] = Bgrps[cmbBgrp.getSelectedIndex()];
                    data[l][6] = Addressbox.getText();
                    data[l][7] = AgeBox.getText();
                    data[l][8] = WeightBox.getText();
                    data[l][9] = HeightBox.getText();
                    data[l][10] = Genders[cmbGender.getSelectedIndex()];
                    data[l][11] = String.format("%.1f", ((Float.parseFloat(WeightBox.getText()) / Float.parseFloat(HeightBox.getText()) / Float.parseFloat(HeightBox.getText())) * 10000));

                    UIManager um = new UIManager();
                    um.put("OptionPane.button.background", Color.RED);
                    um.put("OptionPane.messageForeground", Color.white);
                    um.put("OptionPane.background", g);
                    um.put("Panel.background", g);
                    JOptionPane.showMessageDialog(null, "Edited Entry in Database.", "", JOptionPane.INFORMATION_MESSAGE);
                    AddBox.dispose();
                }
            });

            Back.addActionListener(new ActionListener() {//Action LIstener for back button
                public void actionPerformed(ActionEvent e) {
                    AddBox.dispose();
                }
            });

            AddBox.setLayout(null);
            AddBox.setVisible(true);
        } else {
            UIManager um = new UIManager();
            um.put("OptionPane.button.background", Color.RED);
            um.put("OptionPane.messageForeground", Color.white);
            um.put("OptionPane.background", g);
            um.put("Panel.background", g);
            JOptionPane.showMessageDialog(null, "Added to Database.", "", JOptionPane.INFORMATION_MESSAGE);

            new MainMenu();
        }
    }

    public static void Search(String SearchID) {//Declaring Search Function
        Color g = new Color(51, 51, 51);
        int n = 0, flag1 = 0;

        for (int k = 0; k < 50; k++) {
            if (SearchID.equalsIgnoreCase(data[k][0])) {//Comparing the entered patient id with the patient ids entered already in the database
                n = k;
                flag1 = 1;
            }
        }

        if (flag1 == 1) {

            JFrame AddBox = new JFrame("Search Patient Details");// Frame for viewing patient details
            AddBox.setSize(900, 600);
            AddBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Color f = new Color(77, 77, 77);
            Color b = new Color(64, 64, 64);
            Color m = new Color(38, 38, 38);
            AddBox.getContentPane().setBackground(g);
            AddBox.setLocationRelativeTo(null);
            Font font = new Font("Arial", Font.BOLD, 32);
            Font font2 = new Font("Verdana", Font.PLAIN, 20);

            JLabel AddInfo = new JLabel("Details of Patient (ID: " + data[n][0] + ")");//Label and Text Field declarations for taking the new edited patient details
            AddInfo.setBounds(30, 15, 600, 40);
            AddInfo.setForeground(Color.white);
            AddInfo.setFont(font);
            AddBox.add(AddInfo);

            JLabel FNamelbl = new JLabel("First Name: " + data[n][1]);
            FNamelbl.setBounds(30, 90, 400, 40);
            FNamelbl.setForeground(Color.white);
            FNamelbl.setFont(font2);
            AddBox.add(FNamelbl);

            JLabel LNamelbl = new JLabel("Last Name: " + data[n][2]);
            LNamelbl.setBounds(30, 160, 400, 40);
            LNamelbl.setForeground(Color.white);
            LNamelbl.setFont(font2);
            AddBox.add(LNamelbl);

            JLabel Phnlbl = new JLabel("Phone: " + data[n][3]);
            Phnlbl.setBounds(30, 230, 400, 40);
            Phnlbl.setForeground(Color.white);
            Phnlbl.setFont(font2);
            AddBox.add(Phnlbl);

            JLabel Emaillbl = new JLabel("Email: " + data[n][4]);
            Emaillbl.setBounds(30, 300, 400, 40);
            Emaillbl.setForeground(Color.white);
            Emaillbl.setFont(font2);
            AddBox.add(Emaillbl);

            JLabel Bgrplbl = new JLabel("Blood Group: " + data[n][5]);
            Bgrplbl.setBounds(30, 370, 400, 40);
            Bgrplbl.setForeground(Color.white);
            Bgrplbl.setFont(font2);
            AddBox.add(Bgrplbl);

            JLabel Addresslbl = new JLabel("Address: " + data[n][6]);
            Addresslbl.setBounds(30, 440, 400, 40);
            Addresslbl.setForeground(Color.white);
            Addresslbl.setFont(font2);
            AddBox.add(Addresslbl);

            JLabel Agelbl = new JLabel("Age: " + data[n][7] + " years old");
            Agelbl.setBounds(480, 90, 400, 40);
            Agelbl.setForeground(Color.white);
            Agelbl.setFont(font2);
            AddBox.add(Agelbl);

            JLabel Wtlbl = new JLabel("Weight: " + data[n][8] + " kg");
            Wtlbl.setBounds(480, 160, 400, 40);
            Wtlbl.setForeground(Color.white);
            Wtlbl.setFont(font2);
            AddBox.add(Wtlbl);

            JLabel Htlbl = new JLabel("Height: " + data[n][9] + " cm");
            Htlbl.setBounds(480, 230, 400, 40);
            Htlbl.setForeground(Color.white);
            Htlbl.setFont(font2);
            AddBox.add(Htlbl);

            JLabel Glbl = new JLabel("Gender: " + data[n][10]);
            Glbl.setBounds(480, 300, 400, 40);
            Glbl.setForeground(Color.white);
            Glbl.setFont(font2);
            AddBox.add(Glbl);

            JLabel BMIlbl = new JLabel("BMI: " + data[n][11]);
            BMIlbl.setBounds(480, 370, 400, 40);
            BMIlbl.setForeground(Color.white);
            BMIlbl.setFont(font2);
            AddBox.add(BMIlbl);

            JButton Back2 = new JButton("Back");
            Back2.setBounds(800, 50, 60, 25);
            Back2.setBackground(f);
            Back2.setForeground(Color.white);
            Back2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            Back2.setFont(Back2.getFont().deriveFont(10f));
            AddBox.add(Back2);

            Back2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {//Action Listener for back button
                    AddBox.dispose();
                }
            });

            AddBox.setLayout(null);
            AddBox.setLocationRelativeTo(null);
            AddBox.setVisible(true);
        } else {
            UIManager um = new UIManager();
            um.put("OptionPane.messageForeground", Color.white);
            um.put("OptionPane.background", g);
            um.put("Panel.background", g);
            JOptionPane.showMessageDialog(null, "Patient not found.", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void Delete(String SearchID, int i) {//Declaring delete

        int index = 0, flag2 = 0;

        for (int k = 0; k < 50; k++) {
            if (SearchID.equalsIgnoreCase(data[k][0])) {//Comparing the entered patient id with the patient ids entered already in the database
                index = k;
                flag2 = 1;
            }
        }

        if (flag2 == 1) {
            for (int k = index; k < i; k++) {//Moving the other elements to take over the empty spaces aftering deleting
                data[k][0] = data[k + 1][0];
                data[k][1] = data[k + 1][1];
                data[k][2] = data[k + 1][2];
                data[k][3] = data[k + 1][3];
                data[k][4] = data[k + 1][4];
                data[k][5] = data[k + 1][5];
                data[k][6] = data[k + 1][6];
                data[k][7] = data[k + 1][7];
                data[k][8] = data[k + 1][8];
                data[k][9] = data[k + 1][9];
                data[k][10] = data[k + 1][10];
                data[k][11] = data[k + 1][11];
            }
            data[i][0] = null;
            data[i][1] = null;
            data[i][2] = null;
            data[i][3] = null;
            data[i][4] = null;
            data[i][5] = null;
            data[i][6] = null;
            data[i][7] = null;
            data[i][8] = null;
            data[i][9] = null;
            data[i][10] = null;
            data[i][11] = null;

            new Database();
        }
    }
}
