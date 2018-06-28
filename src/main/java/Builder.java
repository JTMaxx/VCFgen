import java.io.PrintWriter;

public class Builder {


    Reader reader1 = new Reader();

    public void buildVCF() {
       // Reader reader1 = new Reader(reader1.getDistinctDataTypes(reader1.readContacts().get(1)));

        /* TEST POBIERANIA DANYCH ZA POMOCA getDistinctDataTypes Z KLASY READER */
//       Reader reader1 = new Reader(); //Can I use here 'reader' instead of 'reader1' ?
       //reader1. = readContacts();

       String[] Contacts = reader1.getDistinctDataTypes(1);
       try {
           PrintWriter writer = new PrintWriter("export.csv", "UTF-8");
           writer.println("Template header"); //draft title

           for (int contactNumberFromZero = 0; contactNumberFromZero < reader1.getQuantity() - 2; contactNumberFromZero++) { //there is -2 instead of -1 in order to fix the problem
                                                                                                                            // with index which I can't solve
               for (int j = 0; j < 4; j++) {
                   writer.print(Contacts[j] + ",");
               }
               writer.println();
               Contacts = reader1.getDistinctDataTypes(contactNumberFromZero+2); // At the beginning contactNumberFromZero = 0 and ContactNumber = 1 has been already printed.
           }
           writer.close();
       }
       catch (java.io.UnsupportedEncodingException e) {
           System.err.println("Unsupported encoding.");
       }
       catch (java.io.FileNotFoundException e) {
           System.err.println("File not exist!");
       }
        System.out.println("contacts exported. (Without the last - there is an error)");


    }


    int seekingStartIndex = 0;

    //bases on number of column and returns content of field
    String getFieldContent(int seekingFieldNumber, int contactNumber) {

        int actualIndex = 0;
        int actualFieldNumber = 0;
        int fieldContentLength = 0;
        int seekingEndIndex;

        while (actualFieldNumber < seekingFieldNumber - 1) { //-1 because seekingFieldNumber begins from 1
            //if ("\t".equals(reader1.contactsToParse.get(contactNumber).charAt(actualIndex))) {
            if ("\t".equals(reader1.contactsToParse.get(contactNumber).substring(actualIndex, actualIndex+1))) {
                actualFieldNumber++;
                seekingStartIndex = actualIndex + 1; // +1 because \t doesn't belong to fieldContent
            }
            //System.out.println(reader1.contactsToParse.get(contactNumber).charAt(actualIndex)+"o|");

            actualIndex++;
        }

//
//            }




//         for (int i = 0; i < reader1.contactsToParse.get(contactNumber).length(); i++) {
//            if ("\t".equals(reader1.contactsToParse.get(contactNumber).charAt(i))) { //contactsToParse are called in getDistinctDataTypes
//                                                                                              // therefore they have content
//                                                                                              //if you don't use getDistinctDataTypes method, you have to call readContacts() firstly
//                actualFieldNumber++;
//            }
//            if (actualFieldNumber == seekingFieldNumber) {
//                seekingStartIndex = i;
//                break;
//
//            }
//        }
        while ( !"\t".equals(reader1.contactsToParse.get(contactNumber)
                .substring(seekingStartIndex+fieldContentLength, seekingStartIndex+fieldContentLength + 1))) {
            fieldContentLength++;
        }
        seekingEndIndex = seekingStartIndex + fieldContentLength;

        System.out.println("seekingStartIndex = " + seekingStartIndex);
        System.out.println("seekingEndIndex = " + seekingEndIndex);
        String fieldContent = reader1.contactsToParse.get(contactNumber).substring(seekingStartIndex, seekingEndIndex);
        System.out.println("fieldContent = " + fieldContent);
        return fieldContent;
    }

}
