import java.util.List;

public class App {

    public static void main(String[] args) {
        DataBaseJimi jimi = new DataBaseJimi();

        List<Invoice> faktury = jimi.getAllInvoices();

        System.out.println("faktury = " + faktury);
    }
}
