public class Main {
    public final static int COLUMNS_NUMBER = 4;

    public static void main(String[] args) {
        Reader reader = new Reader(); //niepotrzebne jesli uzywam Reader w Builder

        Builder builder = new Builder();
        builder.buildVCF();

//        reader.getFieldContent(3, 2);
        builder.getFieldContent(2, 3);
    }
}
