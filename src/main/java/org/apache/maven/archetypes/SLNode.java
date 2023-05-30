package org.apache.maven.archetypes;
import java.io.Serializable;


@SuppressWarnings("serial")
public class SLNode implements Serializable {

    private String name;
    private String email;
    private String phoneNumber;
    private String cf;
    private SLNode next;


    // create instance of SLNode and set next to 'null'
    public SLNode() {
        //data = -1;
        next = null;
    }
    /**
     * create setters and getters for name, email, phone number, close friend and SLNode
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getClosefriend() {
        return cf;
    }

    public void setClosefriend(String cf) {
        this.cf = cf;
    }
    public SLNode getNext() {
        return next;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return name + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\nClose friend: " + cf + "\n";
    }
}
