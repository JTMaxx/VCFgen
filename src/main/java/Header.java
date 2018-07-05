import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Header {
    private Reader reader = new Reader();
    private int columnsNumber;
    List<String> Contacts = reader.readContacts();


    private List<String> getFieldNamesFromTxt() {
        List<String> fieldNames = new ArrayList<String>();
        File file = new File("field-names.txt");

        //take names of fields from field-names.txt
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

                System.out.println("\nexemplary answers:");

                //this loop displays exemplary answers so that user find out which type of field is it.
                for (int i = 0; i < 3; i++) { // i < 3 because there are 3 exemplary answers
                    System.out.println(reader.getFieldContent(Contacts, currentFieldNumber, i));
                }
                System.out.println();

                int i = 0;
                for (String name: fieldNames) {
                    System.out.println(i + " - " + name);
                    i++;
                }
                System.out.println("Which field is that?");

                Scanner scanner = new Scanner(System.in);
                System.out.println("Put number of field type: ");
                codeFieldNumber = scanner.nextInt();
                return codeFieldNumber;

            }

        public List<String> getHeader() {
            List<String> header = new ArrayList<String>();
            columnsNumber = reader.getNumberOfColumns(Contacts);

            for (int i = 0; i<columnsNumber; i++) {
                header.add(getFieldNamesFromTxt().get(getFieldTypeFromUser(i + 1)));
            }
            System.out.println("\nColumn types accepted.");
            return header;
    }




}


