package Game;


import DbHelper.DbConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login{
    private static JLabel userLabel, userNameLabel, passwordLabel, titleLabel;
    private static JTextField userText, userNameText;
    private static JPasswordField passwordField;
    private static JButton button, button1, button2, button3, button4, button5;
    private static Font titleFont = new Font("Tahoma", Font.BOLD, 30);
    private static Font normalTitle = new Font("Tahoma", Font.PLAIN, 30);


    public static void main(String[] args) {

     // Variables
    PreparedStatement ps;
    ResultSet rs;



    // Window
    JPanel panelLogin = new JPanel();
    JFrame frameLogin = new JFrame();
    frameLogin.setSize(800, 600);
    frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frameLogin.add(panelLogin);
//    panel.setLayout(null);
    frameLogin.setVisible(true);

    // Login info for Users
        titleLabel = new JLabel("WELCOME TO COWS AND BULLS!");
        titleLabel.setBounds(150, 70, 600, 50);
        titleLabel.setFont(titleFont);
        panelLogin.add(titleLabel);

    userLabel = new JLabel("Enter Username");
    userLabel.setBounds(150, 200, 80, 25);
    panelLogin.add(userLabel);

    userNameText = new JTextField();
    userNameText.setBounds(240, 200, 165, 25);
    panelLogin.add(userNameText);

    passwordLabel = new JLabel("Enter Password");
    passwordLabel.setBounds(150, 230, 80, 25);
    panelLogin.add(passwordLabel);

    passwordField = new JPasswordField();
    passwordField.setBounds(240, 230, 165, 25);
    panelLogin.add(passwordField);


    String userName = userNameText.getText();
    String password = String.valueOf(passwordField.getPassword());

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT * FROM Users" +
                    " WHERE username='" + userName + "'");
            rs = ps.executeQuery();

            String passwordCheck = "";
            String userNameCheck = "";
            while(rs.next()) {
                passwordCheck = rs.getString("password");
                userNameCheck = rs.getString("username");

            }

            if(passwordCheck.equals(password) && userNameCheck.equals(userName)) {
                JOptionPane.showMessageDialog(null, "Login successful");
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Username or Password");
            }

        } catch (SQLException e) {
//            e.printStackTrace();

        }
        }
    }


//    public void setVisible(boolean b) {
//    }



