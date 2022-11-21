public class Reservation {
    private float time;
    private String date;
    private Customer customer;
    private int partySize;
    private int tableNumber;

    public Reservation(float time, String date, Customer customer, int partySize, int tableNumber) {
        setTime(time);
        setDate(date);
        setCustomer(customer);
        setPartySize(partySize);
        setTableNumber(tableNumber);
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
