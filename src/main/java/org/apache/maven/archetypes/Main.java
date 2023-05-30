package org.apache.maven.archetypes;
import java.io.IOException;
import java.util.*;

// Ryan Goldstone
// ryangold@bu.edu
// Java 342 B1
// Assignment 3 - The "Linked List" Telephone Book

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        SLList newList = new SLList();
//        InputOutput newIO = new InputOutput();
        Scanner in = new Scanner(System.in);
        String fileName = "";
        String choice;
        boolean done = false;

        do {
            System.out.println();
            System.out.format("*******************%n");
            System.out.format("1. Insert contact  \n2. Delete contact \n3. Search \n4. Display \n5. Update contact \n-1. Quit%n");
            System.out.format("Please Enter your choice: ");
            choice = in.nextLine().toUpperCase();
            switch (choice) {
                case "1":
                    System.out.print("Contact name: ");
                    String name = in.nextLine();

                    System.out.print("Phone number: ");
                    String num = in.nextLine();

                    System.out.print("Email: ");
                    String email = in.nextLine();

                    System.out.print("Close friend: ");
                    String cf = in.nextLine();

                    newList.Insert(name, num, email,cf);
                    break;
                case "2":
                    System.out.print("Enter name to delete: ");
                    String delete = in.nextLine();
                    newList.Delete(delete);
                    break;

                case "3":
                    System.out.print("Enter a Name to search for: ");
                    String sName = in.nextLine();
                    newList.Search(sName);
                    break;
                case "4":
                    System.out.println("Print Phonebook");
                    newList.Display();
                    break;
                case "5":
                    System.out.println("Enter contact name: ");
                    String update = in.nextLine();
                    newList.Update(update);
//                    newIO.readFile(fileName);
                    break;
                case "-1":
                    System.out.println("Exiting!");
                    done = true;
                    break;
                default:
                    System.out.println("Wrong choice, try again");
            }
        }  while (!done);
        System.out.println("Thanks for using our website!");
    }
}