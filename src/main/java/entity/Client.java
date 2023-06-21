package entity;

import java.sql.Timestamp;

/**
 *
 * @author marco
 */
public class Client {
    
    private int id;
    private String name, lastname, email, phoneNumber;
    private double balance;
    private Timestamp createdAt, updatedAt;
    
    public Client() {}

    public Client(int id) {
        this.id = id;
    }
    
    public Client(String name, String lastname, String email, String phoneNumber, double balance) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public Client(int id, String name, String lastname, String email, String phoneNumber, double balance, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", phoneNumber=" + phoneNumber + ", balance=" + balance + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}
