public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;

    public Customer(){
        this("Not provided","Not provided","Not provided",0);
    }

    public Customer(String firstName, String lastName, String email, int phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "\nFirst Name: " + getFirstName() + "\nLast Name: " + getLastName() +
                "\nEmail: " + getEmail() + "\nPhone Number: " + getPhoneNumber();

    }
}
