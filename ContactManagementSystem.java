import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;
    String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail Address: " + emailAddress;
    }
}

public class ContactManagementSystem {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nContact Management System");
            System.out.println("1. Add a new contact");
            System.out.println("2. View contact list");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContactList();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting Contact Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.next();

        Contact newContact = new Contact(name, phoneNumber, emailAddress);
        contacts.add(newContact);

        System.out.println("Contact added successfully!");
    }

    private static void viewContactList() {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("\nContact List:");
            for (Contact contact : contacts) {
                System.out.println(contact);
                System.out.println("--------------");
            }
        }
    }

    private static void editContact() {
        viewContactList();
        System.out.print("Enter the index of the contact you want to edit: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < contacts.size()) {
            System.out.print("Enter new name: ");
            contacts.get(index).name = scanner.next();
            System.out.print("Enter new phone number: ");
            contacts.get(index).phoneNumber = scanner.next();
            System.out.print("Enter new email address: ");
            contacts.get(index).emailAddress = scanner.next();

            System.out.println("Contact edited successfully!");
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }

    private static void deleteContact() {
        viewContactList();
        System.out.print("Enter the index of the contact you want to delete: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }
}
