import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    private int quantity;
    private String telNumb;
    private String email;
    List<String> contactsToParse = new ArrayList();
    private boolean gDDTflag = true; // it refers to first call of getDistinctDataTypes() if it is not first one, gDDTflag is false


    public int getQuantity() {
        return quantity;
    }



    // Read contacts from Scanner and save it to List<String> where each position in this list similar to:
    // johny	monday	39029331	january@gmail.com
    public List<String> readContacts() {
        List<String> contactsLines = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        String path = null;
        String record = null;

        System.out.println("How many contacts you want to put?");
        quantity = scanner.nextInt() + 1; // + 1 to poprawka na wyswietlanie o jeden wiersz za malo
        System.out.println("Paste data from spreadsheet.");

        for (int i = 0; i < quantity; i++) {
            record = scanner.nextLine();
            contactsLines.add(record);
        }

//        System.out.println();
//        System.out.println("You put: ");                                          //
//        for (int i = 0; i < quantity; i++) {  // wyswietla jeden za malo wiersz   // display scanned rows
//            System.out.println("for i = " + i + " : " + contactsLines.get(i));    //
//
//        }
        scanner.close();
        return contactsLines;
    }
    //bases on number of column and returns content of field
    String getFieldContent(int seekingFieldNumber, int contactNumber) {

        int actualFieldNumber = 0;
        int seekingStartIndex = 0;
        //seekingFieldNumber = Header.getPosition(fieldName);
        //for (int i = 0; i < contactsToParse.get(contactNumber).length(); i++) {
        System.out.println("test contactsToParse.get(contactNumber): " + contactsToParse.get(contactNumber));
//        for (int i = 0; i < 5; i++) {
//            if (contactsToParse.get(contactNumber).substring(i, i+1) == "\t")
//            {
//                actualFieldNumber++;
//            }
//            if (actualFieldNumber == seekingFieldNumber) {
//                seekingStartIndex = i;
//                break;
//
//            }
//        }
//        int i = 0;
//        int seekingEndIndex = 0;
//        while (contactsToParse.get(contactNumber).substring(i, i+1) != "\t") {
//            i++;
//        }
//        seekingEndIndex = i;
//
//        String fieldContent = contactsToParse.get(contactNumber).substring(seekingStartIndex, seekingEndIndex);
//        System.out.println("fieldContent = " + fieldContent);
//        return fieldContent;
        return "end";
    }

    public String[] getDistinctDataTypes(int ContactNumber) {

        //Ma byc wykonane tylko przy pierwszym uzyciu metody 'getDistinctDataTypes'
        if (gDDTflag) { contactsToParse = readContacts(); gDDTflag = false; }

        String inputData = contactsToParse.get(ContactNumber);
        String afterName;

        //First name and Surnameparsing
        String[] partOutData = new String[3]; // 4 - liczba kolumn do telefonu wlacznie
        partOutData = inputData.split("\t", 3);    //kontakty przekopiowane z google sheets mają \t
                                                        // a nie spacje pomiędzy wartosciami

        String[] completeOutData = new String[4]; // 4 - liczba kolumn
        completeOutData[0]=partOutData[0];
        completeOutData[1]=partOutData[1];
        afterName = partOutData[2];

        int i;
        telNumb = "";
        for (i = 0; (((int) afterName.charAt(i)) >= 48 && ((int) afterName.charAt(i)) <= 57); i++) { //sprawdzanie czy znak jest liczba
            //dodaj obsluge \t, spacji, "-"
            telNumb = telNumb + afterName.charAt(i);
        }
        completeOutData[2] = telNumb;

        email = afterName.substring(i+1); //gdy zrobisz obsluge \t, skasuj +1
        //System.out.println("email = " + email);
        completeOutData[3] = email;
//        partOutData[2] = telNumb;
//        partOutData[3] = email;
        return  completeOutData;



//        for (String temp: arr1) {
//            System.out.println(temp);
//        }


//        System.out.println("Returned values: ");
//        for (String retval: (contactsToParse.get(1)).split(" ")) {
//            System.out.println(retval);
//        }

//        int i = ((contactsToParse.get(1)).substring(2)).indexOf(' ');
//        System.out.println("index of space = " + i);
//        String firstName = (contactsToParse.get(1)).substring(0, i);
//        System.out.println("firstName = " + firstName + "|");
//        String afterFirstName = (contactsToParse.get(1)).substring(i);
//        System.out.println("afterFirstName =" + afterFirstName);


    }
}


