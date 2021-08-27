package Game;

import javax.swing.*;
import Game.Login;
import Game.SignUp;
import Game.NewGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class Home {

    // Variables
    private static JLabel userLabel, userNameLabel, repeatPsLabel, accountLabel;
    private static JTextField userText, userNameText;
    private static JLabel passwordLabel;
    private static JLabel titleLabel;
    private static JPasswordField passwordText, repeatPsText;
    private static JButton buttonToLogin, buttonToSignUp;
    private static JButton button2, button3, button4;
    private static JLabel success;
    private static Font titleFont = new Font("Times New Roman", Font.BOLD, 30);
    private static Font normalTitle = new Font("Times New Roman", Font.PLAIN, 25);
    private static Object Login;




    // Main page - Home Page
    // All functions will be accessible here
    public static void main() {
            // Main window, formatting
            JPanel panel = new JPanel();
            JFrame frame = new JFrame();
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);

            panel.setLayout(null);
            frame.setVisible(true);

            // Welcome message
            titleLabel = new JLabel("WELCOME TO COWS AND BULLS!");
            titleLabel.setBounds(150, 70, 600, 50);
            titleLabel.setFont(titleFont);
            panel.add(titleLabel);

            // Login button that leads to login window

            buttonToLogin = new JButton("Login");
            buttonToLogin.setBounds(150, 280, 80, 25);
            buttonToLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    this.setVisible(false);
//                    new Login().setVisible(true);
                }
                private void setVisible(boolean b) {
                }
            });
            panel.add(buttonToLogin);

            // SignUp button that leads to signUp window
        buttonToSignUp = new JButton("Sign Up");
        buttonToSignUp.setBounds(350,280,80,25);
        buttonToSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
            panel.add(buttonToSignUp);


                // Exit button that exits from the program
    }
    }


