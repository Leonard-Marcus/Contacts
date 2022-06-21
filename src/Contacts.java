import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {


    public static void main(String[] args) throws IOException {


        String directory = "src";
        String filename = "contacts.txt";

        //Creating file
        Path contactsDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        try {
//            Path contactsDirectory = Paths.get(directory);
//            Path dataFile = Paths.get(directory, filename);

            if (!Files.exists(contactsDirectory)) {
                System.out.println("Creating new directory named: " + contactsDirectory);
                Files.createDirectories(contactsDirectory);
            }

            if (!Files.exists(dataFile)) {
                System.out.println("Creating new file named: " + dataFile);
                Files.createFile(dataFile);
            }

            List<String> personText = new ArrayList<>();
            personText.add("Name  |  Phone number");
            personText.add("-------------------");
            personText.add("Bob | 1234567890");
            personText.add("Gary | 3247789021");
            personText.add("Lauren | 2213356773");
            personText.add("Eric | 4439087127");


//            if (Files.exists(dataFile)) {
//                System.out.println("Writing to contacts.txt file!");
//                Files.write(dataFile, personText);
//
//            }


        } catch (IOException iox) {
            iox.printStackTrace();
        }

        List<String> contacts = Files.readAllLines(Paths.get(directory, filename));

        boolean runLoop = true;
        do {
            System.out.println("1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.\n" +
                    "Enter an option (1, 2, 3, 4 or 5):");
            Scanner scanner = new Scanner(System.in);
            int userInt = scanner.nextInt();

            switch (userInt) {
                case 1:
//                String[] parts = contacts.split(" ");
//                String part = parts[0];
                    for (String contact : contacts) {
                        System.out.println(contact);
                    }
                    break;
                case 2:
                    System.out.println("Enter a name:");
                    String name = scanner.next();
                    System.out.println("Enter a phone number:");
                    String number = scanner.next();
                    List<String> nameList = new ArrayList<>();
                    nameList.add(name + " | " + number);
                    Files.write(dataFile, nameList, StandardOpenOption.APPEND);
                    break;
                case 3:
                    System.out.println("Enter contact name to search:");
                    String searchName = scanner.next();
//                List<String> searchContact = new ArrayList<>();
                    for (String search : contacts) {
                        if (search.contains(searchName)) {
                            System.out.println(search);
                        }
//
                    }
                    break;
                case 4:
                    System.out.println("Select name to delete:");
                    String deleteName = scanner.next();
                    List<String> deleteContact = new ArrayList<>();
                    for (String delete : contacts) {
                        if (delete.contains(deleteName)) {
                            continue;
                        } else {
                            deleteContact.add(delete);
                        }
                    } Files.write(dataFile, deleteContact);
//                Files.write(dataFile, deleteContact, StandardOpenOption.APPEND);
                case 5:
                    System.out.println("Goodbye!");
//                break;
                default: runLoop = false;
            }
//            System.exit(0);

        } while (runLoop);

    }
}

