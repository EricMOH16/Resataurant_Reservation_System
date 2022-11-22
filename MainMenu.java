import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.*;

public class MainMenu extends JFrame implements ActionListener {
    JMenu customerMenu;
    JMenu makeReservation;
    JMenu viewMenu;
    JButton quitOption;
    JLabel welcome;

    public MainMenu(){

        super("Restaurant Reservations System");
        setLayout(new GridBagLayout());


        createCustomerMenu();
        createReservationMenu();
        createViewMenu();


        JMenuBar mainMenuBar = new JMenuBar();
        setJMenuBar(mainMenuBar);
        mainMenuBar.add(customerMenu);
        mainMenuBar.add(makeReservation);
        mainMenuBar.add(viewMenu);

        welcome = new JLabel("Welcome to the System!");
        add(welcome);

        setSize(370,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        quitOption = new JButton("Quit");
        super.add(quitOption);
        quitOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?",
                        "Confirm",JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
                else
                    MainMenu.super.setDefaultCloseOperation(MainMenu.DO_NOTHING_ON_CLOSE);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
    }

    public void actionPerformed(ActionEvent e){
        String menuName;
        menuName = e.getActionCommand();

        if (menuName.equals("Quit"))
            System.exit(0);



    }

    private void createCustomerMenu(){
        JMenuItem createCustomer;

        customerMenu = new JMenu("Customer");

        createCustomer = new JMenuItem("Add Customer");
        createCustomer.addActionListener(this);

        customerMenu.add(createCustomer);

        createCustomer = new JMenuItem("View Customers");
        createCustomer.addActionListener(this);
        customerMenu.add(createCustomer);

        customerMenu.addSeparator();

        createCustomer = new JMenuItem("Quit");
        createCustomer.addActionListener(this);
        customerMenu.add(createCustomer);

    }

    public void createReservationMenu(){
        JMenuItem Reservation;

        makeReservation = new JMenu("Reservations");

        Reservation = new JMenuItem("Make Reservation");
        Reservation.addActionListener(this);
        makeReservation.add(Reservation);

        makeReservation.addSeparator();

        Reservation = new JMenuItem("Quit");
        Reservation.addActionListener(this);
        makeReservation.add(Reservation);

    }

    public void createViewMenu(){
        JMenuItem view;

        viewMenu = new JMenu("View");

        view = new JMenuItem("View Customers");
        view.addActionListener(this);
        viewMenu.add(view);

        makeReservation.addSeparator();

        view = new JMenuItem("Quit");
        view.addActionListener(this);
        viewMenu.add(view);
    }




}
