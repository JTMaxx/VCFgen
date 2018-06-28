import java.util.List;

public class Main {
    public final static int COLUMNS_NUMBER = 4;

    public static void main(String[] args) {
        Reader reader = new Reader();
        List<String> Contacts = reader.readContacts();

        Header header = new Header();

        header.xx();

    }
}
