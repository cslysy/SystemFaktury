import java.util.List;

public class App {

    public static void main(String[] args) {

        DataStorage fileDataStorage = new FileDataStorage("C:\\remove-me\\jimi-database");
        //DataStorage inMemoryDataStorage = new InMemoryDataStorage();

        JimiSystem jimiSystem = new JimiSystem(fileDataStorage);
        jimiSystem.saveInvoice(new Invoice(1, "test", 124, 576854));
        jimiSystem.saveReceipt(new Receipt(3,"Jarosław", 666));
        jimiSystem.saveReceipt(new Receipt(4, "Kaczyński",999));
        jimiSystem.saveInvoice(new Invoice(5, "Hendrix", 777, 65765));

        List<Invoice> faktury = jimiSystem.getAllInvoices();
        List<Receipt> paragony = jimiSystem.getAllReceipts();

        System.out.println("faktury = " + faktury + " paragony +" + paragony);
    }
}
