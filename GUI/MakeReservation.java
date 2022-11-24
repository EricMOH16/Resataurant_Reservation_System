package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Don't forget to add button this time!
public class MakeReservation extends JFrame {
    private Insets normalInsets = new Insets(10,10,0,10);
    private Insets topInsets = new Insets(10,10,0,10);

    public MakeReservation(){
        //Creation of add customer frame
        super("Make Reservation");
        JPanel reservationPanel = new JPanel();
        reservationPanel.setLayout(new BoxLayout(reservationPanel,BoxLayout.Y_AXIS));

        reservationPanel.add(createTitlePanel());
        reservationPanel.add(createDetailsPanel());
        reservationPanel.add(Box.createVerticalStrut(40));
        reservationPanel.add(createSubmitPanel());
        reservationPanel.add(cancelButton());
        reservationPanel.add(returnButton());
        reservationPanel.add(Box.createVerticalStrut(20));

        add(reservationPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private JPanel createTitlePanel(){
        JPanel titlePanel = new JPanel();

        JLabel titleLabel = new JLabel(("Enter Reservation Details Below"));
        titlePanel.add(titleLabel);
        return titlePanel;
    }
    private JPanel createDetailsPanel(){
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridBagLayout());

        int gridY = 0;
        //time
        JLabel time = new JLabel("First name");
        addComponent(detailsPanel,time,0,gridY,1,1,topInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JTextField timeField = new JTextField(20);
        addComponent(detailsPanel,timeField,1,gridY++,1,1,topInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);
        //date
        JLabel date = new JLabel("Date");
        addComponent(detailsPanel,date,0,gridY,1,1,topInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JTextField dateField = new JTextField(20);
        addComponent(detailsPanel,dateField,1,gridY++,1,1,topInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);
        //customer
        JLabel customer = new JLabel("Customer");
        addComponent(detailsPanel,customer,0,gridY,1,1,normalInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JTextField customerField = new JTextField(20);
        addComponent(detailsPanel,customerField,1,gridY++,1,1,normalInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);
        //partySize
        JLabel partySize = new JLabel("Party-Size");
        addComponent(detailsPanel,partySize,0,gridY,1,1,normalInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JTextField partySizeField = new JTextField(20);
        addComponent(detailsPanel,partySizeField,1,gridY++,1,1,normalInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);
        //table-number
        JLabel tableNumber = new JLabel("Table-Number");
        addComponent(detailsPanel,tableNumber,0,gridY,1,1,normalInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JTextField tableNumberField = new JTextField(20);
        addComponent(detailsPanel,tableNumberField,1,gridY++,1,1,normalInsets,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);
        return detailsPanel;
    }

    public JPanel createSubmitPanel()
    {
        JPanel submitPanel = new JPanel();
        JButton addCustomer = new JButton("Make Reservation");
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
        MakeReservation makeReservation = new MakeReservation();

    }



}
