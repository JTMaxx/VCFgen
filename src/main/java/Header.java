import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Header {
    private Reader reader = new Reader();
    private int columnsNumber;
    private List<String> contacts = Collections.unmodifiableList(reader.readContacts());

    private List<String> getFieldNamesFromTxt() {
        List<String> fieldNames = new ArrayList<String>();
        File file = new File("field-names-min.txt"); //field-names-min.txt - minimum list
                                                        //field-names-ext.txt - extended list

        //take names of fields from field-names-xxx.txt
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                fieldNames.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fieldNames;
    }

        private int getFieldTypeFromUser (int currentFieldNumber) {

                List <String> fieldNames = getFieldNamesFromTxt();
                int codeFieldNumber;
                System.out.println("Which type of field is that?");
                System.out.println("\nexamples:");

                //this loop displays exemplary answers so that user find out which type of field is it.
                for (int i = 0; i < 3; i++) { // i < 3 because there are 3 exemplary answers
                    System.out.println(reader.getFieldContent(contacts, currentFieldNumber, i));
                }
                System.out.println();
                System.out.println("Possible field types:");

                int i = 0;
                for (String name: fieldNames) {
                    System.out.println(i + " - " + name);
                    i++;
                }

                Scanner scanner = new Scanner(System.in);
                System.out.println("\nPut number of field type:");
                codeFieldNumber = scanner.nextInt();
                return codeFieldNumber;

            }

        public List<String> getHeader() {
            List<String> header = new ArrayList<String>();
            columnsNumber = reader.getNumberOfColumns(contacts);

            for (int i = 0; i<columnsNumber; i++) {
                header.add(getFieldNamesFromTxt().get(getFieldTypeFromUser(i + 1)));
            }
            System.out.println("\nColumn types accepted.");
            return header;
    }

    public List<String> getContacts() {
        return contacts;
    }
}


