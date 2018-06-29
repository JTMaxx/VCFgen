import java.util.List;

public class Header {
    public void xx() {
        Reader reader = new Reader();
        List<String> Contacts = reader.readContacts();
        System.out.println("Put type of this field.");
        System.out.println("\nexemplary values:");
        for (int i = 1; i<4; i++) { // i=1, a nie 0, bo to poprawka na 1 niewyswietlajacy sie wiersz
            System.out.println(reader.getFieldContent(Contacts,1, i));
        }
    }
}
