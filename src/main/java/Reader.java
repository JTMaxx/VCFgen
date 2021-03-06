//todo: add line with scanner.close() after using all of scans
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    // Read contacts from Scanner and save it to List<String> in which each row is similar to:
    // John	Smith	39029331	january@gmail.com
    // with \t between
    public List<String> readContacts() {
        List<String> contactsLines = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Paste data from spreadsheet and press enter twice.");

        String scan;
        while (true) {
            scan = scanner.nextLine();
            if (!"".equals(scan)) {
                contactsLines.add(scan);
            }
            else {
                break;
            }

        }

        return contactsLines;
    }

    public int getNumberOfColumns(List<String> contacts) {
        int currentIndex = 0;
        int fieldNumber = 0;
        while (true) {

            try {
                contacts.get(0).substring(currentIndex, currentIndex+1);
                if ("\t".equals(contacts.get(0).substring(currentIndex, currentIndex+1))) {
                    fieldNumber++;
                }
            }

            catch (StringIndexOutOfBoundsException e) {
                break;
            }
            currentIndex++;
        }
      return fieldNumber + 1; //+1 because there is one more columns than '\t'
    }


    //bases on number of column and returns content of field
    String getFieldContent(List<String> contactsToParse, int FieldNumber, int contactNumber) {

        int actualIndex = 0;
        int currentFieldNumber = 0;
        int fieldContentLength = 0;
        int startIndex = 0;
        int endIndex;

        while (currentFieldNumber < FieldNumber - 1) { //-1 because FieldNumber begins from 1
            if ("\t".equals(contactsToParse.get(contactNumber).substring(actualIndex, actualIndex+1))) {
                currentFieldNumber++;
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
        return contactsToParse.get(contactNumber).substring(startIndex, endIndex);
    }
}


