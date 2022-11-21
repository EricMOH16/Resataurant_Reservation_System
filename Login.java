/*This is the GUI creation for my login JFrame and the validation that will be performed
  to allow the user to login*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    JTextField usernameTextField;
    JPasswordField userPasswordTextField;

    public Login()
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

        ButtonEventHandler loginHandler = new ButtonEventHandler();
        //Creation of ActionListener for button
        loginButton.addActionListener(loginHandler);

        loginWindow.setVisible(true);

    }

    public static void main(String[] args)
    {
        Login usernameAndPassword = new Login();
    }

    private class ButtonEventHandler implements ActionListener{

        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == usernameTextField)
            {
                userPasswordTextField.requestFocus();
            }
            if (e.getSource() == userPasswordTextField)
            {
                //password is a char! Change it to a string
                char[] passwordChar = userPasswordTextField.getPassword();
                String passwordFieldText = new String(passwordChar);

                //Putting in my all fields must be filled validation
                if (usernameTextField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Invalid Username!");
                    if (passwordFieldText.equals("")) {
                        JOptionPane.showMessageDialog(null, "You must enter a valid password!");
                        if (usernameTextField.getText().equals("") && passwordFieldText.equals(""))
                            JOptionPane.showMessageDialog(null,"All Fields must be filled!");
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Welcome to the system " +
                                    usernameTextField.getText());
                    }
                }
            }



        }
    }


