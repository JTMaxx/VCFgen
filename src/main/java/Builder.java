import java.io.PrintWriter;
import java.util.List;

public class Builder {


    public void buildCSV() {
        Header header = new Header();
        List<String> headerList;
        headerList = header.getHeader();
        Reader reader = new Reader();

        try {
           PrintWriter writer = new PrintWriter("export.csv", "UTF-8");
           int i=0;

           for(String str: headerList) {
               writer.print(str);
               if (i == reader.getNumberOfColumns(header.getContacts()) - 1) { //'removing' unnecessary comma
                   break;
               }
               writer.print(",");
               i++;
           }
           writer.println();

           for (int rowNumber = 0; rowNumber < header.getContacts().size(); rowNumber++) {
               i=0;
               for (int fieldNumber = 0; fieldNumber < reader.getNumberOfColumns(header.getContacts()); fieldNumber++) {
                   writer.print(reader.getFieldContent(header.getContacts(), fieldNumber + 1, rowNumber)); //+1 because seekingFieldNumber starts from 1
                                                                                                                        // whereas fieldNumber starts from 0
                   if (i == reader.getNumberOfColumns(header.getContacts()) - 1) { //'removing' unnecessary comma
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
           System.err.println("File not exist.");
       }
    }
}
