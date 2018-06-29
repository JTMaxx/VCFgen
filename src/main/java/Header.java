import java.util.List;

public class Header {
    public void xx() {
        Reader reader = new Reader();
        //List<String> Contacts = reader.readContacts();
        System.out.println("Put type of this field.");
        for (int i = 0; i<3; i++) {
            System.out.println("exemplary values:");
            System.out.println(reader.getFieldContent(Contacts,1, i));
        }
    }
}
