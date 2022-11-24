package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends JFrame implements ActionListener {
    JMenu customerMenu;
    JMenu makeReservation;
    JMenu viewMenu;
    ArrayList<AddCustomer> customers = new ArrayList<>();
    ArrayList<MakeReservation> reservations = new ArrayList<>();

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


        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        super.add(customerPanel());
        super.add(reservationPanel());
        super.add(quitPanel());

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
        createCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddCustomer();
            }
        });

        customerMenu.add(createCustomer);

        createCustomer = new JMenuItem("View Customers");
        createCustomer.addActionListener(this);
        customerMenu.add(createCustomer);

        customerMenu.addSeparator();

        createCustomer = new JMenuItem("Quit");
        createCustomer.addActionListener(new ActionListener() {
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
        customerMenu.add(createCustomer);

    }

    public void createReservationMenu(){
        JMenuItem Reservation;

        makeReservation = new JMenu("Reservations");

        Reservation = new JMenuItem("Make Reservation");
        Reservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MakeReservation();
            }
        });
        makeReservation.add(Reservation);

        makeReservation.addSeparator();

        Reservation = new JMenuItem("Quit");
        Reservation.addActionListener(new ActionListener() {
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
        view.addActionListener(new ActionListener() {
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
    }

    public Component reservationPanel(){
        JPanel makeReservation = new JPanel();
        JButton reservationButton = new JButton("Make Reservation");
        reservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MakeReservation();
            }
        });
        makeReservation.add(reservationButton);
        return makeReservation;
    }
    public JPanel customerPanel(){
        JPanel addCustomer = new JPanel();
        JButton addCustomerBtn = new JButton("Add Customer");
        addCustomer.add(addCustomerBtn);
        addCustomerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCustomer();
                setVisible(false);
            }
        });
        return addCustomer;
    }

    public JPanel quitPanel(){
        JPanel quit = new JPanel();
        JButton quitBtn = new JButton("Quit");
        quitBtn.addActionListener(new ActionListener() {
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

        return quit;
    }
    public void addCustomer()
    {

    }


    }


}
