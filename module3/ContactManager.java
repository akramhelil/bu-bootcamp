import java.util.*;

public class ContactManager {

    public static HashMap<String, Contact> contacts = new HashMap<>();

    public static void main(String[] args) {

        // Step 4: add contacts here
        contacts.put("Akram Helil",
                new Contact("Akram Helil", "+1 808-253-9666"));
        contacts.put("Ada Lovelace",
                new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Ron Gilliam",
                new Contact("Ron Gilliam", "+1 212-122-1234"));
        contacts.put("Bugs Bunny",
                new Contact("Bugs Bunny", "+1 145-234-7777"));
        contacts.put("John Doe",
                new Contact("John Doe", "+1 334-554-5678"));

        // Step 5: look up a contact
        System.out.println("*********************************");
        System.out.println(getContact("Akram Helil"));
        System.out.println("*********************************\n\n");

        System.err.println("Not Exist Contact Lookup:");
        System.out.println(getContact("Not Exist"));

        // Step 6: print sorted list
        System.out.println("*********************************");
        printAllContacts(getSortedAllContacts(contacts));
        System.out.println("*********************************\n\n");

        // Remove Contact
        System.out.println("*********************************");
        System.out.println("--- Before Removing Contact -----");
        printAllContacts(getSortedAllContacts(contacts));
        System.out.println("*********************************\n\n");

        System.out.println("*********************************");
        System.err.println("Removing Contact:");
        removeContact("Akram Helil");
        System.out.println("--- After Removing Contact -----");
        printAllContacts(getSortedAllContacts(contacts));
        System.out.println("*********************************\n\n");

    }

    public static String getContact(String name) {
        if (contacts.containsKey(name)) {
            return contacts.get(name).toString();
        } else {
            return "Contact Not Found";
        }
    }

    public static ArrayList<Contact> getSortedAllContacts(HashMap<String, Contact> contacts) {
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());

        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        return sorted;
    }

    public static void printAllContacts(ArrayList<Contact> contacts) {
        System.out.println("=== All Contacts ===");
        for (Contact contact : contacts) {
            System.out.println(contact.toString());

        }
    }

    public static String removeContact(String name) {
        if (contacts.containsKey(name)) {
            System.out.println("Contact Removed: " + contacts.get(name).toString());
            contacts.remove(name).toString();
            return "Contact Removed Success";
        } else {
            return "Contact Not Found";
        }
    }
}