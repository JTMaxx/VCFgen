import java.io.PrintWriter;
import java.util.List;

public class Builder {


    public void buildVCF() {
        Header header = new Header();
        List<String> headerList;
        headerList = header.getHeader();
        Reader reader = new Reader();

        try {
           PrintWriter writer = new PrintWriter("export.csv", "UTF-8");
           int i=0;
           for(String str: headerList) {
               writer.print(str);
               if (i == reader.getNumberOfColumns(header.Contacts) - 1) { //'removing' unnecessary comma
                   break;
               }
               writer.print(",");
               i++;
           }
           writer.println();

           for (int rowNumber = 1; rowNumber < header.Contacts.size(); rowNumber++) {
               i=0;
               for (int fieldNumber = 0; fieldNumber < reader.getNumberOfColumns(header.Contacts); fieldNumber++) {
                   writer.print(reader.getFieldContent(header.Contacts, fieldNumber + 1, rowNumber)); //added 1
                   if (i == reader.getNumberOfColumns(header.Contacts) - 1) { //'removing' unnecessary comma
                       break;
                   }
                   writer.print(",");
                   i++;
               }
               writer.println();
           }


           writer.close();
           System.out.println("Contacts exported.");
           }

       catch (java.io.UnsupportedEncodingException e) {
           System.err.println("Unsupported encoding.");
       }
       catch (java.io.FileNotFoundException e) {
           System.err.println("File not exist!");
       }

    }

//    public void buildVCF() {
//       // Reader reader1 = new Reader(reader1.getDistinctDataTypes(reader1.readContacts().get(1)));
//
//        /* TEST POBIERANIA DANYCH ZA POMOCA getDistinctDataTypes Z KLASY READER */
////       Reader reader1 = new Reader(); //Can I use here 'reader' instead of 'reader1' ?
//       //reader1. = readContacts();
//
//       try {
//           PrintWriter writer = new PrintWriter("export.csv", "UTF-8");
//           writer.println("Template header"); //draft title
//
//           for (int contactNumberFromZero = 0; contactNumberFromZero < reader1.getQuantity() - 2; contactNumberFromZero++) { //there is -2 instead of -1 in order to fix the problem
//                                                                                                                            // with index which I can't solve
//               for (int j = 0; j < 4; j++) {
//                   writer.print(Contacts[j] + ",");
//               }
//               writer.println();
//               Contacts = reader1.getDistinctDataTypes(contactNumberFromZero+2); // At the beginning contactNumberFromZero = 0 and ContactNumber = 1 has been already printed.
//           }
//           writer.close();
//       }
//       catch (java.io.UnsupportedEncodingException e) {
//           System.err.println("Unsupported encoding.");
//       }
//       catch (java.io.FileNotFoundException e) {
//           System.err.println("File not exist!");
//       }
//        System.out.println("contacts exported. (Without the last - there is an error)");
//
//
//    }




}
