package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Don't forget to add button this time!
public class AddCustomer extends JFrame {
    private Insets normalInsets = new Insets(10,10,0,10);
    private Insets topInsets = new Insets(10,10,0,10);

    public AddCustomer(){
        //Creation of add customer frame
        super("Add Customer");
        JPanel customerPanel = new JPanel();
        customerPanel.setLayout(new BoxLayout(customerPanel,BoxLayout.Y_AXIS));

        customerPanel.add(createTitlePanel());
        customerPanel.add(createDetailsPanel());
        customerPanel.add(Box.createVerticalStrut(40));
        customerPanel.add(createSubmitPanel());
        customerPanel.add(cancelButton());
        customerPanel.add(returnButton());
        customerPanel.add(Box.createVerticalStrut(20));

        add(customerPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private JPanel createTitlePanel(){
        JPanel titlePanel = new JPanel();

        JLabel titleLabel = new JLabel(("Enter Customer Details Below"));
        titlePanel.add(titleLabel);
        return titlePanel;
    }
    private JPanel createDetailsPanel(){
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridBagLayout());

        int gridY = 0;
        //firstname
        JLabel firstName = new JLabel("First name");
        addComponent(detailsPanel,firstName,0,gridY,1,1,topInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JTextField firstnameField = new JTextField(20);
        addComponent(detailsPanel,firstnameField,1,gridY++,1,1,topInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);
        //lastname
        JLabel lastName = new JLabel("Last name");
        addComponent(detailsPanel,lastName,0,gridY,1,1,topInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JTextField lastnameField = new JTextField(20);
        addComponent(detailsPanel,lastnameField,1,gridY++,1,1,topInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);
        //email
        JLabel email = new JLabel("Email");
        addComponent(detailsPanel,email,0,gridY,1,1,normalInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JTextField emailField = new JTextField(20);
        addComponent(detailsPanel,emailField,1,gridY++,1,1,normalInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);
        //phone number
        JLabel phoneNumber = new JLabel("Phone Number");
        addComponent(detailsPanel,phoneNumber,0,gridY,1,1,normalInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JTextField phoneNumberField = new JTextField(20);
        addComponent(detailsPanel,phoneNumberField,1,gridY++,1,1,normalInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        return detailsPanel;
    }

    public JPanel createSubmitPanel()
    {
        JPanel submitPanel = new JPanel();
        JButton addCustomer = new JButton("Add Customer");
        submitPanel.add(addCustomer);

        return submitPanel;

    }


    private void addComponent(Container container,Component component,int gridX,int gridY,int gridWidth,int gridHeight,Insets insets,
                              int anchor,int fill){

        GridBagConstraints GBC = new GridBagConstraints(gridX,gridY,gridWidth,gridHeight,0.0,0.0,anchor,fill,insets,
                0,0);

        container.add(component,GBC);

    }
    //forgot to add a cancel button
    public JPanel cancelButton(){
        JPanel cancelPanel = new JPanel();
        JButton cancelButton = new JButton("Cancel");
        cancelPanel.add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?",
                        "Confirm",JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION){
                    setVisible(false);
                    new MainMenu().setVisible(true);
                }
                else
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            }
        });

        return cancelPanel;
    }

    public JPanel returnButton(){
        JPanel returnPanel = new JPanel();
        JButton returnButton = new JButton("Return");
        returnPanel.add(returnButton);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null,"Are you sure you want to return to the main menu?",
                        "Return to Main Menu",JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION){
                    MainMenu mainMenu = new MainMenu();
                    setVisible(false);
                }
                else
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            }
        });

        return returnPanel;
    }

    public static void main(String[] args) {
       AddCustomer addCustomer = new AddCustomer();

    }



}
