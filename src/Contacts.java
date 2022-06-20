import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    public static void main(String[] args) {


        String directory = "src";
        String filename = "contacts.txt";

        //Creating file

        try {
            Path contactsDirectory = Paths.get(directory);
            Path dataFile = Paths.get(directory, filename);

            if (!Files.exists(contactsDirectory)) {
                System.out.println("Creating new directory named: " + contactsDirectory);
                Files.createDirectories(contactsDirectory);
            }

            if (!Files.exists(dataFile)) {
                System.out.println("Creating new file named: " + dataFile);
                Files.createFile(dataFile);
            }

            List<String> personText = new ArrayList<>();
            personText.add("Bob 1234567890");
            personText.add("Bob 1234567890");


            if (Files.exists(dataFile)) {
                System.out.println("Writing to contacts.txt file!");
                Files.write(dataFile, personText);

            }



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
                        System.out.println(personText);
                    case 2:
                        System.out.println();
                }


            } catch(IOException iox){
                iox.printStackTrace();
            }


        }


    }

