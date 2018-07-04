import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    int rowsNumber;


    // Read contacts from Scanner and save it to List<String> where each position in this list similar to:
    // johny	monday	39029331	january@gmail.com
    public List<String> readContacts() {
        List<String> contactsLines = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        String row;

        System.out.println("How many contacts you want to put?");
        rowsNumber = scanner.nextInt() + 1; // + 1 to poprawka na wyswietlanie o jeden wiersz za malo
        System.out.println("Paste data from spreadsheet.");

        for (int i = 0; i < rowsNumber; i++) {
            row = scanner.nextLine();
            //scanner.close();
            contactsLines.add(row);
        }
        return contactsLines;
    }

    public int getNumberOfColumns(List<String> contacts) {
        int currentIndex = 0;
        int fieldNumber = 0;
        while (true) {

            try {
                contacts.get(1).substring(currentIndex, currentIndex+1); // 1 bo nie czyta 0 wiersza
                if ("\t".equals(contacts.get(1).substring(currentIndex, currentIndex+1))) { // 1 bo nie czyta 0 wiersza
                    fieldNumber++;
                }
            }

            catch (StringIndexOutOfBoundsException e) {
                break;
            }

//            catch (IndexOutOfBoundsException e) {
//                //hasNextChar = false;
//                break;
//            }


            currentIndex++;
        }


      return fieldNumber + 1; //+1 because there is one more columns than '\t'
    }




    //bases on number of column and returns content of field
    String getFieldContent(List<String> contactsToParse, int seekingFieldNumber, int contactNumber) {

        int actualIndex = 0;
        int actualFieldNumber = 0;
        int fieldContentLength = 0;
        int startIndex = 0;
        int endIndex;
        //List<String> contactsToParse = readContacts();

        while (actualFieldNumber < seekingFieldNumber - 1) { //-1 because seekingFieldNumber begins from 1
            if ("\t".equals(contactsToParse.get(contactNumber).substring(actualIndex, actualIndex+1))) {
                actualFieldNumber++;
                startIndex = actualIndex + 1; // +1 because \t doesn't belong to fieldContent
            }
            actualIndex++;
        }

        try {
            while (!"\t".equals(contactsToParse.get(contactNumber)
                    .substring(startIndex + fieldContentLength, startIndex + fieldContentLength + 1))) {
                fieldContentLength++;
            }
        }
        catch (IndexOutOfBoundsException e) {
            return contactsToParse.get(contactNumber).substring(startIndex);
        }
        endIndex = startIndex + fieldContentLength;
        //System.out.println("liczba kolumn: " + actualFieldNumber);
        return contactsToParse.get(contactNumber).substring(startIndex, endIndex);
    }



}


