
public class Main {
    public final static int COLUMNS_NUMBER = 4;

    public static void main(String[] args) {
        //Reader reader = new Reader();

//        Header header = new Header();
//        for (String str: header.getHeader()) {
//            System.out.println(str);
//        }

        Builder builder = new Builder();
        builder.buildVCF();

    }
}
