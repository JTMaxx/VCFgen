import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Header {
    Reader reader = new Reader();
    int columnsNumber;
    public List<String> getFieldNamesFromTxt() {
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

        public int getFieldTypeFromUser () {


                List<String> Contacts = reader.readContacts();
                List <String> fieldNames = getFieldNamesFromTxt();
                int actualFieldNumber;

                System.out.println("Put type of this field.");
                System.out.println("\nexemplary answers:");

                //this loop displays exemplary answers so that user find out which type of field is it.
                for (int i = 1; i < 4; i++) { // i=1, a nie 0, bo to poprawka na 1 niewyswietlajacy sie wiersz
                    System.out.println(reader.getFieldContent(Contacts, 1, i)); //todo: seekingFieldNumber isn't always = 1
                }
                int i = 0;
                for (String str : fieldNames) {
                    System.out.println(i + " - " + str);
                    i++;
                }
                System.out.println("Which field is that?");

                Scanner scanner = new Scanner(System.in);
                System.out.println("Put number of field type: ");
                actualFieldNumber = scanner.nextInt();
                return actualFieldNumber;
            }

    public List<String> getHeader() {
        List<String> header = new ArrayList<String>();

        columnsNumber = reader.getNumberOfColumns(reader.readContacts());

        for (int i = 0; i<columnsNumber; i++) {
            header.add(getFieldNamesFromTxt().get(getFieldTypeFromUser()));
        }

        return header;
    }




}


//todo: do scanner.close() after using all of scans