package org.apache.maven.archetypes;
import java.io.Serializable;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * create serialization so files can be written and read in byte form
 * and allow readability of types
 */
@SuppressWarnings("serial")
public class SLList implements Serializable {
    private SLNode head;
    private int length;

    public SLList() { // initialize the list
        head = null;
        length = 0;
    }

    public void Insert(String name, String num, String email, String cf) {
        SLNode newNode = new SLNode();

        newNode.setName(name); // Set the data: name, num, email, cf
        newNode.setPhoneNumber(num);
        newNode.setEmail(email);
        newNode.setClosefriend(cf);

        if (head == null) { // if the head is empty, new entry automatically becomes the head and length is increased by one
            head = newNode;
            length++;
        } else {
            newNode.setNext(head); // set new node's next as current head
            head = newNode; // update head pointer to new node
            length++;
        }
        System.out.print("Insert contact sucessfully!");
    }

    public void Delete(String name) {
        SLNode current = head;
        SLNode previous = null;
        boolean found = false;
        int count = 0;

        if (isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            while (current != null) {
                if (current.getName().equalsIgnoreCase(name)) {
                    count++;
                    found = true;
                }
                previous = current;
                current = current.getNext();
            }
            if (!found) {
                System.out.println("Name not found in the list.");
            } else if (count == 1) {
                current = head;
                previous = null;
                while (current != null && !current.getName().equalsIgnoreCase(name)) {
                    previous = current;
                    current = current.getNext();
                }
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                length--;
                System.out.println("Successfully deleted " + name + ".");
            } else {
                int i = 1;
                List<SLNode> nodesToDelete = new ArrayList<>();
                current = head;
                while (current != null) {
                    if (current.getName().equalsIgnoreCase(name)) {
                        System.out.println(i + ". " + current.toString());
                        nodesToDelete.add(current);
                        i++;
                    }
                    current = current.getNext();
                }
                System.out.println("Please choose the contact number you want to delete:");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                if (choice <= 0 || choice > nodesToDelete.size()) {
                    System.out.println("Invalid choice.");
                } else {
                    SLNode nodeToDelete = nodesToDelete.get(choice - 1);
                    current = head; //delete = head
                    previous = null;
                    while (current != nodeToDelete) {
                        previous = current;
                        current = current.getNext();
                    }
                    if (previous == null) { // delete = tail
                        head = current.getNext();
                    } else {
                        previous.setNext(current.getNext()); // delete = mid
                    }
                    length--;
                    System.out.println("Delete the contact successfully");
                }
            }
        }
    }

    public void Display() { //ch=4
        SLNode tempNode = head;

        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }

        int count = 0; // Count the number of nodes in the list
        while (tempNode != null) {
            count++;
            tempNode = tempNode.getNext();
        }

        SLNode[] arr = new SLNode[count]; // Copy the node values into an array
        tempNode = head;
        for (int i = 0; i < count; i++) {
            arr[i] = tempNode;
            tempNode = tempNode.getNext();
        }

        for (int i = 0; i < count - 1; i++) { // Sort the array using bubble sort
            for (int j = 0; j < count - i - 1; j++) {
                if (arr[j].getName().compareToIgnoreCase(arr[j + 1].getName()) > 0) {
                    SLNode temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < count; i++) { // Print the sorted array
            System.out.print((i+1) + ". ");
            System.out.println(arr[i]);
        }
    }

    public void Search(String name) {
        SLNode current = head;
        boolean empty = true;

        if (isEmpty()) { // check to see if the list is empty
            System.out.println("The list is empty!");
        } else {
            for (int i = 0; i < length; i++) {
                if (current.getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.print((i + 1) + ". ");
                    System.out.println(current);
                    empty = false;
                }
                current = current.getNext();
            }
            if (empty) {
                System.out.println("No matches to that name!");
            }
        }
    }

    public void Update(String name) {
        SLNode current = head;
        List<SLNode> matches = new ArrayList<>();

        if (isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            while (current != null) {
                if (current.getName().equalsIgnoreCase(name)) {
                    matches.add(current);
                }
                current = current.getNext();
            }
            if (matches.isEmpty()) {
                System.out.println("Name not found in the list.");
            } else if (matches.size() == 1) {
                Scanner scanner = new Scanner(System.in);
                SLNode contact = matches.get(0);
                System.out.println("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.println("Enter new phone number: ");
                String newPhoneNumber = scanner.nextLine();
                System.out.println("Enter new email: ");
                String newEmail = scanner.nextLine();
                System.out.println("Is this person a close friend? (Y/N)");
                String isCloseFriend = scanner.nextLine();
                contact.setName(newName);
                contact.setPhoneNumber(newPhoneNumber);
                contact.setEmail(newEmail);
                contact.setClosefriend(isCloseFriend);
                System.out.println("Contact updated successfully.");
            } else {
                System.out.println(String.format("%d contacts found with name '%s':", matches.size(), name));
                for (int i = 0; i < matches.size(); i++) {
                    System.out.println(String.format("%d. %s", i+1, matches.get(i).toString()));
                }
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the number of the contact you want to update:");
                int selection = scanner.nextInt();
                scanner.nextLine();
                if (selection >= 1 && selection <= matches.size()) {
                    SLNode contact = matches.get(selection - 1);
                    System.out.println("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.println("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    System.out.println("Close friend: ");
                    String isCloseFriend = scanner.nextLine();
                    contact.setName(newName);
                    contact.setPhoneNumber(newPhoneNumber);
                    contact.setEmail(newEmail);
                    contact.setClosefriend(isCloseFriend);
                    System.out.println("Contact updated successfully.");
                } else {
                    System.out.println("Invalid selection.");
                }
            }
        }
    }

    public boolean isEmpty() { // method to use if the linked list is empty
        return (length == 0);
    }
}