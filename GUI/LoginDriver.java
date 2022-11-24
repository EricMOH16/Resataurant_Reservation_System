package GUI;/*This is the GUI creation for my login JFrame and the validation that will be performed
  to allow the user to login*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class LoginDriver{
    JTextField usernameTextField;
    JPasswordField userPasswordTextField;
    ArrayList<AddCustomer> customer = new ArrayList<>();


    public LoginDriver()
    {
        //Window
        JFrame loginWindow = new JFrame("Welcome");
        FlowLayout loginLayout = new FlowLayout();
        loginWindow.setLayout(loginLayout);
        loginWindow.setSize(300,180);
        loginWindow.setLocationRelativeTo(null);//learned from alvinalexander.com
        loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Username
        JLabel usernameLabel = new JLabel("Username");
        loginWindow.add(usernameLabel);
        usernameTextField = new JTextField(15);
        loginWindow.add(usernameTextField);
        //Password
        JLabel passwordLabel = new JLabel("Password");
        loginWindow.add(passwordLabel);
        userPasswordTextField = new JPasswordField(15);
        loginWindow.add(userPasswordTextField);
        //Adding Button
        JButton loginButton = new JButton("Login");
        loginWindow.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                    if (e.getSource() == usernameTextField)
                    {
                        userPasswordTextField.requestFocus();
                    }
                    if (e.getSource() == userPasswordTextField)
                    {
                        //took a long time to remember password is char NOT TEXT!
                        char[] passwordCharacters = userPasswordTextField.getPassword();
                        String passwordText = new String(passwordCharacters);

                        if (usernameTextField.getText().equals("") || passwordText.equals(""))
                        {
                            JOptionPane.showMessageDialog(null, "All fields must be filled!");
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Welcome " + usernameTextField.getText());

                        new MainMenu();
            }
        });



        loginWindow.setVisible(true);

    }

    public static void main(String[] args)
    {
        LoginDriver usernameAndPassword = new LoginDriver();
    }

    }


